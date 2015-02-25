package lazada.pageobject;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class SignUpForm extends Page {

    public SignUpForm() {
        $("#send").should(appear);
    }

    public SignUpForm enterName(String name) {
        $("#RegistrationForm_first_name").sendKeys(name);
        return this;
    }

    public SignUpForm enterEmail(String email) {
        $("#RegistrationForm_email").sendKeys(email);
        return this;
    }

    public SignUpForm enterPassword(String password) {
        $("#RegistrationForm_password").sendKeys(password);
        return this;
    }

    public SignUpForm pressSubmit() {
        $("#send").click();
        return this;
    }

    public boolean checkError() {
        return $(".error-password.s-error.msg.error-display").isDisplayed();
    }

    @Override
    public boolean isOpened() {
        return $("#send").isDisplayed();
    }

}
