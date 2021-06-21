# performance-test-gatling-demo

Demo Gatling project setup for performance testing of opensourcecms demo application.
Using it you can write performance tests in Gatling.

Example Scala files :
In the below mentioned folder Scala files are avaialble.
performance-test-gatling-demo\user-files\simulations\simulation

1. AssignmentSimulation.scala ( without static resources).
2. OpenSourceCmsSimulation.scala ( with static resources).

Pages Covered and URL's :

1. Homepage and Login- https:/s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login
2. Admin Module - https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/admin/viewSystemUsers
3. Time Module - https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/time/viewEmployeeTimesheet

Prerequisites for setup :

1. JDK 1.8 and above and standalone Gatling 3.5.1 or above requied 
2. For Standalone Gatling, Got to C Drive and Download performance-test-gatling-demo folder from github and rename the change folder name to gatling-charts-highcharts-bundle-3.5.1
2. Set JAVA_HOME and GATLING_HOME environment variables

For Running the Gatling test :

1. Go command prompt and go to the path C:\gatling-charts-highcharts-bundle-3.5.1\bin and trigger gatling.bat
2. Give the appropriate number related for execution of simulation file which is planning to run
3. Results will be available in C:\gatling-charts-highcharts-bundle-3.5.1\results folder and exact path of results will be mentioned on console.
4. For logs, refer C:\gatling-charts-highcharts-bundle-3.5.1\bin\logs.

Note : I have created Gatling scenario with 1 user and perform operations for duration of 60 seconds with think time of 5 Seconds.

Improvements Recommended  

related to Gatling Script :

1. We can create Gatling objects and call them in dynamic manner.
2. We can automate the process by creating maven build and can trigger the tests Jenkins pipeline. ( due to lack of time i am not implemented these changes in this demo).
3. Modular Scripting can be performed
4. For monitoring, we can integrate the setup with Grafan and InfluxDB and live Gatling monitoring we can do during load test execution.


Related to Report Analysis :

1. client side objects caching need to be implemented
2. Each Request URL doing redirecting and need to understand the requirement of this implementation
3. There is no test data available in Application and without that can't provide the baseline details.





