package steps;

import driver.DriverWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.MainPage;


public class Steps {
    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser()
    {   driver = DriverWorker.getDriver(); }

    public void closeDriver()
    {
        DriverWorker.closeDriver();
    }

    public void login(String username, String password)
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.login(username, password);
    }
    public boolean isLoggedIn()
    {
        MainPage mainPage = new MainPage(driver);
        return mainPage.getName().trim().equals("Alexey Smolyak");
    }
    public void search(String text)
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.search(text);
    }
    public boolean isSearched()
    {
        MainPage mainPage = new MainPage(driver);
        return mainPage.getResult().trim().equals("Minsk");
    }
    public void rate()
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.rate();
    }
    public boolean isRated()
    {
        MainPage mainPage = new MainPage(driver);
        return mainPage.getRated().trim().equals("Спасибо!");
    }
    public void follow()
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.follow();
    }
    public boolean isFollowed()
    {
        MainPage mainPage = new MainPage(driver);
        return mainPage.getFollowedText().trim().equals("Слежу");
    }
}
