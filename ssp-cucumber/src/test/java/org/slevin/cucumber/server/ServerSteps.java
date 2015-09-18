package org.slevin.cucumber.server;

import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slevin.config.resource.HelloWorldResource;
import org.slevin.config.server.EmbeddedJetty;

/**
 * Created by jacky on 18/09/15.
 */
public class ServerSteps {

    private EmbeddedJetty server;
    private String name;

    private WebDriver driver = new HtmlUnitDriver();
    public final static String CONTEXT = "http://localhost:9090/hello/";

    @Before
    public void init(){
        server = new EmbeddedJetty();
        try {
            server.start(EmbeddedJetty.DEFAULT_PORT, new HelloWorldResource());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("^the name \"([^\"]*)\"$")
    public void the_name(String name) {
      this.name = name;
    }

    @When("^i run my server$")
    public void i_run_my_server() {

    }

    @Then("^he sais \"([^\"]*)\"$")
    public void he_sais(String hello) {
        driver.get(CONTEXT);
        String response = driver.findElement(By.tagName("body")).toString();
        System.out.println(response);
    }

}
