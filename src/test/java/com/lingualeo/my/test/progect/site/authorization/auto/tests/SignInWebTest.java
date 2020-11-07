package com.lingualeo.my.test.progect.site.authorization.auto.tests;

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.block.HeaderBlock;
import com.lingualeo.my.test.progect.site.helper.ChecksPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Авторизация")
public class SignInWebTest extends BaseWebSettingsTest {

    @BeforeEach
    void setUp() {
        driver.get("https://lingualeo.com");
    }

    @DisplayName("Проверяем возможность перехода на вход в личный кабинет при наличаи аккаунта")
    @Test
    void HaveAnAccountTest() {
        new HeaderBlock(driver)
                .ckickAuthorizationButton()
                .clickHaveAnAccount();
        checkTextHaveAnAccount("Войти");
    }

    private void checkTextHaveAnAccount(String text) {
        new ChecksPage(driver)
                .contentWithDisplayed(text);
    }

}
