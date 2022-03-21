package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectFactory {

    public LandingPage landingPage;
    public WebDriver driver;

    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() {
        landingPage = new LandingPage(driver);
        return landingPage;
    }
}
