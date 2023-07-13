package com.loop.utilities;

import java.util.Arrays;

public class TestExcel {

  public static void main(String[] args) {
    ExcelUtils excelUtils = new ExcelUtils("/Users/yuliiagalushchak/Desktop/Book1.xlsx","Sheet1");
//    System.out.println(excelUtils.getCellData(2,2));
//    String [][] arr = excelUtils.getDataArray();
//    for (String[] strings : arr) {
//      System.out.println(Arrays.toString(strings));
//
//    }

    //excelUtils.setCellData("test",2,2);
    excelUtils.setCellData("test1",5,3);
  }

}
