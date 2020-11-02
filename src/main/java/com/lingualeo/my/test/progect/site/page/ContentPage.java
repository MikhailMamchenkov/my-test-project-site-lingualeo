package com.lingualeo.my.test.progect.site.page;

import com.lingualeo.my.test.progect.site.BasePage;
import com.lingualeo.my.test.progect.site.helper.CommonActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ContentPage extends BasePage {

    private CommonActions commonActions;
    private SocialNetworksPage socialNetworksPage;
    private LanguagePage languagePage;



    public ContentPage(WebDriver driver) {
        super(driver);
        this.socialNetworksPage = new SocialNetworksPage(driver);
        this.languagePage = new LanguagePage(driver);
        this.commonActions = new CommonActions(driver);
    }

    @Step("Content with {string} Displayed")
    public ContentPage contentWithDisplayed(String arg0) {
        commonActions.contentIsDisplayed(arg0);
        return this;
    }


    @Step("Делает проверку url")
    public ContentPage checkUrl(String url) {
        commonActions.urlCheck(url);
        return this;
    }

    @Step("Переходит на другое окно")
    public void switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles())
            driver.switchTo().window(windowHandle);
    }

    @Step("Дожидается загрузки страницы")
    public void waitUntilPageLoad() {
        commonActions.waitPageLoad();
    }


    public CommonActions getCommonActions() {
        return commonActions;
    }


    public SocialNetworksPage getSocialNetworksPage() {
        return socialNetworksPage;
    }

    public LanguagePage getLanguagePage() {
        return languagePage;
    }

}
