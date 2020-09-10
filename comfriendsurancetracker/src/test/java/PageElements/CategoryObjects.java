package PageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryObjects {

    @FindBy(xpath = "//*[@id='go_list_categories']")
    public WebElement cateTab;

    @FindBy(xpath = "//*[@id='go_add_category']")
    public WebElement addCatButton;

    @FindBy(xpath = "//*[@id='name']")
    public WebElement catName;

    @FindBy(xpath = "//*[@id='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "(//td)[1]")
    public WebElement catRow1;

    @FindBy(xpath = "//*[@title='edit category']")
    public WebElement editButton;

    @FindBy(xpath = "//*[@title='delete category']")
    public WebElement deleteButton;
}
