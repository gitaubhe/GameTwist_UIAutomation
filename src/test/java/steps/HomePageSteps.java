package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import game.factory.DriverManager;
import game.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	private final DriverManager driverManager;
	private HomePage homepage;

	public HomePageSteps(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Given("I have launched the website")
	public void i_have_launched_the_website() throws InterruptedException {
		try {

			WebDriver driver = driverManager.get_Driver(ApplicationHooks.browserName);
			homepage = ApplicationLaunch.LaunchApplication(driver);
			Assert.assertEquals(homepage.getHomePageTitle(), "Play FREE Online Casino games | GameTwist Casino",
					"Error in launching the application");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}

	}

	@When("I click on register")
	public void i_click_on_register() throws InterruptedException {
		try {

			homepage.ClickOnRegisterButton();
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}

	}

	@When("I click on login button")
	public void i_click_on_login_button() throws InterruptedException {
		try {

			homepage.clickOnLoginButton();
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@Then("user shall be successfully logged out")
	public void user_shall_be_successfully_logged_out() {
		try {

			Assert.assertEquals(homepage.IsLoginButtonDisplayed(), true, "Login button is not displayed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}
}
