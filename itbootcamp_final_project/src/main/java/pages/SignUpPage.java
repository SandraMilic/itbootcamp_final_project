package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {

    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNameInputField() {
        return this.driver.findElement(By.name("name"));
    }

    public WebElement getEmailInputField() {
        return this.driver.findElement(By.name("email"));
    }

    public WebElement getPasswordInputField() {
        return this.driver.findElement(By.name("password"));
    }

    public WebElement getConfirmPasswordInputField() {
        return this.driver.findElement(By.name("confirmPassword"));
    }

    public WebElement getSignMeUpButton() {
        return  this.driver.findElement(By.className("v-btn--contained"));
    }
}
