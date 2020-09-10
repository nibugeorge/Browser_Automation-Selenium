package Utils;


import com.google.common.base.Function;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Common {

    public static WebDriver driver;

    public static WebDriver driverSetup() throws Exception
    {
        System.setProperty("webdriver.gecko.driver",Config.GECKO_PATH);
        driver= new FirefoxDriver();;
        driver.get("http://thawing-shelf-73260.herokuapp.com/index.jsp");
        return driver;
    }

    public static boolean isElementPresent(WebElement webElement)
    {
        Boolean elementPresent = true;
        try
        {
            // assert mobileElement.getAttribute("text") != null;
            elementPresent = webElement.isDisplayed();
        }
        catch (NoSuchElementException ignored)
        {
            elementPresent = false;
        }
        return elementPresent;
    }

    public static void waitForPageToLoad(WebDriver driver, WebElement id)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(id));
        }
        catch (Exception ignored)
        {
            //e.printStackTrace();
        }
    }

    public static String captureScreenshot(WebDriver driver,String screenshotName) throws Exception
    {
        //String device=driver.getCapabilities().getPlatform().toString();
        //String time=driver.getDeviceTime();
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest=new File(Config.SCREENSHOTS_FILEPATH+screenshotName+".png");
        Files.copy(src,dest);
        System.out.println("Screenshot taken");
        return dest.getAbsolutePath();
    }
}
