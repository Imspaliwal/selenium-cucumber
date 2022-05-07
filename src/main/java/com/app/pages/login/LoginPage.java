
/*
 * @LoginPage.java@
 * Created on 07-May-2022
 *
 * Copyright (c) 2022 Imspaliwal.
 * All Rights Reserved.
 *
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Imspaliwal
 * The copyright notice above does not evidence any
 * actual or intended publication of such source code.
 *
 */
package com.app.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.app.pages.accounts.AccountsPage;

public class LoginPage {

    // Single Responsibility Concepts
    // Only use to create By locators, constructor and public methods

    private final WebDriver driver;

    // 1. By locators:
    private final By email = By.id("email");
    private final By password = By.id("passwd");

    // ?? to intension failed test
    private final By forgotPassLink = By.linkText("Forgot your password???");
    private final By signInBtn = By.id("SubmitLogin");

    // 2. Constructor of the page class
    // (You give me webdriver and same webdriver I will use for this page class)
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. public methods: page actions
    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPassExist() {
        return driver.findElement(forgotPassLink).isDisplayed();
    }

    public void enterUserName(String userName) {
        driver.findElement(email).sendKeys(userName);
    }

    public void enterPassword(String paswrd) {
        driver.findElement(password).sendKeys(paswrd);
    }

    public void clickSignInBtn() {
        driver.findElement(signInBtn).click();
    }

    public AccountsPage doSignIn(String un, String pwd) {
        System.out.println("Sign in user with username : " + un + " ,and password : " + pwd);
        driver.findElement(email).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInBtn).click();
        return new AccountsPage(driver);
    }

}
