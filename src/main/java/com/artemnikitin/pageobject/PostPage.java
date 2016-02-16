package com.artemnikitin.pageobject;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;

public class PostPage extends Page {

    @Override
    public boolean isOpened() {
        boolean social = $(".social.module>ul").isDisplayed();
        String url = WebDriverRunner.url();
        url = url.replace("http://artemnikitin.com/", "");
        return social && url.length() > 0;
    }

}
