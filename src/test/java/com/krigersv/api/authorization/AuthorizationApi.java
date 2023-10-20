package com.krigersv.api.authorization;

import com.krigersv.api.models.AuthorizationModel;
import com.krigersv.api.models.CredentialsModel;
import io.qameta.allure.Step;

import static com.krigersv.specs.AuthorizationSpec.*;
import static io.restassured.RestAssured.given;

public class AuthorizationApi {
    @Step("Авторизация")
    public AuthorizationModel login(CredentialsModel creds) {
        return given(loginRequestSpec)
                .body(creds)
                .when()
                .post("https://demoqa.com/Account/v1/Login")
                .then()
                .spec(loginResponseSpec)
                .extract().as(AuthorizationModel.class);
    }
}
