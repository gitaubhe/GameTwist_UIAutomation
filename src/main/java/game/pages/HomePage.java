package game.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import game.util.AbstractComponents;

public class HomePage extends AbstractComponents {

	private WebDriver driver;

	private By Register_Button = By.xpath("//a[text()='Register']");
	private By Login_Button = By.xpath("//a[text()='Login']");
	private By AcceptAllCookies_Button = By.id("onetrust-accept-btn-handler");

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getHomePageTitle() {
		return driver.getTitle();
	}

	public void ClickOnRegisterButton() throws InterruptedException {
		
		//Accept all cookies
		WaitForElementToBeClickable(AcceptAllCookies_Button);
		driver.findElement(AcceptAllCookies_Button).click();

		//Click on register button
		WaitForElementToBeClickable(Register_Button);
		driver.findElement(Register_Button).click();
		WaitForElementToDisAppear(Register_Button);
	}

	public void clickOnLoginButton() throws InterruptedException {
		
		//Accept all cookies
		WaitForElementToBeClickable(AcceptAllCookies_Button);
		driver.findElement(AcceptAllCookies_Button).click();

		//Click on login button
		WaitForElementToBeClickable(Login_Button);
		driver.findElement(Login_Button).click();
	}

	public boolean IsLoginButtonDisplayed() {

		return elementIsDisplayed(Login_Button);
	}

}
