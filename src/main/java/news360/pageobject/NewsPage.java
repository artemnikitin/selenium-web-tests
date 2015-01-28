package news360.pageobject;

import static com.codeborne.selenide.Selenide.$;

public class NewsPage extends Page {

    @Override
    public boolean isOpened() {
        return $(".user.default").isDisplayed();
    }

}
