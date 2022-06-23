package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public NavPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getLoginButton() {
        return this.driver.findElement(By.className("btnLogin"));
    }

    public void waitForLogoutButtonToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnLogout")));
    }

    public WebElement getLogoutButton() {
        return this.driver.findElement(By.className("btnLogout"));
    }

    public WebElement getLanguageSelectionButton() {
        return this.driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getENlanguageButton() {
        return this.driver.findElement(By.className("btnEN"));
    }

    public WebElement getESlanguageButton() {
        return this.driver.findElement(By.className("btnES"));
    }

    public WebElement getFRlanguageButton() {
        return this.driver.findElement(By.className("btnFR"));
    }

    public WebElement getCNlanguageButton() {
        return this.driver.findElement(By.className("btnCN"));
    }
}
