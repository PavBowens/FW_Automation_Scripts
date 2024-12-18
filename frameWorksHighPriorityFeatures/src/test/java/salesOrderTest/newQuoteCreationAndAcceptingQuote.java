package salesOrderTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.salesOrderPageObjectModal;
import Page.pointOfSalesPageObjectModal;
import io.github.bonigarcia.wdm.WebDriverManager;

public class newQuoteCreationAndAcceptingQuote {

	static WebDriver Driver ;

	@BeforeClass
	//	@Parameter("Browser")
	public static void Intializebrowser() {
		//		Driver = null;
		//				if(Browser .equalsIgnoreCase("Chrome") ) {
		//					WebDriverManager.chromedriver().setup();
		//					Driver = new ChromeDriver();
		//					Driver.manage().window().maximize();	
		//				}else if(Browser.equalsIgnoreCase( "Edge")){
		WebDriverManager.edgedriver().setup();
		Driver = new EdgeDriver();
		Driver.get("https://frameworks.bowens.com.au/FWLive/");
		Driver.switchTo().frame(1);
		pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);
		
//		 please go through the document incase if you are seeing a Old UI or viceversa
		 
		PageObj.loginToTheRequiredEnvironment("pavithra","Pradha@321");
		PageObj.tapOnTheUserIconAndSwitchToClassicFrameworklook();
//		PageObj.driverWait();
		PageObj.SwitchToWindow(0);
		Driver.switchTo().frame(1);
		PageObj.loginToTheRequiredEnvironmentForOldClassicLook("pavithra","Pradha@321");
		//				}else {
		//					WebDriverManager.firefoxdriver().setup();
		//					Driver = new FirefoxDriver();
		//					Driver.manage().window().maximize();
		//					}
	}

	@Test(priority = 1)
	public static void TS_newQuoteCreationAndAcceptingQuote() {
		pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);
		PageObj.tapOnTheHamburgerIcon();
		PageObj.tapOnTheSalesIcon();
		salesOrderPageObjectModal SOObj = new salesOrderPageObjectModal(Driver);
		SOObj.tapOnTheSalesOrderIcon();
		SOObj.tapOnNewSalesOrder(); 
		SOObj.SelectQuotes();
		SOObj.addTheValidDetailsOfSalesOrder("95000","Testing for the release");
		SOObj.addHardwareProducts("ASA1003","5");
		SOObj.addHardwareProducts("ASA1006","2");
		SOObj.editHeader();
		SOObj.tapOnEntryCompleteIcon();
		SOObj.acceptQuote();
	}

	@AfterClass
	public static void tearDown() {
		Driver.quit();
	}
}