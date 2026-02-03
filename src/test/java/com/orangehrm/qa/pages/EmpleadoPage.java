package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmpleadoPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public EmpleadoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // ===== LOCATORS =====
    private By menuPIM = By.xpath("//span[text()='PIM']");
    private By addEmployeeBtn = By.xpath("//a[text()='Add Employee']");
    private By employeeListMenu = By.xpath("//a[text()='Employee List']");

    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");
    private By employeeIdInput =
            By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");

    private By saveBtn = By.xpath("//button[@type='submit']");

    // Search
    private By searchEmployeeIdInput =
            By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");
    private By searchBtn = By.xpath("//button[@type='submit']");

    // ===== ACTIONS =====

    public String crearEmpleado(String nombreCompleto) {
        String[] nombre = nombreCompleto.split(" ");
        String firstName = nombre[0];
        String lastName = nombre.length > 1 ? nombre[1] : "Test";

        wait.until(ExpectedConditions.elementToBeClickable(menuPIM)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addEmployeeBtn)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);

        String employeeIdReal = driver.findElement(employeeIdInput).getAttribute("value");

        driver.findElement(saveBtn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h6[text()='Personal Details']")
        ));

        return employeeIdReal;
    }

    public boolean validarEmpleadoPorId(String employeeId) {
        wait.until(ExpectedConditions.elementToBeClickable(menuPIM)).click();
        wait.until(ExpectedConditions.elementToBeClickable(employeeListMenu)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchEmployeeIdInput)).sendKeys(employeeId);
        driver.findElement(searchBtn).click();

        By resultado = By.xpath("//div[@class='oxd-table-body']//div[text()='" + employeeId + "']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultado)).isDisplayed();
    }
}