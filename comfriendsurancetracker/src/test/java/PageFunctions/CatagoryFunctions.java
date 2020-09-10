package PageFunctions;

import PageElements.AcoountObjects;
import PageElements.CategoryObjects;
import Utils.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CatagoryFunctions {
    int n;
    CategoryObjects categoryObjects=new CategoryObjects();

    public CatagoryFunctions(WebDriver driver) {
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),categoryObjects);
    }

    public int AddCategory(String name) {
        categoryObjects.cateTab.click();
        categoryObjects.addCatButton.click();
        categoryObjects.catName.sendKeys(name);
        categoryObjects.submitButton.click();
        if(Common.isElementPresent(categoryObjects.catRow1)){
            n=1;
        }
        else {
            n=0;
        }

        return n;

    }

    public int EditCategory(String name) {
        //Common.waitForPageToLoad(driver,categoryObjects.editButton);
        categoryObjects.cateTab.click();
        categoryObjects.editButton.click();
        categoryObjects.catName.clear();
        categoryObjects.catName.sendKeys(name);
        categoryObjects.submitButton.click();
        //System.out.println(categoryObjects.catRow1.getAttribute("text"));
        if(Common.isElementPresent(categoryObjects.catRow1)){
            n=1;
        }
        else {
            n=0;
        }

        return n;

    }

    public int DeleteCategory(WebDriver driver) throws Exception {
        categoryObjects.cateTab.click();
        categoryObjects.deleteButton.click();
        driver.switchTo().alert().accept();
        sleep(2000);
        if(Common.isElementPresent(categoryObjects.deleteButton)){
            n=0;
        }
        else {
            n=1;
        }

        return n;

    }
}
