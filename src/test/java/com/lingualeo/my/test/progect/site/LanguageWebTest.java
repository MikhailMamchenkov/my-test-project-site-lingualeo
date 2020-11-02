package com.lingualeo.my.test.progect.site;

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.page.ContentPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

    /*
    1. В блоке Header кликает на кнопку "LanguageButton"
    2. Делает клик по языку из выподающего списка
    3. Дожидается загрузки нового интерфейса и делает проверку
    по тексту на кнопке с изображением флага в блоке Header
    Текст на кнопке должен быть релевантен выбранному языку
     */

@Feature("Проверка изменения языков интерфейса")
class LanguageWebTest extends BaseWebSettingsTest {



    @Step("Проверка языков первой группы от Португальского до Японского включительно")
    @ParameterizedTest()
    @MethodSource("LanguageWebTest1")
    public void LanguageWebTest1(String LANGUAGE, String MESSAGE) {
        driver.get("https://lingualeo.com");
        new ContentPage(driver)
                .getLanguagePage().selectOneGroupLanguage(LANGUAGE)
                .contentWithDisplayed(MESSAGE);

    }

    public static Stream<Arguments> LanguageWebTest1() {
        return Stream.of(
                Arguments.of("[1]", "Em progresso" ),
                Arguments.of("[2]", "Изучаю"),
                Arguments.of("[3]", "Öğreniliyor"),
                Arguments.of("[4]", "Estudiando"),
                Arguments.of("[5]", "Estudiando"),
                Arguments.of("[6]", "Learning"),
                Arguments.of("[7]", "Connectez-vous"),
                Arguments.of("[8]", "Sto studiando"),
                Arguments.of("[9]", "Ich lerne"),
                Arguments.of("[10]", "学习中"),
                Arguments.of("[11]", "学習中")
        );

    }

    @Step("Проверка языков первой группы от Польского до Сербского включительно")
    @ParameterizedTest()
    @MethodSource("LanguageWebTest2")
    public void LanguageWebTest2(String LANGUAGE, String MESSAGE) {
        driver.get("https://lingualeo.com");
        new ContentPage(driver)
                .getLanguagePage().selectTwoGroupLanguage(LANGUAGE)
                .contentWithDisplayed(MESSAGE);


    }

    public static Stream<Arguments> LanguageWebTest2() {
        return Stream.of(
                Arguments.of("[1]", "Języki, których się uczę"),
                Arguments.of("[2]", "Studuji"),
                Arguments.of("[3]", "Μαθαίνετε"),
                Arguments.of("[4]", "학습"),
                Arguments.of("[5]", "Ik leer"),
                Arguments.of("[6]", "Вивчаю"),
                Arguments.of("[7]", "सीखना"),
                Arguments.of("[8]", "Đang học"),
                Arguments.of("[9]", "Mempelajari"),
                Arguments.of("[10]", "Učenje u toku")

        );

    }
}


