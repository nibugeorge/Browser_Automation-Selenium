package Tests;

import PageFunctions.AccountFunctions;
import PageFunctions.CatagoryFunctions;
import PageFunctions.ExpenseFunctions;
import PageFunctions.StaticticsFunctions;
import Utils.Common;
import Utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StatisticsTests {

    public static WebDriver driver;
    AccountFunctions accountFunctions;
    CatagoryFunctions catagoryFunctions;
    ExpenseFunctions expenseFunctions;
    StaticticsFunctions staticticsFunctions;


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
        expenseFunctions=new ExpenseFunctions(driver);
        staticticsFunctions=new StaticticsFunctions(driver);
        accountFunctions.RegUser("tttt","tttt","tttt");
        catagoryFunctions.AddCategory("abcde");
        expenseFunctions.AddExpense("11","1","2001","abcde","20","shopping");

    }

    @Test(priority = 1)
    public void ShowStatTest()  {
        try{
            logger=report.startTest("Show statistics Test");
            result1=staticticsFunctions.ShowStat();
            if(result1==1)
            {
                image1= Common.captureScreenshot(driver,"showstat_pass");
                logger.log(LogStatus.PASS, "Show stat success"+ logger.addScreenCapture(image1));
                expenseFunctions.DeleteExpense(driver);
                catagoryFunctions.DeleteCategory(driver);

            }
            else{
                image1 = Common.captureScreenshot(driver, "showstat_fail");
                logger.log(LogStatus.FAIL, "Show stat failed" + logger.addScreenCapture(image1));
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
