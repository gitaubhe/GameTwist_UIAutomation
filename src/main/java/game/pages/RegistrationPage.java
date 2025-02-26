package game.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import game.util.AbstractComponents;
import game.util.ApplicationHelpers;

public class RegistrationPage extends AbstractComponents {

	private WebDriver driver;

	private By Email_InputText = By.xpath("//input[@name='email']");
	private By Nickname_InputText = By.xpath("//input[@name='nickname']");
	private By Password_InputText = By.xpath("//input[@name='password']");
	private By Day_Dropdown = By.xpath("//select[@name='day']");
	private By Month_Dropdown = By.xpath("//select[@name='month']");
	private By Year_Dropdown = By.xpath("//select[@name='year']");
	private By Recaptcha_Checkbox = By.cssSelector(".recaptcha-checkbox");
	private By TermAccept_InputText = By.xpath("//input[@name='termsAccept']");
	private By BeginAdventure_Button = By.xpath("//button[contains(text(),'Begin adventure')]");
	private By ResendEmail_Button = By.xpath("//button[contains(text(), 'Resend e-mail')]");

	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void enterEmail(String email) {
		ApplicationHelpers.generateUniqueEmail(email);
		driver.findElement(Email_InputText).sendKeys(email);
	}

	public void enterNickname(String nickname) {
		driver.findElement(Nickname_InputText).sendKeys(nickname);
	}

	public void enterPassword(String password) {
		driver.findElement(Password_InputText).sendKeys(password);
	}

	public void selectBirthdate(int day, int month, int year) {
		// Select day
		Select select = new Select(driver.findElement(Day_Dropdown));
		select.selectByValue(Integer.toString(day));

		// Select month
		select = new Select(driver.findElement(Month_Dropdown));
		select.selectByValue(Integer.toString(month));

		// Select year
		select = new Select(driver.findElement(Year_Dropdown));
		select.selectByValue(Integer.toString(year));

	}

	public void checkNotRobotRecaptcha() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down by a specific number of pixels (e.g., 1000 pixels)
		js.executeScript("window.scrollBy(0, 1000);");

		// Switch to captcha frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));

		//Click on recaptcha checkbox
		driver.findElement(Recaptcha_Checkbox).click();
		Thread.sleep(1000);

		driver.switchTo().defaultContent();

		Thread.sleep(1000);

	}

	public void acceptTermsAndConditions() {
		driver.findElement(TermAccept_InputText).click();
	}

	public void clickOnBeginAdventureButton() {
		driver.findElement(BeginAdventure_Button).click();
		WaitForElementToAppear(ResendEmail_Button);
	}

	public String getRegistrationSuccessfulMessage() {
		return driver.getTitle();
	}

	public boolean emailTextboxIsDisplayed() {
		return elementIsDisplayed(Email_InputText);
	}

	public boolean resendButtonIsDisplayed() {
		return elementIsDisplayed(ResendEmail_Button);
	}

}
