import data.Account;
import data.AccountManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import setup.SetUp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@DisplayName("Регистрация пользователя")
public class RegistrationTest extends SetUp {

    public static final String LOGIN_PAGE = HOME_PAGE_LINK + "login";

    @Before
    public void setUp() {
        basicChromeSetup();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void shouldRegisterNewAccount() {
        account = new Account();
        accountManager = new AccountManager();
        assertEquals(
                LOGIN_PAGE,
                homePage
                        .goToLoginPage1()
                        .goToRegistration()
                        .registerRandomAccount(account)
                        .waitForPage()
                        .getCurrentURL()
        );
        deleteAccountAPI();
    }

    @Test
    @DisplayName("Отображение ошибки для некорректного пароля. Минимальный пароль — 6 символов")
    public void shortPasswordErrorIsDisplayed() {
        assertTrue(
                homePage
                        .goToLoginPage1()
                        .goToRegistration()
                        .shortPasswordError()
        );
    }

    @After
    public void cleanUp() {
        closeDriver();
    }
}
