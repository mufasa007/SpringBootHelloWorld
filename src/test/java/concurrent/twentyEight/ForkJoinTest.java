package concurrent.twentyEight;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @Author 59456
 * @Date 2022/1/1
 * @Descrip 使用forkJoin执行求和计算的任务
 * @Version 1.0
 * 3000 6000(forkJoin) 9000(Stream并行流)
 * serial:data=>500000000500000000,time=>711
 * forkJoin:data=>500000000500000000,time=>601
 * LongStream:data=>500000000500000000,time=>387
 */
public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = 0L;
        long end = 10_0000_0000L;
        long startDate,endDate;

        // 普通的串行求和计算
        startDate = System.currentTimeMillis();
        long sum = 0;//499999999500000000
        for (long i = start; i <= end; i++) {
            sum += i;
        }
        endDate = System.currentTimeMillis();
        System.out.println("serial:data=>" + sum + ",time=>" + (endDate - startDate));

        // forkJoin求和计算
        startDate = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinAdd(start, end);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        sum = submit.get();
        endDate = System.currentTimeMillis();
        System.out.println("forkJoin:data=>" + sum + ",time=>" + (endDate - startDate));

        // stream并行流计算
        startDate = System.currentTimeMillis();
        sum = LongStream.rangeClosed(start, end).parallel().reduce(0, Long::sum);
        endDate = System.currentTimeMillis();
        System.out.println("LongStream:data=>" + sum + ",time=>" + (endDate - startDate));
    }

}

/**
 * 1,forkJoinPool 通过这个执行
 * 2,计算任务forkJoinPool.excutor(forkJoinTask)
 * 3,计算类要继承forkJoinTask
 */
class ForkJoinAdd extends RecursiveTask<Long> {
    private Long start;
    private Long end;

    private Long temp = 10_0000L;

    public ForkJoinAdd(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Long compute() {
        if((end-start)<temp){
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else {
            long middle = (start + end) / 2;// 中间值
            ForkJoinAdd task1 = new ForkJoinAdd(start, middle);
            task1.fork(); // 拆分任务，把任务压入线程
            ForkJoinAdd task2 = new ForkJoinAdd(middle + 1, end);
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}


