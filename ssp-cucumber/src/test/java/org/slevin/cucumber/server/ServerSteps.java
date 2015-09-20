package org.slevin.cucumber.server;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;
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
    private String response;

    private WebDriver driver = new HtmlUnitDriver();
    public final static String CONTEXT = "http://localhost:9090/hello/";

    @Before
    public void init(){
        server = new EmbeddedJetty(EmbeddedJetty.DEFAULT_PORT, new HelloWorldResource());
        server.start();
    }

    @Given("^the name \"([^\"]*)\"$")
    public void the_name(String name) {
      this.name = name;
    }

    @When("^i run my service$")
    public void i_run_my_service() {
        Client c = Client.create();
        WebResource resource = c.resource(CONTEXT+name);
        response = resource.get(String.class);
    }

    @Then("^he sais \"([^\"]*)\"$")
    public void he_sais(String hello) {
        System.out.println(response);
        Assert.assertTrue(response.contains(hello));
    }

}
