package com;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConnectBean {
	Properties prop = new Properties();
	Util util = new Util();
	WebDriver driver;
	String url;
	String driverType;
	String driverFile;
	String fileImage;
	String fileDocument;

	public ConnectBean() {
		prop = util.loadProp("connect.properties");
		url = prop.getProperty("url");
		driverType = prop.getProperty("driverType");
		driverFile = prop.getProperty("driverFile");
		fileImage = prop.getProperty("fileImage");
		fileDocument = prop.getProperty("fileDocument");
	}

	public WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		} else {
			return driver;
		}
	}

	public String getUrl() {
		return url;
	}

	public String getSystem() {
		return System.setProperty(driverType, driverFile);
	}

	public Properties getProperty() {
		return prop;
	}

	public void setProperty(Properties prop) {
		this.prop = prop;
	}

	public String getFileImage() {
		Path currentRelativePath = Paths.get("");
		fileImage = currentRelativePath.toAbsolutePath().toString() + fileImage;
		return fileImage;
	}

	public String getFileDocument() {
		Path currentRelativePath = Paths.get("");
		fileDocument = currentRelativePath.toAbsolutePath().toString() + fileDocument;
		return fileDocument;
	}
}