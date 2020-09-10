package PageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountObjects {

    @FindBy(xpath = "//*[@id='editaccount']")
    public WebElement user;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement currentpass;

    @FindBy(xpath = "//*[@id='newpassword1']")
    public WebElement newpass;

    @FindBy(xpath = "//*[@id='newpassword2']")
    public WebElement confirmnewpass;

    @FindBy(xpath = "//*[@id='submit']")
    public WebElement updateButton;
}
