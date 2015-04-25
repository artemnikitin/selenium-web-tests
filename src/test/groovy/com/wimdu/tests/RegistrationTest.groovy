package com.wimdu.tests

import com.codeborne.selenide.WebDriverRunner
import com.wimdu.pageobject.PersonalPage
import com.wimdu.pageobject.RegistrationPage
import com.wimdu.utility.RandomGeneration
import spock.lang.Specification


class RegistrationTest extends Specification {

    def "Successful registration" () {
        when: "Open registration page"
            RegistrationPage page = new RegistrationPage()
        then: "Check that page is opened"
            page.opened

        when: "Enter data and submit form"
            page.enterFirstName(RandomGeneration.randomString(5))
                .enterLastName(RandomGeneration.randomString(7))
                .enterEmail(RandomGeneration.randomEmail())
                .enterPassword(RandomGeneration.randomString(11))
            PersonalPage personal = page.clickOnRegisterButton()
        then: "Check that user is registered"
            personal.opened
    }

    def "Unsuccessful registration" () {
        when: "Open registration page"
            RegistrationPage page = new RegistrationPage()
        then: "Check that page is opened"
            page.opened

        when: "Enter incorrect data and submit form"
            page.enterFirstName("")
                .enterLastName("")
                .enterEmail(RandomGeneration.randomEmail())
                .enterPassword(RandomGeneration.randomString(11))
                .clickOnRegisterButton()
        then: "Check that error is shown to user"
            page.registrationErrorIsDisplayed()
    }

    def cleanup() {
        WebDriverRunner.clearBrowserCache()
    }

}
