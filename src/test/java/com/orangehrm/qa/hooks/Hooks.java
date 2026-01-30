package com.orangehrm.qa.hooks;

import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.utils.DriverFactory;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
    }
}
