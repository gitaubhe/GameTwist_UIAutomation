package game.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import game.util.AbstractComponents;

public class LoggedInPage extends AbstractComponents {

	private WebDriver driver;
	private By userProfile = By.xpath("//div[contains(text(),'Ritika64')]");
	private By personalDataButton = By.xpath("//a[contains(text(),'Personal data')]");
	private By logOutButton = By.xpath("//a[contains(text(),'Log out')]");

	public LoggedInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickOnUserProfile() {		
	
		//Click on user profile
		WaitForElementToAppear(userProfile);
		WaitForElementToBeClickable(userProfile);
		driver.findElement(userProfile).click();
		WaitForElementToAppear(personalDataButton);
	}

	public boolean personalDataButtonIsdisplayed() {
		
		return elementIsDisplayed(personalDataButton);
	}

	public void clickOnPersonalDataButton() {
		
		//Click on personal data from menu 
		WaitForElementToBeClickable(personalDataButton);
		driver.findElement(personalDataButton).click();
		waitForPageLoad();
	}

	public void clickOnLogoutButton() throws InterruptedException {
		
		//Click on logout button from menu 
		WaitForElementToBeClickable(logOutButton);
		driver.findElement(logOutButton).click();
		WaitForElementToDisAppear(logOutButton);
		waitForPageLoad();
	}

}
