package com.wimdu.tests

import com.codeborne.selenide.WebDriverRunner
import com.wimdu.Config
import com.wimdu.pageobject.LoginPage
import com.wimdu.pageobject.PersonalPage
import com.wimdu.utility.RandomGeneration
import spock.lang.Shared
import spock.lang.Specification

class LoginTest extends Specification {

    @Shared LoginPage page

    def setup() {
        page = new LoginPage()
    }

    def "Successful login" () {
        expect: "Check that login page is opened"
            page.opened

        when: "Enter login and password and press login button"
            page.enterLogin(Config.login)
                .enterPassword(Config.password)
            PersonalPage personal = page.clickOnLoginButton()
        then: "Check that user is logged in"
            personal.opened
    }

    def "Unsuccessful login" () {
        expect: "Check that login page is opened"
            page.opened

        when: "Enter incorrect login and password and press login button"
            page.enterLogin(RandomGeneration.randomEmail())
                .enterPassword(RandomGeneration.randomString(11))
                .clickOnLoginButton()
        then: "Check that error is shown to user"
            page.errorDisplayed
    }

    def cleanup() {
        WebDriverRunner.clearBrowserCache()
    }

}
