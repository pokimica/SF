package selenium;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstLoginTest {

	WebDriver driver;
	ChromeOptions chromeoptions = new ChromeOptions();
	
	public FirstLoginTest() {
		chromeoptions.addArguments("start-maximized");
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
	}
	
	
	@Test(priority=1, description="This test will verify login page to SF Community")
	public void startSFCommunity() throws InterruptedException{
		
		
		driver = new ChromeDriver(chromeoptions);
		driver.get("https://sasapokimica-developer-edition.eu16.force.com/s/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentURL = driver.getCurrentUrl();
		
		Assert.assertTrue(currentURL.contains("sasapokimica-developer-edition.eu16.force.com/s/login/"));
		
	}
	
	@Test(priority=2, description="This test will verify login passes", dependsOnMethods="startSFCommunity")
	public void loginToSFComunity() throws InterruptedException{
		
		driver.findElement(By.xpath(".//*[@placeholder='Email']")).sendKeys("sasapokimica@yahoo.com");
		driver.findElement(By.xpath(".//*[@placeholder='Password']")).sendKeys("New6662910");
		driver.findElement(By.xpath(".//*[@type='button']")).click();
		Thread.sleep(5000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.endsWith("sasapokimica-developer-edition.eu16.force.com/s/"));
	}
	
	@Test(priority=3, description="Check if Title is correct", dependsOnMethods="loginToSFComunity")
	public void verifyCommunityFirstPageContent(){
		
		String val = driver.findElement(By.className("title")).getText();
		Assert.assertEquals(val, "Account List 2");
	}
	
	@Test(priority=4, description="This test will verify logout from SF", dependsOnMethods="verifyCommunityFirstPageContent")
	public void logoutFromSFCommunity(){
		
		System.out.println("checkOut");
	}
	
	@AfterClass
	public void closeDriver() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
}
