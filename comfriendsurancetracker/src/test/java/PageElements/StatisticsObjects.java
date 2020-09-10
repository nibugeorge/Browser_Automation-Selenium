package PageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatisticsObjects {

    @FindBy(xpath = "//*[@id='go_show_statistics']")
    public WebElement statTab;

    @FindBy(xpath = "(//h3)[1]")
    public WebElement title;

}
