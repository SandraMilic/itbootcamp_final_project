package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForPopUpToBeVisible() {
        this.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__wrapper")));
    }
    public void waitForPopUpOnCityPageToBeVisible() {
        this.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }
    public WebElement getMessagesFromPopUpOnCityPage() {
        return this.driver.findElement(By.className("success"));
    }

    public WebElement getTextMessages() {
        return this.driver.findElement(By.className("v-snack__content"));
    }

    public WebElement getPopUpCloseButton() {
        return this.driver.findElement(By.className("v-btn--text"));
    }

    public void waitForDialogVerifyYourAccountToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-card")));
    }

    public WebElement getTitleFromDialogBox() {
        return this.driver.findElement(By.className("v-card__title"));
    }

    public WebElement getDialogBoxCloseButton() {
        return  this.driver.findElement(By.className("btnClose"));
    }
}
