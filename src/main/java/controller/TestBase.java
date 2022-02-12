package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.OutputType;

import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.common.io.Files;

import controller.WebDriverManager;

public class TestBase extends WebDriverManager {
//TODOS- COMFIGURE EXCELSHEET
	private FileInputStream file;
	public Properties prop;
	private Logger logger = Logger.getLogger(getClass().getSimpleName());
	

	public String getProperty(String key) {
		String value = prop.getProperty(key);
		logger.info("key: " + key + "\nValue: " + value);
		return value;
	}

	public void loadProperyFile(String name) {
		if (name.equalsIgnoreCase("setup")) {
			loadPropFile(Constants.projectPath + Constants.setupFilePath);
		} else {
			loadPropFile(Constants.projectPath + Constants.propertyFilesPath + name + ".Properties");
		}
		logger.info("Loaded the following property file: " + name);
	}

	private void loadPropFile(String path) {
		try {
			file = new FileInputStream(path);
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String takeScreenShot() {
		String relPath = "/screenshots/"+getTimeStamp()+".png";
		String path = Constants.projectPath+ "/reports"+relPath;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(source, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Screenshot is taken");
		return path;
	}
	
	public void addScreenShotToReport() {
		String imagePath = takeScreenShot();
		try {
			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(imagePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getTimeStamp() {
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return ts.toString().replaceAll(":", "-");
		
	}

}
