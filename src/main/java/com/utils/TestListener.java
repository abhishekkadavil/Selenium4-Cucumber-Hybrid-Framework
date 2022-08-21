package com.utils;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestStepFinished;

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
             
        if (event.getTestStep() instanceof PickleStepTestStep) {
        	PickleStepTestStep pickleStepTestStep  = (PickleStepTestStep) event.getTestStep();
            stepName = pickleStepTestStep.getStep().getText();
            
            Result result = event.getResult();
            
            if(result.getStatus().name().equalsIgnoreCase("FAILED"))
            {
                //Failed step reporting
            	ReporterFactory.getInstance().getExtentTest().log(com.aventstack.extentreports.Status.FAIL, stepName);
            	ReporterFactory.getInstance().getExtentTest().log(com.aventstack.extentreports.Status.FAIL, result.getError().toString());
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