package selenium.product.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import controller.Constants;
import controller.TestBase;

public class HomePage extends TestBase {
	private Logger logger = Logger.getLogger(getClass().getSimpleName());
	@FindBy(id = "PHPTRAVELS")
	@CacheLookup
	WebElement logo;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
		loadProperyFile(this.getClass().getSimpleName());
	}

	public void goToEBFS() {
		goTo(Constants.EBFS_url);
		logger.info("Navigated to: "+Constants.EBFS_url);
	}

	public void verifyTitle() {
		String actual = driver.getTitle();
		String expected = getProperty("HomePage.Title.Text");
		Assert.assertEquals(actual, expected, "Wrong Title. ");
		logger.info("Title verified as: "+expected);
	}
	
	public void verifyLogo() {
		Assert.assertTrue(logo.isDisplayed());
		logger.info("Verified that EBFS Logo is displayed");
	}

}
