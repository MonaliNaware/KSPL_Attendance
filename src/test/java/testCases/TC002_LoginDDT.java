package testCases;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AttendancePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven")//getting data provider from different class
	public void verify_loginDDT(String username, String password, String res)
	
	{
		logger.info("***** Starting TC002_LoginDDT *****");

		try
		{
		LoginPage lp=new LoginPage(driver);
		WebElement email=driver.findElement(By.xpath("//input[@placeholder='Email']"));
		//WebElement pwd=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        Thread.sleep(3000);
        
		email.clear();
		lp.setEmail(username);
        Thread.sleep(3000);
		
        //pwd.clear();
        lp.setPassword(password);
        Thread.sleep(3000);

		lp.clickSignIn();

		AttendancePage ap=new AttendancePage(driver);
		boolean targetPage=ap.isAttendancePageExists();
		
		/*data is valid - login success - test pass - Logout
		                  login failed - test fail
		  Data is invalid - login success - test fail - logout
		                   login failed - test pass                
		 */
		
		//for valid data
		
		if(res.equalsIgnoreCase("valid"))
		{
			
			if(targetPage==true)
			{
				ap.clickProfileImg();
				ap.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				//email.clear();
				//pwd.clear();
			    Assert.assertTrue(false);
			}
		}
		
		//for invalid data
		
		if(res.equalsIgnoreCase("invalid"))
		{
			Thread.sleep(5000);
			lp.isInvalidErrorMsgDisplayed();
			Assert.assertTrue(true);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** Finished TC002_LoginDDT *****");

	}
	
	

}
