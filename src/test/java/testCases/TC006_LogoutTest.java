package testCases;

import org.testng.annotations.Test;

import pageObjects.AttendancePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC006_LogoutTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void Verify_Logout() throws InterruptedException
	{
		logger.info("***** Starting TC006_LogoutTest *****");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("Email"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickSignIn();
		
		AttendancePage ap=new AttendancePage(driver);

		ap.clickProfileImg();
		Thread.sleep(3000);
		ap.clickLogout();
	}

}
