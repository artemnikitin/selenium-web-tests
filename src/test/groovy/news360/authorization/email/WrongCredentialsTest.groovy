package news360.authorization.email
import com.codeborne.selenide.Configuration
import news360.Config
import news360.pageobject.AuthByEmailPage
import news360.pageobject.MainPage
import spock.lang.Specification

class WrongCredentialsTest extends Specification {

    def setup() {
        Configuration.timeout = 15000
    }

    def "Check that with wrong credentials user can't login" () {
        when: "Open main page"
            MainPage main = new MainPage()
        then: "Check that main page is opened"
            main.opened

        when: "Go to authorization form"
            AuthByEmailPage auth = main.goToEmailAuth()
        then: "Check that form is displayed"
            auth.opened

        when: "Set invalid email and password"
            auth.setEmail(Config.invalidUserEmail)
                .setPassword(Config.invalidUserPassword)
            auth.signIn()
        then: "Check that login attempt is failed"
            auth.authorizationErrorIsDisplayed()
    }

}
