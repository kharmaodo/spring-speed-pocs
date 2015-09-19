package org.slevin.cucumber.server;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.glassfish.jersey.client.ClientResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slevin.config.model.Human;
import org.slevin.config.resource.HelloWorldResource;
import org.slevin.config.server.EmbeddedJetty;

import javax.ws.rs.WebApplicationException;
import java.io.IOException;
import java.io.InputStream;

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
        server = new EmbeddedJetty(EmbeddedJetty.DEFAULT_PORT, new HelloWorldResource());
        server.start();
    }

    @Given("^the name \"([^\"]*)\"$")
    public void the_name(String name) {
      this.name = name;
    }

    @Then("^he sais \"([^\"]*)\"$")
    public void he_sais(String hello) {
        Client c = Client.create();
        WebResource resource = c.resource(CONTEXT+name);
        String response = resource.get(String.class);
        System.out.println(response);
        Assert.assertTrue(response.contains(hello));
    }

}
