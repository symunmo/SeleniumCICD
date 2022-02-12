package controller;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browsers {

	private WebDriver driver = null;
	private String driverName = null;
	private String driverPath = null;
	private String platform = null;
	private String projectPath = Constants.projectPath;
	private String driverFolderPath = Constants.driverFolderPath;
	String driverFileName = null;

	public Browsers(String platform) {
		this.platform = platform;
	}

	private void setDriverNameAndPath() {
		switch (platform.toLowerCase()) {
		case "chrome": {
			driverName = Constants.platform_chromeDriver_name;
//			driverFileName = Constants.platform_chrome_driverPath_win;
			driverFileName = Constants.platform_chrome_driverPath_mac;
			break;
		}
		case "firefox": {
			driverName = Constants.platform_fireFox_name;
			driverFileName = Constants.platform_fireFox_driverPath;
			break;
		}
		case "ie": {
			driverName = Constants.platform_iE_name;
			driverFileName = Constants.platform_iE_driverPath;
			break;
		}
		case "safari": {
			driverName = Constants.platform_safari_name;
			driverFileName = Constants.platform_safari_driverPath;
			break;
		}
		default: {
			throw new IllegalArgumentException("Platfom doesn't exist in this framework");
		}
		}
		driverPath = projectPath + driverFolderPath + driverFileName;
	}

	public void openBrowser(String mode) {
		boolean headLess = (mode.equalsIgnoreCase("headless")) ? true : false;
		setDriverNameAndPath();
		System.setProperty(driverName, driverPath);
		switch (platform.toLowerCase()) {
		case "chrome": {
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(headLess);
			this.driver = new ChromeDriver(options);
			break;
		}
		case "firefox": {
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(headLess);
			this.driver = new FirefoxDriver(options);
			break;
		}
		case "ie": {
			if (headLess) {
				throw new IllegalArgumentException("HeadLess mode does not allowed for " + platform);
			}
			this.driver = new InternetExplorerDriver();
			break;
		}
		case "safari": {
			if (headLess) {
				throw new IllegalArgumentException("HeadLess mode does not allowed for " + platform);
			}
			this.driver = new ChromeDriver();
			break;
		}
		}

		driver.manage().timeouts().implicitlyWait(Constants.GeneralTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public static void main(String[] args) {
		Browsers b = new Browsers(Constants.platform_fireFox);
		b.openBrowser("notheadless");
	}
}
