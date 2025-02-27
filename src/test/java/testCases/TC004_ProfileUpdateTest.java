package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AttendancePage;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import testBase.BaseClass;

public class TC004_ProfileUpdateTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_profileUpdate() throws InterruptedException 
	{
		logger.info("***** Starting TC004_ProfileUpdateTest *****");

		try
		{
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("Email"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickSignIn();	
			
		AttendancePage ap=new AttendancePage(driver);
		ap.clickProfile();
		
		ProfilePage pp=new ProfilePage(driver);
		driver.findElement(By.xpath("//input[@name='name']")).clear();
		pp.setName("Monali");
		//pp.setEmail("monalinaware@maildrop.cc");
		
		Thread.sleep(5000);
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scroll(0,30000)");
		Thread.sleep(5000);

		pp.clickUpdate();
		
		boolean targetPage=pp.isProfileUpdated();
		Assert.assertTrue(targetPage);
		
		}
	catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC004_ProfileUpdateTest *****");

	}

}
