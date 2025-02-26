package steps;

import org.testng.Assert;

import game.factory.DriverManager;
import game.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private final DriverManager driverManager;
	private LoginPage loginpage;

	public LoginPageSteps(DriverManager driverManager) {
		this.driverManager = driverManager;
		loginpage = new LoginPage(driverManager.get_Driver(ApplicationHooks.browserName));
	}

	@Then("log in form shall be displayed")
	public void log_in_form_shall_be_displayed() {
		try {
			Assert.assertEquals(loginpage.nickNameInoutTextBoxIsDisplayed(), true, "Log in form is not displayed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("user enters username as {string} and password as {string} and log in")
	public void user_enters_username_as_and_password_as_and_log_in(String userName, String password)
			throws InterruptedException {
		try {
			loginpage.login(userName, password);
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@Then("user shall be logged in successfully")
	public void user_shall_be_logged_in_successfully() {
		try {
			Assert.assertEquals(loginpage.userProfileIsDisplayed(), true, "User profile is not displayed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("logged in with username as {string} and password as {string}")
	public void logged_in_with_username_as_and_password_as(String userName, String password)
			throws InterruptedException {
		try {
			loginpage.login(userName, password);
			Assert.assertEquals(loginpage.userProfileIsDisplayed(), true, "User profile is not displayed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

}
