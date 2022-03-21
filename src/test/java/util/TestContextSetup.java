package util;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectFactory;

public class TestContextSetup {

    public WebDriver driver;
    public PageObjectFactory pageObjectFactory;
    public TestDriverSetup testDriverSetup;

    public TestContextSetup() {

        testDriverSetup = new TestDriverSetup();
        pageObjectFactory = new PageObjectFactory(testDriverSetup.WebDriverManager());
    }
}
