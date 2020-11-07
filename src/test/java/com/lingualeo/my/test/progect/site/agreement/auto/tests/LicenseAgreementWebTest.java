package com.lingualeo.my.test.progect.site.agreement.auto.tests;

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.block.HeaderBlock;
import com.lingualeo.my.test.progect.site.helper.ChecksPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Политика конфиденциальности")
public class LicenseAgreementWebTest extends BaseWebSettingsTest {


    @BeforeEach
    void setUp() {
        driver.get("https://lingualeo.com");
    }

    @DisplayName("Проверяем возможность перехода к лицензионному соглашению")
    @Test
    public void licensedAgreementTest() {
        new HeaderBlock(driver)
                .ckickAuthorizationButton()
                .clickOnLicensedAgreementButton();
        checkAgreement("https://lingualeo.com/ru/blog/termsofuse/");
    }

    @DisplayName("Проверяем возможность перехода к положению о защите персональных данных")
    @Test
    public void personalInformationTest() {
        new HeaderBlock(driver)
                .ckickAuthorizationButton()
                .clickOnProtectionOfPersonalInformationButton();
        checkAgreement("https://lingualeo.com/ru/blog/polozhenie-o-zashhite-personalnyih-dannyih/");

    }

    private void checkAgreement(String url) {
        new ChecksPage(driver)
        .checkUrl(url);
    }


}

