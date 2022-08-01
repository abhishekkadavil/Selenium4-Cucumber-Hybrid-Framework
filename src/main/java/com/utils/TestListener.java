package com.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestStepFinished;
import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.*;
import java.util.Base64;

public class TestListener implements ConcurrentEventListener {
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        
        ReporterFactory.getInstance().finisheExtentTest();
        
    }
    
    private void handleTestStepFinished(TestStepFinished event) {
    	
    	String stepName="";

        InputStream in = null;
        String base64 = "";
        File srcfile;
             
        if (event.getTestStep() instanceof PickleStepTestStep) {
        	PickleStepTestStep pickleStepTestStep  = (PickleStepTestStep) event.getTestStep();
            stepName = pickleStepTestStep.getStep().getText();
            
            Result result = event.getResult();
            
            if(result.getStatus().name().equalsIgnoreCase("FAILED"))
            {
                //Failed step reporting
            	ReporterFactory.getInstance().getExtentTest().log(com.aventstack.extentreports.Status.FAIL, stepName);
            	ReporterFactory.getInstance().getExtentTest().log(com.aventstack.extentreports.Status.FAIL, result.getError().toString());

                //Failed step adding screenshot
                srcfile = ((TakesScreenshot)DriverFactory.getDriverFactory().getWebDriver()).getScreenshotAs(OutputType.FILE);

                try {
                    in = new FileInputStream(srcfile);
                    byte[] imageBytes = new byte[0];
                    imageBytes = IOUtils.toByteArray(in);
                    base64 = Base64.getEncoder().encodeToString(imageBytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ReporterFactory.getInstance().getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

            }
            else if(result.getStatus().name().equalsIgnoreCase("PASSED"))
            {
            	ReporterFactory.getInstance().getExtentTest().log(com.aventstack.extentreports.Status.PASS, stepName);
            }
            else if(result.getStatus().name().equalsIgnoreCase("SKIPPED"))
            {
                ReporterFactory.getInstance().getExtentTest().log(com.aventstack.extentreports.Status.SKIP, stepName);
            }
        }
        
    }
}