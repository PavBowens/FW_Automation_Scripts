package customerPaymentTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.CustomerPaymentsPageObjectModal;
import Page.pointOfSalesPageObjectModal;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNewIconAndPaymentVerification {
	
	static WebDriver Driver ;
	
	@BeforeClass
	
	public static void Intializebrowser() 
	{
	WebDriverManager.edgedriver().setup(); //WebDriverManager SetUp
	Driver = new EdgeDriver(); //Edge Driver SetUp
	Driver.get("https://frameworks.bowens.com.au/FWLive/"); // Opens the URL of the Frame Works
	Driver.switchTo().frame(1); //Switches to the frame in order to tap on the Demo Icon
	pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver); // Page Object which has the login details 
	PageObj.loginToTheRequiredEnvironment("pavithra","Pradha@321"); // Logs into required environment 
	CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
	CustPayObj.TapOnTheHamburgerMenu();
	CustPayObj.TapOnRecievablesIcon();
	CustPayObj.TapOnTheTransactionProcessingIcon();
	CustPayObj.TapOnTheCustomerPaymentIcon();
	CustPayObj.TapOnTheFindIcon();
	CustPayObj.TapOnAnyOneOfTheInvoices();
	}
	
	@Test(priority = 1)
	public void AddNewTransactionsInThePage() 
	{
		CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
		CustPayObj.TapOnTheFindIcon();
		CustPayObj.TapOnAnyOneOfTheInvoices();
		CustPayObj.TapOnAddNewIcon();
		CustPayObj.EnterTransactionNumber("Test");
		CustPayObj.CloseTheTab();
		CustPayObj.TapOnAddNewIcon();
		CustPayObj.TapOntheSearchIcon();
		String ExpectedAdjustmentTrans = CustPayObj.getTheTransactionNumber();
//		System.out.println(ExpectedAdjustmentTrans);
		CustPayObj.SelectTheTransactionNumber();
		CustPayObj.TapOnSaveIcon();
		Assert.assertEquals(ExpectedAdjustmentTrans , CustPayObj.getActualAdjustmentTransNumb());
	}
	
	
	@Test(priority = 2)
	public void PaymentVerification() 
	{
		CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
		Integer TotalDue = CustPayObj.GetTheTotalDue()- CustPayObj.getUnderAllocatedAmount();
		System.out.println(TotalDue);
		CustPayObj.TapOnTheFindIcon();
		CustPayObj.TapOnYesDiscard();
		String CustomerNumber = CustPayObj.GetCustomerNumber();
		System.out.println(CustomerNumber);
		CustPayObj.CloseCustomerPaymentsTab();
		CustPayObj.TapOnCustomerDashboard();
		CustPayObj.EnterTheCustomerNumberInCustomerDashboard(CustomerNumber);
		Integer AllocatedDue = CustPayObj.getAllocatedDue();
		Assert.assertEquals(TotalDue , AllocatedDue , "Total Due and Allocated Dues are not Matching ");
		
	}
	
	@AfterClass
	public static void tearDown() {
		Driver.quit();
	}

}
