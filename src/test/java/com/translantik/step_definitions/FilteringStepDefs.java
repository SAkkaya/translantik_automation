package com.translantik.step_definitions;

import com.translantik.pages.DashboardPage;
import com.translantik.pages.FleetVehiclePage;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilteringStepDefs {

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        switch (userType) {
            case "driver":
                BrowserUtils.waitFor(2);
                new LoginPage().login(ConfigurationReader.get("driver_username"), ConfigurationReader.get("driver_password"));
                break;
            case "sales manager":
                BrowserUtils.waitFor(2);
                new LoginPage().login(ConfigurationReader.get("sales_manager_username"), ConfigurationReader.get("sales_manager_password"));
                break;
            case "store manager":
                BrowserUtils.waitFor(2);
                new LoginPage().login(ConfigurationReader.get("store_manager_username"), ConfigurationReader.get("store_manager_password"));
                break;

            default:
                System.out.println("invalid user");
        }

    }

    @When("the user navigate to {string}{string}")
    public void the_user_navigate_to(String tab, String module) {
        new DashboardPage().navigateToModule(tab, module);
    }

    @Then("Manage filter should be hidden as default")
    public void manage_filter_should_be_hidden_as_default() {
        new FleetVehiclePage().waitUntilLoaderScreenDisappear();

        BrowserUtils.verifyElementNotDisplayed(new FleetVehiclePage().manageFilters);
//        Assert.assertFalse(new FleetVehiclePage().manageFilters.isDisplayed());

    }


    @When("the user clicks on the filter button")
    public void the_user_clicks_on_the_filter_button() {
        new FleetVehiclePage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(new FleetVehiclePage().filterButton, 20);
        new FleetVehiclePage().filterButton.click();
    }

    @Then("Manage filter options should be displayed")
    public void manage_filter_options_should_be_displayed() {
        Assert.assertTrue(new FleetVehiclePage().manageFilters.isDisplayed());
//        BrowserUtils.verifyElementDisplayed(new FleetVehiclePage().manageFilters);
    }



    @Then("the user click on manageFilterButton")
    public void the_user_click_on_manageFilterButton() {

        new FleetVehiclePage().manageFilters.click();
    }

    @Then("User can apply filtering for each of the {string}  on the page")
    public void user_can_apply_filtering_for_each_of_the_on_the_page(String dataColumns) {

        if (dataColumns.equals("Driver")){
            new FleetVehiclePage().methodFilter(dataColumns);

            BrowserUtils.waitFor(2);
            String expectedDriverName =new FleetVehiclePage().driverColumnName.getText();
            new FleetVehiclePage().containsSearchBox.sendKeys(expectedDriverName+ Keys.ENTER);

            System.out.println("expectedDriverName = " + expectedDriverName);
            String actualDriverName = new FleetVehiclePage().getActualCellName(dataColumns).getText();
            System.out.println("actualDriverName = " + actualDriverName);
            Assert.assertTrue(expectedDriverName.contains(actualDriverName));
        }else if(dataColumns.equals("Tags")){
            new FleetVehiclePage().methodFilter(dataColumns);
            BrowserUtils.waitFor(2);
            String expectedTagName =new FleetVehiclePage().tagName.getText();
            new FleetVehiclePage().isAnyOfSearchBox.sendKeys(expectedTagName+ Keys.ENTER);

            System.out.println("expectedTagName = " + expectedTagName);
            String actualTagName = new FleetVehiclePage().getActualCellName(dataColumns).getText();
            System.out.println("actualTagName = " + actualTagName);
            Assert.assertTrue(expectedTagName.contains(actualTagName));
        }


    }


    @When("the user click on multiple options")
    public void the_user_click_on_multiple_options() {

        List<WebElement> manageFilterSearchBox = new FleetVehiclePage().manageFilterCheckBoxes;
        for (int i = 0; i < 2; i++) {
             manageFilterSearchBox.get(i).click();
             new DashboardPage().waitUntilLoaderScreenDisappear();
        }
    }

    @When("the user sends values for the Licence Plate and Tags")
    public void the_user_sends_values_for_the_Licence_Plate_and_Tags() {

        new FleetVehiclePage().filteredItems.get(0).click();
        new FleetVehiclePage().containsSearchBox.sendKeys("55"+Keys.ENTER);

        new DashboardPage().waitUntilLoaderScreenDisappear();

        new FleetVehiclePage().filteredItems.get(1).click();
        new FleetVehiclePage().isAnyOfSearchBox.sendKeys("Purchased"+Keys.ENTER);

    }

    @Then("the application should be able to support multiple filtering of columns")
    public void the_application_should_be_able_to_support_multiple_filtering_of_columns() {

        String text = new FleetVehiclePage().firstRowAfterFiltering.getText();

        System.out.println("text = " + text);

        Assert.assertTrue(text.contains("55") && text.contains("Purchased"));
    }



}
