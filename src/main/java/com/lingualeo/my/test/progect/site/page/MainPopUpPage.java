package com.lingualeo.my.test.progect.site.page;

import com.lingualeo.my.test.progect.site.helper.BasePage;
import com.lingualeo.my.test.progect.site.page.agreement.LicensedAgreementPage;
import com.lingualeo.my.test.progect.site.page.agreement.PersonalInformationPage;
import com.lingualeo.my.test.progect.site.page.authorization.SignInPage;
import com.lingualeo.my.test.progect.site.page.sign.up.SignUpPage;
import com.lingualeo.my.test.progect.site.page.social.networks.DnevnikPage;
import com.lingualeo.my.test.progect.site.page.social.networks.FacebookPage;
import com.lingualeo.my.test.progect.site.page.social.networks.GoogleAccauntPage;
import com.lingualeo.my.test.progect.site.page.social.networks.VkPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPopUpPage extends BasePage {

    @FindBy(css = "[placeholder=E-mail]")
    private WebElement inputLogin;

    @FindBy(css = "[type=password]")
    private WebElement inputPassword;

    @FindBy(css = ".ll-ModalAuthAlt__submit > span:nth-child(1)")
    private WebElement submitButton;

    @FindBy(css = "button.ll-leokit__button:nth-child(5) > span:nth-child(1) > span:nth-child(1)")
    private WebElement haveAnAccountButton;

    @FindBy(xpath = "//span[contains(.,'Создать аккаунт')]")
    private WebElement createAnAccountButton;

    @FindBy(xpath = "//span[contains(.,'Лицензионного соглашения')]")
    private WebElement licensedAgreementButton;

    @FindBy(xpath = "//span[contains(.,'Положения о защите персональных данных')]")
    private WebElement protectionOfPersonalInformationButton;

    @FindBy(xpath = "//button[contains(@class,'m-facebook')]/.")
    private WebElement facebook;

    @FindBy(xpath = "//button[contains(@class,'google')]/.")
    private WebElement googleAccaunt;

    @FindBy(xpath = "//button[contains(@class,'vk')]/.")
    private WebElement vk;

    @FindBy(xpath = "//button[contains(@class,'dnevnik')]/.")
    private WebElement dnevnik;



    public MainPopUpPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажимает на Лицензионного соглашения")
    public LicensedAgreementPage clickOnLicensedAgreementButton() {
        this.licensedAgreementButton.click();
        return new LicensedAgreementPage(driver);
    }

    @Step("Нажимает на Положения о защите персональных данных")
    public PersonalInformationPage clickOnProtectionOfPersonalInformationButton() {
        this.protectionOfPersonalInformationButton.click();
        return new PersonalInformationPage(driver);
    }

    @Step("Заполняет поле Логина")
    public MainPopUpPage fillLogin(String login) {
        this.inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполняет поле Пароля")
    public MainPopUpPage fillPassword(String password) {
        this.inputPassword.sendKeys(password);
        return this;
    }

    @Step("Кликает по кнопке Создать аккаунт")
    public SignUpPage clickCreateAnAccount() {
        this.createAnAccountButton.click();
        return new SignUpPage(driver);
    }

    @Step("Кликает по кнопке У меня уже есть аккаунт")
    public SignInPage clickHaveAnAccount() {
        this.haveAnAccountButton.click();
        return new SignInPage(driver);
    }

    @Step("Кликает по кнопке facebook")
    public SignInPage clickFacebook() {
        this.facebook.click();
        return new FacebookPage(driver);
    }

    @Step("Кликает по кнопке googleAccaunt")
    public SignInPage clickGoogleAccaunt() {
        this.googleAccaunt.click();
        return new GoogleAccauntPage(driver);
    }

    @Step("Кликает по кнопке vk")
    public SignInPage clickVk() {
        this.vk.click();
        return new VkPage(driver);
    }

    @Step("Кликает по кнопке dnevnik")
    public SignInPage clickDnevnik() {
        this.dnevnik.click();
        return new DnevnikPage(driver);
    }

/*    @Step("Кликает по очереди по каждой социальной сети")
    public ContentPage clickSosialNetworks(String ClassName) {
        driver.findElement(By.xpath("//button[contains(@class,'" + ClassName + "')]/.")).click();
        return new ContentPage(driver);
    }*/
}

