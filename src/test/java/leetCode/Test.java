package leetCode;

import java.util.Arrays;

/**
 * @Author 59456
 * @Date 2022/1/5
 * @Descrip
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        merge(nums1,3,nums2,3);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }

        // 比较交换
        int l = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                // 0的数据直接替换
                nums1[i] = nums2[l];
                l++;
            } else if (nums1[i] <= nums2[l]) {
                // 正常顺位
                continue;
            } else {
                int mid = nums1[i];
                nums1[i] = nums2[l];
                nums2[l] = mid;

                Arrays.stream(nums2).sorted();
            }
        }
    }


}
