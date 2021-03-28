# UiBankTestProject

This project tests if https://uibank.uipath.com/loans website is working as expected.When the user submits required data for applicants from the inputdata sheet in the website   ,for successful application APR should be generated and this has to be updated in input excel sheet.

###Pre-requisites
-Java
-Eclipse IDE
-Maven

###Steps
-Create a Maven Project
-In the pom.xml add the required dependencies and plugins for Selenium-java,Maven,TestNG,Cucumber,poi etc.Refer the pom.xml to see the actual list.
-Add a testng.xml file
-Create a page object framework 
   -Delete src/main/java source folder
   -Under src/test/java create package pages -which contains all the webelements and functions specific to that page
   -create runner package and TesRunner class in it 
   -create stepDefinitions package which contains classes attached to feature files
   -create utils package for reusable components
   -Under src/test/resources create config folder and create dev.properties file 
   -create a data foder to inlcude input datafile
   -create drivers folder and add all drivers in it
   -create features folder which will have the feature file
   - Include the runner class in testng.xml and run as a testng suite
 
Reports could be found in test-output folder 
html report :C:\Users\Local User\git\repository2\UiBankLoanProject\test-output\emailable-report.html
Cucumber report:C:\Users\Local User\git\repository2\UiBankLoanProject\target\cucumber-reports\cucumber-pretty\index.html
