package com.lingualeo.my.test.progect.site.Install.apps.auto.tests;

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.helper.ChecksPage;
import com.lingualeo.my.test.progect.site.page.MainPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Приложения и расширение")
public class InstallAppsWebTest extends BaseWebSettingsTest {

    @BeforeEach
    void setUp() {
        driver.get("https://lingualeo.com");
    }

    @DisplayName("Проверяем возможность перехода по кнопке 'AppStore' для скачивания приложения")
    @Test
    void AppStoryButtonTest() {
        new MainPage(driver)
                .clickAppStore();
        checkInstallApps("https://apps.apple.com/us/app/english-with-lingualeo/id480952151",
                "English and other languages");
    }


    @DisplayName("Проверяем возможность перехода по кнопке 'AppGallery' для скачивания приложения")
    @Test
    public void AppGalleryButtonTest() {
        new MainPage(driver)
                .clickAppGallery();
        checkInstallApps("https://appgallery.huawei.com/#/app/C100980145", "HUAWEI AppGallery");
    }


    @DisplayName("Проверяем возможность перехода по кнопке 'Google Play' для скачивания приложения")
    @Test
    public void GooglePlayButtonTest() {
        new MainPage(driver)
                .clickGooglePlay();
        checkInstallApps("https://play.google.com/store/apps/details?id=com.lingualeo.android",
                "Учить английский язык с Lingualeo");

    }


    @DisplayName("Проверяем возможность перехода по кнопке 'Расширение для браузеров'")
    @Test
    public void GoogleExpansionButtonTest() {
        new MainPage(driver)
                .clickGoogleExpansion();
        checkContentWithDisplayed("Lingualeo Language Translator");
    }

    private void checkInstallApps(String url, String text) {
        new ChecksPage(driver)
                .checkUrl(url)
                .contentWithDisplayed(text);
    }

    private void checkContentWithDisplayed(String text) {
        new ChecksPage(driver)
       .contentWithDisplayed(text);
    }

}

