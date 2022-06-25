package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

    String email = "admin@admin.com";
    String password = "12345";
    String cityName = "marko";
    String newCityName = cityName + " Edited";

    @Test(priority = 10)
    public void visitsTheAdminCitiesPageAndListCities() {
        this.navPage.getLoginButton().click();
        this.loginPage.getEmailInputField().sendKeys(email);
        this.loginPage.getPasswordInputField().sendKeys(password);
        this.loginPage.getLoginButton().click();
        this.navPage.getAdminButton().click();
        this.navPage.getCitiesLinkFromAdminDropDown().click();
        Assert.assertTrue(
                this.driver.getCurrentUrl().contains("/admin/cities"),
                "[ERROR] The Url does not contain '/admin/cities'.");
    }

    @Test(priority = 20)
    public void checksInputTypesForCreateEditNewCity() {
        this.navPage.getAdminButton().click();
        this.navPage.getCitiesLinkFromAdminDropDown().click();
        this.citiesPage.getNewItemButton().click();
        this.citiesPage.waitForNewEditItemDialogToBeVisible();
        Assert.assertEquals(
                this.citiesPage.getInputCityField().getAttribute("type"),
                "text",
                "[ERROR] City input field for attribute 'type' has no value 'text'.");
    }

    @Test(priority = 30)
    public void createNewCity() {
        this.navPage.getAdminButton().click();
        this.navPage.getCitiesLinkFromAdminDropDown().click();
        this.citiesPage.getNewItemButton().click();
        this.citiesPage.waitForNewEditItemDialogToBeVisible();
        this.citiesPage.getInputCityField().sendKeys(cityName);
        this.citiesPage.getSaveButtonFromDialog().click();
        this.messagePopUpPage.waitForPopUpOnCityPageToBeVisible();
        Assert.assertTrue(
                this.messagePopUpPage.getMessagesFromPopUpOnCityPage().getText().contains("Saved successfully"),
                "[ERROR] The message does not contain text 'Saved successfully'.");
    }

    @Test(priority = 40)
    public void editCity() {
        this.navPage.getAdminButton().click();
        this.navPage.getCitiesLinkFromAdminDropDown().click();
        this.citiesPage.getSearchInputField().sendKeys(cityName);
        this.citiesPage.waitForNumberOfRowsToBe(1);
        this.citiesPage.getEditButtonByRowIndex(1).click();
        this.citiesPage.getInputCityField().sendKeys(Keys.CONTROL + "a");
        this.citiesPage.getInputCityField().sendKeys(newCityName);
        this.citiesPage.getSaveButtonFromDialog().click();
        this.messagePopUpPage.waitForPopUpOnCityPageToBeVisible();
        Assert.assertTrue(
                this.messagePopUpPage.getMessagesFromPopUpOnCityPage().getText().contains("Saved successfully"),
                "[ERROR] The message does not contain text 'Saved successfully'.");
    }

    @Test(priority = 50)
    public void searchCity() {
        this.navPage.getAdminButton().click();
        this.navPage.getCitiesLinkFromAdminDropDown().click();
        this.citiesPage.getSearchInputField().sendKeys(newCityName);
        this.citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertEquals(
                this.citiesPage.getTableCell(1,2).getText(),
                newCityName,
                "[ERROR] The city name in table cell is not the same as the name of the searched city.");
    }

    @Test(priority = 60)
    public void deleteCity() {
        this.navPage.getAdminButton().click();
        this.navPage.getCitiesLinkFromAdminDropDown().click();
        this.citiesPage.getSearchInputField().sendKeys(newCityName);
        this.citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertEquals(
                this.citiesPage.getTableCell(1,2).getText(),
                newCityName,
                "[ERROR] The city name in table cell is not the same as the name of the searched city.");
        this.citiesPage.getDeleteButtonByRowIndex(1).click();
        this.citiesPage.waitForDeleteDialogToBeVisible();
        this.citiesPage.getDeleteButtonFromDialog().click();
        this.messagePopUpPage.waitForPopUpOnCityPageToBeVisible();
        Assert.assertTrue(
                this.messagePopUpPage.getMessagesFromPopUpOnCityPage().getText().contains("successfully"),
                "[ERROR] The message does not contain text 'Deleted successfully'.");
    }
}
