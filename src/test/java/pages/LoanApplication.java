package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class LoanApplication extends SetUp{
	
	By txtInputEmail = By.xpath("//*[@name=\"email\"]");
	
	By txtInputAmount = By.xpath("//*[@name=\"amount\"]");
	
	By ddTerm = By.xpath("//*[@id=\"term\"]");
	
	By txtInputIncome = By.xpath("//*[@id=\"income\"]");
	
	By txtInputAge = By.xpath("//*[@id=\"age\"]");
	
	By btnSubmitLoan = By.xpath("//*[@id=\"submitButton\"]");
	
	
	public void enterDetails(String email,String amount,String term,String income,String age ) {
		
		SetUp.driver.findElement(txtInputEmail).sendKeys(email);
		SetUp.driver.findElement(txtInputAmount).sendKeys(amount);
		Select loanTerm = new Select(driver.findElement(ddTerm));
		loanTerm.selectByValue(term);
		SetUp.driver.findElement(txtInputIncome).sendKeys(income);
		SetUp.driver.findElement(txtInputAge).sendKeys(age);
		
		}
	
	public LoanApplication submitLoan() {
		
		SetUp.driver.findElement(btnSubmitLoan).click();
		return this;
	}
	
    
}
