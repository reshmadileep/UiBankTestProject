Feature: Apply Loan

Scenario Outline: Successful Loan Application

Given User is on Apply for a Loan  homepage
When User submits loan applications for given applicants from datasheet using "<Email Address>","<Loan Amount>","<Loan Term>","<Income>" and  "<Age>" 

Then User is able to get APR for successful application
Then  the APR is updated to the datasheet "C:\Users\Local User\eclipse-workspace\UiBankLoanProject\src\test\resources\data\datasheet.xlsx" for the corresponding applicants at "<RowNum>"

Examples:
 |Email Address|Loan Amount|Loan Term|Income|Age|RowNum|
 |johnDoe@test.com|10000|10|65000|22|1|
 |abc@test.com|20000|3|72000|27|2|
 |uibank@test.com|15000|5|83000|33|3|
 

 