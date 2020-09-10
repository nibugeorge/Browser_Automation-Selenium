package PageFunctions;

import PageElements.AcoountObjects;
import Utils.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;


public class AccountFunctions {

    int n;
    AcoountObjects accountObjects=new AcoountObjects();

    public AccountFunctions(WebDriver driver) {
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),accountObjects);
    }

    public int LoginUser(String username, String pass) {
        accountObjects.addExp.click();
        accountObjects.username.sendKeys(username);
        accountObjects.password.sendKeys(pass);
        accountObjects.submitButton.click();
        if(Common.isElementPresent(accountObjects.homeHead)){
            n=1;
        }
        else {
            n=0;
        }

        return n;

    }

    public int RegUser(String username, String pass1,String pass2) {
        //Common.waitForPageToLoad(driver,accountObjects.reg);
        accountObjects.reg.click();
        accountObjects.username.clear();
        accountObjects.username.sendKeys(username);
        accountObjects.password1.clear();
        accountObjects.password1.sendKeys(pass1);
        accountObjects.password2.clear();
        accountObjects.password2.sendKeys(pass2);
        accountObjects.submitButton.click();
        if(Common.isElementPresent(accountObjects.homeHead)){
            n=1;
        }
        else{
            n=0;
            accountObjects.addExp.click();
            n=LoginUser(username,pass1);
        }

        return n;

    }

    public int LogoutUser() {
        //Common.waitForPageToLoad(driver, accountObjects.logout);
        if(Common.isElementPresent(accountObjects.logout)){
            accountObjects.logout.click();
        }
        if(Common.isElementPresent(accountObjects.submitButton)){
            n=1;
        }
        else{
            n=0;
        }
        return n;

    }



}
