import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features="src//test//java//features",
    glue= {"stepdefinitions", "utility"}
    )

@Test
public class Runner {

}

