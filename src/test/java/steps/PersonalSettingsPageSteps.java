package steps;

import org.testng.Assert;
import game.factory.DriverManager;
import game.pages.PersonalSettingsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalSettingsPageSteps {
	private final DriverManager driverManager;
	private PersonalSettingsPage personalsettingspage;

	public PersonalSettingsPageSteps(DriverManager driverManager) {
		this.driverManager = driverManager;
		personalsettingspage = new PersonalSettingsPage(driverManager.get_Driver(ApplicationHooks.browserName));
	}

	@Then("personal data section shall be displayed")
	public void personal_data_section_shall_be_displayed() {
		try {
			Assert.assertEquals(personalsettingspage.personalSettingsHeaderIsdisplayed(), true,
					"Personal settings section was not displayed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("I click on change security button")
	public void i_click_on_change_security_button() {
		try {
			personalsettingspage.clickOnChangeSecurityQuestionButton();
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@Then("change security questions form shall be displayed")
	public void change_security_questions_form_shall_be_displayed() {
		try {
			Assert.assertEquals(personalsettingspage.personalSettingsHeaderIsdisplayed(), true,
					"Personal settings section was not displayed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("change the security question {string} and save the changes")
	public void change_the_security_question_and_save_the_changes(String question) throws InterruptedException {
		try {
			personalsettingspage.changeSecurityQuestion(question);
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@Then("security question changes saved successfully message shall be displayed")
	public void security_question_changes_saved_successfully_message_shall_be_displayed() throws InterruptedException {
		try {
			Assert.assertEquals(personalsettingspage.securityQuestionChangedMessageIsDisplayed(), true,
					"Security question changed message was not displayed");
			personalsettingspage.closeChangeSecurityQuestionForm();
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("move to the document table and click on change button in newsletter row")
	public void move_to_the_document_table_and_click_on_change_button_in_newsletter_row() throws InterruptedException {
		try {
			personalsettingspage.clickOnChangeButtonInTable("Newsletter");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("change newsletter settings form shall be displayed")
	public void change_newsletter_settings_form_shall_be_displayed() {
		try {
			Assert.assertEquals(personalsettingspage.changeNewsLetterFormIsDisplayed(), true,
					"Change news letter form is not displayed");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("change to get latest news and click on confirm button")
	public void change_to_get_latest_news_and_click_on_confirm_button() throws InterruptedException {
		try {
			personalsettingspage.selectToGetLatestNews();
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@When("open the change newsletter settings form")
	public void open_the_change_newsletter_settings_form() throws InterruptedException {
		try {
			personalsettingspage.openTheChangeNewsLetterSettingForm("Newsletter");
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

	@Then("changed option shall be displayed as selected")
	public void changed_option_shall_be_displayed_as_selected() throws InterruptedException {
		try {
			Assert.assertEquals(personalsettingspage.getLatestNewsRadiobuttonSelectedState(), "true",
					"Get latest news radio button was in selected state");
			personalsettingspage.selectRemindLaterToGetLatestNews();
		} catch (Exception e) {
			System.err.println("Error entering credentials: " + e.getMessage());
			throw e; // Fail the scenario explicitly
		}
	}

}
