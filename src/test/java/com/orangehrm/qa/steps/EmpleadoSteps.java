package com.orangehrm.qa.steps;

import com.orangehrm.qa.pages.EmpleadoPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class EmpleadoSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private EmpleadoPage empleadoPage;

    private String employeeIdReal;

    @Given("el administrador está logueado en OrangeHRM")
    public void adminLogueado() {
        driver = DriverFactory.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        Assert.assertTrue(
                "No se visualiza el Dashboard",
                loginPage.isDashboardVisible()
        );

        empleadoPage = new EmpleadoPage(driver);
    }

    @When("crea un empleado con nombre {string}")
    public void crearEmpleado(String nombre) {
        employeeIdReal = empleadoPage.crearEmpleado(nombre);
    }

    @Then("el empleado aparece en la lista de empleados")
    public void validarEmpleado() {
        Assert.assertTrue(
                "El empleado no aparece en la lista",
                empleadoPage.validarEmpleadoPorId(employeeIdReal)
        );
        DriverFactory.quitDriver();
    }
}