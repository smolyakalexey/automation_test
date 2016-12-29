import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;


public class TestAutomation {
    private Steps steps;
    private final String USERNAME = "smolyakalexey@gmail.com";
    private final String PASSWORD = "Bigfatbutt95";
    private final String TEXT = "Minsk";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }
    @Test(description = "Login")
    public void oneCanLogin()
    {
        steps.login(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn());
    }
    @Test(description = "Search")
    public void oneCanSearch()
    {
        steps.login(USERNAME, PASSWORD);
        steps.search(TEXT);
        Assert.assertTrue(steps.isSearched());
    }
    @Test(description = "Rate project")
    public void oneCanRateProject()
    {
        steps.login(USERNAME, PASSWORD);
        steps.rate();
        Assert.assertTrue(steps.isRated());
    }
    @Test(description = "Follow")
    public void oneCanFollow()
    {
        steps.login(USERNAME, PASSWORD);
        steps.follow();
        Assert.assertTrue(steps.isFollowed());
    }
    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    { steps.closeDriver();   }
}
