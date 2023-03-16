package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    public WebDriver webDriver;

    public PageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    @FindBy(id ="Email")
    @CacheLookup
    WebElement txtEmail;
    @FindBy(id="Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath ="//button[.='Log in']" )
    @CacheLookup
    WebElement btnLogin;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement btnLogout;

    public void setTxtEmail(String email){
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setTxtPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void clickLogout(){
        btnLogout.click();
    }



}
