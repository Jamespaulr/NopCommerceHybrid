package com.NopCom.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter
{
    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName = "Test-Report-" + timeStamp + ".html";

        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");

        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name","Administrator");
        extent.setSystemInfo("Tester","James Paul R");

        htmlReporter.config().setDocumentTitle("NopCommerce Test Project");
        htmlReporter.config().setReportName("Functional Test Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }
    public void onTestSuccess(ITestResult tr)
    {
        logger=extent.createTest(tr.getName());
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

    }
    public void onTestFailure(ITestResult tr)
    {
        logger=extent.createTest(tr.getName());
        logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

        String screenShotPath=System.getProperty("user.dir")+"\\Screenshot"+tr.getName()+".png";
        File file= new File(screenShotPath);
        if(file.exists())
        {
            try{
                logger.fail("Screenshot is below"+logger.addScreenCaptureFromPath(screenShotPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void onTestSkipped(ITestResult tr)
    {
        logger=extent.createTest(tr.getName());
        logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREY));
    }
    public void onTestFinish(ITestContext testContext)
    {
        extent.flush();
    }


}
