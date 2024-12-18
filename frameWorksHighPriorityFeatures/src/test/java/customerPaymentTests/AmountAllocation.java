package customerPaymentTests;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.CustomerPaymentsPageObjectModal;
import Page.pointOfSalesPageObjectModal;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmountAllocation {
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
	}

	@Test(priority = 1)
	public void PaymentAmountEqualsAgingAmount() 
	{
		CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
		Integer PaymentAmount = CustPayObj.GetThePaymentAmount();
		String CustomerNumber = CustPayObj.GetCustomerNumber();
		CustPayObj.CloseCustomerPaymentsTab();
		CustPayObj.TapOnCustomerDashboard();
		CustPayObj.EnterTheCustomerNumberInCustomerDashboard(CustomerNumber);
		Integer CurrentDueAmount =CustPayObj.GetTheCurrentDueAmount();
		Integer ThirtyDaysDueAmount =CustPayObj.GetTheCurrentThirtyDaysAmount();
		Integer SixtyDaysDueAmount =CustPayObj.GetTheCurrentSixtyDaysAmount();
		Integer NinetyDaysDueAmount =CustPayObj.GetTheCurrentNinetyDaysAmount();
		Integer OneTwentyDaysDueAmount =CustPayObj.GetTheCurrentOneTwentyDaysAmount();
		CustPayObj.VerifyIfInvoiceMatchesWithTheAnyAgeTab(PaymentAmount,CurrentDueAmount,ThirtyDaysDueAmount,SixtyDaysDueAmount,NinetyDaysDueAmount,OneTwentyDaysDueAmount);
		CustPayObj.VerifyIfTheAmountIsAllocatedProperly(PaymentAmount);
//		CustPayObj.TapOnSaveIconForTheCustomerPayment();
		
	}

	@SuppressWarnings("unchecked")
	@Test(priority = 2)
	public void PaymentAmountNotEqualsAgingAmount() 
	{
		
		CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
		Integer PaymentAmount = CustPayObj.GetThePaymentAmount();
		CustPayObj.TapOnTheFindIcon();
		CustPayObj.TapOnYesDiscard();
		CustPayObj.TapOnAnyOneOfTheInvoices();
		CustPayObj.TapOnTheDateIcon();
		CustPayObj.TapOnTheInvoiceOption();
		CustPayObj.TapOnExportAsExcel();
		CustPayObj.TapOnThePaymentIcon();
		List <String> PendingBalance = CustPayObj.GetTheAmountFromTheDataSheet();
		CustPayObj.AllocateTheAmount(PaymentAmount,PendingBalance);
		CustPayObj.VerifyIfTheAmountIsAllocatedProperly(PaymentAmount);
//		CustPayObj.TapOnSaveIconForTheCustomerPayment();
	}
	
	@Test(priority = 3)
	public void overAllocateThePaymentAndSeeIfTheErrorIsThrown() 
	{
		CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
		CustPayObj.TapOnTheFindIcon();
		CustPayObj.TapOnYesDiscard();
		CustPayObj.TapOnAnyOneOfTheInvoices();
		CustPayObj.TapOnTheDateIcon();
		CustPayObj.TapOnTheInvoiceOption();
		CustPayObj.TapOnThePaymentIcon();
		CustPayObj.EnterHighestPrice("120000");
		CustPayObj.TapOnSaveIconForTheCustomerPayment();
		Assert.assertTrue(CustPayObj.ErrorIsShown());
		Assert.assertTrue(CustPayObj.OverAllocatedSentence());
		CustPayObj.TapOnNoDontCloseIcon();
	}

	@AfterClass
	public static void tearDown() {
		Driver.quit();
	}
}
