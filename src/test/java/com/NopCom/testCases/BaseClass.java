package com.NopCom.testCases;

import com.NopCom.utilities.ReadConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class BaseClass {
    ReadConfig readConfig=new ReadConfig();

    public String url= readConfig.getApplicationURL();
    public String adminEmail= readConfig.getAdminEmail();
    public String adminPassword= readConfig.getAdminPassword();
    public static WebDriver driver;
    public static Logger logger;
    @Parameters("Browser")
    @BeforeClass
    public void initBrowser(String br)
    {
        logger=Logger.getLogger("NopCommerceHybrid");
        PropertyConfigurator.configure("Log4j.properties");
        if (br.equals("Chrome")) {
            System.setProperty("webdriver.driver.chrome", readConfig.getChromePath());
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (br.equals("Edge"))
        {
            System.setProperty("webdriver.driver.edge", readConfig.getEdgePath());
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        driver.get(readConfig.getApplicationURL());
    }
    @AfterClass
    public void teardown()
    {
//        driver.quit();
    }
}
