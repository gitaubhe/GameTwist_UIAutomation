package game.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	private WebDriver driver;

	public WebDriver get_Driver(String browser) {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers for Selenium\\chromedriver.exe");

				// Set up ChromeOptions
				ChromeOptions options = new ChromeOptions();

				// Disable browser pop-ups/notifications
				options.addArguments("--disable-notifications");
				options.addArguments("--disable-popup-blocking");

				// Initialize WebDriver with ChromeOptions
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			} 
			else if (browser.equals("firefox")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers for Selenium\\geckodriver.exe");
				driver = new FirefoxDriver();
			} 
			else {
				System.out.println("Please enter the correct browser value: " + browser);
			}
		}
		return driver;
	}

	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
