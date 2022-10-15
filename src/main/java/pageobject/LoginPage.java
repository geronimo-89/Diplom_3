package pageobject;

import io.qameta.allure.Step;
import tools.data.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicPages {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//button[text()='Войти']")
    private WebElement logInButton;
    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement emailInputField;
    @FindBy(xpath = ".//fieldset[2]//input")
    private WebElement passwordInputField;
    @FindBy(linkText = "Зарегистрироваться")
    private WebElement registerButton;
    @FindBy(linkText = "Восстановить пароль")
    private WebElement recoverPasswordLink;

    @Step("Ожидание загрузки страницы")
    public LoginPage waitForPage() {
        waitForElement(logInButton);
        return this;
    }

    @Step("Отображается страница для логина пользователя")
    public boolean loginPageDisplayed() {
        waitForElement(logInButton);
        return logInButton.isDisplayed();
    }

    @Step("Ввод в поле email")
    public LoginPage enterEmail(String email) {
        emailInputField.click();
        emailInputField.sendKeys(email);
        return this;
    }

    @Step("Ввод в поле пароля")
    public LoginPage enterPassword(String password) {
        passwordInputField.click();
        passwordInputField.sendKeys(password);
        return this;
    }

    @Step("Вход в аккаунт по email и паролю")
    public HomePage logIntoAccount(String email, String password) {
        waitForPage();
        enterEmail(email);
        enterPassword(password);
        logInButton.click();
        return new HomePage(driver);
    }

    @Step("Вход в аккаунт с объектом данных аккаунта")
    public HomePage logIntoAccount(Account accountGenerator) {
        waitForPage();
        enterEmail(accountGenerator.getEmail());
        enterPassword(accountGenerator.getPassword());
        logInButton.click();
        return new HomePage(driver);
    }

    @Step("Переход на страницу регистрации")
    public RegisterPage goToRegistration() {
        waitForPage();
        registerButton.click();
        return new RegisterPage(driver);
    }

    @Step("Переход на страницу восстановления пароля")
    public ForgotPasswordPage goToPasswordRecovery() {
        waitForPage();
        recoverPasswordLink.click();
        return new ForgotPasswordPage(driver);
    }

}
