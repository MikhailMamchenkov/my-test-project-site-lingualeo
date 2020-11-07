package com.lingualeo.my.test.progect.site.sign.up.auto.tests;

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.block.HeaderBlock;
import com.lingualeo.my.test.progect.site.helper.ChecksPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

@Feature("Регистрация")
public class SignUpWebTest extends BaseWebSettingsTest {

    @BeforeEach
    public void start() {
        driver.get("https://lingualeo.com");
    }

    @DisplayName("Проверяем регистрацию с рандомной почтой")
    @Step("Регистрация с логин {login} и пароль {password} где n: { n }")
    @Test
    void RegisterSuccessfulTest() {
        Random random = new Random();
        int n = random.nextInt(1000) + 1;
        new HeaderBlock(driver)
                .ckickAuthorizationButton()
                .fillLogin("MishaTest" + n + "@mail.ru")
                .fillPassword("Test12345")
                .clickCreateAnAccount();
        checkContentWithDisplayed("Выбери язык, который хочешь изучать");
        System.out.println(n);

    }

    @DisplayName("Проверяем, что регистрация не возможна с некоректной почтой")
    @Test
    void RegisterFailEmailTest() {
        new HeaderBlock(driver)
                .ckickAuthorizationButton()
                .fillLogin("df@mail.ru")
                .fillPassword("12dfghj")
                .clickCreateAnAccount();
        checkContentWithDisplayed("Неправильный e-mail или пароль. Пожалуйста, повторите попытку");
    }


    @DisplayName("Проверяем, что регистрация не возможна без ввода пароля")
    @Test
    void RegisterEmptyPasswordTest() {
        new HeaderBlock(driver)
                .ckickAuthorizationButton()
                .fillLogin("test.test2564@mail.ru")
                .fillPassword("")
                .clickCreateAnAccount();
        checkContentWithDisplayed("Слишком короткий пароль");
    }


    @DisplayName("Проверяем, что регистация невозможна с коротким паролем")
    @Test
    void RegisterShortPasswordTest() {
        new HeaderBlock(driver)
                .ckickAuthorizationButton()
                .fillLogin("test.test2564@mail.ru")
                .fillPassword("123")
                .clickCreateAnAccount();
        checkContentWithDisplayed("Слишком короткий пароль");
    }

    private void checkContentWithDisplayed(String text) {
        new ChecksPage(driver)
                .contentWithDisplayed(text);
    }
}
