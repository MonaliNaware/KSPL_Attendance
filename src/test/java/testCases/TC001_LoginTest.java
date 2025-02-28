package testCases;

import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AttendancePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void verify_login() {
		
		logger.info("***** Starting TC001_LoginTest *****");
		try
		{
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("Email"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickSignIn();
		
		Thread.sleep(3000);
		
		AttendancePage ap=new AttendancePage(driver);
		boolean targetPage=ap.isAttendancePageExists();
		
		assertTrue(targetPage);//assertEquals(targetPage, true, "Login failed");
		//driver.close();
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** Finished TC001_LoginTest *****");

	}
	
	
}
