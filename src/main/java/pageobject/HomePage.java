package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasicPages {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "Modal_modal__P3_V5")
    private WebElement loadingFinished;
    @FindBy(linkText = "Личный Кабинет")
    private WebElement accountButton;
    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private WebElement accountLoginButton;
    @FindBy(xpath = ".//button[text()='Оформить заказ']")
    private WebElement placeOrderButton;
    @FindBy(xpath = ".//div/span[text()='Булки']")
    private WebElement bunsTab;
    @FindBy(xpath = ".//div/span[text()='Соусы']")
    private WebElement saucesTab;
    @FindBy(xpath = ".//div/span[text()='Начинки']")
    private WebElement fillingsTab;
    @FindBy(xpath = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    private WebElement bunsTabActive;
    @FindBy(xpath = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    private WebElement saucesTabActive;
    @FindBy(xpath = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    private WebElement fillingsTabActive;


    public HomePage waitForPage() {
        waitForElement(loadingFinished);
        return this;
    }

    public HomePage waitForLogin() {
        waitForElement(accountLoginButton);
        return this;
    }

    public HomePage waitForAccount() {
        waitForElement(accountButton);
        return this;
    }

    public HomePage selectBuns() {
        waitForElement(bunsTab);
        bunsTab.click();
        return this;
    }

    public HomePage selectSauces() {
        waitForElement(saucesTab);
        saucesTab.click();
        return this;
    }

    public HomePage selectFillings() {
        waitForElement(fillingsTab);
        fillingsTab.click();
        return this;
    }

    public boolean bunsTabActive() {
        waitForElement(bunsTabActive);
        return bunsTabActive.isDisplayed();
    }

    public boolean saucesTabActive() {
        waitForElement(saucesTabActive);
        return saucesTabActive.isDisplayed();
    }

    public boolean fillingsTabActive() {
        waitForElement(fillingsTabActive);
        return fillingsTabActive.isDisplayed();
    }

    public boolean orderButtonAvailable() {
        waitForElement(placeOrderButton);
        return placeOrderButton.isDisplayed();
    }


    public ProfilePage goToAccountPage() {
        waitForAccount();
        accountButton.click();
        return new ProfilePage(driver);
    }

    public LoginPage goToLoginPage1() {
        waitForAccount();
        accountButton.click();
        return new LoginPage(driver);
    }

    public LoginPage goToLoginPage2() {
        waitForLogin();
        accountLoginButton.click();
        return new LoginPage(driver);
    }

}
