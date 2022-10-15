import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import setup.SetUp;

import static org.junit.Assert.assertTrue;

@DisplayName("Раздел Конструктор")
public class BurgerConstructorTest extends SetUp {

    @Before
    public void setUp() {
        basicChromeSetup();
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    public void shouldSwitchToBunsTab() {
        assertTrue(
                homePage
                        .scrollDown()
                        .homePageWait()
                        .selectBuns()
                        .bunsTabActive()
        );
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void shouldSwitchToSaucesTab() {
        assertTrue(
                homePage
                        .selectSauces()
                        .saucesTabActive()
        );
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void shouldSwitchToFillingsTab() {
        assertTrue(
                homePage
                        .selectFillings()
                        .fillingsTabActive()
        );
    }

    @After
    public void cleanUp() {
        closeDriver();
    }

}
