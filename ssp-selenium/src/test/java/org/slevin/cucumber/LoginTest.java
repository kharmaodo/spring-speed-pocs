package org.slevin.cucumber;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by jacky on 23/03/15.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class LoginTest {

}
