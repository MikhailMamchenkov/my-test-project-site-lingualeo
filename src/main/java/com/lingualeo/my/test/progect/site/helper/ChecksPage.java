package com.lingualeo.my.test.progect.site.helper;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ChecksPage extends BasePage {

    protected CommonActions commonActions;

    public ChecksPage(WebDriver driver) {
        super(driver);
        this.commonActions = new CommonActions(driver);
    }

    @Step("Проверяет видимость текста {string} на странице")
    public ChecksPage contentWithDisplayed(String arg0) {
        commonActions.contentIsDisplayed(arg0);
        return this;
    }

    @Step("Делает проверку url")
    public ChecksPage checkUrl(String url) {
        commonActions.urlCheck(url);
        return this;
    }

    @Step("Переходит на другое окно")
    public void switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles())
            driver.switchTo().window(windowHandle);
    }

    @Step("Дожидается загрузки страницы")
    public ChecksPage waitUntilPageLoad() {
        commonActions.waitPageLoad();
        return this;
    }
}
