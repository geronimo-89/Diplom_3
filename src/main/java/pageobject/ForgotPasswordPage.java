package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasicPages{
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//button[text()='Восстановить']")
    private WebElement recoverPasswordButton;
    @FindBy(linkText = "Войти")
    private WebElement loginLink;

    public ForgotPasswordPage waitForPage() {
        waitForElement(recoverPasswordButton);
        return this;
    }

    public LoginPage goToLoginPage() {
        waitForPage();
        loginLink.click();
        return new LoginPage(driver);
    }

}
