package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

    @Test(priority = 10)
    public void visitsTheSignupPage() {
        this.navPage.getSignupButton().click();
        Assert.assertTrue(
                this.driver.getCurrentUrl().contains("/signup"),
                "[ERROR] The Url does not contain '/signup'.");
    }

    @Test(priority = 20)
    public void checksInputTypes() {
        this.navPage.getSignupButton().click();
        Assert.assertEquals(
                this.signUpPage.getEmailInputField().getAttribute("type"),
                "email",
                "[ERROR] Email input field for attribute 'type' has no value 'email'.");
        Assert.assertEquals(
                this.signUpPage.getPasswordInputField().getAttribute("type"),
                "password",
                "[ERROR] Password input field for attribute 'type' has no value 'password'.");
        Assert.assertEquals(
                this.signUpPage.getConfirmPasswordInputField().getAttribute("type"),
                "password",
                "[ERROR] Confirm Password input field for attribute 'type' has no value 'password'.");
    }

    @Test(priority = 30)
    public void displaysErrorsWhenUserAlreadyExists() {
        this.navPage.getSignupButton().click();
        Assert.assertTrue(
                this.driver.getCurrentUrl().contains("/signup"),
                "[ERROR] The Url does not contain '/signup'.");
        this.signUpPage.getNameInputField().sendKeys("Another User");
        this.signUpPage.getEmailInputField().sendKeys("admin@admin.com");
        this.signUpPage.getPasswordInputField().sendKeys("12345");
        this.signUpPage.getConfirmPasswordInputField().sendKeys("12345");
        this.signUpPage.getSignMeUpButton().click();
        this.messagePopUpPage.waitForPopUpToBeVisible();
        Assert.assertTrue(
                this.messagePopUpPage.getTextMessages().getText().contains("E-mail already exists"),
                "[ERROR] The message does not contain text 'E-mail already exists'.");
        Assert.assertTrue(
                this.driver.getCurrentUrl().contains("/signup"),
                "[ERROR] The Url does not contain '/signup'.");
    }

    @Test(priority = 40)
    public void signUp() {
        this.navPage.getSignupButton().click();
        this.signUpPage.getNameInputField().sendKeys("Sandra Milic");
        this.signUpPage.getEmailInputField().sendKeys("sandra.milic@itbootcamp.rs");
        this.signUpPage.getPasswordInputField().sendKeys("12345");
        this.signUpPage.getConfirmPasswordInputField().sendKeys("12345");
        this.signUpPage.getSignMeUpButton().click();
        this.driver.get(baseUrl + "/home");
        this.messagePopUpPage.waitForDialogVerifyYourAccountToBeVisible();
        Assert.assertEquals(
                this.messagePopUpPage.getTitleFromDialogBox().getText(),
                "IMPORTANT: Verify your account",
                "[ERROR] The dialog box does not contain text 'IMPORTANT: Verify your account'.");
        this.messagePopUpPage.getDialogBoxCloseButton().click();
        this.navPage.getLogoutButton().click();
    }
}
