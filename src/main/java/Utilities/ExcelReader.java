package Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelReader {
    private static volatile ExcelReader instance;
    private Workbook workbook;

    private ExcelReader() {
        try (FileInputStream fis = new FileInputStream(".\\src\\test\\java\\testData\\TestData.xlsx");) {
            workbook = new XSSFWorkbook(fis);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public static ExcelReader getInstance() {
        if (instance == null) {
            synchronized (ExcelReader.class) {
                if (instance == null) {
                    instance = new ExcelReader();
                }
            }
        }
        return instance;
    }

    // Get single row data by sheet name (first data row only)
    public Map<String, String> getRowDataBySheet(String sheetName) {
        Map<String, String> rowData = new LinkedHashMap<>();
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) return rowData;

        Row headerRow = sheet.getRow(0);
        Row dataRow = sheet.getRow(1); // First data row (after header)

        if (headerRow == null || dataRow == null) return rowData;

        int colCount = headerRow.getLastCellNum();
        for (int i = 0; i < colCount; i++) {
            String key = headerRow.getCell(i).getStringCellValue().trim();
            Cell cell = dataRow.getCell(i);
            String value = (cell == null) ? "" : cell.toString().trim();
            rowData.put(key, value);
        }

        return rowData;
    }

    public void close() throws Exception {
        workbook.close();
    }
}
