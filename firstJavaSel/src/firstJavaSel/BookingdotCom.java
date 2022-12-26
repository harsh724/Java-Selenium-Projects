package firstJavaSel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookingdotCom {
	@Test(dataProvider = "getData")
	public void test(HashMap<String, String> map) throws IOException, Exception, SQLException {
		// Setting the .properties files
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//Resources//GolbalData.properties");
		// load that file into fis
		prop.load(fis);
		String browser = prop.getProperty("browser");
		WebDriver driver;
		// checking if the file has browser named Chrome
		if (browser.equalsIgnoreCase("chrome")) {
			System.getProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//chromewebdriver//chromediver");
			driver = new ChromeDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		// connecting to database and fetching login daetails;
		String host = "localhost";
		String port = "3306";
		Connection con2 = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/SeleniumLeraning", "root",
				"outlookftp@12");
		Statement s2 = con2.createStatement();
		ResultSet rs = s2.executeQuery("Select * from logincred where name = 'Harsh Verma';");
		rs.next();
		String id = rs.getString("Login_id");
		String pass = rs.getString("password");
		// deleting all the cookies
		driver.manage().deleteAllCookies();
		// navigating to booking.com web site
		driver.get("https://www.booking.com/");
		// maximizing the window
		driver.manage().window().maximize();
		// fetching data for location(entry 1 )from map
		driver.findElement(By.id("ss")).sendKeys(map.get("entry1"));
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 50);
		// explicit wait for Locator(entry 2)
		(new WebDriverWait(driver, 50)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					driver.findElement(By.xpath(map.get("entry2"))).click();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		});
		// selecting current
		(new WebDriverWait(driver, 50)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {

				try {
					WebElement todayDate = driver.findElement(By.cssSelector("[class=\"bui-calendar__date bui-calendar__date--today\"]"));
					todayDate.click();
					
					//int dateSecond = Integer.parseInt(todayDate.getText())+3;
					// selecting second date
					driver.findElement(By.cssSelector("span[aria-label='27 December 2022'] span[aria-hidden='true']"))
							.click();
					// clicking on submit button
					driver.findElement(By.cssSelector("button[type = 'submit'] span[class=\"js-sb-submit-text \"]"))
							.click();
					// clicking on sign in button
					driver.findElement(By.xpath("(//span[@class=\"bui-button__text\"])[5]")).click();
					// clicking on the signing option facebook
					driver.findElement(By.cssSelector(
							"[class*=\"access-panel__social-button access-panel__social-button-facebook\"]")).click();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		});
		// collecting the window handles in a Set ands itterating it
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		String parent = itr.next(); // for main window
		String child = itr.next(); // for facebook window
		// switching on facebook window
		driver.switchTo().window(child);
		// logging in to facebook.com with credentials
		driver.findElement(By.id("email")).sendKeys(id);
		driver.findElement(By.id("pass")).sendKeys(pass);
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);
		// switching to main window
		driver.switchTo().window(parent);
		// waiting for elements to be appeared
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"bui-avatar-block__text\"]")));
		// click on the profile
		driver.findElement(By.cssSelector("[class=\"bui-avatar-block__text\"]")).click();
		// click on manage account
		driver.findElement(By.xpath("(//a[@class=\"bui-dropdown-menu__button\"])[1]")).click();
		// checking using assert
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("[class*=\"x9mw82OGJDdT97ho7Wyc\"][css='1']")));
		/*String expected = "Manage your Booking.com experience";
		Assert.assertEquals(expected,
				driver.findElement(By.cssSelector("[class*=\"x9mw82OGJDdT97ho7Wyc\"][css='1']")).getText());
		 */
		// Assert.assertTrue(true,
		// driver.findElement(By.cssSelector("[class*=\"x9mw82OGJDdT97ho7Wyc\"][css='1']")).getText());

		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws SQLException {
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/SeleniumLeraning", "root",
				"outlookftp@12");
		Statement s = con.createStatement();
		HashMap<String, String> map0 = new HashMap<>();
		ResultSet res1_1 = s.executeQuery("select * from booking where city = 'New Delhi';");
		while (res1_1.next()) {
			map0.put("entry1", res1_1.getString("City"));
			map0.put("entry2", res1_1.getString("Locator"));
		}
		HashMap<String, String> map1 = new HashMap<>();
		ResultSet res1_2 = s.executeQuery("select * from booking where city = 'jaipur';");
		while (res1_2.next()) {
			map1.put("entry1", res1_2.getString("City"));
			map1.put("entry2", res1_2.getString("Locator"));
		}

		return new Object[][] { { map0 }, { map1 } };
	}
}
