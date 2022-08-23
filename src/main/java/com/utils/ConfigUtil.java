package com.utils;

import org.aeonbits.owner.Config;

@Config.Sources("file:./src/main/resources/Config.properties")
public interface ConfigUtil extends Config {

    @Key("baseURL")
    String getBaseURL();

    @Key("Username")
    String getUsername();

    @Key("Password")
    String getPassword();

    @Key("BrowserWindowSize")
    String getBrowserWindowSize();

    @Key("browser")
    String getBrowser();

    @Key("EnvironmentName")
    String getEnvironmentName();

    @Key("ImplicitlyWait")
    String getImplicitlyWait();

    @Key("selenium.grid.url")
    String getSeleniumGridUrl();

}
