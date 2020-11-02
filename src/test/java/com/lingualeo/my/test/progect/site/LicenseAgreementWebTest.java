package com.lingualeo.my.test.progect.site;

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.page.PrivacyPolicyPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Политика конфиденциальности")
public class LicenseAgreementWebTest extends BaseWebSettingsTest {


    /*
    1. Кликает на кнопку "Авторизоваться"
    2. Кликает на кнопку "Agreement" - Политика конфиденциальности
    3. Переключается на новое окно
    4. Делает проверку по видимости текста на странице "Политики конфиденциальности"
     */

    @DisplayName("Проверяем возможность перехода к политики конфиденциальности")
    @Test
    public void LicenseAgreementTest() {
        driver.get("https://lingualeo.com");
        new PrivacyPolicyPage(driver)
                .clickLicenseAgreement()
                .checkUrl("https://lingualeo.com/ru/blog/termsofuse/");
    }
}

