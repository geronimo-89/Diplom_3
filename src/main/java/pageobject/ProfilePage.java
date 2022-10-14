package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasicPages {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Профиль")
    private WebElement profileTab;

    @FindBy(xpath = ".//button[text()='Выход']")
    private WebElement logOutButton;

    @FindBy(linkText = "Конструктор")
    private WebElement constructorLink;

    @FindBy(className = "AppHeader_header__logo__2D0X2")
    private WebElement burgerLogo;

    public boolean profileDisplayed() {
        waitForElement(profileTab);
        return profileTab.isDisplayed();
    }

    public HomePage goHomeViaConstructorLink() {
        waitForElement(constructorLink);
        constructorLink.click();
        return new HomePage(driver);
    }

    public HomePage goHomeViaBurgerLogo() {
        waitForElement(burgerLogo);
        burgerLogo.click();
        return new HomePage(driver);
    }

    public LoginPage logOut() {
        waitForElement(logOutButton);
        logOutButton.click();
        return new LoginPage(driver);
    }
}
