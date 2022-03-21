package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import util.TestContextSetup;

public class LandingStepDefinition {

    public WebDriver driver;
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectFactory.getLandingPage();
    }

    @Given("^User is on the landing page$")
    public void user_is_on_the_landing_page() throws Throwable {

        String title = landingPage.getTitleLandingPage();
        Assert.assertEquals(title, "Swag Labs");

        //System.out.println("on landing page " + title);
    }

    @When("^User enters a username \"([^\"]*)\"$")
    public void user_enters_a_username_something(String userName) throws Throwable {

        landingPage.enterUsername(userName);
        String userFieldText = landingPage.getUserName();
        Assert.assertEquals(userName, userFieldText);

        //System.out.println("entered username " + userName + " " + userFieldText);
    }

    @When("^User selects the login button$")
    public void user_selects_the_login_button() throws Throwable {

        landingPage.clickSubmitButton();
        //System.out.println("selected login button");
    }

    @Then("^User is logged in and directed to the homepage$")
    public void user_is_logged_in_and_directed_to_the_homepage() throws Throwable {

        String pageTitle = landingPage.getClassHomePage();
        Assert.assertEquals("PRODUCTS", pageTitle);

        //System.out.println("user logged in");
    }

    @Then("^User is presented \"([^\"]*)\" error message$")
    public void user_is_presented_something_error_message(String error) throws Throwable {

        String errorMessage = landingPage.loginErrorDisplayed();
        switch (error) {
            case "password required":
                Assert.assertEquals("Epic sadface: Password is required", errorMessage);
                break;
            case "no matching user":
                Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage);
                break;
            case "username required":
                Assert.assertEquals("Epic sadface: Username is required", errorMessage);
                break;

        }

        //System.out.println(error + " on landing page");
    }

    @And("^User enters the password \"([^\"]*)\"$")
    public void user_enters_the_password_something(String password) throws Throwable {

        landingPage.enterPassword(password);
        String passwordFieldText = landingPage.getPassword();
        Assert.assertEquals(password, passwordFieldText);

        //System.out.println("entered " + password);
    }

}
