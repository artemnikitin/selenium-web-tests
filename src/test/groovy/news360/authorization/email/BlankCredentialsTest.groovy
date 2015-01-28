package news360.authorization.email

import com.codeborne.selenide.Configuration
import news360.Config
import news360.pageobject.AuthByEmailPage
import news360.pageobject.MainPage
import spock.lang.Specification
import spock.lang.Unroll

class BlankCredentialsTest extends Specification {

    def setup() {
        Configuration.timeout = 15000
    }

    @Unroll("Authorization with email=#email and password=#password")
    def "Check authorization with blank password or email" () {
        when: "Open main page"
            MainPage main = new MainPage()
        then: "Check that main page is opened"
            main.opened

        when: "Go to authorization form"
            AuthByEmailPage auth = main.goToEmailAuth()
        then: "Check that form is displayed"
            auth.opened

        when: "Enter password and email"
            auth.setEmail(email)
                .setPassword(password)
            auth.signIn()
        then: "Check for error"
            auth.checkRequiredFieldIsBlank()

        where:
            email                |password
            ""                   |Config.validUserPassword
            Config.validUserEmail|""
    }

}
