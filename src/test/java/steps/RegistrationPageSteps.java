package steps;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import game.factory.DriverManager;
import game.pages.RegistrationPage;
import game.util.ApplicationHelpers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationPageSteps {
	private final DriverManager driverManager;
	private RegistrationPage registrationpage;

	public RegistrationPageSteps(DriverManager driverManager) {
		this.driverManager = driverManager;
		registrationpage = new RegistrationPage(driverManager.get_Driver(ApplicationHooks.browserName));

	}

	@Then("I shall be navigated to registration page")
	public void i_shall_be_navigated_to_registration_page() {
		try {
			Assert.assertEquals(registrationpage.getHomePageTitle(), "Registration | GameTwist Casino",
					"Registration page is not displayed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("I enter new user details as below")
	public void i_enter_new_user_details_as_below(io.cucumber.datatable.DataTable dataTable) {
		try {
			List<Map<String, String>> credList = dataTable.asMaps();
			String Email = credList.get(0).get("Email");
			String Nickname = credList.get(0).get("Nickname");
			String Password = credList.get(0).get("Password");
			String DateOfBirth = credList.get(0).get("DateOfBirth");

			// Parse the date
			LocalDate localDate = LocalDate.parse(DateOfBirth);

			int year = localDate.getYear();
			int month = localDate.getMonthValue();
			int day = localDate.getDayOfMonth();

			registrationpage.enterEmail(ApplicationHelpers.generateUniqueEmail(Email));
			registrationpage.enterNickname(ApplicationHelpers.generateUniqueNickName(Nickname));
			registrationpage.enterPassword(Password);
			registrationpage.selectBirthdate(day, month, year);
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("confirmed recpatcha and accepted terms and conditions")
	public void confirmed_recpatcha_and_accepted_terms_and_conditions() throws InterruptedException {
		try {
			registrationpage.checkNotRobotRecaptcha();
			registrationpage.acceptTermsAndConditions();
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("click on begin adventure button")
	public void click_on_begin_adventure_button() {
		try {
			registrationpage.clickOnBeginAdventureButton();
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@Then("I shall be registered successfully")
	public void i_shall_be_registered_successfully() {
		try {
			Assert.assertEquals(registrationpage.getRegistrationSuccessfulMessage(), "Confirm your e-mail address",
					"User registration is failed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@Then("{string} message shall be displayed")
	public void message_shall_be_displayed(String msg) {
		try {
			Assert.assertEquals(registrationpage.getRegistrationSuccessfulMessage(), msg, "Message was not displayed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@Then("email textbox and resend email button shall be displayed")
	public void email_textbox_and_resend_email_button_shall_be_displayed() {
		try {
			Assert.assertEquals(registrationpage.emailTextboxIsDisplayed(), true,
					"Email input text box was not displyed");
			Assert.assertEquals(registrationpage.resendButtonIsDisplayed(), true,
					"Resend email button was not displyed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

}
