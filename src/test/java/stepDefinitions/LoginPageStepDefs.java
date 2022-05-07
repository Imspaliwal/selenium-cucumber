
/*
 * @LoginStepDefs.java@
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

import org.junit.Assert;

import com.app.pages.login.LoginPage;
import com.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefs {

    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    private String title;

    // Do only assertion in Step Def as per best practices

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver()
                .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @When("user get the title of the page")
    public void user_get_the_title_of_the_page() {
        title = loginPage.getPageTitle();
        System.out.println("Login page title is : " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        Assert.assertTrue(title.contains(expectedTitle));
    }

    @Then("forgot password link should be displayed")
    public void forgot_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPassExist());
    }

    @When("user enters username {string}")
    public void user_enters_username(String usr) {
        System.out.println("Entering Username : " + usr);
        loginPage.enterUserName(usr);
    }

    @When("user enters password {string}")
    public void user_enters_password(String pwd) {
        System.out.println("Entering Password : " + pwd);
        loginPage.enterPassword(pwd);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickSignInBtn();
    }

}
