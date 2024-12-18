package creditNoteTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.CreditNotesPageObjectModel;
import Page.pointOfSalesPageObjectModal;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createNewCreditNoteForOverCharge {

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
		PageObj.driverWait();
		Driver.switchTo().frame(1);
		pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);

//		 please go through the document incase if you are seeing a Old UI or viceversa
		 
		PageObj.loginToTheRequiredEnvironment("pavithra","Pradha@321");
		PageObj.tapOnTheUserIconAndSwitchToClassicFrameworklook();
		PageObj.SwitchToWindow(0);
		PageObj.driverWait();
		Driver.switchTo().frame(1);
		PageObj.loginToTheRequiredEnvironmentForOldClassicLook("pavithra","Pradha@321");
		//			}else {
		//				WebDriverManager.firefoxdriver().setup();
		//				Driver = new FirefoxDriver();
		//				Driver.manage().window().maximize();
		//				}
	}

	@Test
	public static void TS_createNewCreditNoteForOverCharge() {
		pointOfSalesPageObjectModal PageObj = new pointOfSalesPageObjectModal(Driver);
		PageObj.tapOnTheHamburgerIcon();
		PageObj.tapOnTheSalesIcon();
		CreditNotesPageObjectModel CredObj = new CreditNotesPageObjectModel(Driver);
		CredObj.tapOnCreditNoteIcon();
		CredObj.tapOnNewCreditIcon();
		CredObj.enterTheCustomerId("444142");
		CredObj.selectTheReturnType();
		CredObj.selectOverChargeOption();
		CredObj.selectReasonDropDown();
		CredObj.selectTheReasonForOvercharge();
		CredObj.selectTheDocketNumberforOverCharge();
		CredObj.loadDetailsOfTheDocket();
		CredObj.tapOnRefundAllIcon();
		CredObj.enterTheDespatchDetails();
		CredObj.tapOnFinishTheCredit();
		CredObj.tapOnRefundIconViaCash();
	}

	@AfterClass
	public static void tearDown() {
//		Driver.quit();
	}
}
