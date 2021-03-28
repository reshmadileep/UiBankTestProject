package pages;

import org.openqa.selenium.By;

public class LoanApproval extends SetUp {
	
	By txtAPR = By.xpath("//*[@id=\"rateValue\"]");
	
	
	public String getAprValue() {		
	
	return	SetUp.driver.findElement(txtAPR).getText();
	
		
	}
	
	

}
