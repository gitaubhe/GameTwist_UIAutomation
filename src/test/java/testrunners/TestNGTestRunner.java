package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "src/test/java/steps", monochrome = true, plugin = {
		"pretty", "html:target/cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
