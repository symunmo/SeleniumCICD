package controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverManager {
	public static WebDriver driver=null;
	private Browsers DriverManager;
	
	public void setWebDriver(String platform) {
		DriverManager = new Browsers(platform);
	}
	
	public void openBrowser(String mode) {
		DriverManager.openBrowser(mode);
		driver= DriverManager.getDriver();
	}
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void closeCurrentTab(){
		driver.close();
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageTitle() {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource() {
		return driver.getPageSource();
	}
}
