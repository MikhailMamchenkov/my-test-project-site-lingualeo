package com.lingualeo.my.test.progect.site.language.auto.tests;

import com.lingualeo.my.test.progect.site.base.BaseWebSettingsTest;
import com.lingualeo.my.test.progect.site.block.HeaderBlock;
import com.lingualeo.my.test.progect.site.helper.ChecksPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/*    1. В блоке Header кликает на кнопку "LanguageButton"
    2. Делает клик по языку из выподающего списка
    3. Дожидается загрузки нового интерфейса и делает проверку
    по тексту на кнопке с изображением флага в блоке Header
    Текст на кнопке должен быть релевантен выбранному языку
     */


@Feature("Проверка изменения языков интерфейса")
class LanguageWebTest extends BaseWebSettingsTest {

    @BeforeEach
    void setUp() {
        driver.get("https://lingualeo.com");
    }

    @Step("Проверка изменения языка интерфейса")
    @ParameterizedTest(name = "{index} => Нажатие на: {0}")
    @MethodSource("LanguageWebTest1")
    public void LanguageWebTest1(String LANGUAGE, String MESSAGE) {
        new HeaderBlock(driver)
                .ckickLanguageButton()
                .selectLanguage(LANGUAGE);
        checkContentWithDisplayed(MESSAGE);
    }

    public static Stream<Arguments> LanguageWebTest1() {
        return Stream.of(
                Arguments.of("Português (Br)", "Em progresso"),
                Arguments.of("Русский", "Изучаю"),
                Arguments.of("Türkçe", "Öğreniliyor"),
                Arguments.of("Español", "Estudiando"),
                Arguments.of("Español (LA)", "Estudiando"),
                Arguments.of("English", "Learning"),
                Arguments.of("Français", "Connectez-vous"),
                Arguments.of("Italiano", "Sto studiando"),
                Arguments.of("Deutsch", "Ich lerne"),
                Arguments.of("中文（中国）", "学习中"),
                Arguments.of("日本語", "学習中"),
                Arguments.of("Polski", "Języki, których się uczę", "pol"),
                Arguments.of("Čeština", "Studuji"),
                Arguments.of("Ελληνικά", "Μαθαίνετε"),
                Arguments.of("한국어", "학습"),
                Arguments.of("Nederlands", "Ik leer"),
                Arguments.of("Українська", "Вивчаю"),
                Arguments.of("हिन्दी", "सीखना"),
                Arguments.of("Tiếng Việt", "Đang học"),
                Arguments.of("Bahasa Indonesia", "Mempelajari"),
                Arguments.of("Српски", "Učenje u toku")
        );

    }

    private void checkContentWithDisplayed(String text) {
        new ChecksPage(driver)
                .contentWithDisplayed(text);
    }
}


