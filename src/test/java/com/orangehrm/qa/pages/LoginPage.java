package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By loader = By.cssSelector(".oxd-form-loader");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void enterUsername(String username) {
        // Espera a que desaparezca el loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        userInput.clear();
        userInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passInput.clear();
        passInput.sendKeys(password);
    }

    public void clickLogin() {
        // Espera a que desaparezca el loader antes de hacer click
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        btn.click();
    }

    public boolean isDashboardVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }
}