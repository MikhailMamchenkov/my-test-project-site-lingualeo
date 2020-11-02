package com.lingualeo.my.test.progect.site.page;

import com.lingualeo.my.test.progect.site.block.HeaderBlock;
import com.lingualeo.my.test.progect.site.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyPolicyPage extends BasePage {

    private HeaderBlock headerBlock;
    private ContentPage contentPage;


    @FindBy(css = "[class=ll-ModalAuthAlt__disclaimer]")
    private WebElement agreement;


    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
        this.headerBlock = new HeaderBlock(driver);
        this.contentPage = new ContentPage(driver);

    }


    @Step("Кликает по кнопке agreement и переходит на страницу лецензионного соглашения ")
    public ContentPage clickLicenseAgreement() {
        headerBlock.getAuthorizationButton().click();
        agreement.click();
        contentPage.switchToNewWindow();
        return new ContentPage(driver);
    }



    public HeaderBlock getHeaderBlock() {
        return headerBlock;
    }


}
