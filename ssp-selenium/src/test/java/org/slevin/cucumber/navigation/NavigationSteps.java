package org.slevin.cucumber.navigation;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by jacky on 25/04/15.
 */
public class NavigationSteps {

    private WebDriver driver = new HtmlUnitDriver();
    public final static String ACCOUNT_MENU = "accountsMenu";
    public final static String ACCOUNT_ALL = "accountsAll";
    public final static String ACCOUNT_NEW = "accountNew";
    public final static String ACCOUNT_List = "accountList";
    public final static String NEW_USER = "newUser";




    @Given("^I click on accounts menu$")
    public void I_click_on_accounts_menu() {
        WebElement accountMenu = driver.findElement(By.id(ACCOUNT_MENU));
        accountMenu.click();
    }

    @When("^I click on all accounts link$")
    public void I_click_on_all_accounts_link() {
        WebElement accountsAll = driver.findElement(By.id(ACCOUNT_ALL));
        accountsAll.click();
    }

    @Then("^I will be on all accounts page$")
    public void I_will_be_on_all_accounts_page() {
        WebElement accountListPage = driver.findElement(By.id(ACCOUNT_List));
        Assert.assertTrue(accountListPage.getText().contains("Account List"));
    }

    @When("^I click on new account link$")
    public void I_click_on_new_account_link() {
        WebElement accountNew = driver.findElement(By.id(ACCOUNT_NEW));
        accountNew.click();
    }

    @Then("^I will be on new account page$")
    public void I_will_be_on_new_account_page() {
        WebElement newUserPage = driver.findElement(By.id(NEW_USER));
        Assert.assertTrue(newUserPage.getText().contains("New User"));
    }




}
