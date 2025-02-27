package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AttendancePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC005_SearchUserTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_SearchUsersResult() throws InterruptedException 
	{
		logger.info("***** Starting TC005_SearchUserTest *****");
		
		try
		{
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("Email"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickSignIn();
		
		AttendancePage ap=new AttendancePage(driver);
		ap.drpdwnUsers();
		ap.clickList();
		
		UsersPage up=new UsersPage(driver);
		up.SetSearch("Rajiv Kumar");
		
		Thread.sleep(3000);
		
		boolean targetPage=up.isSearchWorked();
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
        
		logger.info("***** Finished TC005_SearchUserTest *****");


	}

}
