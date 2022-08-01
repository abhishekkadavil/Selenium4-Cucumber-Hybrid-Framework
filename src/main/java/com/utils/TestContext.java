package com.utils;

import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

public class TestContext {

    @Setter
    @Getter
    Scenario scenario;

    public static ThreadLocal<Map<String,String>> scenarioContext = new ThreadLocal<Map<String,String>>();

    public Map<String,String> getScenarioContext() {
        return scenarioContext.get();
    }

    public void setScenarioContext(Map<String, String> scenarioContextMap) {
        scenarioContext.set(scenarioContextMap);
    }



}
