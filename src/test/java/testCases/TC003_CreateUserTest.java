package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AttendancePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC003_CreateUserTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public  void verify_userCreation() throws InterruptedException
	{
		logger.info("***** TC003_CreateUserTest *****");

		try
		{
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("Email"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickSignIn();
		
		AttendancePage ap=new AttendancePage(driver);
		ap.drpdwnUsers();
		ap.clickAddOrUpdate();
		
		UsersPage up=new UsersPage(driver);
		String empid=randomAlphanumeric();
		up.SetEmpID(empid);
		up.SetName(randomString().toUpperCase());
		up.SetMobNo(randomNumber());
		up.SetEmail(randomString()+"@gmail.com");
		
		String pwd=randomAlphanumeric();
		up.SetPassword(pwd);
		up.drpdwnDesignation();
		Thread.sleep(3000);

		up.SetImg("C:\\Automation\\img1.JPG");
		
		Thread.sleep(3000);
		up.ClickAdd();
		
		boolean targetPage=up.isUserCreated();
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC003_CreateUserTest *****");

	}

}
