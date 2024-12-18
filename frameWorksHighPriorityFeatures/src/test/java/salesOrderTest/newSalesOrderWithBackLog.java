package salesOrderTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Page.salesOrderPageObjectModal;
import Page.pointOfSalesPageObjectModal;
import io.github.bonigarcia.wdm.WebDriverManager;

public class newSalesOrderWithBackLog {

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
	public static void TS_NewSalesOrderWithBackLog() {
		pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);
		PageObj.tapOnTheHamburgerIcon();
		PageObj.tapOnTheSalesIcon();
		salesOrderPageObjectModal SOObj = new salesOrderPageObjectModal(Driver);
		SOObj.tapOnTheSalesOrderIcon();
		SOObj.tapOnNewSalesOrder();
		SOObj.addTheValidDetailsOfSalesOrder("95000","Testing for the release");
		SOObj.addTallyProduct("P10F190035","5","5.1" ,"6","6");
		SOObj.addHardwareProducts("ASA1003","5");
		SOObj.editHeader();
		SOObj.tapOnEntryCompleteIcon();
		SOObj.tapOnPickAndRelease();
		SOObj.tapOnYesForBacklog ();
//		SOObj.TapOnThePickerDropDownAndSelectPicker();
		SOObj.enterTheProductsThatNeedsToBePicked("1","");
		SOObj.confirmTheProducts();
		SOObj.completePickUp ();
		SOObj.checkPickUp();
		SOObj.enterTheBackOrderReasons();
		SOObj.clickReleaseOrder();
		SOObj.releaseOrder();
	}

	@AfterClass
	public static void tearDown() {
		Driver.quit();
	}
}
