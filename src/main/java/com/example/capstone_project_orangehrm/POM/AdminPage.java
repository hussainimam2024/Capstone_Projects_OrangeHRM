package com.example.capstone_project_orangehrm.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
    private WebDriver driver;

    // Locators for Admin module
    private By adminTab = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    private By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By confirmPasswordField = By.xpath("//input[@name='confirmPassword']");
    private By emailField = By.xpath("//input[@name='email']");
    private By saveButton = By.xpath("//button[@type='submit']");

    // Constructor to initialize the driver
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to the Admin module
    public void navigateToAdminModule() {
        driver.findElement(adminTab).click();
    }

    // Method to click the Add button to add a new user
    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    // Method to fill in the details for adding a new user
    public void addUser(String username, String password, String email) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(emailField).sendKeys(email);
    }

    // Method to save the new user
    public void saveUser() {
        driver.findElement(saveButton).click();
    }
}
