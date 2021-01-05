package linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickElemet(By locator) {
		wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).click();
	}
	public void clickHrefElement(By locator) { 
		WebDriverWait wait = new WebDriverWait(driver, 100);
//		wait.until(ExpectedConditions.elementToBeClickable(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement button=driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", button);
	}

	public void setFieldText(By locator, String text) {
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	public void sendKeysToInputs(By locator, Keys key) {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);  
		element.sendKeys(key);
	}

	public void setDropdownValue(By locator, String value) {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		Select valueDropdown = new Select(element);
		valueDropdown.selectByVisibleText(value);

	}

	public String getElementText(By locator) {
		wait=new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));  
		return driver.findElement(locator).getText(); 

	}
 
	public boolean isElementDisplayed(By locator) {
		wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).isDisplayed(); 
	}
	
	public void scrollDown(int value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+value+")");
	}
	public String getAttribute(By locator,String attribute) {
		wait=new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); 
		return driver.findElement(locator).getAttribute(attribute);
	} 

}
