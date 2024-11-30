
package com.example.capstone_project_orangehrm.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
    private By passwordField = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
    private By loginButton = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    private By forgotPasswordLink = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");

    // After Forgot Password
    private By usernameAfterForgotField = By.xpath("/html/body/div/div[1]/div[1]/div/form/div[1]/div/div[2]/input");
    private By resetButton = By.xpath("/html/body/div/div[1]/div[1]/div/form/div[2]/button[2]");
    private By resetPasswordVerifyText = By.xpath("/html/body/div/div[1]/div[1]/div/h6");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    // Utility method to wait for an element to be visible
    private WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Utility method to wait for an element to be clickable
    private WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Methods to interact with the login page
    public void enterUsername(String username) {
        WebElement usernameElement = waitForElementToBeVisible(usernameField);
        usernameElement.clear();  // Clear any pre-existing text
        usernameElement.sendKeys(username);
        waitFor(2000);  // Wait for 2 seconds
    }

    public void enterPassword(String password) {
        WebElement passwordElement = waitForElementToBeVisible(passwordField);
        passwordElement.clear();  // Clear any pre-existing text
        passwordElement.sendKeys(password);
        waitFor(2000);  // Wait for 2 seconds
    }
    public void clickLogin() {
        WebElement loginButtonElement = waitForElementToBeClickable(loginButton);
        loginButtonElement.click();
        waitFor(2000);  // Wait for 2 seconds
    }
    public void clickForgotPassword() {
        WebElement forgotPasswordElement = waitForElementToBeClickable(forgotPasswordLink);
        forgotPasswordElement.click();
        waitFor(2000);  // Wait for 2 seconds
    }
    public void enterUsernameAfterForgot(String username) {
        WebElement usernameAfterForgotElement = waitForElementToBeVisible(usernameAfterForgotField);
        usernameAfterForgotElement.clear();
        usernameAfterForgotElement.sendKeys(username);
        waitFor(2000);  // Wait for 2 seconds
    }

    public void clickResetButton() {
        WebElement resetButtonElement = waitForElementToBeClickable(resetButton);
        resetButtonElement.click();
        waitFor(2000);  // Wait for 2 seconds
    }

    public String getResetPasswordVerifyText() {
        WebElement verifyTextElement = waitForElementToBeVisible(resetPasswordVerifyText);
        waitFor(2000);
        return verifyTextElement.getText();
    }
    private By password_errorMessage = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span");  // Replace with correct XPath if necessary
    public String getErrorMessage() {
        WebElement errorElement = waitForElementToBeVisible(password_errorMessage);
        return errorElement.getText();
    }
    private By invaliderrorMessage = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div[1]/div[1]/p");  // Your provided XPath
    public String getErrorMessageinvalidlogin() {
        WebElement errorElement = waitForElementToBeVisible(invaliderrorMessage);
        return errorElement.getText();  // Get the text content of the error message
    }
    private void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  // Log the interruption if it occurs
        }
    }
}
