package com.example.capstone_project_orangehrm.Testcases;

import com.example.capstone_project_orangehrm.POM.LoginPage;
import com.example.capstone_project_orangehrm.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_AdminTest extends BaseClass {
    private LoginPage loginPage;
    private static final String EXCEL_FILE_PATH = "C:\\Users\\imam.hussain\\IdeaProjects\\Capstone_Project_OrangeHRM\\ExcelData.xlsx";

    @BeforeMethod
    public void setUpTest() {
        setUp(EXCEL_FILE_PATH);
        loginPage = new LoginPage(driver);
    }

    // Test for blank username and password
    @Test(priority = 1)
    public void testLoginWithBlankUsernameAndPassword() {
        String baseUrl = getTestData("baseUrl");
        driver.get(baseUrl);

        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Required"), "Error message for blank credentials is correct.");
    }

    // Test for username "Admin" and blank password
    @Test(priority = 2)
    public void testLoginWithUsernameAdminAndBlankPassword() {
        String baseUrl = getTestData("baseUrl");
        driver.get(baseUrl);

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Required"), "Error message for blank password is correct.");
    }

    // Test for invalid login
    @Test(priority = 3)
    public void testInvalidLogin() {
        String baseUrl = getTestData("baseUrl");
        driver.get(baseUrl);

        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessageinvalidlogin();
        String expectedErrorMessage = "Invalid credentials";  // Update with the actual message you expect
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Expected error message to contain: '" + expectedErrorMessage + "', but found: '" + actualErrorMessage + "'");
    }

    // Test for forgot password functionality
    @Test(priority = 4)
    public void testForgotPassword() {
        String baseUrl = getTestData("baseUrl");
        driver.get(baseUrl);

        loginPage.clickForgotPassword();
        String usernameForReset = getTestData("ForgotPasswordUsername");
        loginPage.enterUsernameAfterForgot(usernameForReset);
        loginPage.clickResetButton();

        String expectedMessage = getTestData("ResetPasswordVerifyText");
        String actualMessage = loginPage.getResetPasswordVerifyText();
        Assert.assertEquals(expectedMessage, actualMessage, "Reset password verification failed.");
    }

    // Test for valid login
    @Test(priority = 5)
    public void testValidLogin() {
        String baseUrl = getTestData("baseUrl");
        String username = getTestData("Username");
        String password = getTestData("Password");
        driver.get(baseUrl);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed for valid credentials.");
    }

    // Cleanup after tests
    @Override
    public void tearDown() {
        driver.quit();
    }
}

//package com.example.capstone_project_orangehrm.Testcases;
//
//import com.example.capstone_project_orangehrm.POM.LoginPage;
//import com.example.capstone_project_orangehrm.base.BaseClass;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//
//
//
//public class Login_AdminTest extends BaseClass {
//    private LoginPage loginPage;
//    private static final String EXCEL_FILE_PATH = "C:\\Users\\imam.hussain\\IdeaProjects\\Capstone_Project_OrangeHRM\\ExcelData.xlsx";
//
//    @BeforeEach
//    public void setUpTest() {
//        setUp(EXCEL_FILE_PATH);
//        loginPage = new LoginPage(driver);
//    }
//    @Test
//    public void testValidLogin() {
//        String baseUrl = getTestData("baseUrl");
//        String username = getTestData("Username");
//        String password = getTestData("Password");
//        driver.get(baseUrl);
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//        loginPage.clickLogin();
//        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed for valid credentials.");
//    }
//    //working
//    @Test
//    public void testInvalidLogin() {
//        String baseUrl = getTestData("baseUrl");
//        driver.get(baseUrl);
//        loginPage.enterUsername("invalidUser");
//        loginPage.enterPassword("invalidPassword");
//        loginPage.clickLogin();
//        String actualErrorMessage = loginPage.getErrorMessageinvalidlogin();
//        String expectedErrorMessage = "Invalid credentials";  // Update with the actual message you expect
//        Assertions.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
//                "Expected error message to contain: '" + expectedErrorMessage + "', but found: '" + actualErrorMessage + "'");
//    }
//    @Test
//    public void testForgotPassword() {
//        String baseUrl = getTestData("baseUrl");
//        driver.get(baseUrl);
//
//        loginPage.clickForgotPassword();
//        String usernameForReset = getTestData("ForgotPasswordUsername");
//        loginPage.enterUsernameAfterForgot(usernameForReset);
//        loginPage.clickResetButton();
//
//        String expectedMessage = getTestData("ResetPasswordVerifyText");
//        String actualMessage = loginPage.getResetPasswordVerifyText();
//        Assertions.assertEquals(expectedMessage, actualMessage, "Reset password verification failed.");
//    }
//    @Test
//    @Order(1)
//    public void testLoginWithBlankUsernameAndPassword() {
//        String baseUrl = getTestData("baseUrl");
//        driver.get(baseUrl);
//
//        loginPage.enterUsername("");
//        loginPage.enterPassword("");
//        loginPage.clickLogin();
//
//        String errorMessage = loginPage.getErrorMessage();
//        Assertions.assertTrue(errorMessage.contains("Required"), "Error message for blank credentials is correct.");
//    }
//
//    @Test
//
//    public void testLoginWithUsernameAdminAndBlankPassword() {
//        String baseUrl = getTestData("baseUrl");
//        driver.get(baseUrl);
//
//        loginPage.enterUsername("Admin");
//        loginPage.enterPassword("");
//        loginPage.clickLogin();
//        // Verify that an error message is displayed for blank password
//        String errorMessage = loginPage.getErrorMessage();
//        Assertions.assertTrue(errorMessage.contains("Required"), "Error message for blank password is correct.");
//    }
//
//    @Override
//    public void tearDown() {
////        super.tearDown();
//        driver.quit();
//    }
//}
