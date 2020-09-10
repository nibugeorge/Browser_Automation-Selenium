package PageFunctions;

import PageElements.CategoryObjects;
import PageElements.ExpenseObjects;
import Utils.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import static java.lang.Thread.sleep;

public class ExpenseFunctions {
    int n;
    ExpenseObjects expenseObjects=new ExpenseObjects();

    public ExpenseFunctions(WebDriver driver) {
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),expenseObjects);
    }

    public int AddExpense(String day, String month,String year,String cat,String amount,String reason) {
        expenseObjects.addExpTab.click();
        expenseObjects.day.sendKeys(day);
        expenseObjects.month.sendKeys(month);
        expenseObjects.year.sendKeys(year);
        expenseObjects.category.sendKeys(cat);
        expenseObjects.amount.sendKeys(amount);
        expenseObjects.reason.sendKeys(reason);
        expenseObjects.submit.click();
        if(Common.isElementPresent(expenseObjects.exprow1)){
            n=1;
        }
        else {
            n=0;
        }

        return n;

    }

    public int EditExpense(String amount) {
        expenseObjects.editButton.click();
        expenseObjects.amount.clear();
        expenseObjects.amount.sendKeys(amount);
        expenseObjects.submit.click();
        if(Common.isElementPresent(expenseObjects.exprow1)){
            n=1;
        }
        else {
            n=0;
        }

        return n;

    }

    public int DeleteExpense(WebDriver driver) throws Exception {
        expenseObjects.listExpTab.click();
        expenseObjects.delButton.click();
        driver.switchTo().alert().accept();
        sleep(2000);
        if(Common.isElementPresent(expenseObjects.delButton)){
            n=0;
        }
        else {
            n=1;
        }
        return n;

    }
}
