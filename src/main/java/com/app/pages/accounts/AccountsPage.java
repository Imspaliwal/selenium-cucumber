
/*
 * @AccountsPage.java@
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
package com.app.pages.accounts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

    private final WebDriver driver;

    // 1. private By locators
    private final By accountSections = By.cssSelector("div#center_column span");

    // 2. Constructor to initialize driver
    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. public methods
    public String getAccountsPageTitle() {
        return driver.getTitle();
    }

    public int getAccountsSectionCount() {
        return driver.findElements(accountSections).size();
    }

    public List<String> getAccountsSectionsList() {

        List<String> accountsList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements(accountSections);

        for (WebElement e : accountsHeaderList) {
            String text = e.getText();
            System.out.println(text);
            accountsList.add(text);
        }

        return accountsList;

    }

}
