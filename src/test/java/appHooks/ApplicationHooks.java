
/*
 * @ApplicationHooks.java@
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
package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.app.util.ConfigReader;
import com.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

    private ConfigReader configReader;
    Properties prop;
    private DriverFactory driverFactory;
    private WebDriver driver;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void lunchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    // order 1 will execute first in after case
    @After(order = 0)
    public void teardown() {
        driver.quit();
    }

    @After(order = 1)
    public void screenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot
            String screenshotName = scenario.getName().replace(" ", "_");
            byte[] scurcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(scurcePath, "image/png", screenshotName);
        }

    }

}
