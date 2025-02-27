package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
	
	public ProfilePage(WebDriver driver)
    {
	   super (driver);
    }
	
@FindBy(xpath="//input[@name='name']")
WebElement txtName;

@FindBy(xpath="//input[@name='email']")
WebElement txtEmail;

@FindBy(xpath="//button[@id='btn-admin-member-submit']")
WebElement btnUpdate;

@FindBy(xpath="//div[@role='alert']") //updated profile page message
WebElement msgHeading;

public void  setName(String name)
{
	txtName.sendKeys(name);
}

public void  setEmail(String email)
{
	txtEmail.sendKeys(email);
}

public void  clickUpdate()
{
	btnUpdate.click();
}

public boolean isProfileUpdated()
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

}
