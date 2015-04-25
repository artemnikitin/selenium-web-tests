package com.wimdu.pageobject;

import com.wimdu.Config;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends Page {

    public LoginPage() {
        open(Config.getLoginUrl());
    }

    public LoginPage enterLogin(String login) {
        $("#user_email").clear();
        $("#user_email").sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        $("#user_password").clear();
        $("#user_password").sendKeys(password);
        return this;
    }

    public PersonalPage clickOnLoginButton() {
        $(".btn.btn--primary.btn--medium.btn--block").click();
        return new PersonalPage();
    }

    public boolean isErrorDisplayed() {
        return $(".inputs__row-error").isDisplayed();
    }

    @Override
    public boolean isOpened() {
        boolean login_is_isplayed = $("#user_email").isDisplayed();
        boolean password_is_displayed = $("#user_password").isDisplayed();
        return login_is_isplayed && password_is_displayed;
    }

}
