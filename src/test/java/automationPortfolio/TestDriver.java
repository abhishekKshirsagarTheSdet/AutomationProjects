package automationPortfolio;

import automationPortfolio.Pages.LoginPage;
import automationPortfolio.Pages.Utility;
import automationPortfolio.Pages.basePage;
//import io.cucumber.junit-vintage-engineit.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class TestDriver {

    basePage basepage = basePage.getInstance();
    static LoginPage lp = LoginPage.get_instance();
    static Utility ut = Utility.get_instance();
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException, InterruptedException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.setProperty("webdriver.chrome.driver", "/Users/abhishekkshirsagar/Documents/Software/seleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        TakesScreenshot snap = (TakesScreenshot) driver;
        File screenShot = snap.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("/Users/abhishekkshirsagar/IdeaProjects/AutomationProjects/Data/screenShots.word"));
//        Duration timeout = Duration.ofSeconds(20000);
//        WebDriverWait wait = new WebDriverWait(driver,timeout);
//        wait.until(ExpectedConditions.elementToBeClickable(lp.getSearchBox()));
//        lp.getSearchBox().click();
        String EmpEmailID = ut.dataFromSql("Abhishek");
        long EmpPhoneNumber = ut.DataFromExcel("Abhishek");
        List<String> data = new ArrayList<>();
        data.add(EmpEmailID);
        data.add(String.valueOf(EmpPhoneNumber));
        for(String s: data){
//            lp.getSearchBox().sendKeys(s);
            System.out.println("User has entered "+s);
//            lp.getSearchBox().clear();
        }
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(2000);
        driver.close();








    }
}