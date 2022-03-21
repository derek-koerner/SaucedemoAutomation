package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameField = By.xpath("//input[@id='user-name']");
    // By.id('user-name');
    private By enteredUserName = By.xpath("//input[@id='user-name']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By enteredPassword = By.xpath("//input[@id='password']");
    private By submitButton = By.xpath("//input[@type='submit']");
    private By classTitle = By.xpath("//span[@class='title']");
    private By errorDisplayed = By.xpath("//h3[@data-test='error']");

    public String getTitleLandingPage() {
        return driver.getTitle();
    }

    public void enterUsername(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public String getUserName() {
        return driver.findElement(enteredUserName).getAttribute("value");
    }

    public String getPassword() {
        return driver.findElement(enteredPassword).getAttribute("value");
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public String getClassHomePage() {
        String pageTitle = driver.findElement(classTitle).getText();
        return pageTitle;
    }

    public String loginErrorDisplayed() {
        return driver.findElement(errorDisplayed).getText();
    }

}
