package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class contains reusable methods of webDriver
 * @author admin
 */

public class WebDriverUtility {

	private WebDriver driver;
	/**
	 * This method is used to navigate to an application using user desired browser
	 * @param browser
	 * @param url
	 * @param time 
	 * @return
	 */
	public WebDriver openApplication1(String browser,String url, long time) {
		switch(browser) {
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		default:System.out.println("invalid browser data");
		
		
		}
		driver.manage().window().maximize();
		driver.get("url");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		
		return driver ;
	}
	/**
	 * This method is used to wait until the visibility of particular element
	 * @param element
	 * @param time
	 * @return
	 */
	public WebElement explicitWait(WebElement element,long time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to perform mouse hover actions on an element
	 * @param source
	 * @param target
	 */
	public void mouseHover(WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method is used to perform mouseHover on an element
	 * @param source
	 * @param target
	 */
	public void doubleClickOnElement(WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
/**
 * This method is used to drag and drop the element from source to target
 * @param source
 * @param target
 */
	public void dragAndDropElement(WebElement  source,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source,target).perform();
	} 
	/**
	 * This method is used to select an element from drop down based on the index
	 * @param element
	 * @param index
	 */
	
	public void drapdown (WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select an element from drop down based on the visible text
	 * @param element
	 * @param text
	 */
	public void drapdown(WebElement element,String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method is used to select an element from drop down based on the value
	 * @param value
	 * @param element
	 */
	public void drapdown (String value,WebElement element) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is used to scroll till the element
	 * @param  
	 * @param 
	 */
	public void scrollToElement() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)");
	}
	/**
	 * This method is used to take screenshot of web page
	 */
	public void takeScreenshot() {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshot/screenshot.png");
		try {
			FileUtils.copyFile(src,dest);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 *  This method is used to handle alert pop up
	 
	 */
	public void handleAlert() {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to switch to the child browser
	 */
	public void switchToChildBrowser() {
		Set<String> set=driver.getWindowHandles();
		for(String windowID: set) {
			driver.switchTo().window(windowID);
		}
	}
	/**
	 * This method is used to switch to the frame
	 */
	public void switchToFrame() {
		driver.switchTo().frame(0);
	}
	/**
	 * This method is used to switch back to the frame
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to close the current tab
	 */
	public void closeCurrentWindow() {
		driver.close();
	}
	/**
	 * This method is used to close all the tabs and exit webDriver
	 */
	public void quitBrowser() {
		driver.quit();
	}
	public WebDriver openApplication(String fetchProperty, String fetchProperty2) {
		// TODO Auto-generated method stub
		return null;
	
	}
}
	
	

		
	
	
		
		

	


