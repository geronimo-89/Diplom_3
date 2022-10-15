package tools;


import tools.data.Account;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import static io.restassured.RestAssured.given;

public class AccountManager {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api";
    private static final String AUTH = "/auth";
    private static final String REGISTER = AUTH + "/register";
    private static final String USER = AUTH + "/user";
    private static final String LOGIN = AUTH + "/login";
    @Getter
    private String accessToken;

    private RequestSpecification getSpec() {
        return given().log().all()
                .header("Content-Type", "application/json")
                .baseUri(BASE_URL);
    }

    public ValidatableResponse register(Account account) {
        return getSpec()
                .and()
                .body(account)
                .when()
                .post(REGISTER)
                .then()
                .statusCode(200);
    }

    public String getAccessToken(Account account) {
        return getSpec()
                .and()
                .body(account)
                .when()
                .post(LOGIN)
                .then()
                .extract()
                .path("accessToken");
    }

    public ValidatableResponse delete(Account account) {
        String accessToken = getAccessToken(account);
        return getSpec()
                .header("Authorization", accessToken)
                .when()
                .delete(USER)
                .then()
                .statusCode(202);
    }
}
