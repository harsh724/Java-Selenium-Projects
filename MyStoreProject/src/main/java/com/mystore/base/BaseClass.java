package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.mystore.actiondriver.Action;
public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	@BeforeTest
	public void loadConfig() {
		try {
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//Resources//GolbalData.properties");
			prop.load(fis);
			System.out.println("driver: "+driver);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		if(browserName.contains("Chrome")) {
			driver = new ChromeDriver();
		}else if( browserName.contains("IE")) {
			driver = new InternetExplorerDriver();
		}
		
		
	}
	

}
