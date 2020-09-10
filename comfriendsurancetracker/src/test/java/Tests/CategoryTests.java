package Tests;

import PageFunctions.AccountFunctions;
import PageFunctions.CatagoryFunctions;
import Utils.Common;
import Utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CategoryTests {

    public static WebDriver driver;
    AccountFunctions accountFunctions;
    CatagoryFunctions catagoryFunctions;


    String image1;
    int result1;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeTest
    public void setup() throws Exception {
        report = ExtentManager.Instance();
        driver= Common.driverSetup();
        accountFunctions=new AccountFunctions(driver);
        catagoryFunctions=new CatagoryFunctions(driver);
        accountFunctions.RegUser("tttt","tttt","tttt");
    }

    @Test(priority = 1)
    public void AddCatTest()  {
        try{
            logger=report.startTest("Add Category Test");
            result1=catagoryFunctions.AddCategory("abcde");
            if(result1==1)
            {
                image1= Common.captureScreenshot(driver,"catadd_pass");
                logger.log(LogStatus.PASS, "Category add success"+ logger.addScreenCapture(image1));
                //accountFunctions.LogoutUser(driver);

            }
            else{
                image1 = Common.captureScreenshot(driver, "catadd_fail");
                logger.log(LogStatus.FAIL, "Category add failed" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 2)
    public void EditCatTest()  {
        try{
            logger=report.startTest("Edit Category Test");
            result1=catagoryFunctions.EditCategory("qwert");
            if(result1==1)
            {
                image1= Common.captureScreenshot(driver,"catedit_pass");
                logger.log(LogStatus.PASS, "Category edit success"+ logger.addScreenCapture(image1));
                //accountFunctions.LogoutUser(driver);

            }
            else{
                image1 = Common.captureScreenshot(driver, "catedit_fail");
                logger.log(LogStatus.FAIL, "Category edit failed" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 3)
    public void DelCatTest()  {
        try{
            logger=report.startTest("Delete Category Test");
            //catagoryFunctions.AddCategory(driver,"abcde");
            result1=catagoryFunctions.DeleteCategory(driver);
            if(result1==1)
            {
                image1= Common.captureScreenshot(driver,"catdel_pass");
                logger.log(LogStatus.PASS, "Category delete success"+ logger.addScreenCapture(image1));
                //accountFunctions.LogoutUser(driver);

            }
            else{
                image1 = Common.captureScreenshot(driver, "catdel_fail");
                logger.log(LogStatus.FAIL, "Category delete failed" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }



    @AfterTest
    public void endtest() {
        report.endTest(logger);
        report.flush();
        driver.quit();
    }
}
