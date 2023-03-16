package StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Step {

    public WebDriver webDriver= Hook.driver;
    PageObject pageObject;
    @Given("User opens URL {string}")
    public void user_opens_url(String url) {
        pageObject=new PageObject(webDriver);
        webDriver.get(url);
    }
    @When("Check the title")
    public void check_the_title() {
        String big_title=webDriver.getTitle();
        Assert.assertEquals("Your store. Login",big_title );
    }
    @Then("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        pageObject.setTxtEmail(email);
        pageObject.setTxtPassword(password);
    }
    @Then("Click on Login")
    public void click_on_login() {
        pageObject.clickLogin();
    }
    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
       if(webDriver.getPageSource().contains("Login was unsuccessful.")){
           webDriver.close();
           Assert.assertTrue(false);
       }else {
           Assert.assertEquals(title,webDriver.getTitle());
       }
    }
    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
        Thread.sleep(3000);
       pageObject.clickLogout();
       Thread.sleep(2000);
    }
    @Then("close browser")
    public void close_browser() {
       webDriver.quit();
    }


}
