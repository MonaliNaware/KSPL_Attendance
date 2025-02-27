package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UsersPage extends BasePage{
	
	public UsersPage(WebDriver driver)
    {
	   super (driver);
    }
	
@FindBy(xpath="//input[@name='emp_id']") 
WebElement txtEmpID;

@FindBy(xpath="//input[@name='name']") 
WebElement txtName;

@FindBy(xpath="//input[@name='mobile_number']") 
WebElement txtMobNo;

@FindBy(xpath="//input[@name='email']") 
WebElement txtEmail;

@FindBy(xpath="//input[@id='password']") 
WebElement txtPassword;

@FindBy(xpath="//input[@name='image']") 
WebElement txtimg;

@FindBy(xpath="//select[@id='designation']") 
WebElement drpDesignation;

@FindBy(xpath="//button[@id='btn-admin-member-submit']") 
WebElement btnAdd;

@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible fade show\"]") //user created message
WebElement msgHeading;

@FindBy(xpath="//input[@type='search']") 
WebElement txtSearch;

@FindBy(xpath="//div[@id='dataTableBuilder_info']") 
WebElement msgHeading2;

public void SetEmpID(String empId)
{
	txtEmpID.sendKeys(empId);
}

public void SetName(String name)
{
	txtName.sendKeys(name);
}

public void SetMobNo(String mobNo)
{
	txtMobNo.sendKeys(mobNo);
}

public void SetEmail(String email)
{
	txtEmail.sendKeys(email);
}

public void SetPassword(String pwd)
{
	txtPassword.sendKeys(pwd);
}

public void SetImg(String img)
{
	txtimg.sendKeys(img);
}

public void drpdwnDesignation()
{
	Select drpDes=new Select(drpDesignation);
	drpDes.selectByValue("7");
}

public void ClickAdd()
{
	btnAdd.click();
}

public boolean isUserCreated()
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

public void SetSearch(String search)
{
	txtSearch.sendKeys(search);
}

public boolean isSearchWorked()
{
	try
	{
		return (msgHeading2.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
}
}
