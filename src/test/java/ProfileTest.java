import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import setup.SetUp;

import static org.junit.Assert.assertTrue;

@DisplayName("Раздел Личный кабинет")
public class ProfileTest extends SetUp {

    @Before
    public void setUp() {
        registerAccountAPI();
        basicChromeSetup();
        logIntoAccount();
    }

    @Test
    @DisplayName("Переход в личный кабинет по клику на «Личный кабинет»")
    public void shouldGoToProfilePageFromHome() {
        assertTrue(
                homePage
                        .goToAccountPage()
                        .profileDisplayed()
        );
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void shouldGoHomeWithConstructorButton() {
        assertTrue(
                homePage
                        .goToAccountPage()
                        .goHomeViaConstructorLink()
                        .orderButtonAvailable()
        );

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void shouldGoHomeWithBurgerLogo() {
        assertTrue(
                homePage
                        .goToAccountPage()
                        .goHomeViaBurgerLogo()
                        .orderButtonAvailable()
        );
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    public void shouldLogOutOfAccount() {
        assertTrue(
                homePage
                        .goToAccountPage()
                        .logOut()
                        .loginPageDisplayed()
        );
    }

    @After
    public void cleanUp() {
        closeDriver();
        deleteAccountAPI();
    }
}
