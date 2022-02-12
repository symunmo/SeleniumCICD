package selenium.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import selenium.product.pages.HomePage;

public class HomePageSteps {
	HomePage homePage = new HomePage();
	
	@Given("^user goes to the EBFS website$")
	public void gotoGoogle() {
		homePage.goToEBFS();
	}
	
	@Then("^verify the homepage title$")
	public void verifyHomePageTitle() {
		homePage.verifyTitle();
	}
	
	@And("^verify the Logo$")
	public void verifyGoogleLogo() {
		homePage.verifyLogo();
	}
}
