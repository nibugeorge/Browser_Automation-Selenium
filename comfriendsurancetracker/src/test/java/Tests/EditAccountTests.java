package Tests;

import PageFunctions.*;
import Utils.Common;
import Utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditAccountTests {
    public static WebDriver driver;
    AccountFunctions accountFunctions;
    CatagoryFunctions catagoryFunctions;
    ExpenseFunctions expenseFunctions;
    StaticticsFunctions staticticsFunctions;
    EditAccountFunctions editAccountFunctions;
    String pass="jjjj";


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
        editAccountFunctions=new EditAccountFunctions(driver);
        accountFunctions.RegUser("jjjj","tttt","tttt");
        //catagoryFunctions.AddCategory("abcde");
        //expenseFunctions.AddExpense("11","1","2001","abcde","20","shopping");

    }


    @Test(priority = 1)
    public void ChangePassTest()  {
        try{
            logger=report.startTest("Change Password Test");
            result1=editAccountFunctions.ChangePass("tttt","tttt","tttt");
            if(result1==1)
            {
                accountFunctions.LogoutUser();
                accountFunctions.LoginUser("jjjj","tttt");
                image1= Common.captureScreenshot(driver,"changepass_pass");
                logger.log(LogStatus.PASS, "Change pass success"+ logger.addScreenCapture(image1));

            }
            else{
                image1 = Common.captureScreenshot(driver, "chnagepass_fail");
                logger.log(LogStatus.FAIL, "Change pass failed" + logger.addScreenCapture(image1));
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
