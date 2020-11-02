package com.lingualeo.my.test.progect.site;

 /*
    1. В блоке Header кликает на кнопку "Авторизоваться"
    2. Делает клик по социальной сети из выподающего списка
    3. Дожидается загрузки страницы социальной сети
    и делает проверку по тексту
     */

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.page.ContentPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Feature("Переход на авторизацию через социальные сети")
class SocialNetworks extends BaseWebSettingsTest {

    public static final String FACEBOOK = "Войдите на Facebook | Facebook";
    public static final String VK = "ВКонтакте | Вход";
    public static final String GOOGLE = "Вход – Google Аккаунты";
    public static final String DNEVNIK = "Дневник.ру | Войти в Дневник.ру";


    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("CheckSosialNetworks")
    public void checkNavigationNotPopUp(String ClassName, String MESSAGE) {
        driver.get("https://lingualeo.com");
        new ContentPage(driver)
                .getSocialNetworksPage().clickSosialNetworks(ClassName)
                .contentWithDisplayed(MESSAGE);
    }


    public static Stream<Arguments> CheckSosialNetworks() {
        return Stream.of(
                Arguments.of("m-facebook", FACEBOOK),
                Arguments.of("vk", VK),
                Arguments.of("google", GOOGLE),
                Arguments.of("dnevnik", DNEVNIK)
        );

    }
}


