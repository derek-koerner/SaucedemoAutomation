package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriverSetup {

    public WebDriver driver;

    public WebDriver WebDriverManager() {

        String url = "https://www.saucedemo.com/";

        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\Resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(url);
        }
        //to be added - other browsers in either if/else if or switch format
        return driver;
    }

}
