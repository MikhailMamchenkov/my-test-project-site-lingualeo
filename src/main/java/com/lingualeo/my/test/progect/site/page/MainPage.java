package com.lingualeo.my.test.progect.site.page;

import com.lingualeo.my.test.progect.site.helper.BasePage;
import com.lingualeo.my.test.progect.site.page.installing.applications.AppGalleryPage;
import com.lingualeo.my.test.progect.site.page.installing.applications.AppStorePagePage;
import com.lingualeo.my.test.progect.site.page.installing.applications.GoogleExpansionPage;
import com.lingualeo.my.test.progect.site.page.installing.applications.GooglePlayPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css = "[href=\"https://itunes.apple.com/us/app/english-with-lingualeo/id480952151?mt=8\"]")
    private WebElement appStore;

    @FindBy(css = "[href=\"https://appgallery8.huawei.com/#/app/C100980145\"]")
    private WebElement appGallery;

    @FindBy(css = "[href=\"https://play.google.com/store/apps/details?id=com.lingualeo.android\"]")
    private WebElement googlePlay;

    @FindBy(css = "a.ll-leokit__landing-section-4__store-link:nth-child(4)")
    private WebElement googleExpansion;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Кликает по кнопке appStore")
    public AppStorePagePage clickAppStore() {
        this.appStore.click();
        return new AppStorePagePage(driver);
    }

    @Step("Кликает по кнопке app gallery")
    public AppGalleryPage clickAppGallery() {
        this.appGallery.click();
        return new AppGalleryPage(driver);
    }

    @Step("Кликает по кнопке googlePlay")
    public GooglePlayPage clickGooglePlay() {
        this.googlePlay.click();
        return new GooglePlayPage(driver);
    }

    @Step("Кликает по кнопке googleExpansion")
    public GoogleExpansionPage clickGoogleExpansion() {
        this.googleExpansion.click();
        return new GoogleExpansionPage(driver);
    }
}


