package steps;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import game.factory.DriverManager;
import game.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private final DriverManager driverManager;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	public static String browserName;

	public ApplicationHooks(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Before(order = 0)
	public void getProperty() {

		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		browserName = prop.getProperty("browser");
		System.out.println("Inside before #############");
		driver = driverManager.get_Driver(browserName);
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {

			// Capture and attach a screenshot to the Cucumber report
			try {
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "Screenshot on Failure");
				System.err.println("Scenario failed: " + scenario.getName());
			} catch (Exception e) {
				System.err.println("Failure occured : " + e.getMessage());
				System.out.println("Stack Trace: " + e.getStackTrace());
			}
		}
		if (driver != null) {
			driver.quit(); // Clean up the WebDriver instance
		}
	}

}
