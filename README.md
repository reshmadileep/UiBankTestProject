# UiBankTestProject

This project tests if the Apply for a Loan functionality of https://uibank.uipath.com/loans website is working as expected.When the user submits required data for applicants from the inputdata sheet in the website   ,for successful application APR should be generated and this has to be updated in input excel sheet.

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
   
   -Under src/test/java create package pages -which contains all the webelements and functions specific to that page.SetUp class will have the initialization steps - reading properties file and setting driver and launching the url
   
   -create runner package and TestRunner class in it 
   
   -create stepDefinitions package which contains classes attached to feature files
   
   -create utils package for reusable components
   
   -Under src/test/resources create config folder and create dev.properties file - where we can set the variables browser and url 
   
      -create a data foder to inlcude input datafile
      
      -create drivers folder and add all drivers in it
      
      -create features folder which will have the feature file
      
      -Include the TestRunner class in testng.xml and run as a testng suite.The driver will launch the website and the will click the Apply for a Loan button and  will be redirected to the Loan Application page.In the Loan Application page it will enter the data from data file which is actually provided in the feature file.The in the Loan Approval page APR will be displayed.This is then updated in the datafile .The framework can be extended further by directly taking data from excel file by using data tables.
 
Reports could be found in test-output folder 
html report :C:\Users\Local User\git\repository2\UiBankLoanProject\test-output\emailable-report.html
Cucumber report:C:\Users\Local User\git\repository2\UiBankLoanProject\target\cucumber-reports\cucumber-pretty\index.html
