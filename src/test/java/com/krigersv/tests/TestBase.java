package com.krigersv.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.krigersv.api.authorization.book.BookWebApi;
import com.krigersv.api.authorization.AuthorizationApi;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    AuthorizationApi loginWebApi = new AuthorizationApi();
    BookWebApi bookWebApi = new BookWebApi();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        RestAssured.baseURI = System.getProperty("baseURI", "https://demoqa.com");
        Configuration.browserSize = System.getProperty("browserrSize", "2560x1440");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.pageLoadStrategy = "eager";

        String selenoidUrl = System.getProperty("selenoidUrl", "selenoid.autotests.cloud");
        Configuration.remote = "https://user1:1234@" + selenoidUrl + "/wd/hub";
    }

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
