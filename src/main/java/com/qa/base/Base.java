package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	FileInputStream fis;
	public static Properties prop;
	public static WebDriver driver;
	String filePath="C:\\Users\\D E L L\\eclipse-workspace\\BarCodePDFAutomation\\src\\main\\java\\com\\qa\\config\\config.properties";
	String browserName;
	String url;
	Logger log=Logger.getLogger("com.qa.base.Base");
	
	public Base() throws IOException{
		prop=new Properties();
		fis = new FileInputStream(filePath);
		prop.load(fis);	
	}
	public void initialization() {
		browserName=prop.getProperty("browserName");
		if (browserName.equals("chrome")){
			log.info("BrowserName: "+browserName);
			System.setProperty("webdriver.chrome.driver", "C:\\Study\\SeleniumDownloads\\Driver\\chromedriver_win32\\chromedriver_win32_2.35\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		log.info("Launched browser");
		url=prop.getProperty("url2");
		driver.get(url);
		log.info("Launching Url: "+prop.getProperty("url2"));
	}
}
