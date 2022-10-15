package pageobject;

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

    public LoginPage waitForPage() {
        waitForElement(logInButton);
        return this;
    }

    public boolean loginPageDisplayed() {
        waitForElement(logInButton);
        return logInButton.isDisplayed();
    }

    public LoginPage enterEmail(String email) {
        emailInputField.click();
        emailInputField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInputField.click();
        passwordInputField.sendKeys(password);
        return this;
    }

    public HomePage logIntoAccount(String email, String password) {
        waitForPage();
        enterEmail(email);
        enterPassword(password);
        logInButton.click();
        return new HomePage(driver);
    }

    public HomePage logIntoAccount(Account accountGenerator) {
        waitForPage();
        enterEmail(accountGenerator.getEmail());
        enterPassword(accountGenerator.getPassword());
        logInButton.click();
        return new HomePage(driver);
    }

    public RegisterPage goToRegistration() {
        waitForPage();
        registerButton.click();
        return new RegisterPage(driver);
    }

    public ForgotPasswordPage goToPasswordRecovery() {
        waitForPage();
        recoverPasswordLink.click();
        return new ForgotPasswordPage(driver);
    }

}
