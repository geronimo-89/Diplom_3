package tools.data;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

public class Account {

    @Getter
    @Setter
    private String name, email, password;

    public static String generateRandomEmail(int length) {
        return RandomStringUtils.randomAlphanumeric(length) + "@yandex.ru";
    }

    public static String generateRandomName(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String generateRandomPassword(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public Account(String name, String email, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Account() {
        this.email = generateRandomEmail(12);
        this.name = generateRandomName(12);
        this.password = generateRandomPassword(12);
    }

}
