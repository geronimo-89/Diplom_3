package setup;

import data.Account;
import data.AccountManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.*;

//all tests extend this
public class SetUp {

    protected WebDriver driver;
    protected HomePage homePage;
    protected AccountManager accountManager;
    protected Account account;

    public static final String HOME_PAGE_LINK = "https://stellarburgers.nomoreparties.site/";

    public void chromeDriverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void openHomePage() {
        driver.get(HOME_PAGE_LINK);
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
