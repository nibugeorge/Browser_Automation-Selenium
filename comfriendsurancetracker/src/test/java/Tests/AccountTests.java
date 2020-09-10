package Tests;

import PageFunctions.AccountFunctions;
import Utils.Common;
import Utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountTests {

    public WebDriver driver;
    AccountFunctions accountFunctions;


    String image1;
    int result1;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeTest
    public void setup() throws Exception {
        report = ExtentManager.Instance();
        driver=Common.driverSetup();
        accountFunctions=new AccountFunctions(driver);
    }


    @Test(dataProvider = "credentials2",priority = 1)
    public void RegUserTest(String user,String pass1,String pass2)  {
        try{
            logger=report.startTest("Reg User Test");
            result1=accountFunctions.RegUser(user,pass1,pass2);
            if(result1==1)
            {
                image1= Common.captureScreenshot(driver,"reguser_pass_"+user);
                logger.log(LogStatus.PASS, "User reg success"+ logger.addScreenCapture(image1));
                accountFunctions.LogoutUser();

            }
            else{
                image1 = Common.captureScreenshot(driver, "reguser_fail_"+user);
                logger.log(LogStatus.FAIL, "User reg failed" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(dataProvider = "credentials1",priority = 2)
    public void LoginUserTest(String user,String pass)  {
        try{
            logger=report.startTest("Login User Test");
            result1=accountFunctions.LoginUser(user,pass);
            if(result1==1)
            {
                image1= Common.captureScreenshot(driver,"loginuser_pass_"+user);
                logger.log(LogStatus.PASS, "User log in success"+ logger.addScreenCapture(image1));
                accountFunctions.LogoutUser();

            }
            else if(result1==0){
                image1 = Common.captureScreenshot(driver, "loginuser_fail_"+user);
                logger.log(LogStatus.FAIL, "User log in failed" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @Test(priority = 4)
    public void LogoutUserTest()  {
        try{
            logger=report.startTest("Logout User Test");
            accountFunctions.RegUser("tttt","tttt","tttt");
            result1=accountFunctions.LogoutUser();
            if(result1==1)
            {
                image1= Common.captureScreenshot(driver,"logoutuser_pass");
                logger.log(LogStatus.PASS, "User log out success"+ logger.addScreenCapture(image1));
                //accountFunctions.LogoutUser();

            }
            else if(result1==0){
                image1 = Common.captureScreenshot(driver, "logoutuser_fail");
                logger.log(LogStatus.FAIL, "User log out failed" + logger.addScreenCapture(image1));
            }
        }catch(Exception e){logger.log(LogStatus.ERROR, e.getMessage());}
    }

    @DataProvider(name="credentials1")
    public Object[][] data1(){
        Object[][] data1=new Object[3][2];
        data1[0][0]="aaaa";
        data1[0][1]="aaaa";
        data1[1][0]="";
        data1[1][1]="";
        data1[2][0]="www";
        data1[2][1]="www";
        data1[2][0]="aaaa";
        data1[2][1]="bbbb";
        return data1;
    }

    @DataProvider(name="credentials2")
    public Object[][] data2(){
        Object[][] data2=new Object[4][3];
        data2[0][0]="tttt";
        data2[0][1]="tttt";
        data2[0][2]="tttt";
        data2[1][0]="";
        data2[1][1]="";
        data2[1][2]="";
        data2[2][0]="www";
        data2[2][1]="www";
        data2[2][2]="www";
        data2[3][0]="aaaa";
        data2[3][1]="bbbb";
        data2[3][2]="cccc";
        return data2;
    }

    @AfterTest
    public void endtest() {
        report.endTest(logger);
        report.flush();
        driver.quit();
    }
}
