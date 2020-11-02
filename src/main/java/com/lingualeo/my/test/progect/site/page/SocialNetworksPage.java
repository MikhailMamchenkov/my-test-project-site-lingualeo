package com.lingualeo.my.test.progect.site.page;

import com.lingualeo.my.test.progect.site.BasePage;
import com.lingualeo.my.test.progect.site.block.HeaderBlock;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SocialNetworksPage extends BasePage {

    private HeaderBlock headerBlock;


    public SocialNetworksPage(WebDriver driver) {
        super(driver);
        this.headerBlock = new HeaderBlock(driver);
    }

    @Step("Кликает по очереди по каждой социальной сети")
    public ContentPage clickSosialNetworks(String ClassName) {
        headerBlock.getAuthorizationButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'" + ClassName + "')]/."))).click();
        return new ContentPage(driver);
    }

    public HeaderBlock getHeaderBlock() {
        return headerBlock;
    }
}

