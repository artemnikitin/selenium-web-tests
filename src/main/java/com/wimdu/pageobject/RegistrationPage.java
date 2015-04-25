package com.wimdu.pageobject;

import com.wimdu.Config;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends Page {

    public RegistrationPage() {
        open(Config.getRegistrationUrl());
    }

    public RegistrationPage enterFirstName(String firstName) {
        $("#user_firstname").clear();
        $("#user_firstname").sendKeys(firstName);
        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        $("#user_lastname").clear();
        $("#user_lastname").sendKeys(lastName);
        return this;
    }

    public RegistrationPage enterEmail(String email) {
        $("#user_email").clear();
        $("#user_email").sendKeys(email);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        $("#user_password").clear();
        $("#user_password").sendKeys(password);
        return this;
    }

    public PersonalPage clickOnRegisterButton() {
        $(".btn.btn--primary.btn--medium.btn--block").click();
        return new PersonalPage();
    }

    public boolean registrationErrorIsDisplayed() {
        return $(".inputs__row-error").isDisplayed();
    }

    @Override
    public boolean isOpened() {
        return $(".btn.btn--primary.btn--medium.btn--block").isDisplayed();
    }

}
