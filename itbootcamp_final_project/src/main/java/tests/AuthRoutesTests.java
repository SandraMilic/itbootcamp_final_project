package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        this.driver.get(this.baseUrl + "/home");
        Assert.assertTrue(
                this.driver.getCurrentUrl().contains("/login"),
                "[ERROR]The Url does not contain 'login'.");
    }

    @Test(priority = 20)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        this.driver.get(this.baseUrl + "/profile");
        Assert.assertTrue(
                this.driver.getCurrentUrl().contains("/login"),
                "[ERROR]The Url does not contain 'login'.");
    }

    @Test(priority = 30)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        this.driver.get(this.baseUrl + "/admin/cities");
        Assert.assertTrue(
                this.driver.getCurrentUrl().contains("/login"),
                "[ERROR]The Url does not contain 'login'.");
    }

    @Test(priority = 40)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        this.driver.get(this.baseUrl + "/admin/users");
        Assert.assertTrue(
                this.driver.getCurrentUrl().contains("/login"),
                "[ERROR]The Url does not contain 'login'.");
    }
}
