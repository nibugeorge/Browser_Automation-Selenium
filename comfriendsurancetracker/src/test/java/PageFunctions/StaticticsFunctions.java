package PageFunctions;

import PageElements.ExpenseObjects;
import PageElements.StatisticsObjects;
import Utils.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class StaticticsFunctions {
    int n;
    StatisticsObjects statisticsObjects=new StatisticsObjects();

    public StaticticsFunctions(WebDriver driver) {
        PageFactory.initElements(new DefaultElementLocatorFactory(driver),statisticsObjects);
    }

    public int ShowStat() {
        statisticsObjects.statTab.click();
        if(Common.isElementPresent(statisticsObjects.title)){
            n=1;
        }
        else {
            n=0;
        }

        return n;

    }



}
