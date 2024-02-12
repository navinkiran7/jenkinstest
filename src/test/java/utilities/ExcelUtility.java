package utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtility {

    private static final String path = "src/test/resources/test-data/TestData.xlsx";
    private static final String Sheet = "TestData";

    public static void main(String[] args) 
 	   {
     	
     	Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
         data.put("1", 
                  new Object[] { "UserName", "Password", "Status" }); 
         data.put("2", 
                  new Object[] { "Ronan", "Eqmd20441", "fail" }); 
         data.put("3", 
                  new Object[] { "Rathoor", "vnrojfi(@u2", "pass" }); 
         data.put("4", new Object[] {"Sharukh", "Njnfuneu9!u","pass" }); 
         data.put("5", new Object[] {"Virat", "NSukohl2s2i","pass" }); 
     	writeTestData(data);
 	   
        
     	
     		Map<String, Object[]> testData = readTestData();
         System.out.println("Test Data from Excel:");
         for (Map.Entry<String, Object[]> entry : testData.entrySet()) {
             String key = entry.getKey();
             Object[] values = entry.getValue();
             System.out.print("Row " + key + ": ");
             for (Object value : values) {
                 System.out.print(value + "\t");
             }
             System.out.println();
         }
     	
         }
         
    public static Map<String, Object[]> readTestData() {
        Map<String, Object[]> data = new TreeMap<>();

        try (FileInputStream file = new FileInputStream(path)) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(Sheet);

            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowCount; i++) {
                XSSFRow row = sheet.getRow(i);
                int colCount = row.getPhysicalNumberOfCells();
                Object[] rowData = new Object[colCount];
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    rowData[j] = cell.toString();
                }
                data.put(String.valueOf(i + 1), rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
    
    
    public static void writeTestData(Map<String, Object[]> data) {
        try (FileOutputStream writer = new FileOutputStream(path)) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(Sheet);

            Set<String> keyset = data.keySet();
            int rownum = 0;

            for (String key : keyset) {
                Row row = sheet.createRow(rownum++);
                Object[] objArr = data.get(key);

                int cellnum = 0;

                for (Object obj : objArr) {
                    Cell cell = row.createCell(cellnum++);

                    if (obj instanceof String)
                        cell.setCellValue((String) obj);
                    else if (obj instanceof Integer)
                        cell.setCellValue((Integer) obj);
                }
            }

            workbook.write(writer);
            System.out.println("TestData written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}