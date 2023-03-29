package com.sample.testcase;

import io.qameta.allure.*;
import com.sample.config.ThreadLocalDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.testng.Assert.assertEquals;

@Epic("User Management")
@Feature("Login")
public class loginTestcase {
    @Severity(BLOCKER)
    @Description("Verify that a valid user can login to the application")
    @Story("As a user I should be able to login to the application")
    @Test
    public void loginUser() {
        setUserName("standard_user");
        setPassword("secret_sauce");
        login();
        assertEquals(ThreadLocalDriver.getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    public boolean setUserName(String username) {
        String xpath_userName = "//input[@placeholder='Username']";

        try {
            WebElement elem = ThreadLocalDriver.getDriver().findElement(By.xpath(xpath_userName));
            elem.click();
            elem.sendKeys(username);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean setPassword(String password) {
        String xpath_pwd = "//input[@placeholder='Password']";
        try {
            WebElement elem = ThreadLocalDriver.getDriver().findElement(By.xpath(xpath_pwd));
            elem.click();
            elem.sendKeys(password);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean login(){
        String btn_login="//input[@id='login-button']";
        try {
            WebElement elem = ThreadLocalDriver.getDriver().findElement(By.xpath(btn_login));
            elem.click();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
