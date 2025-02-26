package game.util;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void WaitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void WaitForElementToAppear(By findBy, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void WaitForElementToDisAppear(By findBy) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

	public void WaitForElementToBeClickable(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	
	public void WaitForElementToBeClickable(By findBy, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}

	public boolean elementIsDisplayed(By findBy) {
		return driver.findElement(findBy).isDisplayed();

	}

	public void selectdropDownOptionByVisibleText(By findBy, String visibleText) throws InterruptedException {
		WebElement dropdownElement = driver.findElement(findBy);
		dropdownElement.click();
		Thread.sleep(200);
		Select select = new Select(dropdownElement);
		select.selectByContainsVisibleText(visibleText);
	}

	public void selectdropDownOptionByIndex(By findBy, int index) {
		WebElement dropdownElement = driver.findElement(findBy);
		Select select = new Select(dropdownElement);
		select.selectByIndex(index);
	}

	public void selectdropDownOptionByValue(By findBy, String value) {
		WebElement dropdownElement = driver.findElement(findBy);
		Select select = new Select(dropdownElement);
		select.selectByValue(value);
	}

	public void waitForPageLoad() {
		ExpectedCondition<Boolean> cond = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver input) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return js.executeScript("return document.readyState;").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(cond);
	}

	public void scrollToTheElement(By findBy) {
		// Locate the element you want to scroll to
		WebElement element = driver.findElement(findBy);

		// Use JavaScriptExecutor to scroll to the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
}
