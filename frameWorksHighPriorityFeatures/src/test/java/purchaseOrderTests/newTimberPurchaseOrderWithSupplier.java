package purchaseOrderTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Page.pointOfSalesPageObjectModal;
import Page.purchaseOrderPageObjectModel;
import Page.salesOrderPageObjectModal;
import io.github.bonigarcia.wdm.WebDriverManager;

public class newTimberPurchaseOrderWithSupplier {

	static WebDriver Driver;

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
	public static void TS_newTimberPurchaseOrderWithSupplier() {
		pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);
		PageObj.tapOnTheHamburgerIcon();
		purchaseOrderPageObjectModel POObj = new purchaseOrderPageObjectModel(Driver);
		POObj.tapOnPurchaseAndReceipting();
		POObj.tapOnTransactionProcessingIcon();
		POObj.tapOnThePurchaseOrderIcon();
		POObj.tapOnNewPurchaseOrder(); 
		POObj.enterTheValidDetailsInThePurchaseOrderForm("oneForty");
		salesOrderPageObjectModal SOObj =new salesOrderPageObjectModal(Driver);
		SOObj.addTallyProduct("P10F190035","5","5.1","6","6");
		POObj.editHeader();
		POObj.tapOnHeaderAndSaveThePurchaseOrder();
		POObj.tapOnTheHamburgerIcon();
		POObj.tapOnStockReceipting();
		POObj.checkIfThePurchaseOrderIsBeingShownInStockReceiptingPage(POObj.getPONumber());
	}

	@AfterClass
	public static void tearDown() {
		Driver.quit();
	}

}
