package com.orangehrm.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriverWait wait;

    // ===== LOCATORS =====
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By loader = By.cssSelector(".oxd-form-loader");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // ===== UTILIDADES =====
    private void esperarLoader() {
        // Espera a que el loader desaparezca, si aparece
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        } catch (TimeoutException e) {
            // Si nunca aparece, seguimos adelante
        }
    }

    private WebElement esperarVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement esperarClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ===== ACCIONES =====
    public void enterUsername(String username) {
        esperarLoader();
        WebElement userInput = esperarVisible(usernameInput);
        userInput.clear();
        userInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        esperarLoader();
        WebElement passInput = esperarVisible(passwordInput);
        passInput.clear();
        passInput.sendKeys(password);
    }

    public void clickLogin() {
        esperarLoader();
        WebElement btn = esperarClickable(loginBtn);
        try {
            btn.click();
        } catch (ElementClickInterceptedException e) {
            // Si el loader intercepta, esperamos otra vez y reintentamos
            esperarLoader();
            btn = esperarClickable(loginBtn);
            btn.click();
        }
    }

    public boolean isDashboardVisible() {
        esperarLoader();
        return esperarVisible(dashboardHeader).isDisplayed();
    }
}