package automationPortfolio.Steps;

import automationPortfolio.Pages.LoginPage;
import automationPortfolio.Pages.basePage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.*;

public class loginPageSteps extends basePage {

    LoginPage loginPage = LoginPage.get_instance();

    public loginPageSteps() throws SQLException {
    }


    @Given("User lands on amazon website")
    public void userLandsOnAmazonWebsite() throws SQLException {
//        try {
        System.setProperty("WebDriver.chrome.driver", "Path");
        WebDriver driver = new ChromeDriver();



        String url = "jdbc:mysql://localhost:3306/CompanyData";
        String username = "root";
        String password = "Kshirsagar@10";

        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to the database successfully!");


        // Execute Query
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Employees");

        // Print Results
        while (rs.next()) {
            System.out.println("User: " + rs.getString("name") + " | Email: " + rs.getString("email"));
        }
//        JavascriptExecutor ja = (JavascriptExecutor) driver;
//        WebElement shadowElement = ja.executeScript(document.querySelector('ntp-app').shadowRoot.querySelector('div').children.searchboxContainer
//                )

    }
}

