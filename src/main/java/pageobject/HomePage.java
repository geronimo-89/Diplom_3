package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasicPages {

    private JavascriptExecutor js;

    public HomePage(WebDriver driver) {
        super(driver);
    }

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
    @FindBy(xpath = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']/ul[last()]/a[last()]")
    private WebElement lastIngredient;

    @Step("Ожидание загрузки страницы")
    public HomePage waitForPage() {
        waitForElement(accountButton);
        return this;
    }
    @Step("Ожидание")
    public HomePage homePageWait() {
        wait(5);
        return this;
    }

    public HomePage scrollDown() {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", lastIngredient);
        return this;
    }

    @Step("Переход к разделу Булки")
    public HomePage selectBuns() {
        waitForElement(bunsTab);
        bunsTab.click();
        return this;
    }

    @Step("Переход к разделу Соусы")
    public HomePage selectSauces() {
        waitForElement(saucesTab);
        saucesTab.click();
        return this;
    }

    @Step("Переход к разделу Начинки")
    public HomePage selectFillings() {
        waitForElement(fillingsTab);
        fillingsTab.click();
        return this;
    }

    @Step("Булки - активная вкладка")
    public boolean bunsTabActive() {
        waitForElement(bunsTabActive);
        return bunsTabActive.isDisplayed();
    }

    @Step("Соусы - активная вкладка")
    public boolean saucesTabActive() {
        waitForElement(saucesTabActive);
        return saucesTabActive.isDisplayed();
    }

    @Step("Начинки - активная вкладка")
    public boolean fillingsTabActive() {
        waitForElement(fillingsTabActive);
        return fillingsTabActive.isDisplayed();
    }

    @Step("Отображается кнопка Оформить заказ, т.е. пользователь успешно залогинен")
    public boolean orderButtonAvailable() {
        waitForElement(placeOrderButton);
        return placeOrderButton.isDisplayed();
    }

    @Step("Переход в Личный кабинет")
    public ProfilePage goToAccountPage() {
        waitForElement(accountButton);
        accountButton.click();
        return new ProfilePage(driver);
    }

    @Step("Переход к авторизации через кнопку Личный кабинет")
    public LoginPage goToLoginPage1() {
        waitForElement(accountButton);
        accountButton.click();
        return new LoginPage(driver);
    }

    @Step("Переход к авторизации через кнопку Войти в аккаунт")
    public LoginPage goToLoginPage2() {
        waitForElement(accountLoginButton);
        accountLoginButton.click();
        return new LoginPage(driver);
    }

}
