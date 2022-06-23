package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailInputField() {
        return this.driver.findElement(By.name("email"));
    }

    public WebElement getPasswordInputField() {
        return this.driver.findElement(By.name("password"));
    }

    public WebElement getLoginButton() {
        return this.driver.findElement(By.className("v-btn--contained"));
    }
}
