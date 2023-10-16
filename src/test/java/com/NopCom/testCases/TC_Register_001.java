package com.NopCom.testCases;

import com.NopCom.pageObjects.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TC_Register_001 extends BaseClass
{
    @Test
    public void RegisterTest()
    {
        driver.get(url);
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.registerButton.click();
        registerPage.selectGender(registerPage.genderMale);
        registerPage.enterFirstAndLastname("James","Paul");
        registerPage.selectDOBDay("2");
        registerPage.selectDOBMonth("8");
        registerPage.selectDOBYear("1999");
        registerPage.enterEmail("SeleniumTesting@gmail.com");
        registerPage.enterCompanyName("Testing.co.pvt");
        registerPage.setNewsLetterCheckBox(0);
        registerPage.setRegPassword("Password@123");
    }
}
