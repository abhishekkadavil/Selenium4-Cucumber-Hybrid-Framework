package com.dataproviders;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.SneakyThrows;
import io.cucumber.guice.ScenarioScoped;

import java.io.File;
import java.io.IOException;

/**
 * @author Abhishek Kadavil
 */
@ScenarioScoped
public class TestDataReader {

    private JsonNode rootNode;

    @SneakyThrows
    public void loadData(String jsonPath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.rootNode = mapper.readTree(new File(jsonPath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test data", e);
        }
    }

    public JsonNode getRootNode() {
        return rootNode;
    }

    public String getUsername() {
        return rootNode.path("loginCredential").path("username").asText();
    }

    public String getPassword() {
        return rootNode.path("loginCredential").path("password").asText();
    }

    public JsonNode getItems() {
        return rootNode.path("items");
    }

    public String getBillingCity() {
        return rootNode.path("billingAddress").path("city").asText();
    }

    public String getShippingZip() {
        return rootNode.path("shippingAddress").path("zip").asText();
    }

    public String getPaymentType() {
        return rootNode.path("payment").path("pmtType").asText();
    }

    // Optionally: add general-purpose dynamic access
    public JsonNode get(String field) {
        return rootNode.path(field);
    }
}
