package org.slevin.cucumber.navigation;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by jacky on 25/04/15.
 */

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class NavigationIT {
}
