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


    @Then("the user should be able to login") // verification
    public void the_user_should_be_able_to_login()  {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard", actualTitle);

    }


    @Then("the user should see the title contains {string}")
    public void the_title_contains(String expectedTitle) {
        System.out.println("expectedTitle = " + expectedTitle); //expectedTitle = Dashboard ==> this side will be dynamic
        BrowserUtils.waitFor(2);
        System.out.println("actual Title="+ Driver.get().getTitle());
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
       new LoginPage().login(username, password);
    }

    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedTextMessage) {

        if(!new LoginPage().userName.getText().isEmpty() && !new LoginPage().password.getText().isEmpty()){
            Assert.assertEquals(expectedTextMessage, new LoginPage().invalidLoginMessage.getText());
        }else {
            Assert.assertEquals(expectedTextMessage, LoginPage.emptyMessage);
        }


    }


    @Then("{string} should lands on the {string} page after successful login")
    public void should_lands_on_the_page_after_successful_login(String userType, String expectedPage) {

        if(userType.equals("driver")){
            Assert.assertEquals(expectedPage,new DashboardPage().pageSubTitle.getText());
        }else if(userType.equals("sales manager")){
            Assert.assertEquals(expectedPage,new DashboardPage().pageSubTitle.getText());
        }else if(userType.equals("store manager")) {
            Assert.assertEquals(expectedPage, new DashboardPage().pageSubTitle.getText());
        }

    }



       
}


