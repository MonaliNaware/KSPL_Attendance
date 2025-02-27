package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
    {
	   super (driver);
    }

@FindBy(xpath="//input[@placeholder='Email']")
WebElement txtEmail;

@FindBy(xpath="//input[@placeholder='Password']")
WebElement txtPassword;

@FindBy(xpath="//button[@type='submit']")
WebElement btnSignIn;

@FindBy(xpath="//div[@class=\"invalid-feedback\"]")
WebElement invalidMsg;


public void  setEmail(String email)
{
	txtEmail.sendKeys(email);
}

public void  setPassword(String pwd)
{
	txtPassword.sendKeys(pwd);
}

public void  clickSignIn()
{
	btnSignIn.click();
	
}

public boolean isInvalidErrorMsgDisplayed()
{
	try
	{
		return (invalidMsg.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
}


}
