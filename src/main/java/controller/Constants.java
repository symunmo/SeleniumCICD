package controller;

public interface Constants {
	public final String projectPath= System.getProperty("user.dir");
	public final String driverFolderPath= "/src/main/resources/drivers";
	public final String setupFilePath= "/src/main/resources/setup.properties";
	public final String propertyFilesPath = "/src/test/resources/testProperties/";
	public final String platform_chrome= "chrome";
	public final String platform_fireFox= "firefox";
	public final String platform_ie= "iE";
	public final String platform_safari= "safari";
	
	public final String platform_chromeDriver_name="webdriver.chrome.driver";
	public final String platform_fireFox_name = "webdriver.gecko.driver";
	public final String platform_iE_name = "webdriver.ie.driver";
	public final String platform_safari_name = null;
	
	public final String platform_chrome_driverPath_win= "/cromeDriver/chromedriver.exe";
	public final String platform_chrome_driverPath_mac= "/cromeDriver/chromedriver";
	public final String platform_fireFox_driverPath="/fireFoxDriver/geckodriver";
	public final String platform_iE_driverPath="/iEDriver/IEDriverServer";
	public final String platform_safari_driverPath="/safariDriver/";
	
	public final String google_url= "http://www.google.com";
	public final String EBFS_url= "https://phptravels.com/demo/";

	
	
	public final long GeneralTimeOut = 10;
	
	public final String headLess = "headLess";
}
