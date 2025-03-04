package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AttendancePage;
import pageObjects.HolidayPage;
import pageObjects.LoginPage;
import pageObjects.PublicHolidayPage;
import testBase.BaseClass;

public class TC006_PublicHolidayUpdateTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void verify_publicHolidayUpdate()
	{
		logger.info("***** Started TC006_PublicHolidayUpdateTest *****");
		
		try
		{
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("Email"));
		lp.setPassword(p.getProperty("Password"));
		lp.clickSignIn();
		
		AttendancePage ap=new AttendancePage(driver);
		ap.drpdwnPublicHoliday();
		ap.clickListPH();
		
		PublicHolidayPage php=new PublicHolidayPage(driver);
		php.clickEdit();
		
		HolidayPage hp=new HolidayPage(driver);
		hp.clickSearch();
		hp.clickArea1();
		Thread.sleep(2000);
        hp.clickUpdate();
		
		Thread.sleep(3000);
		
		boolean targetPage=php.isHolidayUpdated();
		Assert.assertTrue(targetPage);
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC006_PublicHolidayUpdateTest *****");

				
	}

}
