package com.lingualeo.my.test.progect.site.block;

import com.lingualeo.my.test.progect.site.helper.BasePage;
import com.lingualeo.my.test.progect.site.page.MainPopUpPage;
import com.lingualeo.my.test.progect.site.page.language.LanguagePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderBlock extends BasePage {


    @FindBy(css = "[class=ll-leokit__site-menu__auth-wrapper]")
    protected WebElement authorizationButton;

    @FindBy(css = "[class=ll-leokit__site-logo]")
    protected WebElement lingualeoButton;

    @FindBy(xpath = "(//span[contains(.,'Задания')])[2]")
    protected WebElement Tasks;

    @FindBy(xpath = "(//span[contains(.,'Джунгли')])[2]")
    protected WebElement jungle;

    @FindBy(xpath = "(//span[contains(.,'Тренировки')])[2]")
    protected WebElement workouts;

    @FindBy(xpath = "//span[contains(.,'Курсы%')])[2]")
    protected WebElement courses;

    @FindBy(xpath = "(//span[contains(.,'Словарь')])[2]")
    protected WebElement dictionary;

    @FindBy(xpath = "(//div[contains(@class,'country-flag ')])[3]")
    protected WebElement countryFlag;

    @FindBy(xpath = "//span[contains(.,'PREMIUM')]")
    protected WebElement premium;

    @FindBy(css = ".ll-locale-selector2__button")
    protected WebElement languageButton;


    public HeaderBlock(WebDriver driver) {
        super(driver);
    }

    @Step("Кликает по кнопке Авторизация")
    public MainPopUpPage ckickAuthorizationButton() {
        this.authorizationButton.click();
        return new MainPopUpPage(driver);
    }
    @Step("Кликает по кнопке с выбором языкового интерфейса на странице")
    public LanguagePage ckickLanguageButton() {
        this.languageButton.click();
        return new LanguagePage(driver);
    }
}