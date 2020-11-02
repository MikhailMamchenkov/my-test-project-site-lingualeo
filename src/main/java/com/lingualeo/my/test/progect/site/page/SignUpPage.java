package com.lingualeo.my.test.progect.site.page;

import com.lingualeo.my.test.progect.site.BasePage;
import com.lingualeo.my.test.progect.site.block.HeaderBlock;
import com.lingualeo.my.test.progect.site.helper.CommonActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    private HeaderBlock headerBlock;
    private CommonActions commonActions;


    @FindBy(css = "[placeholder=\"E-mail\"]")
    private WebElement inputLogin;

    @FindBy(css = "[type=\"password\"]")
    private WebElement inputPassword;

    @FindBy(css = "button.ll-leokit__button:nth-child(5) > span:nth-child(1) > span:nth-child(1)")
    private WebElement haveAnAccount;

    @FindBy(css = ".ll-ModalAuthAlt__submit > span:nth-child(1)")
    private WebElement buttonSingIn;

    @FindBy(css = "[class=ll-ModalAuthAlt__disclaimer]")
    private WebElement agreement;

    @FindBy(css = "[class=\"ll-ModalAuthAlt__error\"]")
    private WebElement passwordError;

    @FindBy(css = "[class=\"ll-ModalAuthAlt__error\"]")
    private WebElement emailError;

    @FindBy(css = "[class=\"ll-ModalAuthAlt__error\"]")
    private WebElement authorizationError;


    public SignUpPage(WebDriver driver) {
        super(driver);
        this.headerBlock = new HeaderBlock(driver);
        this.commonActions = new CommonActions(driver);
    }

    @Step("Регистрация с логин {login} и пароль {password}")
    public ContentPage singIn(String login, String password) {
        headerBlock.getAuthorizationButton().click();
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSingIn.click();
        return new ContentPage(driver);
    }

    @Step("Возвращает ошибку о неправильным email: '{emailError}'")
    public String getTextFromEmailError() {
        return commonActions.getTextWithWait(emailError);
    }


    @Step("Возвращает ошибку о неправильным password: '{passwordError}'")
    public String getTextFromPasswordError() {
        return commonActions.getTextWithWait(passwordError);
    }

    public HeaderBlock getHeaderBlock() {
        return headerBlock;
    }
}
