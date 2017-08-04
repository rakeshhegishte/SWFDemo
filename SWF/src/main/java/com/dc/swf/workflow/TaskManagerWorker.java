package com.dc.swf.workflow;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;

public class TaskManagerWorker { 
	public static void main(String[] args) throws Exception {
		ClientConfiguration config = new ClientConfiguration()
				.withSocketTimeout(700 * 10000);

		AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(config);
		service.setEndpoint("https://swf.ap-south-1.amazonaws.com");

		String domain = "TestDomain";
		String taskListToPoll = "TestActivityList";
		
		ActivityWorker aw = new ActivityWorker(service, domain, taskListToPoll);
		WorkflowWorker wfw = new WorkflowWorker(service, domain, taskListToPoll);
		
		System.out.println("starting....");
		aw.addActivitiesImplementation(new TaskManagerActivitiesImpl());
		aw.start();
		System.out.println("Task worker started");
	
		
		wfw.addWorkflowImplementationType(TaskManagerWorkflowImpl.class);
		wfw.start();
		System.out.println("Task workflow started");
				
	}
}
