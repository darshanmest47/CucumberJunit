package com.tests;
import Utilities.ExcelReader;
import Utilities.PropertyReader;

import java.util.Map;

public class FirstTest {
    public static void main(String[] args) throws Exception {
        Map<String, String> value = ExcelReader.getInstance().getRowDataBySheet("Sheet1");
        System.out.println(value.get("UserName"));
        System.out.println(value.get("Password"));
        System.out.println(PropertyReader.getInstance().getProperty("BROWSER"));
    }
}
