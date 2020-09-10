# Browser_Automation-Selenium
Selenium Framework with Page Object Model using Maven and TestNG

Steps to run Automation Task:

Tools and configuration:

1.Make sure Java JDK is installed in the system

2.Install MAVEN and set MAVEN HOME and PATH<br/>
Verion used:"3.6.1"<br/>
ex:MAVEN_HOME=/Users/ngeorge1/Downloads/apache-maven-3.6.1</br>
PATH=$PATH:$MAVEN_HOME/bin

Test Suite Configurations:

3.Install Gecko drivers in the system and update GECKO_PATH variable in the Config file located in the below location:
/comfriendsurancetracker⁩/src/test/java/Utils/Config.java

ex:GECKO_PATH = "//Users//ngeorge1//Downloads//geckodriver";

To run the test suite:

4.Go to to the project root folder from terminal and run the following command:<br/>
mvn install

Results:

Once the build is done, a report is generated in the Reports folder as “SanityReport” and screens shots in Screenhots folder
