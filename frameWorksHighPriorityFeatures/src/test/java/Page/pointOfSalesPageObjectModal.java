package Page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class pointOfSalesPageObjectModal {

	static WebDriver Driver;
	public pointOfSalesPageObjectModal(WebDriver Driver) // We are initiating the Constructor
	{
		pointOfSalesPageObjectModal.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}

	@FindBy(xpath="//input[@value='Demo Login']")
	WebElement demoLogin; //Element to tap on the Demo login
	@FindBy(xpath="//input[@value='Train Login']")
	WebElement trainLogin; //Element to tap on the train login
	@FindBy(xpath="//input[@value='Test Login']")
	WebElement testLogin; //Element to tap on the test login

	public void demoLogin() {
		//Tap on the Demo Login
		driverWait();
		WebDriverWaitForElement(demoLogin);
		demoLogin.click();
	}
	public void trainLogin() {
		//Tap on the Train Icon
		driverWait();
		WebDriverWaitForElement(trainLogin);
		trainLogin.click();
	}
	public void testLogin() {
		//Tap on the test Icon
		WebDriverWaitForElement(testLogin);
		testLogin.click();
	}

	@FindBy(id="userid")
	WebElement loginUserId;
	@FindBy(id="password")
	WebElement loginPassword;
	@FindBy(xpath="//a[contains(text(),'LOGIN')]")
	WebElement loginIcon;

	//Login to the Expected Environment 
	public void loginToTheRequiredEnvironment(String UserId, String Password) {
		demoLogin();
//		trainLogin();
		SwitchToWindow(1);
		WebDriverWaitForElement(loginUserId);
		loginUserId.sendKeys(UserId);
		WebDriverWaitForElement(loginPassword);
		loginPassword.sendKeys(Password);
		WebDriverWaitForElement(loginIcon);
		loginIcon.click();
		SwitchToWindow(1);
	}
	//Switch to the expected window
	public void SwitchToWindow(int Index) {
		Set<String> windowHandles = Driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
//		System.out.println(windowHandlesList);
		Driver.switchTo().window(windowHandlesList.get(Index));
	}

	@FindBy(name="isc_Amain")
	WebElement hamburgerMenu;
	@FindBy(xpath="//b[text()='Transaction Processing']")
	WebElement transactionProcessingIcon;
	@FindBy(xpath="//td[text()='Point Of Sale']")
	WebElement pointOfSalesIcon;

	public void driverWait() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void implicitWait() {
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	public void tapOnTheHamburgerIcon() {
		implicitWait();
		hamburgerMenu.click(); // Taps on the hamburger Icon
	}

	public void tapOnTheSalesIcon() {
		implicitWait();
		transactionProcessingIcon.click(); //Taps on the transaction processing
	}

	public void tapOnThePointOfSalesIcon() {
		driverWait();
		pointOfSalesIcon.click(); //Taps on the point of sales
	}

	@FindBy(name="operatorId")
	WebElement operatorNumber;
	@FindBy(name="pin")
	WebElement pinPassword;
	@FindBy(xpath="//div[text()='OK']")
	WebElement pinLoginIcon;

	public void enterTheValidOperatorID(String Pin , String Password) {
//		driverWait();
		try {
		WebDriverWaitForElement(operatorNumber);}catch(StaleElementReferenceException Exp) {}
		operatorNumber.sendKeys(Pin);
		pinPassword.sendKeys(Password);
		pinLoginIcon.click();
	}

	@FindBy(name ="customerIdX")
	WebElement customerID;
	public void enterCustomerID(String CustomerID) {
		// TODO Auto-generated method stub
		try{WebDriverWaitForElement(customerID);}catch(StaleElementReferenceException Exp) {}
		customerID.sendKeys(CustomerID,Keys.ENTER);
	}
	@FindBy(name="prodId")
	WebElement productID;
	@FindBy(name="quantityOrdered")
	WebElement quantityIcon;
	@FindBy(xpath="//a[contains(text(),'EA')]")
	WebElement UOMIcon;
	@FindBy(xpath="//img[contains(@src,'checkmark-circle.png')]")
	WebElement tickIcon;
	@FindBy(name="comment")
	WebElement commentIcon;

	public void enterProductDetails(String ProductID , String Quantity ,String Comment) {
		// TODO Auto-generated method stub
		driverWait();
		productID.sendKeys(ProductID,Keys.ENTER);driverWait();
		UOMIcon.click();driverWait();
		quantityIcon.sendKeys(Quantity);driverWait();
		commentIcon.sendKeys(Comment);
		tickIcon.click();

	}
	@FindBy(xpath="//div[text()='ACCOUNT (']")
	WebElement QuickAccountIcon;
	public void TapOnQuickAccount() {
		driverWait();
		QuickAccountIcon.click();
	}
	@FindBy(xpath="//td[text()='Delivery Details']")
	WebElement deliveryDetailsTab;
	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[1]")
	WebElement despatchDropDown;
	@FindBy(xpath="//div[text()='PUPEX - 3. EXPRESS PICK UP']")
	WebElement expressPickUpDespatch;
	@FindBy(xpath="(//img[contains(@src,'calendar.png')])[1]")
	WebElement deliverydateCalendar;
	@FindBy(xpath="//div[text()='22']")
	WebElement deliverydateOption;
	@FindBy(xpath="//td[text()='Product Entry']")
	WebElement productEntryTab;

	public void enterDeliveryDetails() {
		driverWait();
		deliveryDetailsTab.click();
		despatchDropDown.click();
		expressPickUpDespatch.click();
		driverWait();
		deliverydateCalendar.click();
		deliverydateOption.click();
		productEntryTab.click();
	}

	@FindBy(xpath="//div[text()='EFTPOS (']")
	WebElement EFTPOSIcon; //quick EFTPOS icon

	public void tapOnQuickEFTPOS() {
		EFTPOSIcon.click();
	}

	@FindBy(xpath="(//img[contains(@src,'checkmark-circle.png')])[2]")
	WebElement EFTPOSTickIcon; //Eftpos tick icon

	public void tapOnTheCircleIcon() {
		EFTPOSTickIcon.click();  //clicks the checkmark of the EFTPOS icon
	}


	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[1]")
	WebElement paymentOptionSelection; //Payment selection Dropdown
	@FindBy(xpath="//div[text()='Finish']")
	WebElement finishSale;  //finish sale icon 
	@FindBy(xpath="//div[text()='Cash']")
	WebElement CashPayOption; //Cash option in the finish sale page

	//Performs the Finish Sale via cash
	public void tapOnFinishSaleIcon() {
		driverWait();
		finishSale.click(); //Tap on the Finish sale Icon 
	}

	//selecting cash option for the payment method
	public void selectCashOption() {
		paymentOptionSelection.click(); //Taps on the dropdown of the payment option
		CashPayOption.click(); //Selects the payment Option
	}

	@FindBy(xpath="//div[text()='Pay']")
	WebElement payIcon;//Taps on the Pay Icon of the sale finish page
	public void tapOnPayIcon() {
		payIcon.click(); 

	}
	@FindBy(xpath="(//div[text()='Cheque'])[2]")
	WebElement chequeIconFromDropDown;

	//selects the cheque payment option
	public void selectChequeOption() {
		paymentOptionSelection.click(); //Taps on the dropdown of the payment option
		chequeIconFromDropDown.click();
	}

	@FindBy(name="bankName")
	WebElement chequeBankName;
	@FindBy(name="branchName")
	WebElement chequeBranchName;
	@FindBy(name="drawerName")
	WebElement chequeDrawerName;
	@FindBy(name="refTender")
	WebElement chequeNumber;
	@FindBy(xpath="//td[text()='Save (']")
	WebElement chequeSaveIcon;

	//Enters the cheque details
	public void enterChequeDetails(String bankName ,String branchName ,String drawerName ,String Number) {
		// enters the bank , branch , drawer name etc
		driverWait();
		chequeBankName.sendKeys(bankName);
		chequeBranchName.sendKeys(branchName);
		chequeDrawerName.sendKeys(drawerName);
		chequeNumber.sendKeys(Number);
		chequeSaveIcon.click();
	}

	@FindBy(xpath="(//div[text()='EFTPOS'])[2]")
	WebElement EFTPOSIconfromDropDown;
	//selects EFTPOS payment options
	public void tapOnEFTPOSOption() {
		// TODO Auto-generated method stub
		paymentOptionSelection.click();
		EFTPOSIconfromDropDown.click();
	}
	@FindBy(xpath="//div[text()='Bowens Gift Voucher']")
	WebElement bowensGiftCardVouchers;

	public void tapOnBowensGiftVouchers() {
		// TODO Auto-generated method stub
		paymentOptionSelection.click();
		bowensGiftCardVouchers.click();
	}

	@FindBy(name="memberName")
	WebElement bowensCardName;
	@FindBy(name="memberNumber")
	WebElement bowensCardNumber;
	public void enterBowensGiftCardNumber(String Name ,String Number) {
		// Enters the bowens gift card details
	try {
		WebDriverWaitForElement(bowensCardName);}catch(StaleElementReferenceException Exp) {}
	try {bowensCardName.sendKeys(Name);}catch(StaleElementReferenceException Exp) {}
		bowensCardNumber.sendKeys(Number);
	}
	@FindBy(xpath="//div[text()='Charge']")
	WebElement chargeIcon;

	public void tapOnChargeIcon() {
		// Tap on the Charge Icon 
		chargeIcon.click();
	}

	@FindBy(xpath="//div[text()='Credit Balance']")
	WebElement creditBalanceIcon;

	public void tapOnTheCreditBalance() {
		// Taps on the Credit Balance Icon
		paymentOptionSelection.click();
		creditBalanceIcon.click();
	}

	@FindBy(xpath="//div[text()='$5 Cash']")
	WebElement DollarCashIcon5;
	@FindBy(xpath="//div[text()='$10 Cash']")
	WebElement DollarCashIcon10;
	@FindBy(xpath="//div[text()='$20 Cash']")
	WebElement DollarCashIcon20;
	@FindBy(xpath="//div[text()='$50 Cash']")
	WebElement DollarCashIcon50;
	@FindBy(xpath="//div[text()='$100 Cash']")
	WebElement DollarCashIcon100;
	@FindBy(xpath="//div[text()='EFTPOS']")
	WebElement EFTPOSIconInBottom;

	public void selectBelowPayingOption() {
		// TODO Auto-generated method stub
		driverWait();
		DollarCashIcon5.click();driverWait();
		DollarCashIcon10.click();driverWait();
		DollarCashIcon20.click();driverWait();
		DollarCashIcon50.click();driverWait();
		DollarCashIcon100.click();driverWait();
		EFTPOSIconInBottom.click();driverWait();
	}
	@FindBy(xpath="(//td[@class='toolsMenuButton'])[2]")
	WebElement userIDIcon;
	@FindBy(xpath="//div[contains(text(),'Switch')]")
	WebElement switchToOldLookIcon;

	public void tapOnTheUserIconAndSwitchToClassicFrameworklook() {
		WebDriverWaitForElement(userIDIcon);
		userIDIcon.click();
		WebDriverWaitForElement(switchToOldLookIcon);
		switchToOldLookIcon.click();
		SwitchToWindow(0);Driver.close();
		
	}

	public void WebDriverWaitForElement (WebElement SearchElement){
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(60)); 
		wait.until(ExpectedConditions.elementToBeClickable(SearchElement));
//		driverWait();
	}
	public void loginToTheRequiredEnvironmentForOldClassicLook(String UserId, String Password) {
//		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(60)); 
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[@class='toolsMenuButton']")));
		demoLogin();
//		trainLogin();
		SwitchToWindow(1);
		WebDriverWaitForElement(loginUserId);
		loginUserId.sendKeys(UserId);
		WebDriverWaitForElement(loginPassword);
		loginPassword.sendKeys(Password);
		WebDriverWaitForElement(loginIcon);
		loginIcon.click();
		SwitchToWindow(0);
		
	}




}
