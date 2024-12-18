package pointOfSalesTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.pointOfSalesPageObjectModal;
import io.github.bonigarcia.wdm.WebDriverManager;

public class finishSaleViaGivenBelowCashIcon {

	static WebDriver Driver ;
	static pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);

	@BeforeClass
//		@Parameter("Browser")
	public static void Intializebrowser() {
//			Driver = null;
//					if(Browser .equalsIgnoreCase("Chrome") ) {
//						WebDriverManager.chromedriver().setup();
//						Driver = new ChromeDriver();
//						Driver.manage().window().maximize();	
//					}else if(Browser.equalsIgnoreCase( "Edge")){
		WebDriverManager.edgedriver().setup();
		Driver = new EdgeDriver();
		Driver.get("https://frameworks.bowens.com.au/FWLive/");
		Driver.switchTo().frame(1);
		pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);

//		 please go through the document incase if you are seeing a Old UI or viceversa
		
		PageObj.loginToTheRequiredEnvironment("hallam","3803");
		PageObj.tapOnTheUserIconAndSwitchToClassicFrameworklook();
		PageObj.SwitchToWindow(0);
		Driver.switchTo().frame(1);
		PageObj.loginToTheRequiredEnvironmentForOldClassicLook("hallam","3803");
//					}else {
//						WebDriverManager.firefoxdriver().setup();
//						Driver = new FirefoxDriver();
//						Driver.manage().window().maximize();
//						}
	}

	@Test(priority = 1)
	public static void TS_finishSaleViaGivenBelowCashIcon() {
		pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);
		PageObj.tapOnTheHamburgerIcon();
		PageObj.tapOnTheSalesIcon();
		PageObj.tapOnThePointOfSalesIcon();
		PageObj.enterTheValidOperatorID("686","1234");
		PageObj.enterCustomerID("95000");
		PageObj.enterProductDetails("ASA1003","50","Testing");
		PageObj.tapOnFinishSaleIcon();
		PageObj.selectBelowPayingOption();
		PageObj.tapOnTheCircleIcon();
		PageObj.enterTheValidOperatorID("686","1234");
	}

	@AfterClass
	public static void tearDown() {
		Driver.quit();
	}
}
