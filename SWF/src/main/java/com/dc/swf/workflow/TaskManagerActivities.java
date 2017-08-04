package com.dc.swf.workflow;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

@Activities(version="1.0")
@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 300, defaultTaskStartToCloseTimeoutSeconds = 1000)
public interface TaskManagerActivities {
	
   public String activity1();
	
   public String manualActivity();
	
   public String activity2();

}
