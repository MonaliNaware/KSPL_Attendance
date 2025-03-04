package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublicHolidayPage extends BasePage{
	
	public PublicHolidayPage(WebDriver driver)
    {
	   super (driver);
    }
@FindBy(xpath="//tbody/tr[1]/td[5]/div[1]/div[1]/a[1]/button[1]")
WebElement btnEdit;	

@FindBy(xpath="//div[@role='alert']") // holiday updated msg
WebElement msgHeading;

public void clickEdit()
{
	btnEdit.click();
}

public boolean isHolidayUpdated()
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
