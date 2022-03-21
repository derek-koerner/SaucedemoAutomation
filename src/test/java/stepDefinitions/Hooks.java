package stepDefinitions;

import io.cucumber.java.After;
import util.TestContextSetup;

public class Hooks {

    public TestContextSetup testContextSetup;
    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void exitBrowser() {

        testContextSetup.testDriverSetup.WebDriverManager().quit();
    }
}
