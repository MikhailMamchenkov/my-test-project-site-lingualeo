package com.lingualeo.my.test.progect.site.page;

import com.lingualeo.my.test.progect.site.BasePage;
import com.lingualeo.my.test.progect.site.block.HeaderBlock;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LanguagePage extends BasePage {

    private HeaderBlock headerBlock;


    public LanguagePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        this.headerBlock = new HeaderBlock(driver);
    }

    @Step("Кликает по кнопке languageButton, а затем по очереди кликает 1-ю группу языков")
    public ContentPage selectOneGroupLanguage(String LANGUAGE)   {
        headerBlock.getLanguageButton().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div/div[9]/div[2]/div[1]/a" + LANGUAGE + "/span/span"))).click();
        return new ContentPage(driver);

    }


    @Step("Кликает по кнопке languageButton, а затем по очереди кликает 2-ю группу языков")
    public ContentPage selectTwoGroupLanguage(String LANGUAGE)   {
        headerBlock.getLanguageButton().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div/div[9]/div[2]/div[2]/a" + LANGUAGE + "/span/span"))).click();
        return new ContentPage(driver);
    }


    public HeaderBlock getHeaderBlock() {
        return headerBlock;
    }

}
