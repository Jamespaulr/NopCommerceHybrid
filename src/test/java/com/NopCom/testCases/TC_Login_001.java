package com.NopCom.testCases;
import com.NopCom.pageObjects.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_Login_001 extends BaseClass
{
    public TC_Login_001() throws IOException {
    }
    @Test
    public void LoginTest() throws IOException {

        TC_Register_001 tcRegister001= new TC_Register_001();
        tcRegister001.RegisterTest();
        logger.info("Getting the url");
        driver.get(url);
        LoginPage loginPage=new LoginPage(driver);
        logger.info("entering admin email");
        loginPage.loginButton.click();
        loginPage.enterUsername(adminEmail);
        logger.info("entering admin email");
        loginPage.enterPassword(adminPassword);
        logger.info("asserting whether the expected value is been seen");
        System.out.println(driver.getTitle());
        if (driver.getTitle().equals("nopCommerce demo store"))
        {
            Assert.assertTrue(true,"It is Passed");
            logger.info("Asserted...The testcase passed");
        }
        else
        {
            Assert.assertTrue(false,"It is Failed");
            logger.info("Asserted...The testcase failed");
        }
    }
}
