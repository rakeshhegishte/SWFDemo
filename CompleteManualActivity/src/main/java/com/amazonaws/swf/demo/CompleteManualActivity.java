package com.amazonaws.swf.demo;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.ManualActivityCompletionClient;
import com.amazonaws.services.simpleworkflow.flow.ManualActivityCompletionClientFactory;
import com.amazonaws.services.simpleworkflow.flow.ManualActivityCompletionClientFactoryImpl;

public class CompleteManualActivity {

	public static void main(String[] args) {
		
		ClientConfiguration config = new ClientConfiguration()
				.withSocketTimeout(70 * 1000);

		AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(config);
		service.setEndpoint("https://swf.ap-south-1.amazonaws.com");

		ManualActivityCompletionClientFactory manualCompletionClientFactory
           = new ManualActivityCompletionClientFactoryImpl(service);

        ManualActivityCompletionClient manualCompletionClient
           = manualCompletionClientFactory.getClient(args[0]);
        
        String message = "Completed successfully";
		
        manualCompletionClient.complete(message);

	}

}
