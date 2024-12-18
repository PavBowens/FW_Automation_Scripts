package Page;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class salesOrderPageObjectModal {

	static WebDriver Driver;
	public salesOrderPageObjectModal(WebDriver Driver) // We are initiating the Constructor
	{
		salesOrderPageObjectModal.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}

	public void driverWait() //Waits for a second uses thread sleep function
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void longDriverWait() //Waits for a 3 seconds 
	{
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void implicitWait() // implicit wait condition
	{
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	@FindBy(xpath="//td[text()='Sales Orders']")
	WebElement salesOrderIcon; 

	public void tapOnTheSalesOrderIcon() //taps on the sales order icon from the hamburger menu 
	{
		driverWait();
		salesOrderIcon.click();
	}

	@FindBy(xpath="//div[text()='New']")
	WebElement newSalesOrderIcon; 

	public void tapOnNewSalesOrder() //taps on the new icon on the sales order page 
	{
		newSalesOrderIcon.click();
	}

	//locators for the new sales order form 

	@FindBy(xpath="//input[@name='idCustX']")
	WebElement newOrderCustomerID;
	@FindBy(name="custOrderRef")
	WebElement newOrderCustomerReference;
	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[6]")
	WebElement despatchDropDown;
	@FindBy(xpath="//div[text()='ZZPUP - 8. PICKUP FROM SITE']")
	WebElement pickUpFromSiteIcon;
	@FindBy(xpath="(//img[contains(@src,'calendar.png')])[2]")
	WebElement dateRequiredCalendarIcon;
	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[7]")
	WebElement requestedTimeDropDown;
	@FindBy(xpath="//div[text()='1159 - AM any time ( before 12)']")
	WebElement requestedTimeOption;
	@FindBy(xpath="//div[text()='24']")
	WebElement dateIcon;
	@FindBy(xpath="(//img[contains(@src,'search.png')])[4]")
	WebElement addressSearchIcon;
	@FindBy(xpath="//td[text()='Use']")
	WebElement addressSelectionIcon;
	@FindBy(xpath="(//td[text()='Save ('])[2]")
	WebElement newOrderSaveIcon;

	public void addTheValidDetailsOfSalesOrder(String CustomerID , String CustomerRef) //Enter all the details in the New sales order Form
	{
		// TODO Auto-generated method stub
		longDriverWait();
		newOrderCustomerID.sendKeys(CustomerID , Keys.ENTER );driverWait();
		//		newOrderCustomerReference.sendKeys(CustomerRef ,Keys.ENTER);driverWait();(CommentIcon);
		despatchDropDown.click();driverWait();
		pickUpFromSiteIcon.click();driverWait();
		dateRequiredCalendarIcon.click();driverWait();
		dateIcon.click();driverWait();
		requestedTimeDropDown.click();driverWait();
		requestedTimeOption.click();driverWait();
		addressSearchIcon.click();driverWait();
		addressSelectionIcon.click();driverWait();
		newOrderSaveIcon.click();
	}


	//locators for the sales Order Maintenance screen

	@FindBy(name="idProd")
	WebElement productIDIcon;
	@FindBy(name="qtyTran")
	WebElement quantityIcon;
	@FindBy(linkText="EA")
	WebElement UOMIcon;
	@FindBy(xpath="(//img[contains(@src,'checkmark-circle.png')])")
	WebElement tickIcon;
	@FindBy(name="comment")
	WebElement commentsIcon;
	@FindBy(xpath="(//div[text()='Actions'])[1]")
	WebElement actionsIconInHeader;
	@FindBy(xpath="//div[text()='Edit Header']")
	WebElement editHeaderIcon;
	@FindBy(xpath="//div[contains(text(),'Mark as')]")
	WebElement markAsEntryCompletedIcon;
	@FindBy(xpath="//div[text()='Pick & Release']")
	WebElement pickAndReleaseIcon;
	@FindBy(xpath="(//td[text()='Save ('])[3]")
	WebElement SaveIcon;
	@FindBy(xpath="(//img[contains(@src,'calendar.png')])[2]")
	WebElement editHeaderCalendarIcon;
	@FindBy(xpath="(//td[text()='Today'])[1]")
	WebElement todayIcon;

	public void EmptyValue(WebElement Element) {
		try {
			JavascriptExecutor JS = (JavascriptExecutor)Driver;
			JS.executeScript("arguments[0].value='';", Element);}catch(StaleElementReferenceException Exception) {}
	}

	public void addHardwareProducts(String ProdName , String Quantity) // adds the hardware products in the product entry tile
	{
		longDriverWait();driverWait();
		productIDIcon.sendKeys(ProdName , Keys.ENTER);driverWait();
		UOMIcon.click();
		try{driverWait();}catch(StaleElementReferenceException Exception) {}
		EmptyValue(quantityIcon);driverWait();
		quantityIcon.sendKeys(Quantity );driverWait();
		tickIcon.click();
	}

	public void editHeader() //Edits the Header of the sales order maintenance screen only the date required
	{
		longDriverWait();driverWait();
		actionsIconInHeader.click();driverWait();
		editHeaderIcon.click();driverWait();
		try {
		editHeaderCalendarIcon.click();driverWait();} catch (StaleElementReferenceException exp) {}
		todayIcon.click();driverWait();
		SaveIcon.click();
	}

	public void tapOnEntryCompleteIcon() //taps on the Entry complete icon of the header
	{
		longDriverWait();
		actionsIconInHeader.click();driverWait();
		markAsEntryCompletedIcon.click();longDriverWait();
		SaveIcon.click();
	}

	public void webDriverWaitForTheElement(WebElement SearchElement) {
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(100)); 
		wait.until(ExpectedConditions.elementToBeClickable(SearchElement));
	}
	public void tapOnPickAndRelease() //taps on the pick and release icon in the header 
	{
		driverWait();longDriverWait();
		actionsIconInHeader.click();driverWait();
		pickAndReleaseIcon.click();
	}

	//locators for creating the backlog order by yes or no 

	@FindBy(xpath="//div[text()='Yes']")
	WebElement yesForTheBackLogIcon;
	@FindBy(xpath="//div[text()='No']")
	WebElement noForTheBackLogIcon;

	public void tapOnYesForBacklog() //taps on the yes icon to create a back order
	{
		driverWait();
		yesForTheBackLogIcon.click();
	}

	//locator in the pick and release page 
	@FindBy(name="backOrderQty")
	WebElement backOrderQuantityIcon;
	@FindBy(name="pickedQty")
	WebElement pickedQuantityIcon;
	@FindBy(xpath="//div[text()='Complete Picking']")
	WebElement CompletePickUpIcon;
	@FindBy(xpath="//div[text()='Check Picking']")
	WebElement checkPickUpIcon;
	@FindBy(xpath="//td[text()='Save/Close (']")
	WebElement checkPickingSaveIcon;
	@FindBy(xpath="(//img[contains(@src,'calendar.png')])[2]")
	WebElement pickReleaseBackOrderCalendarIcon;
	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[6]")
	WebElement reasonForBackLogdropdown;
	@FindBy(xpath="//div[text()='CUSTOMER - CUSTOMER BACKORDER']")
	WebElement customerBackOrderIcon;
	@FindBy(xpath="(//div[text()='Release Order'])")
	WebElement releaseOrderIcon;
	@FindBy(xpath="(//div[text()='Confirm Order/SMS'])")
	WebElement ConfirmOrderSMSIcon;
	@FindBy(xpath="//td[text()='Confirm Only']")
	WebElement confirmOnlyIcon;
	@FindBy(xpath="(//div[@class='labelAnchor'])[2]")
	WebElement printDocumentCheckBox;
	@FindBy(xpath="//td[text()='Release (']")
	WebElement ReleaseIcon;
	@FindBy(xpath="//div[contains(text(),'ASA1003 ')]")
	WebElement backOrderClickIcon;
	@FindBy(xpath="(//div[text()='P10F190035'])[1]")
	WebElement secondBackOrderProduct;

	public void enterTheProductsThatNeedsToBePicked(String PQ1 , String BQ1 ) //enters the backorder quantity and the pick up quantity
	{
		driverWait();
		backOrderClickIcon.click();driverWait();
		enterBackOrderQuantity(PQ1,BQ1);driverWait();
		secondBackOrderProduct.click();driverWait();
		enterBackOrderQuantity(PQ1,BQ1);
	}

	private void enterBackOrderQuantity(String PQ1, String BQ1) {
		driverWait();
		pickedQuantityIcon.sendKeys(PQ1);driverWait();
		try {
		backOrderQuantityIcon.sendKeys(BQ1);}catch (StaleElementReferenceException e) {
//			backOrderQuantityIcon.sendKeys(BQ1);
		}
	}

	public void completePickUp() //taps on the complete picking icon
	{
		longDriverWait();
		CompletePickUpIcon.click();
	}

	public void checkPickUp() //taps on the checking icon
	{
		longDriverWait();
		checkPickUpIcon.click(); longDriverWait();
		checkPickingSaveIcon.click();
	}
	
	
	public void enterTheBackOrderReasons() //adds the reason in the pick up quantity backorder form
	{
		driverWait();
		pickReleaseBackOrderCalendarIcon.click();driverWait();
		dateIcon.click();driverWait();
		reasonForBackLogdropdown.click();driverWait();
		customerBackOrderIcon.click();driverWait();
		printDocumentCheckBox.click();driverWait();
		SaveIcon.click();
	}


	public void clickReleaseOrder() //Tap on the Release Order
	{
		driverWait();
		releaseOrderIcon.click();
	}

	public void releaseOrder() //fill form and Release 
	{
		longDriverWait();
		printDocumentCheckBox.click();driverWait();
		ReleaseIcon.click();
	}

	public void confirmTheProducts() //Confirms the products in the release screen
	{
		driverWait();
		ConfirmOrderSMSIcon.click();driverWait();
		confirmOnlyIcon.click();driverWait();
		newOrderSaveIcon.click();
	}


	@FindBy(xpath="(//div[@class='labelAnchor'])[3]")
	WebElement printDocumentCheckBoxForNoBackOrder;
	@FindBy(xpath="(//td[@class='cellSelected'])//div[text()='0']")
	WebElement tallyEnterIcon;
	@FindBy(name="tallyQuantity")
	WebElement tallyQuantity;
	@FindBy(name="tallyLength")
	WebElement tallyLength;
	@FindBy(xpath="//td[contains(text(),'Save/Close')]")
	WebElement tallySaveIcon;

	public void addTallyProduct(String ProductName, String Q1 , String L1 ,String Q2 , String L2) 
	{
		
		longDriverWait();driverWait();
		try {
		productIDIcon.sendKeys(ProductName , Keys.ENTER);}catch(StaleElementReferenceException Exp) {}
		driverWait();
//		tallyEnterIcon.click();driverWait();
		tallyQuantity.sendKeys(Q1 ,Keys.ENTER);driverWait();
		tallyLength.sendKeys(L1, Keys.ENTER);driverWait();
		tallyQuantity.sendKeys(Q2 ,Keys.ENTER);driverWait();
		tallyLength.sendKeys(L2, Keys.ENTER);driverWait();
		tallySaveIcon.click();driverWait();
		longDriverWait();
		tickIcon.click();
		
	}


	public void tapOnNoForTheBackLog() {
		longDriverWait();
		noForTheBackLogIcon.click();

	}
	@FindBy(name="instructions")
	WebElement instructionsIcon;
	@FindBy(name="comment1")
	WebElement CommentIcon;
	public void EnterDeliveryInstructionsOrCommentsIfAny(String Instruction, String Comments)
	{
			longDriverWait();driverWait();
			try {
			instructionsIcon.sendKeys(Instruction);driverWait();} catch (StaleElementReferenceException exp) {}
			try{CommentIcon.sendKeys(Comments);} catch (StaleElementReferenceException exp) {}
	}

	public void releaseOrderforNoBackOrder() 
	{
		longDriverWait();
		printDocumentCheckBoxForNoBackOrder.click();driverWait();
		ReleaseIcon.click();
	}
	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[4]")
	WebElement quoteOrOrderSelectionIcon;
	@FindBy(xpath="//div[text()='Quote']")
	WebElement quoteIcon;
	public void SelectQuotes() 
	{
		
		driverWait();
		quoteOrOrderSelectionIcon.click();driverWait();
		quoteIcon.click();
	}
	@FindBy(xpath="//div[text()='Accept Quote']")
	WebElement acceptQuoteIcon;
	@FindBy(xpath="(//div[@class='labelAnchor'])[2]")
	WebElement acceptThisQuoteIcon;


	public void acceptQuote() {
		longDriverWait();
		driverWait();
		actionsIconInHeader.click();driverWait();
		acceptQuoteIcon.click();driverWait();
		acceptThisQuoteIcon.click();driverWait();
		SaveIcon.click();
	}


	@FindBy(xpath="//div[contains(text(),'Entry Not Completed')]")
	WebElement entryNotCompleteIcon;

	@FindBy(xpath="//td[text()='OK (']")
	WebElement OKIcon;

	public void tapOnEntryNotCompletedIcon() {
		driverWait();
		entryNotCompleteIcon.click();driverWait();
		OKIcon.click();

	}

	@FindBy(xpath="(//div[@class='labelAnchor'])[2]")
	WebElement printDocumentUncheckIconforPO;

	public void releaseOrderforBackOrderForPurchaseOrder() {
		// TODO Auto-generated method stub
		longDriverWait();
		printDocumentUncheckIconforPO.click();driverWait();
		ReleaseIcon.click();
	}

	@FindBy(xpath="(//div[text()='Yes'])[2]")
	WebElement yesForTheBackLogIconForPO;
	@FindBy(xpath="(//div[text()='No'])[2]")
	WebElement noForTheBackLogIconForPO;
	public void tapOnNoForTheBackLogForPO() {
		// TODO Auto-generated method stub
		longDriverWait();
		noForTheBackLogIconForPO.click();

	}


	@FindBy(xpath="//div[text()='Update Date/Time']")
	WebElement updateDateAndTime;
	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[3]")
	WebElement requestedTimDropwnInReleaseScreen;
	@FindBy(xpath="//td[contains(text(),'Apply')]")
	WebElement applyIcon;
	@FindBy(xpath="//td[text()='es - Discard changes']")
	WebElement yesDiscardChanges;
	public void updateDateAndTime() {
		// TODO Auto-generated method stub
		longDriverWait();
		updateDateAndTime.click();
		driverWait();
		requestedTimDropwnInReleaseScreen.click();
		driverWait();
		requestedTimeOption.click();driverWait();
		applyIcon.click();
		//		yesDiscardChanges.click();

	}
	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[5]")
	WebElement reasonForBackLogdropdownForPO;
	@FindBy(xpath="(//div[@class='labelAnchor'])[1]")
	WebElement printDocumentCheckBoxForPO;

	public void enterTheBackOrderReasonsForPOc() {
		// TODO Auto-generated method stub
		longDriverWait();
		pickReleaseBackOrderCalendarIcon.click();driverWait();
		dateIcon.click();driverWait();
		reasonForBackLogdropdownForPO.click();driverWait();
		customerBackOrderIcon.click();driverWait();
		printDocumentCheckBoxForPO.click();driverWait();
		SaveIcon.click();
	}

	public void releaseOrderforYesBackOrderForPurchaseOrder() {
		longDriverWait();
		printDocumentCheckBoxForPO.click();driverWait();
		ReleaseIcon.click();
	}

	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[4]")
	WebElement dropdownForPicker;
	@FindBy(xpath="//div[text()='Maggie G']")
	WebElement optionForPicker;
	public void TapOnThePickerDropDownAndSelectPicker() {
		longDriverWait();driverWait();
		dropdownForPicker.click();driverWait();
		optionForPicker.click();driverWait();
	}

	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[3]")
	WebElement dropdownForPickerForPO;
	@FindBy(xpath="//div[text()='Ryan Gaff']")
	WebElement optionForPickerForPO;
	public void TapOnThePickerDropDownAndSelectPickerForPO() {
		longDriverWait();driverWait();
		dropdownForPickerForPO.click();driverWait();
		optionForPickerForPO.click();driverWait();
	}



}
