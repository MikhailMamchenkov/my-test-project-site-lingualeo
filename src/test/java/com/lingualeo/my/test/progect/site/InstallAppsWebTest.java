package com.lingualeo.my.test.progect.site;

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.page.InstallingApplicationsPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Приложения и расширение")
public class InstallAppsWebTest extends BaseWebSettingsTest {

    /*
    1. Кликает на кнопку "AppStore"
    2. Совершает проверку Url
    3. Делает проверку по видимости текста на странице "AppStore
     */

    @DisplayName("Проверяем возможность перехода по кнопке 'AppStore' для скачивания приложения")
    @Test
    void AppStoryButtonTest() {
        driver.get("https://lingualeo.com");
        new InstallingApplicationsPage(driver)
                .clickAppStore()
                .checkUrl("https://apps.apple.com/us/app/english-with-lingualeo/id480952151")
                .contentWithDisplayed("English and other languages");
    }

    /*
    1. Кликает на кнопку "AppGallery"
    2. Совершает проверку Url
    3. Делает проверку по видимости текста на странице "AppGallery
     */

    @DisplayName("Проверяем возможность перехода по кнопке 'AppGallery' для скачивания приложения")
    @Test
    public void AppGalleryButtonTest() {
        driver.get("https://lingualeo.com");
        new InstallingApplicationsPage(driver)
                .clickAppGallery()
                .checkUrl("https://appgallery.huawei.com/#/app/C100980145")
                .contentWithDisplayed("HUAWEI AppGallery");

    }

    /*
    1. Кликает на кнопку "Google Play"
    2. Совершает проверку Url
    3. Делает проверку по видимости текста на странице "Google Play
     */

    @DisplayName("Проверяем возможность перехода по кнопке 'Google Play' для скачивания приложения")
    @Test
    public void GooglePlayButtonTest() {
        driver.get("https://lingualeo.com");
        new InstallingApplicationsPage(driver)
                .clickGooglePlay()
                .checkUrl("https://play.google.com/store/apps/details?id=com.lingualeo.android")
                .contentWithDisplayed("Учить английский язык с Lingualeo");

    }

      /*
    1. Кликает на кнопку "Расширение для браузеров"
    2. Делает проверку по видимости текста на странице "Расширение для браузеров"
     */

    @DisplayName("Проверяем возможность перехода по кнопке 'Расширение для браузеров'")
    @Test
    public void GoogleExpansionButtonTest() {
        driver.get("https://lingualeo.com");
        new InstallingApplicationsPage(driver)
                .clickGoogleExpansion()
                .contentWithDisplayed("Lingualeo Language Translator");
    }

}

