package com.krigersv.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {

    public ProfilePage openProfile() {
        open("/profile");
        return this;
    }

    public ProfilePage checkTable() {
        $("[id='see-book-Git Pocket Guide']").shouldNotBe(visible);
        return this;
    }
}
