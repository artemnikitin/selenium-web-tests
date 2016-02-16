package com.artemnikitin.pageobject;

import com.artemnikitin.Config;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends Page {

    public MainPage() {
        open(Config.getUrl());
    }

    public ElementsCollection getListOfPosts() {
        return $$(".module.color-3>h2>a");
    }

    public PostPage openPost() {
        $(".module.color-3>h2>a").click();
        return new PostPage();
    }

    @Override
    public boolean isOpened() {
        return $(".module.title.color-1>h1>a").has(text("Artem Nikitin"));
    }

}
