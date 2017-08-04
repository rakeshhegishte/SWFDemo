package com.dc.swf.workflow;

import com.amazonaws.services.simpleworkflow.flow.ActivityExecutionContext;
import com.amazonaws.services.simpleworkflow.flow.ActivityExecutionContextProvider;
import com.amazonaws.services.simpleworkflow.flow.ActivityExecutionContextProviderImpl;
import com.amazonaws.services.simpleworkflow.flow.annotations.ManualActivityCompletion;

public class TaskManagerActivitiesImpl implements TaskManagerActivities {
	@Override
	public String activity1(){
		System.out.println("Activity 1 in progress");
		return "Successful > Activity one";
	}
	
	@Override
    @ManualActivityCompletion
    public String manualActivity(){
		
       System.out.println("Manual activity is in progress");
       
// Token generation for external decision.
       ActivityExecutionContextProvider contextProvider = new  ActivityExecutionContextProviderImpl();
	   ActivityExecutionContext executionContext = contextProvider.getActivityExecutionContext();
	   String taskToken = executionContext.getTaskToken(); 
	
//     
	   System.out.println("Token :: >>> " + taskToken);
	   return "Successful > manual activity";
	}

	@Override
	public String activity2(){
		System.out.println("Activity 2 in progress");
		return "Successful > Activity Two";
	}
}
