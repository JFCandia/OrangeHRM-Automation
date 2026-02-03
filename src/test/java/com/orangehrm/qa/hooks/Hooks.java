package com.orangehrm.qa.hooks;

import com.orangehrm.qa.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void setUp() {
        // Inicializa el driver antes de cada escenario
        driver = DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        // Cierra el driver después de cada escenario
        DriverFactory.quitDriver();
    }
}