package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Suzanna on 29.12.2016.
 */
public abstract class AbstractPage {
    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}
