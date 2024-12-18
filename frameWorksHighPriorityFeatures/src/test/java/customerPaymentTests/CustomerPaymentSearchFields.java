package customerPaymentTests;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Page.CustomerPaymentsPageObjectModal;
import Page.pointOfSalesPageObjectModal;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomerPaymentSearchFields 
{

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
	}
	
	@Test(priority=1)
	public static void goToCustomerPaymentsAndSearchWithInvalidCustomer() // Taps on the required fields and Goes to the searches Customer with Invalid Data 
	{
		CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
		CustPayObj.TapOnTheFindIcon();
		CustPayObj.EnterTheCustomerNumber("95000");
		CustPayObj.TapOnTheFindIcon();
		Assert.assertTrue(CustPayObj.getElementFiltered() , "The Expected Customer is not filtered Out ");
	}
	
	@Test(priority=2)
	public static void selectCustomerNumberAndVerifyIfThePaymentIsShown() throws IOException // Taps on the required fields and Goes to the searches Customer with Invalid Data 
	{
		CustomerPaymentsPageObjectModal CustPayObj = new CustomerPaymentsPageObjectModal(Driver);
		CustPayObj.clearCustomerNumber();
		CustPayObj.TapOnTheFindIcon();
		CustPayObj.TapOnAnyOneOfTheInvoices();
		CustPayObj.TakeScreenShotAndVerifyThePageAfterSelectingPayment();
	}
	
	public static void driverQuit() {
		Driver.quit();
	}
	
}
