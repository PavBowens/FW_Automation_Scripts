package Page;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class purchaseOrderPageObjectModel {

	public static final String filterTheSupplier = null;
	static WebDriver Driver;

	public purchaseOrderPageObjectModel(WebDriver Driver) //constructor
	{
		purchaseOrderPageObjectModel.Driver = Driver ;
		PageFactory.initElements(Driver,this);
	}

	//locators to navigate to the purchase order processing
	@FindBy(xpath= "//b[text()='Purchasing & Receipting']")
	WebElement purchasingAndReceiptingIcon;
	@FindBy(xpath= "(//b[text()='Transaction Processing'])[2]")
	WebElement transactionAndProcessingIcon;
	@FindBy(xpath="//td[text()='Purchase Orders']")
	WebElement purchaseOrderIcon;

	private void driverWait() //WebDriver waits for .5 seconds
	{
		try {
			Thread.sleep(500);
		}catch (InterruptedException e) {}
	}

	private void longDriverWait() //WebDriver waits for 2.5 seconds
	{
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tapOnPurchaseAndReceipting() //taps on the purchase and receipting icon  
	{
		driverWait();
		purchasingAndReceiptingIcon.click();
	}

	public void tapOnTransactionProcessingIcon() //taps on the
	{
		driverWait();
		transactionAndProcessingIcon.click();
	}

	public void tapOnThePurchaseOrderIcon() {
		driverWait();
		purchaseOrderIcon.click();
	}

	@FindBy(xpath="(//div[text()='New'])[1]")
	WebElement newPurchaseOrder;
	@FindBy(name="idSupp")
	WebElement supplierId;
	@FindBy(xpath="(//img[contains(@src,'calendar.png')])[2]")
	WebElement deliveryDateCalendarIcon;
	@FindBy(xpath="//td[text()='Today']")
	WebElement deliveryDate;
	@FindBy(xpath="(//td[text()='Save ('])[2]")
	WebElement secondWindowSaveIcon;
	@FindBy(xpath="(//td[text()='Save ('])[3]")
	WebElement thirdWindowSaveIcon;

	public void tapOnNewPurchaseOrder() {
		driverWait();
		newPurchaseOrder.click();
	}

	public void enterTheValidDetailsInThePurchaseOrderForm(String supplierName) 
	{
		longDriverWait();
		supplierId.sendKeys(supplierName , Keys.ENTER);driverWait();
		deliveryDateCalendarIcon.click();driverWait();
		deliveryDate.click();driverWait();
		secondWindowSaveIcon.click();driverWait(); 
	}

	@FindBy(xpath="(//td[@class='tabButtonTop']//span)[3]")
	WebElement PONumber1;

	public String getPONumber() {
		driverWait();
		String purchaseOrder = PONumber1.getText();driverWait();
		String inputString = purchaseOrder.trim();driverWait();
		String Value = inputString.replaceAll("[^0-9]", "");driverWait();
		int OrderNumber = Integer.parseInt(Value);driverWait();
		String PONumber = String.valueOf(OrderNumber);driverWait();
		return PONumber;
	}

	@FindBy(xpath="//div[text()='Actions']")
	WebElement actionsIcon;
	@FindBy(xpath="//div[text()='Save Order']")
	WebElement saveOrderIcon;

	public void tapOnHeaderAndSaveThePurchaseOrder() {
		longDriverWait();
		actionsIcon.click();driverWait();
		saveOrderIcon.click();driverWait();
	}

	@FindBy(xpath="//img[contains(@src,'arrow_right.png')]")
	WebElement calendarNextMonthIcon;
	@FindBy(xpath="//div[text()='24']")
	WebElement dateInNextMonth;
	@FindBy(xpath="//div[text()='Edit Header']")
	WebElement editHeaderIcon;
	public void editHeader()
	{
		longDriverWait();
		actionsIcon.click();driverWait();
		editHeaderIcon.click();longDriverWait();
		deliveryDateCalendarIcon.click();driverWait();
		calendarNextMonthIcon.click();driverWait();
		dateInNextMonth.click();driverWait();
		thirdWindowSaveIcon.click();
	}

	@FindBy(xpath="//td[text()='Stock Receipting']")
	WebElement stockReceipting;
	@FindBy(xpath="(//input[@name='orderNo'])[2]")
	WebElement stockOrderNumberTab;
	@FindBy(xpath="(//div[text()='Find'])[2]")
	WebElement findIcon;

	@FindBy(name="isc_Amain")
	WebElement hamburgerMenu;

	public void tapOnTheHamburgerIcon() {
		driverWait();
		hamburgerMenu.click();
	}

	public void tapOnStockReceipting() {
		driverWait();
		stockReceipting.click();
	}

	public void checkIfThePurchaseOrderIsBeingShownInStockReceiptingPage(String PONumber) {
		longDriverWait();driverWait();driverWait();
		stockOrderNumberTab.sendKeys( PONumber, Keys.ENTER );driverWait();
		verifyThePoNumber(PONumber);driverWait();
	}
	@FindBy(xpath="(//td[@class='cellSelected']//a)[1]")
	WebElement verifyingElement;

	private void verifyThePoNumber(String PONumber) 
	{
		String ActualPONumber = PONumber;
		String ExpectedPONumber = verifyingElement.getText();
		Assert.assertEquals (ActualPONumber, ExpectedPONumber);
	}

	@FindBy(xpath="(//td[@class='tabButtonTop'])[2]")
	WebElement purchaseOrderTab;
	@FindBy(name="orderNo")
	WebElement purchaseOrderFilterIcon;
	@FindBy (xpath="(//td[@class='cellSelected']//a)[1]")
	WebElement purchaseOrderLink;
	@FindBy (xpath="//a[contains(text(),'Tfer SO')]")
	WebElement transferSOVerifyingElement;
	public void navigateBackToPurchaseOrder(String PONumber1) {
		longDriverWait();
		purchaseOrderTab.click();driverWait();
		purchaseOrderFilterIcon.sendKeys(PONumber1 ,Keys.ENTER);longDriverWait();
//		verifyThePoNumber(PONumber1);
		PONumberTabSelection.click();driverWait();

	}

	public void verifyIfTransferIconIsPresent() {
		try {
		Boolean Element = transferSOVerifyingElement.isDisplayed(); 
		Assert.assertTrue(Element);}catch(StaleElementReferenceException Exp) {}
	}
	
	@FindBy(xpath="(//td[@class='tabButtonTop']//span)[3]")
	WebElement PONumber2;
	@FindBy(xpath="(//td[@class='tabButtonTop']//span)[2]")
	WebElement PONumberTabSelection;
	public String getPONumber1() {
		String purchaseOrder = PONumber2.getText();
		String inputString = purchaseOrder.trim();
		String Value = inputString.replaceAll("[^0-9]", "");
		int OrderNumber = Integer.parseInt(Value);
		String PONumber1 = String.valueOf(OrderNumber);
		return PONumber1;
	}
	@FindBy(xpath="//div[text()='Finalise Transfer']")
	WebElement finaliseTransferIcon;
	
	public void webDriverWaitForTheElement(WebElement SearchElement) {
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30)); 
		wait.until(ExpectedConditions.elementToBeClickable(SearchElement));
	}
	
	@FindBy(xpath="//span[contains(text(),'PO')]")
	WebElement purchaseOrderMaintananceTab;
	public void finaliseTransfer() {
		longDriverWait();
		purchaseOrderMaintananceTab.click();
		driverWait();
		actionsIcon.click();driverWait();
		finaliseTransferIcon.click();driverWait();
	try {printPickingSlipCheckbox.click();}catch (StaleElementReferenceException e) {
		// TODO: handle exception
	}

	}

	public void tapOnTransferToSOOrder() {
		driverWait();
		transferSOVerifyingElement.click();

	}
	@FindBy(xpath="(//div[text()='Actions'])[2]")
	WebElement internalSalesOrderActionIcon;

	public void tapOnActionsInTheSalesOrderIcon() {
		// TODO Auto-generated method stub
		internalSalesOrderActionIcon.click();
	}

	@FindBy(xpath="(//div[@class='labelAnchor']//span)[3]")
	WebElement printPickingSlipCheckbox;
	public void addAssigneeDescriptionAndTapOnSave() {
//		driverWait();
//		selectAssignee("Test");driverWait();
//		addDescription("Testing Do Not Proceed");
		driverWait();
		tapOnSaveIcon();driverWait();


	}

	@FindBy(xpath="(//td[text()='Save ('])[3]")
	WebElement transferFinaliseSaveIcon;
	public void tapOnSaveIcon() {
		driverWait();
		transferFinaliseSaveIcon.click();
	}

	@FindBy(name="descDeliv")
	WebElement transferDescriptionIcon;
	private void addDescription(String Text) 
	{
		driverWait();
		transferDescriptionIcon.sendKeys(Text);

	}

	@FindBy(xpath="(//img[contains(@src,'pencil.png')])[4]")
	WebElement assigneePencilIcon;
	@FindBy(name="diaryNote")
	WebElement dairyNoteIcon;
	@FindBy(xpath="(//td[text()='Save ('])[4]")
	WebElement assigneeSaveIcon;


	private void selectAssignee(String Text) {
		longDriverWait();
		assigneePencilIcon.click();driverWait();
		try {
		dairyNoteIcon.sendKeys(Text);driverWait();
		}catch(StaleElementReferenceException Exp) {}
		assigneeSaveIcon.click();driverWait();
	}
	//Taps on the Advanced Icon
	@FindBy(xpath="//div[text()='Advanced']")
	WebElement advancedIcon;
	@FindBy(name="orderStatus$148l")
	WebElement statusFilterTab;
	@FindBy(xpath="//div[text()='New']")
	WebElement newIcon;

	public void tapOnAdvancedIcon() {
		driverWait();
		advancedIcon.click();
	}

	public void filterTheStatusAsNew() {
		longDriverWait();longDriverWait();longDriverWait();longDriverWait();
		statusFilterTab.sendKeys("new");

	}
	@FindBy(name="purchaseOrderType$148l")
	WebElement  typefilterTab;

	public void filterTheTypeAsPurchaseOrder() {
		driverWait();
		typefilterTab.sendKeys("purchase order");

	}
	@FindBy(name="supplierName$148l")
	WebElement supplierFilterTab;
	public void selectThePurchaseOrderID() {
		driverWait();
		filteredPurchaseOrder.click();
	}
	@FindBy(xpath="(//td[@class='cell']//a[contains(text(),'5')])[1]")
	WebElement filteredPurchaseOrder;
	@FindBy(xpath="//div[text()='Find']")
	WebElement FindIcon;
	public void tapOnFindIcon() {
		longDriverWait();
		FindIcon.click();
	}

	public void filterTheSupplier(String supplierName) {
		driverWait();
		supplierFilterTab.sendKeys(supplierName);
	}

	@FindBy(name="refSuppDocket")
	WebElement docketNumber;
	@FindBy(xpath="//div[text()='Receive All']")
	WebElement receiveAllGoods;
	@FindBy(xpath="//div[text()='Clear All']")
	WebElement clearAllIcon;
	@FindBy(xpath="//div[text()='Receipt Goods']")
	WebElement receiptGoods;
	@FindBy(xpath="//div[text()='Rapid Entry']")
	WebElement rapidEntryInReceiptingPage;
	@FindBy(name="idProdEntered")
	WebElement productInTheReciptingPage;
	@FindBy(name="qtyTran")
	WebElement quantityInReceiptingPage;
	@FindBy(xpath="(//td[@class='cellSelected']//div[text()='0.0000'])")
	WebElement rapidEntryProductClickIcon;


	public void rapidEntryProducts(String ProductID, String Quantity) {
		longDriverWait();
		rapidEntryInReceiptingPage.click(); driverWait();
		rapidEntryProductClickIcon.click(); driverWait();
		productInTheReciptingPage.sendKeys(ProductID, Keys.ENTER);driverWait();
		quantityInReceiptingPage.sendKeys(Quantity, Keys.ENTER);driverWait();
		thirdWindowSaveIcon.click();driverWait();
	}

	public void tapOnReceiveAllIcon() {
			driverWait();
			receiveAllGoods.click();

	}
	public void clearAllProductsAndReceiveGoods() {
		driverWait();
		clearAllIcon.click();driverWait();
		receiveAllGoods.click();driverWait();
	}


	public void enterDocketNumber(String docketNumber1) {
		driverWait();
		docketNumber.sendKeys(docketNumber1);
	}

	public void tapOnReceiptGoods() {
		driverWait();
		receiptGoods.click();
	}
	@FindBy(xpath="(//td[@class='headerButton'])[10]")
	WebElement invoiceFilterHeaderButton;

	public void tapOnTheInvoicedFilterHeader() {
		longDriverWait();
		invoiceFilterHeaderButton.click();
	}

	@FindBy(xpath="(//img[contains(@src,'close.png')])[1]")
	WebElement closeIcon1;
	@FindBy(xpath="(//img[contains(@src,'close.png')])[2]")
	WebElement closeIcon;
	
	public void closeThePurchaseOrderIcon() {
		// TODO Auto-generated method stub
		longDriverWait();
		closeIcon.click();driverWait();
		closeIcon.click();driverWait();
		
	}

	public void closeFirstTab() {
		driverWait();
		closeIcon1.click();
	}

	public void tapOnThePurchaseOrderTab() {
		longDriverWait();
		purchaseOrderTab.click();driverWait();
	}
	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[2]")
	WebElement BranchDropDownIcon;
	@FindBy(xpath="(//div[contains(text(),'21 - TRAINING BRANCH 021')])")
	WebElement AllBranchIcon;

	public void tapOnAllBranches() {
		longDriverWait();
		BranchDropDownIcon.click();
		driverWait();
		MoveToTargetElement(AllBranchIcon);
		
	}

	public void MoveToTargetElement(WebElement Element) {
		Actions actions = new Actions(Driver);driverWait();
		actions.moveToElement(Element).click().build().perform();
	}




}


