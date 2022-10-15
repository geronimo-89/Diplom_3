package pageobject;

import io.qameta.allure.Step;
import tools.data.Account;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasicPages {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private WebElement completeRegistrationButton;
    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement nameInputField;
    @FindBy(xpath = ".//fieldset[2]//input")
    private WebElement emailInputField;
    @FindBy(xpath = ".//fieldset[3]//input")
    private WebElement passwordInputField;
    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private WebElement passwordError;
    @FindBy(linkText = "Войти")
    private WebElement loginLink;

    @Step("Ожидание загрузки страницы")
    public RegisterPage waitForPage() {
        waitForElement(completeRegistrationButton);
        return this;
    }

    @Step("Ввод в поле имени")
    public RegisterPage enterName(String name) {
        nameInputField.click();
        nameInputField.sendKeys(name);
        return this;
    }

    @Step("Ввод в поле email")
    public RegisterPage enterEmail(String email) {
        emailInputField.click();
        emailInputField.sendKeys(email);
        return this;
    }

    @Step("Ввод в поле пароля")
    public RegisterPage enterPassword(String password) {
        passwordInputField.click();
        passwordInputField.sendKeys(password);
        return this;
    }

    @Step("Регистрация аккаунта с данными")
    public LoginPage registerAccount(String name, String email, String password) {
        waitForPage();
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        completeRegistrationButton.click();
        return new LoginPage(driver);
    }

    @Step("Регистрация аккаунта с объектом аккаунта")
    public LoginPage registerRandomAccount(Account accountGenerator) {
        waitForPage();
        enterName(accountGenerator.getName());
        enterEmail(accountGenerator.getEmail());
        enterPassword(accountGenerator.getPassword());
        completeRegistrationButton.click();
        return new LoginPage(driver);
    }

    @Step("Отображение ошибки при вводе пароля короче 6 символов")
    public boolean shortPasswordError() {
        waitForPage();
        enterPassword(Account.generateRandomPassword(5));
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        return passwordError.isDisplayed();
    }

    @Step("Переход на страницу логина")
    public LoginPage goToLoginPage() {
        waitForPage();
        loginLink.click();
        return new LoginPage(driver);
    }

}
