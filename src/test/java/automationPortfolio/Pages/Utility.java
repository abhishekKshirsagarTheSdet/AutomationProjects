package automationPortfolio.Pages;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.*;

public class Utility {

    private static Utility _instance = null;

    public static Utility get_instance(){
        if(_instance ==null){
            _instance = new Utility();
        }
        return _instance;
    }

    protected Utility(){
        super();
    }

    public String dataFromSql(String EmpName) throws ClassNotFoundException, SQLException {
        String dbClass = "com.mysql.cj.jdbc.Driver";

        Class.forName(dbClass);
//        Class<?> clazz = Class.forName(dbClass);
//        Object instance = clazz.getDeclaredConstructor().newInstance();
//
        String url = "jdbc:mysql://localhost:3306/CompanyData";
        String username = "root";
        String password = "Kshirsagar@10";

        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to the database successfully!");
        // Execute Query
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");

        String empEmailID = "No data Found";
        // Print Results
        while (rs.next()) {
            System.out.println(rs.getString("name"));
            if (rs.getString("name").trim().equalsIgnoreCase(EmpName.trim())) {
                empEmailID = rs.getString("email");
            }
        }
        return empEmailID;
    }

    public long DataFromExcel(String EmpName) throws FileNotFoundException {
        long EmpPhone = 0000;

        String FilePath = "/Users/abhishekkshirsagar/IdeaProjects/AutomationProjects/Data/EmpData.xlsx";
        try {
            FileInputStream fis = new FileInputStream(new File(FilePath));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(0);
            int rowLength = sheet.getLastRowNum();
            for (Cell cell : row) {
                if (cell.getStringCellValue().equals("EmpName")) {
                    int currentRow = 1;
                    while (currentRow < rowLength) {
                        row = sheet.getRow(currentRow);
                        if (row.getCell(1).getStringCellValue().equals(EmpName)) {
                            EmpPhone = (long)row.getCell(2).getNumericCellValue();
                        }
                        currentRow++;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Unable to read Excel, " + e.getMessage());
        }
        return EmpPhone;

    }



}
