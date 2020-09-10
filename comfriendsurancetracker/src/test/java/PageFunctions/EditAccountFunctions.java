package PageFunctions;

import PageElements.EditAccountObjects;
import PageElements.StatisticsObjects;
import Utils.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class EditAccountFunctions {

    int n;
    EditAccountObjects editAccountObjects=new EditAccountObjects();

    public EditAccountFunctions(WebDriver driver) {
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),editAccountObjects);
    }

    public int ChangePass(String cpass,String npass,String cnewpass) {
        editAccountObjects.user.click();
        editAccountObjects.currentpass.sendKeys(cpass);
        editAccountObjects.newpass.sendKeys(npass);
        editAccountObjects.confirmnewpass.sendKeys(cnewpass);
        editAccountObjects.updateButton.click();
        if(Common.isElementPresent(editAccountObjects.user)){
            n=1;
        }
        else {
            n=0;
        }

        return n;

    }
}
