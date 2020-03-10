```                                                                      
#             .___      __     _____          __                         __  .__               
#    ______ __| _/_____/  |_  /  _  \  __ ___/  |_  ____   _____ _____ _/  |_|__| ____   ____  
#   /  ___// __ |/ __ \   __\/  /_\  \|  |  \   __\/  _ \ /     \\__  \\   __\  |/  _ \ /    \ 
#   \___ \/ /_/ \  ___/|  | /    |    \  |  /|  | (  <_> )  Y Y  \/ __ \|  | |  (  <_> )   |  \
#  /____  >____ |\___  >__| \____|__  /____/ |__|  \____/|__|_|  (____  /__| |__|\____/|___|  /
#       \/     \/    \/             \/                         \/     \/                    \/ 
```

# seleniumJava
Selenium Startup Project for Java

[![Build Status](https://travis-ci.org/sdetAutomation/seleniumJava.svg?branch=master)](https://travis-ci.org/sdetAutomation/seleniumJava)

[![Java CI](https://github.com/sdetAutomation/seleniumJava/workflows/Java%20CI/badge.svg)](https://github.com/sdetAutomation/seleniumJava/actions)

Introduction
------------
This project is made for anyone who is looking for a starting point for writing functional tests using Selenium WebDriver and Java.

This project was written using IntelliJ IDEA Community Edition.   


Project Packages
-----
* PageObjects:  
Contains class files for each web page being tested.  Page element definitions / mappings, and functions for interacting with page elements.
 
* SeleniumExtensions:  
Contains helper function to instantiate WebDriver to the appropriate browser type.  WebDriverExtensions class contains helper functions to handle driver waits for page elements conditions. 

* TestHelper:  
    - ConfigSettings: contains helper functions for reading config.properties.  
    - IoLibrary: contains helper functions used across tests.  
    - LoggingLibrary: contains custom functions for comparing actual to expected conditions.  
    - TestAssert: Is a custom assert, used to track if a verification point has failed.  The class variable is latched, once set to false it will remain false for the remainder of the test run. 


Maven Java Project / Maven Wrapper
-----
This project is written in Java and tests can be executed using Maven commands. 

    ./mvnw clean install

Page Object Model
-----
Page object model is used in this framework.  Each web page will have its own java.class and within each class contains page element mappings and functions / methods used to interact /verify a specific web page under test.  


Test web page
-----
    http://the-internet.herokuapp.com/      

   
Accessibility Testing
------------
This project uses [axe-selenium](https://github.com/dequelabs/axe-selenium-java) package for accessibility testing.

View accessibility test code: [click here](https://github.com/sdetAutomation/seleniumJava/blob/master/src/test/java/com/sdet/auto/SeleniumTest.java#L69-L78)
   
View accessibility helper function: [AccessibilityHelper.basicAccessibilityCheck()](https://github.com/sdetAutomation/seleniumJava/blob/master/src/main/java/com/sdet/auto/TestHelper/AccessibilityHelper.java)

Continuous Integration(CI)
------------
A web hook has been setup with Travis CI for all Push and Pull Requests.
 
A web hook has also been setup with Github Actions, and Selenium Tests will execute with [testcontainers](https://www.testcontainers.org/) during CI.  
 
 
Selenium WebDriver
------------
This project is configured to use Firefox & Chrome WebDriver's.  The default is set to Chrome.  The WebDriver's added to this project will only work on macos.  


Testcontainers
------------
Tests "SeleniumContainerTest" will execute Selenium test in a docker container.  In order to execute this test using a testcontainer
you must install docker, and also have docker running before test execution.

for more information: https://www.testcontainers.org/


Selenium Grid
------------
Tests in this solution can also run on the Selenium Grid.  Selenium Grid is hosted by www.gridlastic.com.

Questions / Contact / Contribute
------------
Feel free to fork this repo, add to it, and create a pull request if you like to contribute.  

If you have any questions, you can contact me via email: `sdet.testautomation@gmail.com`
