package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HolidayPage extends BasePage{

	public HolidayPage(WebDriver driver)
    {
	   super (driver);
    }
	
@FindBy(xpath = "//input[@role='searchbox']")	
WebElement searchBox;

@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")	
WebElement slctArea1;

@FindBy(xpath = "//button[@id='btn-admin-member-submit']")	
WebElement btnUpdate;


public void clickSearch()
{
	searchBox.click();
}

public void clickArea1()
{
	slctArea1.click();
}

public void clickUpdate()
{
	btnUpdate.click();
}
}
