package com.amazonaws.swf.demo;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowAsync;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowAsyncClientBuilder;
import com.amazonaws.services.simpleworkflow.model.StartWorkflowExecutionRequest;
import com.amazonaws.services.simpleworkflow.model.WorkflowType;

public class StartWorkFlow {

	public static void main(String[] args) {
		
		AmazonSimpleWorkflowAsync swfAsync = AmazonSimpleWorkflowAsyncClientBuilder.standard().withEndpointConfiguration(new EndpointConfiguration("https://swf.ap-south-1.amazonaws.com", "ap-south-1")).build();

	       
	        swfAsync.startWorkflowExecution(new StartWorkflowExecutionRequest()
	                .withDomain("TestDomain")
	                .withWorkflowType(new WorkflowType()
	                .withName("TaskManagerWorkflow.execute")
	                .withVersion("1.0"))
	                .withWorkflowId("123"));


	}

}
