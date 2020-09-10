package PageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExpenseObjects {

    @FindBy(xpath = "//*[@id='go_add_expense']")
    public WebElement addExpTab;

    @FindBy(xpath = "//*[@id='go_list_expenses']")
    public WebElement listExpTab;

    @FindBy(xpath = "//*[@id='day']")
    public WebElement day;

    @FindBy(xpath = "//*[@id='month']")
    public WebElement month;

    @FindBy(xpath = "//*[@id='year']")
    public WebElement year;

    @FindBy(xpath = "//*[@id='category']")
    public WebElement category;

    @FindBy(xpath = "//*[@id='amount']")
    public WebElement amount;

    @FindBy(xpath = "//*[@id='reason']")
    public WebElement reason;

    @FindBy(xpath = "//*[@id='submit']")
    public WebElement submit;

    @FindBy(xpath = "(//tr)[3]")
    public WebElement exprow1;

    @FindBy(xpath = "//*[@title='edit expense']")
    public WebElement editButton;

    @FindBy(xpath = "//*[@title='copy expense']")
    public WebElement addButton;

    @FindBy(xpath = "//*[@title='delete expense']")
    public WebElement delButton;
}
