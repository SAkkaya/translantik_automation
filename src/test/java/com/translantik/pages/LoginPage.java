package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-error']/div")
    public WebElement invalidLoginMessage;

    public static String emptyMessage;

    @FindBy(xpath = "//h2[@class='title']")
    public WebElement loginName;

    public void login(String userNameStr, String passwordStr) {
            userName.sendKeys(userNameStr);
            password.sendKeys(passwordStr);
            submit.click();

            if(userNameStr.equals("")){
                BrowserUtils.waitForVisibility(userName, 10);
                userName.sendKeys(userNameStr);
                submit.click();
                emptyMessage = Driver.get().findElement(By.name("_username")).getAttribute("validationMessage");
            }

            if(passwordStr.equals("")){
                BrowserUtils.waitForVisibility(password, 10);
                password.sendKeys(passwordStr);
                submit.click();
            emptyMessage = Driver.get().findElement(By.name("_password")).getAttribute("validationMessage");

        }



    }

    public void login(String userNameStr, String passwordStr, String submitType) {

        if(submitType.equals("submitButton")){
            userName.sendKeys(userNameStr);
            password.sendKeys(passwordStr);
            submit.click();
        }else{
            userName.sendKeys(userNameStr);
            password.sendKeys(passwordStr+Keys.ENTER);

        }

    }


}
