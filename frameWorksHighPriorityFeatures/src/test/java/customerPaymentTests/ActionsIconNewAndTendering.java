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

public class ActionsIconNewAndTendering {
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
		CustPayObj.MakeAllocations("2000005");
		CustPayObj.TapOnActionsIcon();
		CustPayObj.TapOnClearAllocations();
		Assert.assertFalse(CustPayObj.VerifyingElementToSeeIfClearAllocationIsWorking());
		CustPayObj.TapOnActionsIcon();
		CustPayObj.TapOnShowAllIcon();
		CustPayObj.TapOnActionsIcon();
		CustPayObj.TapOnShowUnallocatedIcon();
		CustPayObj.TapOnActionsIcon();
		CustPayObj.TapOnAddDiscounts();
		CustPayObj.TapOnActionsIcon();
		CustPayObj.TapOnRemoveDiscounts();
	}
	
	@Test(priority = 2)
	public void TenderingTheAmount() 
	{
		CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
		CustPayObj.TapOnNewIcon();
		CustPayObj.EnterCustomerNumberInPaymentForm("444142");
		CustPayObj.EnterThePaymentAmount("200");
		CustPayObj.TapOnTenderingIcon();
		CustPayObj.TapOnPaymentOptionDropDown();
		CustPayObj.TapOnCashIcon();
		CustPayObj.TapOnPayIcon();
		Assert.assertTrue(CustPayObj.VerifyIfTenderingAmountIsDisplayed(), "The Tendering Amount Is Not Added Properly");
	}
	
	@Test(priority = 3)
	public void DirectDepositTheAmount() 
	{
		CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
		CustPayObj.TapOnNewIcon();
		CustPayObj.EnterCustomerNumberInPaymentForm("444142");
		CustPayObj.EnterThePaymentAmount("200");
		CustPayObj.TapOnDirectDepositIcon();
		CustPayObj.TapOnCloseIcon();
		CustPayObj.TapOnDirectDepositIcon();
		CustPayObj.TapOnSaveIcon();
		Assert.assertTrue(CustPayObj.VerifyIfTenderingAmountIsDisplayed(), "The Tendering Amount Is Not Added Properly");
	}
	
	@Test(priority = 4)
	public void CustomerPaymentAsZeroDollars() 
	{
		
		CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
		CustPayObj.TapOnNewIcon();
		CustPayObj.EnterCustomerNumberInPaymentForm("95000");
		CustPayObj.EnterThePaymentAmount("0.00");
		CustPayObj.TapOnDirectDepositIcon();
		CustPayObj.TapOnSaveIcon();
		CustPayObj.TapOnYesPerformSaveIcon();
		CustPayObj.TapOnNewIcon();
		CustPayObj.EnterCustomerNumberInPaymentForm("95000");
		CustPayObj.EnterThePaymentAmount("0.00");
		CustPayObj.TapOnTenderingIcon();
		CustPayObj.TapOnPayIcon();
		CustPayObj.TapOnYesPerformSaveIcon();
	}
	@Test(priority = 4)
	public void ImportPayments() 
	{
		CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
		CustPayObj.TapOnImportPayments();
		CustPayObj.TapOnBrowseIcon();
		CustPayObj.UploadTheValidPaymentExcel();
		CustPayObj.TapOnUploadIcon();
	}
	
	@AfterClass
	public static void tearDown() {
		Driver.quit();
	}
	
}
