package lazada.pageobject;

public class MainPage extends Page {

    public SignUpForm signUp() {
        return new SignUpForm();
    }

    @Override
    public boolean isOpened() {
        return false;
    }

}
