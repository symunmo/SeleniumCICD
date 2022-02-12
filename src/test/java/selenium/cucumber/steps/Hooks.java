package selenium.cucumber.steps;

import controller.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
//ToDos - add fail screenshot
public class Hooks extends TestBase {
	@Before
	public void beforeScenerio() {
		loadProperyFile("setup");
		setWebDriver(getProperty("Browser"));
		openBrowser(getProperty("BrowserMode"));
	}

	@After
	public void afterScenerio() {
		addScreenShotToReport();
		closeBrowser();
	}
}
