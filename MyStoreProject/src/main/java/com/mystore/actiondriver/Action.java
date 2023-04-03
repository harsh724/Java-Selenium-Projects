package com.mystore.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actioninterface.ActionInterface;
import com.mystore.base.BaseClass;

public class Action extends BaseClass  implements ActionInterface{
	@Override
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", ele);
		
	}

	@Override
	public void click(WebDriver ldriver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
		
	}

	@Override
	public boolean isDisplayed(WebDriver ldriver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if(flag) {
			flag = ele.isDisplayed();
			if(flag) {
			System.out.println("The element is not displayed");
			}
			else
			System.out.println("The element is not displayed");
		}else
			System.out.println("Not Displayed");
		return flag;
	}

	@Override
	public boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;
		}catch(Exception e) {
			System.out.println("Location not found");
			flag = false;
		}
		finally {
		if(flag)
			System.out.println("Sucessfully entered Value");
		else
			System.out.println("Unable to enter value");
		}
		return flag;
	}

	@Override
	public boolean findElement(WebDriver ldriver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		}catch(Exception e) {
			flag = false;
		}finally {
			if(flag) {
				System.out.println("Successfully found element at");
			}else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}

	@Override
	public boolean isSelected(WebDriver ldriver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if(flag) {
			flag = ele.isSelected();
			if(flag)
				System.out.println("The element is selected");
			else
				System.out.println("The elemenet is not selected");
		}
		else
			System.out.print("Not selected");
		return flag;
	}

	@Override
	public boolean isEnabled(WebDriver ldriver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if(flag) {
			flag = ele.isEnabled();
			if(flag)
				System.out.println("The element is selected");
			else
				System.out.println("The elemenet is not selected");
		}
		else
			System.out.print("Not selected");
		return flag;
	}

	@Override
	public boolean selectBySendkeys(String value, WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return flag;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag)
				System.out.println("Select value from drop down");
			else
				System.out.println("Not selected value from drop down");
		}
	}

	@Override
	public boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag)
				System.out.println("option select by index");
			else
				System.out.println("Option not selected by index");
		}
	}

	@Override
	public boolean selectByValue(WebElement element, String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag)
				System.out.println("option select by value");
			else
				System.out.println("option not selected by value");
		}
	}

	@Override
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag)
				System.out.println("option select by visible text");
			else
				System.out.println("option not selected by visible text");
		}
	}

	@Override
	public boolean mouseHoverByJavaScript(WebElement locator) {
		
		return false;
	}

	@Override
	public boolean JSClick(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToFrameByIndex(WebDriver driver, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToFrameById(WebDriver driver, String idValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToFrameByName(WebDriver driver, String nameValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchToDefaultFrame(WebDriver driver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mouseOverElement(WebDriver driver, WebElement element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean moveToElement(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseover(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean draggable(WebDriver driver, WebElement source, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean draganddrop(WebDriver driver, WebElement source, WebElement target) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rightclick(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag)
				System.out.println("Right Click Performed");
			else
				System.out.println("Right Click not performed");
		}
	}

	@Override
	public boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();
			String[] array = windowList.toArray(new String[0]);
			driver.switchTo().window(array[count-1]);
			if(driver.getTitle().contains(windowTitle))
				flag = true;
			else flag = false;
			return flag;
		}catch(Exception e) {
			return flag;
		}finally {
			if(flag) {
				System.out.println("Navigated to the window title");
			}else
				System.out.println("The Window with title is not selected");
		}
	}

	@Override
	public boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {
			Set<String> s = driver.getWindowHandles();
			Object popup[]= s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Focus navigated to the window with title");
			}else {
				System.out.println("The window with title : is not selected");
			}
		}
	}

	@Override
	public boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {
			Set<String> s = driver.getWindowHandles();
			Object popup[]= s.toArray();
			driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		}catch(Exception e) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Focus navigated to the window with title");
			}else {
				System.out.println("The window with title : is not selected");
			}
		}
	}

	@Override
	public int getColumncount(WebElement row) {
		List<WebElement> l = driver.findElements(By.tagName("td"));
		int a = l.size();
		System.out.println(a);
		for(WebElement ls : l) {
			System.out.println(ls.getText());
			System.out.println("|");
		}
		return a;
	}

	@Override
	public int getRowCount(WebElement table) {
		List<WebElement> ls = driver.findElements(By.tagName("tr"));
		int a = ls.size()-1;
		System.out.println(ls.size());
		return a;
	}

	@Override
	public boolean Alert(WebDriver driver) {
		boolean presentFlag = false;
		Alert alert = null;
		try {
			alert = driver.switchTo().alert();
			alert.accept();
			presentFlag = true;
		}catch(NoAlertPresentException ex) {
			ex.printStackTrace();
		}finally {
			if(!presentFlag) {
				System.out.println("The Alert is handeled successfully");
			}else
				System.out.println("There was not alert");
		}
		return presentFlag;
	}

	@Override
	public boolean launchUrl(WebDriver driver, String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		}catch(Exception ex) {
			return false;
		}finally {
			if(flag) {
				System.out.println("Navigated to URL : "+url);
			}else
				System.out.println("Error in URL");
		}
		
	}

	@Override
	public boolean isAlertPresent(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().alert();
			flag = true;
			return true;
		}catch(NoAlertPresentException ex) {
			return false;
		}
	}

	@Override
	public String getCurrentURL(WebDriver driver) {
		String presentURL=null;
		try {
			presentURL = driver.getCurrentUrl();
			System.out.println("Current URL is : \""+presentURL+"\"");
		}catch(Exception ex) {
			System.out.println("URL not found");
			return null;
		}
		return presentURL;
	}

	@Override
	public String getTitle(WebDriver driver) {
		boolean flag = false;
		String text = null;
		try {
		text = driver.getTitle();
		flag = true;
		}catch(Exception ex) {
			flag = false;
		}finally {
			if(flag) {
				return text;
			}else
			System.out.println("No Title found");
		}
		return text;
	}

	@Override
	public boolean click1(WebElement locator, String locatorName) {
		boolean flag = false;
		try {
			locator.click();
			flag = true;
		}catch(Exception e) {
			flag = false;
		}finally {
			if(flag) {
				System.out.println("Able to click on\""+locatorName+"\"");
			}
			else
				System.out.println("unable to click on\""+locatorName+"\"");
		}
		return false;
	}

	@Override
	public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		//WebDriverWait wait = new WebDriverWait(driver, timeOut);
	Wait<WebDriver> wait = null;
	try{
		wait = new FluentWait<WebDriver>((WebDriver)driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		element.click();
	}catch(Exception e) {}
		
	}

	@Override
	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	@Override
	public void explicitWait(WebDriver driver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	@Override
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
		
	}

	@Override
	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File source = takescreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\ScreenShots\\"+filename+"_"+dateName+".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		}catch(Exception e) {
			e.getMessage();
		}//todo
		String newImageString = null ;
		return newImageString;
	}

	@Override
	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		
		return currentDate;
	}

	@Override
	public List<WebElement> FindElements(WebDriver driver, By ele) {
		boolean flag = false;
		List<WebElement> list = null;
		try {
			list = driver.findElements(ele);
			flag = true;
		}catch(Exception exe) {
			flag = false;
		}finally {
			if(flag) return list;
			else System.out.println("no element found");
		}
		return list;

	}

	

}
