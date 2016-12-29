package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class MainPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.behance.net/";

    @FindBy(id = "nav-login")
    private WebElement loginButton;

    @FindBy(id = "adobeid_username")
    private WebElement inputEmail;

    @FindBy(id = "adobeid_password")
    private WebElement inputPassword;

    @FindBy(id = "sign_in")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"profile-display-name\"]/a")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"nav-search\"]/span")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"search\"]")
    private WebElement inputSearch;

    @FindBy(xpath = "//*[@id=\"filter-crumbs\"]/div/div[1]")
    private WebElement searchResult;

    @FindBy(xpath = "//*[@id=\"activity\"]/div[2]/div[1]/a/img")
    private WebElement projectLink;

    @FindBy(xpath = "//*[@id=\"project-sidebar\"]/div/div[1]/div[5]/div/div[3]")
    private WebElement rateProject;

    @FindBy(xpath = "//*[@id=\"project-sidebar\"]/div/div[1]/div[1]/div/div[2]/div[1]/div[1]/a[1]")
    private WebElement followButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public void login(String username, String password)
    {
        loginButton.click();
        inputEmail.sendKeys(username);
        inputPassword.sendKeys(password);
        submitButton.click();
    }
    public String getName()
    { return name.getText();    }
    public void search(String text)
    {
        searchButton.click();
        inputPassword.sendKeys(text);
        searchButton.click();
    }
    public String getResult()
    { return searchResult.getText();}
    public void rate()
    {
        projectLink.click();
        rateProject.click();
    }
    public String getRated() { return rateProject.getText();}
    public void follow()
    {
        projectLink.click();
        followButton.click();
    }
    public String getFollowedText()
    {
        return followButton.getText();
    }
}
