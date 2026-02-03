package com.orangehrm.qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    /**
     * Obtiene una instancia única de WebDriver.
     * Por defecto abre Chrome con UI (visible).
     */
    public static WebDriver getDriver() {
        return getDriver(false); // visible por defecto
    }

    /**
     * Obtiene una instancia única de WebDriver.
     * @param headless true para ejecución sin UI (CI/CD),
     *                 false para ejecución local con ventana visible.
     */
    public static WebDriver getDriver(boolean headless) {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            if (headless) {
                // Configuración obligatoria para Jenkins/Docker
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            } else {
                // Configuración para ejecución local con UI
                options.addArguments("--start-maximized");
            }

            driver = new ChromeDriver(options);

            // Usar esperas explícitas en los tests, no implícitas
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        }
        return driver;
    }

    /**
     * Cierra y limpia la instancia de WebDriver.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}