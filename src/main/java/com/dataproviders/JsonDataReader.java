package com.dataproviders;

import com.google.gson.Gson;
import com.testdatamodels.TestDataModel;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Abhishek Kadavil
 */
public class JsonDataReader {

    private JsonDataReader() {
    }

    @SneakyThrows
    public static synchronized TestDataModel getTestData(String fileName) {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        TestDataModel testDataModel;
        try {
            bufferReader = new BufferedReader(new FileReader(fileName));
            testDataModel = gson.fromJson(bufferReader, TestDataModel.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + fileName);
        } finally {
            if (bufferReader != null)
                bufferReader.close();
        }
        return testDataModel;
    }

}
