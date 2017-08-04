Steps to run demo:

1. Create SWF domain in target region.
2. Do necessory referance changes of domain name & region name in 3 locations
	a. SWF > TaskManagerWorker.java
	b. TestWorkFlow > StartWorkFlow.java
	c. CompleteManualActivity > CompleteManualActivity.java
3. Build all three jar's & place it on EC2
4. Give require roles to EC2 instance.
5. run Jar as 
	a. java -jar swf-0.0.1.jar
	b. java -jar TestWorkFlow-1.0.0.jar
	c. java -jar CompleteActivity-1.0.0.jar
6. Observe SWF console at each step.
