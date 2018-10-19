package pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class BaseTest {
	protected WebDriver driver;
	public WebDriverWait wait;
	ChromeOptions chromeoptions = new ChromeOptions();
	
	public BaseTest(){
		chromeoptions.addArguments("start-maximized");
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		driver = new ChromeDriver(chromeoptions);
	}
	
	public void openUrl(String url){
		driver.get(url);
	}
	
	public WebElement find(By locator, Boolean drawRectangle){
		WebElement elem = driver.findElement(locator);
		if (drawRectangle && driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	    }
		return elem;
	}
	
	public BaseTest click(By locator, Boolean drawRectangle) throws InterruptedException{
		Thread.sleep(1000);
		find(locator, drawRectangle).click();
		return this;
	}
	
	public void waitForVisible(By by){
		this.wait = new WebDriverWait(this.driver,  30);
		this.wait.until(ExpectedConditions.visibilityOfElementLocated((by)));
	}
	
	public String getWindowHandle(){
		return this.driver.getWindowHandle();
	}	
	
	public void implicitlyWait(Integer seconds){
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public String currentURL(){
		return driver.getCurrentUrl();		
	}
	
	@AfterClass
	public void closeDriver() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
}
