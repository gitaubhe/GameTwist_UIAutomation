package game.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import game.util.AbstractComponents;

public class PersonalSettingsPage extends AbstractComponents {

	private WebDriver driver;
	
	private By personalSettingsHeader = By.cssSelector(".c-headline-section");
	private By changeSecurityQuestionButton = By.xpath("//button[contains(text(),'Change security question')]");
	private By changeSecurityQuestionFormBy = By.xpath("//div[contains(text(),'Change security question')]");
	private By securityQuestionDropBox = By.xpath("//select[contains(@name,'security-question')]");
	private By securityAnswerInputTextbox = By.xpath("//input[contains(@name,'security-answer')]");
	private By passwordInputTextbox = By.xpath("//input[contains(@name,'new-password')]");
	private By saveChangesButton = By.xpath("//button[contains(text(),'Save changes')]");
	private By securityQuestionChangedMessageBy = By
			.xpath("//div[contains(text(),'The security question and answer have been changed.')]");
	private By closeSecurityQuestionFormBy = By.xpath("//a[@class='c-btn c-btn--ghost']");
	private By documentTableBy = By.id("table-gdpr-status");
	private By changeButtonNewsletterDocumentTableBy = By
			.xpath("//table[@id='table-gdpr-status']//tr[td[3]]//button[1]");

	// News Letter Settings form
	private By changeNewsLetterFormBy = By.xpath("//div[@class='c-modal__inner c-modal__inner--oversize']");
	private By receiveEmailRadioButtonBy = By.xpath("//div[contains(@for,'receiveEmailYes')]//input");
	private By remindLaterToReceiveEmailRadioButtonBy = By.xpath("//div[contains(@for,'receiveEmailNo')]//input");
	private By confirmButtonBy = By.xpath("(//button[contains(text(),'Confirm')])[1]");

	public PersonalSettingsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean personalSettingsHeaderIsdisplayed() {
		return elementIsDisplayed(personalSettingsHeader);
	}

	public void clickOnChangeSecurityQuestionButton() {
		
		//Click on change security question button
		WaitForElementToAppear(personalSettingsHeader);
		WaitForElementToBeClickable(changeSecurityQuestionButton);
		driver.findElement(changeSecurityQuestionButton).click();
		WaitForElementToAppear(changeSecurityQuestionFormBy);
	}

	public void changeSecurityQuestion(String question) throws InterruptedException {
		
		//Select security question from drop down
		WaitForElementToAppear(securityQuestionDropBox);
		WaitForElementToBeClickable(securityQuestionDropBox);
		Thread.sleep(2000);
		selectdropDownOptionByVisibleText(securityQuestionDropBox, question);
		
		//Enter answer
		driver.findElement(securityAnswerInputTextbox).sendKeys("Max");
		
		//Enter password
		driver.findElement(passwordInputTextbox).sendKeys("abcde_1234");
		WaitForElementToBeClickable(saveChangesButton);
		
		//Click on save button
		driver.findElement(saveChangesButton).click();
		WaitForElementToAppear(securityQuestionChangedMessageBy);
	}

	public boolean securityQuestionChangedMessageIsDisplayed() {
		return elementIsDisplayed(securityQuestionChangedMessageBy);
	}

	public void closeChangeSecurityQuestionForm() throws InterruptedException {

		driver.findElement(closeSecurityQuestionFormBy).click();
		WaitForElementToDisAppear(closeSecurityQuestionFormBy);

	}

	public void clickOnChangeButtonInTable(String rowText) throws InterruptedException {
		try {
            // Click on change button in table   
				scrollToTheElement(documentTableBy);
				WaitForElementToAppear(documentTableBy);
				driver.findElement(changeButtonNewsletterDocumentTableBy).click();
				WaitForElementToAppear(changeNewsLetterFormBy);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public boolean changeNewsLetterFormIsDisplayed() {
		return elementIsDisplayed(changeNewsLetterFormBy);
	}

	public void selectToGetLatestNews() throws InterruptedException {

		//Select receive email radio button
		WaitForElementToAppear(By.className("c-page__modal"),20);
		WaitForElementToAppear(By.xpath("//form[contains(@class,'c-modal__content')]//div[contains(@for,'receiveEmailYes')]"),20);
		//Thread.sleep(5000);
		WebElement radioBtn1 = driver.findElement(receiveEmailRadioButtonBy);
		((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn1);

		//Click on confirm button
		WaitForElementToBeClickable(confirmButtonBy);
		driver.findElement(confirmButtonBy).click();
		WaitForElementToAppear(personalSettingsHeader,10);
	}

	public void selectRemindLaterToGetLatestNews() throws InterruptedException {
		//Select remind me later radio button
	//	Thread.sleep(5000);
		WaitForElementToAppear(By.className("c-modal__inner"));

		WebElement radioBtn1 = driver.findElement(remindLaterToReceiveEmailRadioButtonBy);
		((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn1);

		//Click on confirm button
		WaitForElementToBeClickable(confirmButtonBy);
		driver.findElement(confirmButtonBy).click();
		WaitForElementToAppear(personalSettingsHeader);
	}

	@SuppressWarnings("deprecation")
	public String getLatestNewsRadiobuttonSelectedState() {

		return driver.findElement(receiveEmailRadioButtonBy).getAttribute("value");

	}

	public void openTheChangeNewsLetterSettingForm(String rowText) throws InterruptedException {
		WaitForElementToAppear(personalSettingsHeader);
		driver.findElement(personalSettingsHeader).click();
		clickOnChangeButtonInTable(rowText);
		Thread.sleep(5000);

	}
}
