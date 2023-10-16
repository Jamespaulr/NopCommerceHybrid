package com.NopCom.pageObjects;

import com.NopCom.testCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RegisterPage
{

    public  static WebDriver ldriver;
    public RegisterPage(WebDriver rdriver)
    {
        ldriver =rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath = "//a[@href=\"/register?returnUrl=%2F\"]")
    public WebElement registerButton;
    @FindBy(xpath = "//input[@id=\"gender-male\"]")
    public WebElement genderMale;

    @FindBy(xpath = "//input[@id=\"FirstName\"]")
    public WebElement firstName;

    @FindBy(xpath ="//input[@id=\"LastName\"]")
    public WebElement lastName;

    @FindBy(xpath="//select[@name=\"DateOfBirthDay\"]")
    public WebElement DOBDay;

    @FindBy(xpath = "//select[@name=\"DateOfBirthMonth\"]")
    public WebElement DOBMonth;
    @FindBy(xpath = "//select[@name=\"DateOfBirthYear\"]")
    public WebElement DOBYear;

    @FindBy(xpath = "//input[@id=\"Email\"]")
    public WebElement RegEmail;

    @FindBy(xpath = "//input[@id=\"Company\"]")
    public WebElement CompanyName;

    @FindBy(xpath = "//input[@id=\"Newsletter\"]")
    public WebElement NewsLetterCheckBox;

    @FindBy(xpath = "//input[@id=\"Password\"]")
    public WebElement RegPassword;
    @FindBy(xpath = "//input[@id=\"ConfirmPassword\"]")
    public WebElement confirmRegPassword;

    @FindBy(xpath = "//button[@id=\"register-button\"]")
    public WebElement RegButton;
    @FindBy(xpath = "//div[@class='result']")
    public WebElement result;

    public void selectGender(WebElement locator)
    {
        locator.click();
        if (locator.isSelected())  {
            System.out.println("Gender male is selected");
        }
        else
        {
            System.out.println("Gender female is selected");
        }
    }
    public void enterFirstAndLastname(String firstname,String lastname)
    {
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
    }
    public void selectDOBDay(String Day) {
        Select dropDown = new Select(DOBDay);
        dropDown.selectByValue(Day);
    }
    public void selectDOBMonth(String Month) {
        Select dropDown = new Select(DOBMonth);
        dropDown.selectByValue(Month);
    }
    public void selectDOBYear(String Year)
    {
        Select dropDown = new Select(DOBYear);
        dropDown.selectByValue(Year);
    }
    public void enterEmail(String email)
    {
        RegEmail.clear();
        RegEmail.sendKeys(email);
    }
    public void enterCompanyName(String companyName)
    {
        CompanyName.clear();
        CompanyName.sendKeys(companyName);
    }
    public void setNewsLetterCheckBox( int value)
    {
        if(NewsLetterCheckBox.isSelected()==false & value==1)
        {
            NewsLetterCheckBox.click();
        }
        else if (NewsLetterCheckBox.isSelected()==true & value==0)
        {
            NewsLetterCheckBox.click();
        }
    }
    public void setRegPassword(String password)
    {
        RegPassword.clear();
        RegPassword.sendKeys(password);
        confirmRegPassword.clear();
        confirmRegPassword.sendKeys(password);
        confirmRegPassword.submit();
    }







}
