package com.krigersv.api.authorization.book;

import com.krigersv.api.models.AuthorizationModel;
import com.krigersv.api.models.BookListModel;
import com.krigersv.api.models.DeleteBookModel;
import io.qameta.allure.Step;

import static com.krigersv.specs.BookWebSpec.*;
import static io.restassured.RestAssured.given;

public class BookWebApi {
    @Step("Запрос на добавление книги")
    public void addBook(AuthorizationModel response, BookListModel booksList) {
        given(commonBookSpec)
                .header("Authorization", "Bearer " + response.getToken())
                .body(booksList)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(addBookResponseSpec);

    }
    @Step("Запрос на удаление книги из списка")
    public void removeBook(AuthorizationModel response, DeleteBookModel book) {
        given(commonBookSpec)
                .header("Authorization", "Bearer " + response.getToken())
                .body(book)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .spec(removingBookResponseSpec);
    }

    @Step("Запрос на удаление всех книг")
    public void removeAllBooks(AuthorizationModel response) {
        given(commonBookSpec)
                .header("Authorization", "Bearer " + response.getToken())
                .queryParam("UserId", response.getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(removingBookResponseSpec);
    }
}
