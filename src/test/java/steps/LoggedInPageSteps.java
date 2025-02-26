package steps;

import org.testng.Assert;
import game.factory.DriverManager;
import game.pages.LoggedInPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoggedInPageSteps {
	private final DriverManager driverManager;
	private LoggedInPage loggedinpage;

	public LoggedInPageSteps(DriverManager driverManager) {
		this.driverManager = driverManager;
		loggedinpage = new LoggedInPage(driverManager.get_Driver(ApplicationHooks.browserName));
	}

	@When("I click on player name on top right corner")
	public void i_click_on_player_name_on_top_right_corner() {
		try {
			loggedinpage.clickOnUserProfile();
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@Then("menu shall be displayed")
	public void menu_shall_be_displayed() {
		try {
			Assert.assertEquals(loggedinpage.personalDataButtonIsdisplayed(), true,
					"Personal data button was not displayed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("I click on  personal data button")
	public void i_click_on_personal_data_button() {
		try {
			loggedinpage.clickOnPersonalDataButton();
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("click on logout button")
	public void click_on_logout_button() throws InterruptedException {
		try {
			loggedinpage.clickOnLogoutButton();
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}
}
