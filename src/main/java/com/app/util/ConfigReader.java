
/*
 * @ConfigReader.java@
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
package com.app.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    /**
     * This method is used to load property from config.properties file
     *
     * @author imspaliwal
     * @return it return Properties prop object
     */
    public Properties init_prop() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
