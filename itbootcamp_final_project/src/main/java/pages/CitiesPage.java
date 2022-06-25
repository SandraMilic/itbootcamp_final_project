package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CitiesPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getSearchInputField() {
        return this.driver.findElement(By.id("search"));
    }

    public WebElement getNewItemButton() {
        return this.driver.findElement(By.className("btnNewItem"));
    }

    public void waitForNewEditItemDialogToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
    }

    public WebElement getInputCityField() {
        return this.driver.findElement(By.id("name"));
    }

    public WebElement getSaveButtonFromDialog() {
        return this.driver.findElement(By.className("btnSave"));
    }

    public void waitForDeleteDialogToBeVisible() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("warning")));
    }

    public WebElement getDeleteButtonFromDialog() {
        return this.driver.findElement(By.xpath("//div[contains(@class, 'rounded-0')]//button[2]"));
    }

    public void waitForNumberOfRowsToBe(int rowNumber) {
        this.wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rowNumber + 1));
    }

    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return this.driver.findElement(By.xpath("//tbody/tr["+ rowIndex +"]/td["+ columnIndex +"]"));
    }

    public WebElement getDeleteButtonByRowIndex(int rowIndex) {
        return this.driver.findElements(By.id("delete")).get(rowIndex -1);
    }

    public WebElement getEditButtonByRowIndex(int rowIndex) {
        return this.driver.findElements(By.id("edit")).get(rowIndex -1);
    }
}
