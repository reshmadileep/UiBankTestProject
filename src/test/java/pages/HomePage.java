package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class HomePage extends SetUp{
	
  By btnApplyLoan = By.xpath("(//*[@id=\"applyButton\"])[1]");	
  By txtLoanApplication = By.xpath("//*[text()=\"Loan Application\"]");

	

	public void verifyTitle() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	

		if(SetUp.driver.getTitle().equals("UiBank"))			
			System.out.println("Website launched successfully.");

		else			
			System.out.println("Website Launch is unsuccessful. ");		
				
	}

	public HomePage clickApplyLoan() {
		
		JavascriptExecutor js = (JavascriptExecutor) SetUp.driver;
		js.executeScript("window.scrollBy(0,500)");
	
		//Click ApplyLoan button
		SetUp.driver.findElement(btnApplyLoan).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
		 if (driver.findElement(txtLoanApplication).isDisplayed()) 
		 System.out.println("Loan Application page is launched successfully.");
		 else	
		 System.out.println("Loan Application page has not been launched. ");
		
		return  this;
	}
	
}
