package pages;

import org.openqa.selenium.By;

public class LoanApproval extends SetUp {
	
	By txtAPR = By.xpath("//*[@id=\"rateValue\"]");
	
	
	public String getAprValue() {	
		
	if ((SetUp.driver.findElement(txtAPR)).isDisplayed())
		System.out.println("Loan Application is successful");
	
	return	SetUp.driver.findElement(txtAPR).getText();
	
		
	}
	
	

}
