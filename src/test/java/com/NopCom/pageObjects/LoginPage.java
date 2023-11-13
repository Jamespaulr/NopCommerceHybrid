package com.NopCom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage
{

    public  static WebDriver ldriver;

    public LoginPage(WebDriver rdriver)
    {
       ldriver =rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath = "//input[@id='Email']")
    public WebElement email;
    @FindBy(id = "Password")
    public WebElement password;
    @FindBy(xpath = "//a[@href=\"/login?returnUrl=%2F\"]")
    public WebElement loginButton;

    public void enterUsername(String username)
    {
        email.click();
        email.clear();
        email.sendKeys(username);
    }
    public void enterPassword(String username)
    {
        password.click();
        password.clear();
        password.sendKeys(username);
        password.submit();
    }

}
