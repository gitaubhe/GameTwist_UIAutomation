package game.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import game.util.AbstractComponents;

public class LoginPage extends AbstractComponents {

	private WebDriver driver;

	private By Nickname_InputText = By.id("username");
	private By Password_InputText = By.id("password");
	private By Login_Button = By.xpath("//button[contains(text(),'Log in')]");
	private By bonus_Button = By.xpath("//a[contains(text(),'Collect')]");
	private By RemindMeLater_RadioButton = By.xpath("//input[contains(@id,'receiveEmailNot now, remind me later')]");
	private By MarketingConsentNo_RadioButton = By.xpath("//input[contains(@id,'marketingConsentNo')]");
	private By Confirm_Button = By.xpath("//a[contains(text(),'Confirm')]");
	private By userProfile = By.xpath("//div[contains(text(),'Ritika64')]");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void login(String userName, String password) throws InterruptedException {
		
		//Enter nickname and password
		WaitForElementToAppear(Nickname_InputText);
		driver.findElement(Nickname_InputText).sendKeys(userName);
		driver.findElement(Password_InputText).sendKeys(password);

		//Click on login button
		WaitForElementToBeClickable(Login_Button);
		driver.findElement(Login_Button).click();

		waitForPageLoad();
		WaitForElementToAppear(userProfile,20);

	}

	public void firstTime_login(String userName, String password) throws InterruptedException {
		
		//Enter nickname and password
		WaitForElementToAppear(Nickname_InputText);
		driver.findElement(Nickname_InputText).sendKeys(userName);
		driver.findElement(Password_InputText).sendKeys(password);

		//Click on login button
		WaitForElementToBeClickable(Login_Button);
		driver.findElement(Login_Button).click();

		//Click on bonus button on pop up
		WaitForElementToBeClickable(bonus_Button);
		driver.findElement(bonus_Button).click();
		
		//Select remind me later radio button
		WaitForElementToAppear(RemindMeLater_RadioButton);
		driver.findElement(RemindMeLater_RadioButton).click();
		
		//Select no marketing consent radio button
		WaitForElementToAppear(MarketingConsentNo_RadioButton);
		driver.findElement(MarketingConsentNo_RadioButton).click();
		
		//Click on confirm button
		driver.findElement(Confirm_Button).click();
		waitForPageLoad();
		WaitForElementToAppear(userProfile,20);

	}

	public String getLoggedInPageTitle() {
		return driver.getTitle();
	}

	public boolean nickNameInoutTextBoxIsDisplayed() {
		return elementIsDisplayed(Nickname_InputText);
	}

	public boolean userProfileIsDisplayed() {
		return elementIsDisplayed(userProfile);
	}

}
