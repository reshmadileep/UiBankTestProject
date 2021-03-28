package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pages.HomePage;
import pages.LoanApplication;
import pages.LoanApproval;
import pages.SetUp;


public class SuccessfulLoanApplication  {

   
	SetUp setUp= new SetUp();
	HomePage homePage= new HomePage();
	LoanApplication loanApplication = new LoanApplication();
	LoanApproval loanApproval = new LoanApproval();
	String valAPR;

	
	@Given("^User is on Apply for a Loan  homepage$")
	public void user_is_on_Apply_for_a_Loan_homepage() throws Throwable {
	    
	    setUp.doSetUpBeforeExecution();	
		homePage.verifyTitle();
	   
	}
	
	@When("^User submits loan applications for given applicants from datasheet using \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and  \"([^\"]*)\"$")
	public void user_submits_loan_applications_for_given_applicants_from_datasheet_using_and(String email, String amount, String term, String income, String age)throws Throwable {
	   homePage.clickApplyLoan();
	   loanApplication.enterDetails(email, amount, term, income, age);
	   loanApplication.submitLoan();
	    
	}

	@Then("^User is able to get APR for successful application$")
	public void user_is_able_to_get_APR_for_successful_application() throws Throwable {
		
	  valAPR = loanApproval.getAprValue();
	 
	}
     
	
	@Then("^the APR is updated to the datasheet \"([^\"]*)\" for the corresponding applicants at \"([^\"]*)\"$")
	public void the_APR_is_updated_to_the_datasheet_for_the_corresponding_applicants_at(String path, String rowNum) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row row  =sheet.getRow(Integer.valueOf(rowNum));   
        Cell cell = row.createCell(5);
		System.out.println(valAPR);
		cell.setCellValue(valAPR);
	
		FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
	  
	    outputStream.close();
	    workbook.close();
	   
	}

	@After
	 public void cleanUp() {
		
		SetUp.driver.quit();
	
	}
}
