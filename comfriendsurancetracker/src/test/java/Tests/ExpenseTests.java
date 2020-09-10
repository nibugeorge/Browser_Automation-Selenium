package Tests;

import PageFunctions.AccountFunctions;
import PageFunctions.CatagoryFunctions;
import PageFunctions.ExpenseFunctions;
import Utils.Common;
import Utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExpenseTests {
    public static WebDriver driver;
    AccountFunctions accountFunctions;
    CatagoryFunctions catagoryFunctions;
    ExpenseFunctions expenseFunctions;


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
        accountFunctions.RegUser("tttt","tttt","tttt");

    }

    @Test(priority = 1)
    public void AddExpTest()  {
        try{
            logger=report.startTest("Add Expense Test");
            catagoryFunctions.AddCategory("abcde");
            result1=expenseFunctions.AddExpense("11","1","2001","abcde","20","shopping");
            if(result1==1)
            {
                image1= Common.captureScreenshot(driver,"expadd_pass");
                logger.log(LogStatus.PASS, "Expense add success"+ logger.addScreenCapture(image1));
                //accountFunctions.LogoutUser(driver);

            }
            else{
                image1 = Common.captureScreenshot(driver, "expadd_fail");
                logger.log(LogStatus.FAIL, "Expense add failed" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 2)
    public void EditExpTest()  {
        try{
            logger=report.startTest("Edit Expense Test");
            result1=expenseFunctions.EditExpense("25");
            if(result1==1)
            {
                image1= Common.captureScreenshot(driver,"expedit_pass");
                logger.log(LogStatus.PASS, "Expense edit success"+ logger.addScreenCapture(image1));
                //accountFunctions.LogoutUser(driver);

            }
            else{
                image1 = Common.captureScreenshot(driver, "expedit_fail");
                logger.log(LogStatus.FAIL, "Expense edit failed" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 3)
    public void DelExpTest()  {
        try{
            logger=report.startTest("Delete Expense Test");
            //catagoryFunctions.AddCategory(driver,"abcde");
            result1=expenseFunctions.DeleteExpense(driver);
            if(result1==1)
            {
                image1= Common.captureScreenshot(driver,"expdel_pass");
                logger.log(LogStatus.PASS, "Expense delete success"+ logger.addScreenCapture(image1));
                catagoryFunctions.DeleteCategory(driver);

            }
            else{
                image1 = Common.captureScreenshot(driver, "expdel_fail");
                logger.log(LogStatus.FAIL, "Expense delete failed" + logger.addScreenCapture(image1));
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
