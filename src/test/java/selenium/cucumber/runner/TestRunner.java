package selenium.cucumber.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import controller.TestBase;
import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

public class TestRunner extends TestBase {
	protected TestNGCucumberRunner testNGCucumberRunner;


	@BeforeSuite
	public void beforeSuite() {

	}

	@BeforeTest
	public void BeforeTest() {
		
	}

	@BeforeClass
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
		try {
			testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @return returns two dimensional array of {@link CucumberFeatureWrapper}
	 *         objects.
	 */
	@DataProvider
	public Object[][] scenarios() {

		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}

	@AfterTest(alwaysRun = true)
	public void tearDownTests() throws Exception {
		
	}

	@AfterSuite(alwaysRun = true)
	public void tearDownSuite() {

	}
}
