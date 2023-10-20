package com.krigersv.tests;

import com.krigersv.api.models.AuthorizationModel;
import com.krigersv.api.models.BookListModel;
import com.krigersv.api.models.CollectionModel;
import com.krigersv.api.models.DeleteBookModel;
import com.krigersv.pages.ProfilePage;
import com.krigersv.pages.ResponsePage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.krigersv.utils.TestData.bookSpeakingJavaScript;
import static com.krigersv.utils.TestData.loginDetails;
import static io.qameta.allure.Allure.step;

public class DeleteBooksFromTest extends TestBase {

    @Test
    void verifyingSuccessfulAdditionAndDeletionBook() {

        AuthorizationModel response = loginWebApi.login(loginDetails);

        ProfilePage profilePage = new ProfilePage();
        ResponsePage responsePage = new ResponsePage();

        CollectionModel isbnModel = new CollectionModel();
        isbnModel.setIsbn(bookSpeakingJavaScript);

        List<CollectionModel> collectionIsbn = new ArrayList<>();
        collectionIsbn.add(isbnModel);

        BookListModel booksList = new BookListModel();
        booksList.setUserId(response.getUserId());
        booksList.setCollectionOfIsbns(collectionIsbn);

        DeleteBookModel deleteBooksList = new DeleteBookModel();
        deleteBooksList.setIsbn(bookSpeakingJavaScript);
        deleteBooksList.setUserId(response.getUserId());

        bookWebApi.removeAllBooks(response);
        bookWebApi.addBook(response,booksList);
        bookWebApi.removeBook(response,deleteBooksList);

        step("Добавление куков на сайт", () -> {
            responsePage.appendCookies(response);
        });

        step("Открытие страницы профиля", () -> {
            profilePage.openProfile();
        });

        step("Проверка удаленной из списка книги", () -> {
            profilePage.checkTable();
        });
    }
}
