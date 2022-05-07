
/*
 * @AccountPageStepDef.java@
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
package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.app.pages.accounts.AccountsPage;
import com.app.pages.login.LoginPage;
import com.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageStepDef {

    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credentialList) {
        List<Map<String, String>> credList = credentialList.asMaps();

        String usrName = credList.get(0).get("username");
        String paswrd = credList.get(0).get("password");

        DriverFactory.getDriver()
                .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountsPage = loginPage.doSignIn(usrName, paswrd);
    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String title = accountsPage.getAccountsPageTitle();
        System.out.println("Accounts page titile is : " + title);
    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionTable) {
        List<String> exAccountSectionsList = sectionTable.asList();
        System.out.println("Expected Accounts Section list : " + exAccountSectionsList);
        List<String> actualAccountList = accountsPage.getAccountsSectionsList();
        System.out.println("Actual Accounts Section list : " + actualAccountList);

        Assert.assertTrue(actualAccountList.equals(exAccountSectionsList));
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedSectionCount) {
        Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
    }

}
