package util.excelUtil;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import static javax.swing.UIManager.getString;

/**
 * @Author 59456
 * @Date 2022/1/12
 * @Descrip
 * @Version 1.0
 */
public class ExcelTest {
    private static ArrayList<Person> list = new ArrayList<>();
    private static HashMap<String, Person> map = new HashMap<>(1024);

    public static void main(String[] args) throws Exception {
        List<String> fileNameList = readAllExcelFileName("E:\\MyU\\工作\\事件记录总结");
        for (String fileName : fileNameList) {
            readSingleExcel(fileName);
        }
        Collections.sort(list);

        for (Person person : list) {
            System.out.println(person.getName()+"=>"+person.getTimes());
        }

    }

    public static List<String> readAllExcelFileName(String path){
        List<String> fileNameList = new ArrayList<>();
        File file = new File(path);
        File[] cFile = file.listFiles();
        for (int i = 0; i < cFile.length; i++) {
            String name = cFile[i].getName();
            fileNameList.add(path + "\\" + name);
        }
        return fileNameList;
    }

    public static void readSingleExcel(String fileName) throws Exception {
        File file = new File(fileName);
        if (!file.exists()){
            throw new Exception("文件不存在!");
        }



        InputStream in = new FileInputStream(file);

        // 读取整个Excel
        XSSFWorkbook sheets = new XSSFWorkbook(in);
        // 获取第一个表单Sheet
        XSSFSheet sheetAt = sheets.getSheetAt(0);


        //默认第一行为标题行，i = 0
        XSSFRow titleRow = sheetAt.getRow(0);
        Integer index = 0;
        for (int i = 0; i < 5; i++) {
            XSSFCell cell = titleRow.getCell(i);
            String title = cell.toString();
            if("对接人".equals(title)){
                index = i;
                break;
            }
        }


        // 循环获取每一行数据
        for (int i = 1; i < sheetAt.getPhysicalNumberOfRows(); i++) {
            XSSFRow row = sheetAt.getRow(i);
            if(row == null){
                continue;
            }
            XSSFCell cell = row.getCell(index);
            if(cell == null){
                continue;
            }
            String str = cell.toString();
            if(str == null || str.trim() == ""){
                continue;
            }else {
                String[] accountNameList = str.split("[,、/\\\\]");

                for (String accountName : accountNameList) {
                    if(map.containsKey(accountName)){
                        map.get(accountName).setName(accountName);
                    }else {
                        Person person = new Person();
                        person.setName(accountName);
                        list.add(person);
                        map.put(accountName,person);
                    }
                }
            }
        }
        Collections.sort(list);
    }
}


class Person implements Comparable<Person>{
    private String name;
    private Integer times = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(times==0){
            this.name = name;
        }
        times ++;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @Override
    public int compareTo(Person o) {
        return o.getTimes() - times;
    }
}