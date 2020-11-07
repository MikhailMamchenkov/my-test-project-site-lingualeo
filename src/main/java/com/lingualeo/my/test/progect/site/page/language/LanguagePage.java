package com.lingualeo.my.test.progect.site.page.language;

import com.lingualeo.my.test.progect.site.helper.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LanguagePage extends BasePage {


    public LanguagePage(WebDriver driver) {
        super(driver);
    }

 /*   String serialNumberOfLanguage создана для того чтобы метод работал коректно,
    поскольку у единственного языка "English" xpath отличается!
    Наглядный пример:
            //span[contains(.,'English')])[4]
            //span[contains(.,'Türkçe')])[2]
            //span[contains(.,'Čeština')])[2]*/



    @Step("Кликает по очереди по каждому языку")
    public LanguagePage selectLanguage(String LANGUAGE)   {
        String serialNumberOfLanguage = "2";
        if(LANGUAGE.equals("English")) {
            serialNumberOfLanguage = "4";
        }
       // driver.findElement(By.xpath("(//span[contains(.,'"+LANGUAGE+"')])["+serialNumberOfLanguage+"]")).click();
        this.languageButton(LANGUAGE, serialNumberOfLanguage).click();
        return new LanguagePage(driver);

    }
    private WebElement languageButton(String LANGUAGE, String serialNumberOfLanguage) {
        return driver.findElement(By.xpath("(//span[contains(.,'"+LANGUAGE+"')])["+serialNumberOfLanguage+"]"));
    }
}
