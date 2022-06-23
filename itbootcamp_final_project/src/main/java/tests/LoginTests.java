package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BasicTest {

    @Test(priority = 10)
    public void visitsTheLoginPage() {
        this.navPage.getLanguageSelectionButton().click();
        this.navPage.getENlanguageButton().click();
        this.navPage.getLoginButton().click();
        Assert.assertTrue(
                this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] The Url does not contain '/login'.");
    }

    @Test(priority = 20)
    public void checksInputTypes() {
        this.navPage.getLoginButton().click();
        Assert.assertEquals(
                this.loginPage.getEmailInputField().getAttribute("type"),
                "email",
                "[ERROR] Email input field for attribute 'type' has no value 'email'.");
        Assert.assertEquals(
                this.loginPage.getPasswordInputField().getAttribute("type"),
                "password",
                "[ERROR] Password input field for attribute 'type' has no value 'password'.");
    }

    @Test(priority = 30)
    public void displaysErrorsWhenUserDoesNotExist() {
        this.navPage.getLoginButton().click();
        this.loginPage.getEmailInputField().sendKeys("non-existing-user@gmal.com");
        this.loginPage.getPasswordInputField().sendKeys("password123");
        this.loginPage.getLoginButton().click();
        this.messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertTrue(
                this.messagePopUpPage.getTextMessages().getText().contains("User does not exists"),
                "[ERROR] The message does not contain text 'User does non exist'.");
        Assert.assertTrue(
                this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] The Url does not contain '/login'.");
    }

    @Test(priority = 40)
    public void displaysErrorsWhenPasswordIsWrong() {
        this.navPage.getLoginButton().click();
        this.loginPage.getEmailInputField().sendKeys("admin@admin.com");
        this.loginPage.getPasswordInputField().sendKeys("password123");
        this.loginPage.getLoginButton().click();
        this.messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertTrue(
                this.messagePopUpPage.getTextMessages().getText().contains("Wrong password"),
                "[ERROR] The message does not contain text 'Wrong password'.");
        Assert.assertTrue(
                this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] The Url does not contain '/login'.");
    }

    @Test(priority = 50)
    public void logIn() {
        this.navPage.getLoginButton().click();
        this.loginPage.getEmailInputField().sendKeys("admin@admin.com");
        this.loginPage.getPasswordInputField().sendKeys("12345");
        this.loginPage.getLoginButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/home"));
    }

    @Test(priority = 60)
    public void logOut() {
        this.navPage.waitForLogoutButtonToBeVisible();
        this.navPage.getLogoutButton().click();
    }
}
