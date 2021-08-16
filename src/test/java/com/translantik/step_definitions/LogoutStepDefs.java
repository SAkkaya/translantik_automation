package com.translantik.step_definitions;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutStepDefs {


    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {
        BrowserUtils.waitFor(2);
        new DashboardPage().navigateToModule(tab, module);
    }

    @When("the user click on user icon")
    public void the_user_click_on_user_icon() {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(10);
        BrowserUtils.waitForClickablility(new DashboardPage().userName, 20);
        new DashboardPage().userName.click();
    }

    @Then("the user should see the Logout Button")
    public void the_user_should_see_the_Logout_Button() {
        Assert.assertTrue(new DashboardPage().logOutLink.isDisplayed());
        Assert.assertTrue(new DashboardPage().logOutLink.isEnabled());
    }


    @When("the user click on Logout button")
    public void the_user_click_on_Logout_button() {
      new LoginPage().logout();
    }

    @Then("the user should be able to see the Login Page")
    public void the_user_should_be_able_to_see_the_Login_Page() {
        String expectedLoginName= "Login";
        Assert.assertEquals(expectedLoginName, new LoginPage().loginName.getText());

        String expectedLoginUrl= "https://qa.translantik.com/user/login";
        Assert.assertEquals(expectedLoginUrl, Driver.get().getCurrentUrl());
    }


    @When("the user click on goBack arrow")
    public void the_user_click_on_goBack_arrow() {
        Driver.get().navigate().back();
    }


}
