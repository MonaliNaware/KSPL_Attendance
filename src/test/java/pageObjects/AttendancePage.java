package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

;

public class AttendancePage extends BasePage{
	
	public AttendancePage(WebDriver driver)
    {
	   super (driver);
    }
	
@FindBy(xpath="//b[normalize-space()='ATTENDANCE']") //Attendance page heading
WebElement msgHeading;

@FindBy(xpath="//img[@class='user-image img-circle elevation-2']") 
WebElement btnProfileImg;

@FindBy(xpath="//a[@class='btn btn-default btn-flat float-right btn-block ']") 
WebElement btnLogout;

@FindBy(xpath="//a[@class=\"nav-link nav-item \"]  //i[@class=\"fa fa-user \"]") 
WebElement drpdwnUsers;

@FindBy(xpath="//a[@href='https://attendance-demo.ourattendance.com/users/list']") 
WebElement btnList;

@FindBy(xpath="//a[contains(@href,'https://attendance-demo.ourattendance.com/users/add')]//p[contains(text(),'Add or Update')]") 
WebElement btnAddOrUpdate;

@FindBy(xpath="//p[normalize-space()='Profile']") 
WebElement btnProfile;

public boolean isAttendancePageExists()
{
	try
	{
		return (msgHeading.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
}

public void clickProfileImg()
{
	btnProfileImg.click();
}

public void clickLogout()
{
	btnLogout.click();
}

public void drpdwnUsers()
{
	drpdwnUsers.click();
}

public void clickList()
{
	btnList.click();
}

public void clickAddOrUpdate()
{
	btnAddOrUpdate.click();
}

public void clickProfile()
{
	btnProfile.click();
}

}
