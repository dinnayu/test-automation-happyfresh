package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = "Feature",glue ={"stepDefinitions"}
			,tags = {"@Horizon_Splash"},
			plugin = { "html:target/cucumber-htmlreport", "json:target/cucumber-report.json","usage:target/cucumber-usage.json" }
		)

public class RunTest extends AbstractTestNGCucumberTests {

}
