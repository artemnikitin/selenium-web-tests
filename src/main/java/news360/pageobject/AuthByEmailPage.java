package news360.pageobject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class AuthByEmailPage extends Page {

    private static final String EMAIL_FIELD = "div.simplepopup form.signin input.email.textbox";
    private static final String PASSWORD_FIELD = "div.simplepopup form.signin input.password.textbox";
    private static final String SIGN_IN = "div.simplepopup form.signin button.green-button.ladda-button.signin-button";
    private static final String ERROR = "div.simplepopup.expand div.error-message";

    public AuthByEmailPage() {}

    public AuthByEmailPage setEmail(String email) {
        $(By.cssSelector(EMAIL_FIELD)).clear();
        $(By.cssSelector(EMAIL_FIELD)).append(email);
        return this;
    }

    public AuthByEmailPage setPassword(String password) {
        $(By.cssSelector(PASSWORD_FIELD)).clear();
        $(By.cssSelector(PASSWORD_FIELD)).append(password);
        return this;
    }

    public Object signIn() {
        $(By.cssSelector(SIGN_IN)).shouldBe("'Sign in' button must be displayed", visible).click();
        if(!authorizationErrorIsDisplayed()) return new NewsPage();
        else return this;
    }

    @Override
    public boolean isOpened() {
        boolean check1 = $(By.cssSelector(EMAIL_FIELD)).isDisplayed();
        boolean check2 = $(By.cssSelector(SIGN_IN)).isDisplayed();
        return check1 && check2;
    }

    public boolean authorizationErrorIsDisplayed() {
        return $(By.cssSelector(ERROR)).isDisplayed();
    }

}
