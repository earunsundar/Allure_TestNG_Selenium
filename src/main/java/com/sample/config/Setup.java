/**
 * Classification:
 * Description: Setup Step Definitions
 *
 * @author: Arun Sundar
 * @since: 2023-03-29
 * @version: 0.1
 */
package com.sample.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Setup {
    public Setup() {

    }

    @BeforeSuite
    public void initialization() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        ThreadLocalDriver.setDriver(driver);
        driverSetUp();
        System.out.println("Inside the initialization method");

    }

    public static void driverSetUp() {
        WebDriver driver = ThreadLocalDriver.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @BeforeTest
    public void gotoURL() throws InterruptedException {
        WebDriver driver = ThreadLocalDriver.getDriver();
        String url = "https://www.saucedemo.com/";
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() {
        ThreadLocalDriver.getDriver().close();
    }

    @AfterSuite
    public static void generateConsolidatedReport() {
    }

}



