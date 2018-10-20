package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePage extends BaseTest {

	private final String XPATH_LOGIN_USERNAME = ".//*[@placeholder='Email']";
	private final String XPATH_LOGIN_PASSWORD = ".//*[@placeholder='Password']";
	private final String XPATH_LOGIN_LOGIN_BUTTON = ".//*[@type='button']";
	private final String XPATH_LOGOUT_BUTTON = ".//*[@type='button']";

	public Boolean drawRectangles = true;
	
	public HomePage() {
	}	
	
	@Test(priority=1, description="This test will start login page to SF Community")
	public void startSFCommunity() throws InterruptedException{
		
		openUrl("https://sasapokimica-developer-edition.eu16.force.com/s/");
		implicitlyWait(30);
		String currentURL = currentURL();
		
		Assert.assertTrue(currentURL.contains("sasapokimica-developer-edition.eu16.force.com/s/login/"));		
	}
	
	@Test(priority=2, description="This test will verify login passes")//, dependsOnMethods="startSFCommunity")
	public void loginToSFComunity() throws InterruptedException{
		find(By.xpath(XPATH_LOGIN_USERNAME), drawRectangles).sendKeys("sasapokimica@yahoo.com");
		find(By.xpath(XPATH_LOGIN_PASSWORD), drawRectangles).sendKeys("New6662910");
		click(By.xpath(XPATH_LOGIN_LOGIN_BUTTON), drawRectangles);
		Thread.sleep(5000);
		String currentUrl = currentURL();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.endsWith("sasapokimica-developer-edition.eu16.force.com/s/"));
	}
	
	@Test(priority=3, description="Check if Title is correct")//, dependsOnMethods="loginToSFComunity")
	public void verifyCommunityFirstPageContent(){
		
		String val = find(By.className("title"), drawRectangles).getText();
		Assert.assertEquals(val, "Account List 2");
	}
	
	@Test(priority=4, description="This test will verify logout from SF")//, dependsOnMethods="verifyCommunityFirstPageContent")
	public void logoutFromSFCommunity() throws InterruptedException{
		
		click(By.xpath(XPATH_LOGOUT_BUTTON), drawRectangles);
		Thread.sleep(5000);
		String currentUrl = currentURL();
		Assert.assertTrue(currentUrl.equals("https://sasapokimica-dev-ed.my.salesforce.com/"));
	}
}
