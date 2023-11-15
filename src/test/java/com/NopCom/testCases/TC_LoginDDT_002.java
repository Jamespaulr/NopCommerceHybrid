package com.NopCom.testCases;

import com.NopCom.pageObjects.LoginPage;
import com.NopCom.utilities.XLUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass
{
    @Test(dataProvider="LoginData")

    public void loginDDT(String user ,String pwd) throws InterruptedException {
        LoginPage lp=new LoginPage(driver);
        lp.enterUsername(user);
        logger.info("user name entered");
        lp.enterPassword(pwd);
        logger.info("Password entered");
        Thread.sleep(3000);
        if (driver.getTitle().equals("nopCommerce demo store"))
        {
            Assert.assertTrue(true);
            logger.info("Login Success");
            lp.logout();
            driver.switchTo().defaultContent();
        }
        else
        {
            Assert.assertTrue(false);
            logger.info("Login failed");
            driver.switchTo().defaultContent();
        }

    }


    @DataProvider(name="LoginData")
    String [] [] getData() throws IOException {
        String path =System.getProperty("user.dir")+"/src/test/java/com/NopCom/testData/LoginData.xlsx";
        int rownum= XLUtils.getRowCount(path,"Sheet1");
        int colCount=XLUtils.getCellCount(path, "Sheet1",1);
        String loginData [] [] = new String[rownum][colCount];

        for (int i =1; i<=rownum;i++)
        {
            for (int j=0; j<colCount;j++)
            {
                loginData[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
            }
        }
        return loginData;
    }


}
