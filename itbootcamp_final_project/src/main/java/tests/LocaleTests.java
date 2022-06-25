package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

    @Test(priority = 10)
    public void setLocaleToES() {
        this.navPage.getLanguageSelectionButton().click();
        this.navPage.getESlanguageButton().click();
        Assert.assertEquals(
                this.navPage.getTextFromHeaderOnHomePage().getText(),
                "Página de aterrizaje",
                "[ERROR]The header text does not contain 'Página de aterrizaje'.");
    }

    @Test(priority = 20)
    public void setLocaleToEN() {
        this.navPage.getLanguageSelectionButton().click();
        this.navPage.getENlanguageButton().click();
        Assert.assertEquals(
                this.navPage.getTextFromHeaderOnHomePage().getText(),
                "Landing",
                "[ERROR]The header text does not contain 'Landing'.");
    }

    @Test(priority = 30)
    public void setLocaleToCN() {
        this.navPage.getLanguageSelectionButton().click();
        this.navPage.getCNlanguageButton().click();
        Assert.assertEquals(
                this.navPage.getTextFromHeaderOnHomePage().getText(),
                "首页",
                "[ERROR]The header text does not contain '首页'.");
    }

    @Test(priority = 40)
    public void setLocaleToFR() {
        this.navPage.getLanguageSelectionButton().click();
        this.navPage.getFRlanguageButton().click();
        Assert.assertEquals(
                this.navPage.getTextFromHeaderOnHomePage().getText(),
                "Page d'atterrissage",
                "[ERROR]The header text does not contain 'Page d'atterrissage'.");
    }
}
