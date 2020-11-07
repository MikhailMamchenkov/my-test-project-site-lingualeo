package com.lingualeo.my.test.progect.site.social.networks.auto.tests;/*
package com.lingualeo.my.test.progect.site.social.networks.auto.tests;

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.block.HeaderBlock;
import com.lingualeo.my.test.progect.site.helper.ChecksPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 */
/*
    1. В блоке Header кликает на кнопку "Авторизоваться"
    2. Делает клик по социальной сети из выподающего списка
    3. Дожидается загрузки страницы социальной сети
    и делает проверку по тексту
     */


import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.block.HeaderBlock;
import com.lingualeo.my.test.progect.site.helper.ChecksPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Feature("Переход на авторизацию через социальные сети")
class SocialNetworksWebTest extends BaseWebSettingsTest {


    @BeforeEach
    void setUp() {
        driver.get("https://lingualeo.com");
    }

    @Test
    public void checkFacebook() {
        new HeaderBlock(driver)
                .ckickAuthorizationButton()
                .clickFacebook();
        checkContentWithDisplayed("Learn English with LinguaLeo");
    }

    @Test
    public void checkGoogleAccount() {
        new HeaderBlock(driver)
                .ckickAuthorizationButton()
                .clickGoogleAccaunt();
        checkContentWithDisplayed("Lingualeo");
    }

    @Test
    public void checkVk() {
        new HeaderBlock(driver)
                .ckickAuthorizationButton()
                .clickVk();
        checkContentWithDisplayed("Регистрация");
    }

    @Test
    public void checkDnevnik() {
        new HeaderBlock(driver)
                .ckickAuthorizationButton()
                .clickDnevnik();
        checkContentWithDisplayed("Логин");
    }

    private void checkContentWithDisplayed(String text) {
        new ChecksPage(driver)
                .contentWithDisplayed(text);
    }
}


