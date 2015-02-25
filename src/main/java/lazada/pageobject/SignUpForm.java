package lazada.pageobject;

public class SignUpForm extends Page {

    public SignUpForm enterName(String name) {
        return this;
    }

    public SignUpForm enterEmail(String email) {
        return this;
    }

    public SignUpForm enterPassword(String password) {
        return this;
    }

    public SignUpForm pressSubmit() {
        return this;
    }

    public boolean checkError() {
        return true;
    }

    @Override
    public boolean isOpened() {
        return false;
    }

}
