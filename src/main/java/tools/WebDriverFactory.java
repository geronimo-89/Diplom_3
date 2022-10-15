package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {


    public static WebDriver getBrowser() {
        String browserName;
        try {
            browserName = System.getProperty("browser");
        } catch (RuntimeException e) {
            e.printStackTrace();
            browserName = "chrome";
        }
        if (browserName == null) browserName = "chrome";
        String path = System.getProperty("user.dir");
        switch (browserName) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\driver\\chromedriver.exe");
                return new ChromeDriver();
            }
            case "yandex": {
                System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\driver\\yandexdriver.exe");
                return new ChromeDriver();
            }
            default: {
                System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\driver\\chromedriver.exe");
                throw new RuntimeException("Unknown browser name!");
            }
        }
    }
}
