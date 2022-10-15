import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import setup.SetUp;

import static org.junit.Assert.assertTrue;

@DisplayName("Логин пользователя")
public class LoginTest extends SetUp {

    @Before
    public void setUp() {
        registerAccountAPI();
        basicChromeSetup();
        openHomePage();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void shouldLoginFromHomePageLoginButton() {
        assertTrue(
                homePage
                        .goToLoginPage1()
                        .logIntoAccount(account)
                        .orderButtonAvailable()
        );
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void shouldLoginFromHomePageAccountButton() {
        assertTrue(
                homePage
                        .goToLoginPage2()
                        .logIntoAccount(account)
                        .orderButtonAvailable()
        );
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void shouldLoginFromRegistrationPage() {
        assertTrue(
                homePage
                        .goToLoginPage1()
                        .goToRegistration()
                        .goToLoginPage()
                        .logIntoAccount(account)
                        .orderButtonAvailable()
        );
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void shouldLoginFromPasswordRecoveryPage() {
        assertTrue(
                homePage
                        .goToLoginPage1()
                        .goToPasswordRecovery()
                        .goToLoginPage()
                        .logIntoAccount(account)
                        .orderButtonAvailable()
        );
    }

    @After
    public void cleanUp() {
        closeDriver();
        deleteAccountAPI();
    }

}
