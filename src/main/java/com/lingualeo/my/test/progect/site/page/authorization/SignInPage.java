package com.lingualeo.my.test.progect.site.page.authorization;

import com.lingualeo.my.test.progect.site.helper.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {


    @FindBy(css = "button.ll-leokit__button:nth-child(5) > span:nth-child(1) > span:nth-child(1)")
    private WebElement haveAnAccount;

    public SignInPage(WebDriver driver) {
        super(driver);
    }


}

