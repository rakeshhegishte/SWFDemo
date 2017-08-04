package com.dc.swf.workflow;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;

public class TaskManagerWorkflowImpl implements TaskManagerWorkflow {
   private TaskManagerActivitiesClient operations = new TaskManagerActivitiesClientImpl();

   @Override
   public void execute(String message) {
	
      Promise<String> activity1Out = operations.activity1();
 
      Promise<String> manualActivityOut = operations.manualActivity();
   
      Promise<String> activity2Out = operations.activity2();

   }
}
