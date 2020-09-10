package PageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AcoountObjects {

    @FindBy(xpath = "//*[@id='login']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id='editaccount']")
    public WebElement homeHead;

    @FindBy(xpath = "//*[@class='alert alert-danger']")
    public WebElement loginError;

    @FindBy(xpath = "//*[@id='logout']")
    public WebElement logout;

    @FindBy(xpath = "//*[@href='register.jsp']")
    public WebElement reg;

    @FindBy(xpath = "//*[@id='password1']")
    public WebElement password1;

    @FindBy(xpath = "//*[@id='password2']")
    public WebElement password2;

    @FindBy(xpath = "//*[@id='go_add_expense']")
    public WebElement addExp;
}
