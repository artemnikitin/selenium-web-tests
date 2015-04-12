package exness.pageobject;

import ru.yandex.qatools.allure.annotations.Step;

public abstract class Page {

    @Step("Check that page is opened")
    public abstract boolean isOpened();

}
