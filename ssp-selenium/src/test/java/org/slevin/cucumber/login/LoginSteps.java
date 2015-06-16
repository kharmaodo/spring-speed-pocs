package org.slevin.cucumber.login;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by jacky on 23/03/15.
 */
public class LoginSteps {

    private WebDriver driver = new HtmlUnitDriver();
    public final static String CONTEXT = "http://localhost:8080/ssp-web/";
    public final static String EMAIL = "email";
    public final static String PASSWORD = "password";
    public final static String SUBMIT = "loginButton";
    public final static String WELCOME = "welcomePage";


    @Given("^the email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void the_email_and_password(String email, String password) throws Throwable {
        driver.get(CONTEXT);
        WebElement emailInput = driver.findElement(By.id(EMAIL));
        WebElement passwordInput = driver.findElement(By.id(PASSWORD));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    @When("^I click on login$")
    public void I_click_on_login() throws Throwable {
        WebElement submitButton = driver.findElement(By.id(SUBMIT));
        submitButton.click();
    }

    @Then("^I will be on welcome page$")
    public void I_will_be_on_welcome_page() throws Throwable {
        WebElement welcomePageTitle = driver.findElement(By.id(WELCOME));
        Assert.assertTrue(welcomePageTitle.getText().contains("PrimeFaces 5 Integration with Spring Security (Spring v4)"));
    }

}
