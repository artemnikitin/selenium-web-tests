package news360.authorization.email

import com.codeborne.selenide.Configuration
import news360.Config
import news360.pageobject.AuthByEmailPage
import news360.pageobject.MainPage
import news360.pageobject.NewsPage
import spock.lang.Specification

class SuccessfulAuthorizationTest extends Specification {

    def setup() {
        Configuration.timeout = 15000
    }

    def "With valid email and password user can login in application" () {
        when: "Open main page"
            MainPage main = new MainPage()
        then: "Check that main page is opened"
            main.opened

        when: "Go to authorization form"
            AuthByEmailPage auth = main.goToEmailAuth()
        then: "Check that form is displayed"
            auth.opened

        when: "Set email and password"
            auth.setEmail(Config.validUserEmail)
                .setPassword(Config.validUserPassword)
            Object page = auth.signIn()
        then: "Check that login is successful"
            page instanceof NewsPage
    }

}
