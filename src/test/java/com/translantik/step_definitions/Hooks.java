package com.translantik.step_definitions;

import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {  //https://www.toolsqa.com/cucumber/execution-order-hooks/


    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
        Driver.get().get(ConfigurationReader.get("url"));
    }



    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()+ "_screenshot");
        }

        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpdb(){
        System.out.println("\tconnecting to database...");
    }

    @After("@db")
    public void tearDowndb(){
        System.out.println("\tdisconnecting to database...");
    }


    /*
    //Before methodlardan hangisini once acti ise onu en son kapatiyor

    @Before (order = 0)
    public void setUp(){
        System.out.println("\tthis is coming from BEFORE ");
    }

    @After(order = 1)
    public void tearDown(){
        System.out.println("\tthis is coming from AFTER");
    }

    @Before(value = "@db", order = 1)
    public void setUpdb(){
        System.out.println("\tconnecting to database...");
    }

    @After(value = "@db", order = 0)
    public void tearDowndb(){
        System.out.println("\tdisconnecting to database...");
    }

     */


}
