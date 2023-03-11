package firstJavaSel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class demo {
	@Test(dataProvider= "getData")
	public void test1(HashMap<String, String> input) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//Resources//GolbalData.properties");
		prop.load(fis);
		String BrowserName = prop.getProperty("browser");
		String test = prop.getProperty("test");
		System.out.println(test);
		WebDriver driver;// = new WebDriver();
		if(BrowserName.equalsIgnoreCase("chrome")) {
			System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromewebdriver/chromedriver");
			driver = new ChromeDriver();	
		}
		else {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("https://google.co.in");
		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys(input.get("entry1"));
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		WebElement search = driver.findElement(By.xpath("//input[@aria-label='Search']"));
		search.clear();
		search.sendKeys(input.get("entry2"));
		search.sendKeys(Keys.ENTER);
		System.out.println(takeScreenShot(driver, "test1"));
		driver.close();	
	}
	@DataProvider
	public Object[][] getData() throws SQLException {
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/SeleniumLeraning", "root", "outlookftp@12");
		Statement s = con.createStatement();
		HashMap<String, String> map0 = new HashMap<String, String>();
		ResultSet rs1_1 = s.executeQuery("select searchvalues from searchkeys where entry = 'entry1' and entry_seq = 1;"); 
		while(rs1_1.next()){
		map0.put("entry1", rs1_1.getString("searchvalues"));
		System.out.println(rs1_1.getString("searchvalues"));
		}
		ResultSet rs1_2 = s.executeQuery("select searchvalues from searchkeys where entry = 'entry2' and entry_seq = 1;");
		while(rs1_2.next()) {
			map0.put("entry2", rs1_2.getString("searchvalues"));
			System.out.println(rs1_2.getString("searchvalues"));
		}
		HashMap<String, String> map1 = new HashMap<String, String>();
		ResultSet rs2_1 = s.executeQuery("select searchvalues from searchkeys where entry = 'entry1' and entry_seq = 2;");
		while(rs2_1.next()) {
			map1.put("entry1", rs2_1.getString("searchvalues"));
			System.out.println(rs2_1.getString("searchvalues"));
		}
		ResultSet rs2_2 = s.executeQuery("select searchvalues from searchkeys where entry = 'entry2' and entry_seq = 2;");
		while(rs2_2.next()) {
		map1.put("entry2", rs2_2.getString("searchvalues"));
		System.out.println(rs2_2.getString("searchvalues"));
		}
		
		return new Object[][] {{map0}, {map1}};
	}
	//WebDriver driver;
	public String takeScreenShot(WebDriver driver, String TestCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"/Documents/Screenshot/"+TestCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"/Documents/Screenshot/"+TestCaseName+".png";
	}
	
}
