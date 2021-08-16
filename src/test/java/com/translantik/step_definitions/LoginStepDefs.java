package com.translantik.step_definitions;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page()  {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }


    @Then("the user should see the title contains {string}")
    public void the_title_contains(String expectedTitle) {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }

    @When("the user logged in as {string} with {string}")
    public void the_user_logged_in_as_with(String userType, String submitType) {

        String username = null;
        String password = null;

        if (userType.equals("driver")){
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        }else if(userType.equals("sales manager")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        }else if(userType.equals("store manager")) {
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }
        //send username and password and login
        new LoginPage().login(username,password,submitType);

    }


    @When("the user logged in as {string} and {string}")
    public void the_user_logged_in_as_and(String username, String password) {
        BrowserUtils.waitFor(10);
       new LoginPage().login(username, password);
    }

    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedTextMessage) {

        if((expectedTextMessage.equals("Please fill in this field.")) || (expectedTextMessage.equals("Please fill out this field.")) ){
            BrowserUtils.waitForPageToLoad(10);

            Assert.assertEquals(expectedTextMessage,  LoginPage.emptyMessage);
        }else {
            BrowserUtils.waitFor(10);
            Assert.assertEquals(expectedTextMessage, new LoginPage().invalidLoginMessage.getText());
        }


    }



    @When("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {

        if(userType.equals("driver")){
            new LoginPage().userName.sendKeys(ConfigurationReader.get("driver_username"));
            new LoginPage().password.sendKeys(ConfigurationReader.get("driver_password"));
        }
        if(userType.equals("sales manager")) {
            new LoginPage().userName.sendKeys(ConfigurationReader.get("sales_manager_username"));
            new LoginPage().password.sendKeys(ConfigurationReader.get("sales_manager_password"));
        }
        if(userType.equals("store manager")) {
            new LoginPage().userName.sendKeys(ConfigurationReader.get("store_manager_username"));
            new LoginPage().password.sendKeys(ConfigurationReader.get("store_manager_password"));
        }

        new LoginPage().submit.click();

    }



    @Then("the user should lands on the {string} page")
    public void the_user_should_lands_on_the_page(String expectedSubtitle) {


        System.out.println("expectedSubtitle = " + new DashboardPage().pageSubTitle.getText());
     Assert.assertEquals(expectedSubtitle, new DashboardPage().pageSubTitle.getText());

    }






}


