package steps;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import game.pages.HomePage;

public class ApplicationLaunch {

	public static HomePage LaunchApplication(WebDriver driver) throws InterruptedException {
		driver.get("https://www.gametwist.com/en/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5));

		Thread.sleep(2000);

		HomePage homepage = new HomePage(driver);

		return homepage;
	}

}
