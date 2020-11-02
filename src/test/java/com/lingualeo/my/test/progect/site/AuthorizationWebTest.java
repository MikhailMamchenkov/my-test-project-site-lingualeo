package com.lingualeo.my.test.progect.site;

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.page.AuthorizationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorizationWebTest extends BaseWebSettingsTest {

    /*
    1. Кликает на кнопку "Авторизоваться"
    2. Кликает на кнопку "Уже есть аккаунт"
    3. Проверяет, что после нажатия появилась форма SignIn по тексту "Вход"
     */

    @DisplayName("Проверяем возможность перехода на вход в личный кабинет при наличаи аккаунта")
    @Test
    void HaveAnAccountTest() {
        driver.get("https://lingualeo.com");
        new AuthorizationPage(driver)
                .clickHaveAnAccount()
                .contentWithDisplayed("Войти");

    }

}
