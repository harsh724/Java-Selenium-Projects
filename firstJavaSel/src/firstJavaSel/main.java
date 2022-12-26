package firstJavaSel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class main  {
	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		System.getProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//		ChromeOptions option = new ChromeOptions();
//		option.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.co.in");
		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys();
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		WebElement search = driver.findElement(By.xpath("//input[@aria-label='Search']"));
		search.clear();
		search.sendKeys();
		search.sendKeys(Keys.ENTER);
		driver.close();
	}
	

}
