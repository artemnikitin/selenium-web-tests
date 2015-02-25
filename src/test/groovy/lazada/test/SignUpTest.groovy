package lazada.test

import com.codeborne.selenide.WebDriverRunner
import lazada.Config
import lazada.pageobject.MainPage
import lazada.pageobject.SignUpForm
import spock.lang.Specification

class SignUpTest extends Specification {

    def "Without password confirmation signup process must fail"() {

        given: "Main page is opened"
            MainPage main = new MainPage()

        when: "Click on signup button"
            SignUpForm signup = main.signUp()
        then: "Check that signup form is displayed"
            signup.opened

        when: "Enter signup data and press 'Submit'"
            signup.enterName(Config.userName)
                .enterEmail(Config.userEmail)
                .enterPassword(Config.userPassword)
                .pressSubmit()
        then: "Check for error"
            signup.checkError()

    }

    def cleanup() {
        WebDriverRunner.clearBrowserCache()
    }

}
