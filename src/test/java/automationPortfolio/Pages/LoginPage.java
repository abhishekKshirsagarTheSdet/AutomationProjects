package automationPortfolio.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends basePage {

    private String loginlink = "//*[contains(text(),'element')]";
    private String searchBox = "//input[@placeholder='Search Amazon.in']";


    private static LoginPage _instance = null;

    public static LoginPage get_instance(){
        if(_instance ==null){
            _instance = new LoginPage();
        }
        return _instance;
    }

    protected LoginPage(){
        super();
    }

    public WebElement getLoginLink(){
       return driver.findElement(By.xpath(loginlink));
    }

    public WebElement getSearchBox(){
        return driver.findElement(By.xpath(searchBox));
    }




}
