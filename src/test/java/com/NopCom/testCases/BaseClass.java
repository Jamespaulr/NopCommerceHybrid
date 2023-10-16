package com.NopCom.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass {

    public String url="https://demo.nopcommerce.com/";
    public String adminEmail="SeleniumTesting@gmail.com";
    public String adminPassword="Password@123";
    public static WebDriver driver;
    public static Logger logger;



    @BeforeClass
    public void initBrowser()
    {
        System.setProperty("webdriver.driver.chrome",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        logger=Logger.getLogger("NopCommerceHybrid");
        PropertyConfigurator.configure("Log4j.properties");

    }
    @AfterClass
    public void teardown()
    {
//        driver.quit();
    }



}
