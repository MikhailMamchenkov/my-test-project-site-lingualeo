package com.lingualeo.my.test.progect.site.page;

import com.lingualeo.my.test.progect.site.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InstallingApplicationsPage extends BasePage {


    @FindBy(css = "[href=\"https://itunes.apple.com/us/app/english-with-lingualeo/id480952151?mt=8\"]")
    private WebElement appStore;

    @FindBy(css = "[href=\"https://appgallery8.huawei.com/#/app/C100980145\"]")
    private WebElement appGallery;

    @FindBy(css = "[href=\"https://play.google.com/store/apps/details?id=com.lingualeo.android\"]")
    private WebElement googlePlay;

    @FindBy(css = "a.ll-leokit__landing-section-4__store-link:nth-child(4)")
    private WebElement googleExpansion;

    public InstallingApplicationsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Кликает по кнопке appStore")
    public ContentPage clickAppStore() {
        appStore.click();
        return new ContentPage(driver);
    }

    @Step("Кликает по кнопке app gallery")
    public ContentPage clickAppGallery() {
        appGallery.click();
        return new ContentPage(driver);
    }

    @Step("Кликает по кнопке googlePlay")
    public ContentPage clickGooglePlay() {
        googlePlay.click();
        return new ContentPage(driver);
    }

    @Step("Кликает по кнопке googleExpansion")
    public ContentPage clickGoogleExpansion() {
        googleExpansion.click();
        return new ContentPage(driver);
    }
}

