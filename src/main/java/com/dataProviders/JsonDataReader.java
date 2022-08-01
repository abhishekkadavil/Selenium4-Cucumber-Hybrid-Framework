package com.dataProviders;

import com.google.gson.Gson;
import com.testDataModels.TestDataModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public String fileName;

    private static TestDataModel testDataModel;

    public JsonDataReader() {

    }

    public synchronized static TestDataModel getTestData(String fileName) {
//        fileName = TestContext.testDataFilePath + fileName + ".json";
//    	/Selenium4CucumberHybridFramework/TestData/CreditCardPaymentFeature/Scenario01.json
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(fileName));
            testDataModel = gson.fromJson(bufferReader, TestDataModel.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + fileName);
        } finally {
            try {
                if (bufferReader != null)
                    bufferReader.close();
            } catch (IOException ignore) {
            }
        }
        return testDataModel;
    }

}
