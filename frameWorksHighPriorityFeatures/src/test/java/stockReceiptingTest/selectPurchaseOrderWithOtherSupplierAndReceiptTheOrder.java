package stockReceiptingTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Page.pointOfSalesPageObjectModal;
import Page.purchaseOrderPageObjectModel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class selectPurchaseOrderWithOtherSupplierAndReceiptTheOrder {
	
	static WebDriver Driver ;
	static pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);

	@BeforeClass
	//	@Parameter("Browser")
	public static void Intializebrowser() {
		//	Driver = null;
		//			if(Browser .equalsIgnoreCase("Chrome") ) {
		//				WebDriverManager.chromedriver().setup();
		//				Driver = new ChromeDriver();
		//				Driver.manage().window().maximize();	
		//			}else if(Browser.equalsIgnoreCase( "Edge")){
		WebDriverManager.edgedriver().setup();
		Driver = new EdgeDriver();
		Driver.get("https://frameworks.bowens.com.au/FWLive/");
		Driver.switchTo().frame(1);
		pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);
		
//		 please go through the document incase if you are seeing a Old UI or viceversa
		 
		PageObj.loginToTheRequiredEnvironment("pavithra","Pradha@321");
		PageObj.tapOnTheUserIconAndSwitchToClassicFrameworklook();
		PageObj.SwitchToWindow(0);
		Driver.switchTo().frame(1);
		PageObj.loginToTheRequiredEnvironmentForOldClassicLook("pavithra","Pradha@321");
		//			}else {
		//				WebDriverManager.firefoxdriver().setup();
		//				Driver = new FirefoxDriver();
		//				Driver.manage().window().maximize();
		//				}
	}

	@Test
	public static void TS_selectPurchaseOrderWithOtherSupplierAndReceiptTheOrder() {
		pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);
		PageObj.tapOnTheHamburgerIcon();
		purchaseOrderPageObjectModel POObj = new purchaseOrderPageObjectModel(Driver);
		POObj.tapOnPurchaseAndReceipting();
		POObj.tapOnTransactionProcessingIcon();
		POObj.tapOnStockReceipting();
//		POObj.tapOnAllBranches();
		POObj.tapOnFindIcon();
		POObj.filterTheStatusAsNew();
		POObj.filterTheTypeAsPurchaseOrder();
		POObj.filterTheSupplier("SELLEYS");
		POObj.selectThePurchaseOrderID();
		POObj.rapidEntryProducts("ASA1003","2");
		POObj.rapidEntryProducts("P10F190035","25.5");
		POObj.tapOnReceiveAllIcon();
//		POObj.tapOnClearAllIcon();
		POObj.enterDocketNumber("156892");
		POObj.tapOnReceiptGoods();
		
		
		
	}

	@AfterClass
	public static void tearDown() {
		Driver.quit();
	}
	

}
