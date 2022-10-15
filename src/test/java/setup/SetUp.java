package setup;

import tools.data.Account;
import tools.AccountManager;
import org.openqa.selenium.WebDriver;
import pageobject.*;
import tools.WebDriverManager;

import java.util.concurrent.TimeUnit;

//all tests extend this
public class SetUp {

    protected WebDriver driver;
    protected HomePage homePage;
    protected AccountManager accountManager;
    protected Account account;

    public static final String HOME_PAGE_LINK = "https://stellarburgers.nomoreparties.site/";

    public void chromeDriverSetUp() {
        driver = WebDriverManager.getBrowser();
    }

    public void openHomePage() {
        driver.get(HOME_PAGE_LINK);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void setUpObjects() {
        homePage = new HomePage(driver);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void basicChromeSetup() {
        chromeDriverSetUp();
        setUpObjects();
        openHomePage();
        maximizeWindow();
    }

    public void registerAccountAPI() {
        account = new Account();
        accountManager = new AccountManager();
        accountManager.register(account);
    }

    public void deleteAccountAPI() {
        accountManager.delete(account);
    }

    public void logIntoAccount() {
        homePage
                .waitForLogin()
                .goToLoginPage1()
                .logIntoAccount(account)
                .waitForAccount();
    }

    public void closeDriver() {
        driver.quit();
    }


}
