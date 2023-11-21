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
    public void loginDDT(String user,String pwd) throws InterruptedException
    {
        LoginPage lp=new LoginPage(driver);
        lp.loginButton.click();
        lp.enterUsername(user);
        logger.info("user name provided");
        lp.enterPassword(pwd);
        logger.info("password provided");

        Thread.sleep(3000);

    }
    @DataProvider(name="LoginData")
    String [][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"/src/test/java/com/NopCom/testData/TestData.xlsx";

        int rownum=XLUtils.getRowCount(path, "Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
            }
        }
        return logindata;
    }
}
