package com.utils;

import org.aeonbits.owner.Config;

/**
 * @author Abhishek Kadavil
 */
@Config.Sources("file:./src/main/resources/Config.properties")
public interface ConfigUtil extends Config {

    @Key("BaseURL")
    String getBaseURL();

    @Key("Browser")
    String getBrowser();

    @Key("ChromeVersion")
    String getChromeVersion();

    @Key("EnvironmentName")
    String getEnvironmentName();

    @Key("ImplicitWait")
    long getImplicitWait();

    @Key("ExplicitWait")
    long getExplicitWait();

    @Key("selenium.grid.url")
    String getSeleniumGridUrl();

    @Key("PassTestExecutionControlNumFlag")
    boolean getPassTestExecutionControlNumFlag();

    @Key("PassTestExecutionControlNum")
    int getPassTestExecutionControlNum();

    @Key("FlakyTestRetryFlag")
    boolean getFlakyTestRetryFlag();

    @Key("MaxFlakyTestRetryCount")
    int getMaxFlakyTestRetryCount();

}
