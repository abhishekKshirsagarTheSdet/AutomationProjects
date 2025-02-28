package automationPortfolio.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.log.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class basePage {

    private static basePage _instance= null;
    public static basePage getInstance(){
        if (_instance == null){
            _instance = new basePage();
        }
        return _instance;
    }

protected static final Logger logger = Logger.getGlobal();
    protected WebDriver driver;

    public basePage() {
        this.driver = DriverManager.getDriver();
    }





    public  static Properties loadProperties (String filePath) {
        Properties prop = new Properties();
        try (FileInputStream fos = new FileInputStream(filePath)) {
            prop.load(fos);
        } catch (IOException e) {
//                throw new RuntimeException(e);
        }
        return prop;
    }


}
