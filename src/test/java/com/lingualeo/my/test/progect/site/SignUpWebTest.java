package com.lingualeo.my.test.progect.site;

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.page.ContentPage;
import com.lingualeo.my.test.progect.site.page.SignUpPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

@Feature("Регистрация")
public class SignUpWebTest extends BaseWebSettingsTest {


    /*
    1. Кликает на кнопку "Авторизоваться"
    2. Вводится login с 1-м случайным пораметром
    3. Вводится password "Test12345"
    4. Нажимает кнопку "Создать аккаунт"
    5. Делает проверку по видимости текста на странице "С выбором изучения языка"
    5. Выводит в консоль случайно-сгенерированное значение
     */


    @DisplayName("Проверяем регистрацию с рандомной почтой")
    @Test
    void RegisterSuccessfulTest() {
        driver.get("https://lingualeo.com");
        Random random = new Random();
        int n = random.nextInt(1000) + 1;
        new SignUpPage(driver)
                .singIn("MishaTest" + n + "@mail.ru", "Test12345")
                .contentWithDisplayed("Выбери язык, который хочешь изучать");
        System.out.println(n);

    }

    /*
    1. Кликает на кнопку "Авторизоваться"
    2. Вводится login "df@mail.ru"
    3. Вводится password "12dfghj"
    4. Нажимает кнопку "Создать аккаунт"
    5. Делает проверку по видимости текста ошибки, о том что: "введенные данные не корректны"
     */

    @DisplayName("Проверяем, что регистрация не возможна с некоректной почтой")
    @Test
    void RegisterFailEmailTest() {
        driver.get("https://lingualeo.com");
        new SignUpPage(driver)
                .singIn("df@mail.ru", "12dfghj");
        new ContentPage(driver)
                .contentWithDisplayed("Неправильный e-mail или пароль. Пожалуйста, повторите попытку");
    }

    /*
    1. Кликает на кнопку "Авторизоваться"
    2. Вводится login "df@mail.ru"
    3. Поле password остается пустым ""
    4. Нажимает кнопку "Создать аккаунт"
    5. Делает проверку по видимости текста ошибки, о том что: "Слишком короткий пароль"
     */

    @DisplayName("Проверяем, что регистрация не возможна без ввода пароля")
    @Test
    void RegisterEmptyPasswordTest() {
        driver.get("https://lingualeo.com");
        new SignUpPage(driver)
                .singIn("test.test2564@mail.ru", "");
        new ContentPage(driver)
                .contentWithDisplayed("Слишком короткий пароль");
    }


    /*
    1. Кликает на кнопку "Авторизоваться"
    2. Вводится login "test.test2564@mail.ru"
    3. Вводится password "123"
    4. Нажимает кнопку "Создать аккаунт"
    5. Делает проверку по видимости текста ошибки, о том что: "Слишком короткий пароль"
     */

    @DisplayName("Проверяем, что регистация невозможна с коротким паролем")
    @Test
    void RegisterShortPasswordTest() {
        driver.get("https://lingualeo.com");
        new SignUpPage(driver)
                .singIn("test.test2564@mail.ru", "123");
        new ContentPage(driver)
                .contentWithDisplayed("Слишком короткий пароль");
    }
}
