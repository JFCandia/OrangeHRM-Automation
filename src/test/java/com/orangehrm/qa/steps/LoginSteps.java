package com.orangehrm.qa.steps;

import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.utils.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("el usuario está en la página de login")
    public void usuarioEnLogin() {
        driver = DriverFactory.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
    }

    @When("ingresa el usuario {string} y la contraseña {string}")
    public void ingresarCredenciales(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
        loginPage.clickLogin();
    }

    @Then("accede al dashboard correctamente")
    public void validarDashboard() {
        Assert.assertTrue("El dashboard no está visible después del login", loginPage.isDashboardVisible());
    }
}