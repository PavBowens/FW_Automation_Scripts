package Page;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CustomerPaymentsPageObjectModal {

	static WebDriver Driver;

	public CustomerPaymentsPageObjectModal(WebDriver Driver) //Constructor 
	{
		CustomerPaymentsPageObjectModal.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}

	public void WaitForTheElementToBeClickable(WebElement Element) 
	{
		WebDriverWait wait = new WebDriverWait(Driver,Duration.ofSeconds(60)); 
		try{wait.until(ExpectedConditions.elementToBeClickable(Element));}catch(StaleElementReferenceException exp) {}	
	}
	//	Locator 

	@FindBy(name="isc_Bmain")
	WebElement HamburgerMenu; 

	//	Action
	public void TapOnTheHamburgerMenu() {
		WaitForTheElementToBeClickable(HamburgerMenu);
		HamburgerMenu.click();
	}
	//	Locator 

	@FindBy(xpath="//b[normalize-space(text())='Receivables']")
	WebElement ReceivablesIcon;

	//	Action

	public void TapOnRecievablesIcon() {
		WaitForTheElementToBeClickable(ReceivablesIcon);
		ReceivablesIcon.click();
	}
	//	Locator 

	@FindBy(xpath="(//b[normalize-space(text())='Transaction Processing'])[2]")
	WebElement TransactionProcessingIcon;

	//	Action

	public void TapOnTheTransactionProcessingIcon() {
		WaitForTheElementToBeClickable(TransactionProcessingIcon);
		TransactionProcessingIcon.click();
	}

	//	Locator 
	@FindBy(xpath="//td[normalize-space(text())='Customer Payments']")
	WebElement CustomerPaymentIcon;
	//	Action
	public void TapOnTheCustomerPaymentIcon() {
		WaitForTheElementToBeClickable(CustomerPaymentIcon);
		CustomerPaymentIcon.click();
	}

	//	Locator 
	@FindBy(name="idCustX")
	WebElement CustomerNumberField;
	//	Action
	public void EnterTheCustomerNumber(String Text) {
		WaitForTheElementToBeClickable(CustomerNumberField);
		CustomerNumberField.sendKeys(Text, Keys.ENTER); }

	//	Locator 
	@FindBy(xpath="//td[normalize-space(text())='Find']")
	WebElement FindIcon;
	//	Action
	public void TapOnTheFindIcon() {
		WaitForTheElementToBeClickable(FindIcon);
		FindIcon.click();
	}




	@FindBy(xpath="(//div[text()='95000'])[1]")
	WebElement CustomerFilterTable;

	public boolean getElementFiltered() {
		WaitForTheElementToBeClickable(CustomerFilterTable);
		return CustomerFilterTable.isDisplayed();
	}

	@FindBy(xpath="(//a[contains(text(),'388')])[1]")
	WebElement InvoiceNumber;

	public void TapOnAnyOneOfTheInvoices() {
		WaitForTheElementToBeClickable(InvoiceNumber);
		InvoiceNumber.click();

	}

	public void clearCustomerNumber() {
		WaitForTheElementToBeClickable(CustomerNumberField);
		CustomerNumberField.clear();
	}

	public void TakeScreenShotAndVerifyThePageAfterSelectingPayment()  {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File screenshot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./src/CustomerPayment/CustomerPaymentScreen.png");
		try {
			FileUtils.copyFile(screenshot , destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FindBy(xpath="//div[normalize-space(text())='Add New']")
	WebElement AddNewIcon;

	public void TapOnAddNewIcon() 
	{
		WaitForTheElementToBeClickable(AddNewIcon);
		AddNewIcon.click();
	}

	@FindBy(xpath="(//input[@name='numTranX'])")
	WebElement TransactionsNumber;

	public void EnterTransactionNumber(String Text) { 
		try {
			WaitForTheElementToBeClickable(TransactionsNumber);}catch(StaleElementReferenceException Exp) {}
		TransactionsNumber.sendKeys(Text , Keys.ENTER);	
	}
	@FindBy(xpath="(//td[(text()='Close (')])[2]")
	WebElement CloseIcon;
	@FindBy(xpath="//u[text()='N']")
	WebElement NoDontClose;
	@FindBy(xpath="//td[contains(text(),'Close View')]")
	WebElement YesClose;

	public void CloseTheTab() {
		WaitForTheElementToBeClickable(CloseIcon);
		CloseIcon.click();
		WaitForTheElementToBeClickable(NoDontClose);
		NoDontClose.click();
		WaitForTheElementToBeClickable(CloseIcon);
		CloseIcon.click();
		WaitForTheElementToBeClickable(YesClose);
		YesClose.click();
	}
	@FindBy(xpath="(//img[contains(@src,'search_icon.png')])[3]")
	WebElement TransctionsSearchIcon;

	public void TapOntheSearchIcon() {
		WaitForTheElementToBeClickable(TransctionsSearchIcon);
		TransctionsSearchIcon.click();
	}
	@FindBy(xpath="//td[normalize-space(text())='Use']")
	WebElement UseIcon;

	@FindBy(xpath="//td[text()='Save/Close (']")
	WebElement SaveIcon;

	public void SelectTheTransactionNumber() {
		WaitForTheElementToBeClickable(UseIcon);
		UseIcon.click();
	}

	public void TapOnSaveIcon() {
		WaitForTheElementToBeClickable(SaveIcon);
		SaveIcon.click();
	}
	@FindBy(xpath="(//td[@class='cellSelected']//a)[1]")
	WebElement AdjustmentTrans;
	public String getTheTransactionNumber() {
		WaitForTheElementToBeClickable(AdjustmentTrans);
		return AdjustmentTrans.getText();
	}
	@FindBy(xpath="(//td[@class='cellSelected']//div)[4]")
	WebElement ActualAdjustmentTrans;
	public Object getActualAdjustmentTransNumb() {
		WaitForTheElementToBeClickable(ActualAdjustmentTrans);
		return ActualAdjustmentTrans.getText();
	}
	@FindBy(xpath="//td[@class='gridSummaryCellDisabled']//div[contains(text(),'$')]")
	WebElement TotalDueIcon;
	public Integer GetTheTotalDue() {
		try
		{
			WaitForTheElementToBeClickable(TotalDueIcon);}catch(StaleElementReferenceException exp) {}
		String Due = TotalDueIcon.getText();
		String inputString = Due.trim();
		String Value = inputString.replaceAll("[^0-9]", "");
		int TotalDue = Integer.parseInt(Value);
		return TotalDue; 
	}

	public String GetCustomerNumber() {
		WaitForTheElementToBeClickable(SelectedCustomerIcon);
		return SelectedCustomerIcon.getText();
	}

	@FindBy(xpath="(//td[@class='cellSelected']//div)[2]")
	WebElement SelectedCustomerIcon;
	@FindBy(xpath="//img[contains(@src,'customer.png')]")
	WebElement CustomerDashboardIcon;

	public void TapOnCustomerDashboard() {
		WaitForTheElementToBeClickable(CustomerDashboardIcon);
		CustomerDashboardIcon.click();
	}

	@FindBy(name="CustId")
	WebElement CustomerNumberInCustomerDash;

	public void EnterTheCustomerNumberInCustomerDashboard(String CustomerNumber) {
		WaitForTheElementToBeClickable(CustomerNumberInCustomerDash);
		CustomerNumberInCustomerDash.sendKeys(CustomerNumber,Keys.ENTER);
	}

	@FindBy(xpath="//b[contains(normalize-space(text()),'The payment is under allocated by')]")
	WebElement UnderAllocatedAmount;
	public Integer getUnderAllocatedAmount() {
		WaitForTheElementToBeClickable(UnderAllocatedAmount);
		String Amount = UnderAllocatedAmount.getText();
		String inputString = Amount.trim();
		String Value = inputString.replaceAll("[^0-9]", "");
		int UnderAllocatedAmount = Integer.parseInt(Value);
		return UnderAllocatedAmount; 
	}
	@FindBy(xpath="(//img[contains(@src,'close.png')])[1]")
	WebElement CloseTabIcon;

	public void CloseCustomerPaymentsTab() {
		WaitForTheElementToBeClickable(CloseTabIcon);
		CloseTabIcon.click();

		boolean isImageVisible  = isElementVisible(Driver , YesClose);

		if (isImageVisible) {
			WaitForTheElementToBeClickable(YesClose);
			YesClose.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public boolean isElementVisible(WebDriver driver, WebElement element) {
		try {

			return element.isDisplayed();
		} catch (Exception e) {
			return false;

		}
	}

	@FindBy(xpath="(//td[@class='cellDark']//div[contains(text(),'$')])[9]")
	WebElement TotalDueAmountInCustomerDashboard;

	public Integer getAllocatedDue() {
		WaitForTheElementToBeClickable(TotalDueAmountInCustomerDashboard);
		String Amount = TotalDueAmountInCustomerDashboard.getText();
		String inputString = Amount.trim();
		String Value = inputString.replaceAll("[^0-9]", "");
		int TotalDueAmount = Integer.parseInt(Value);
		return TotalDueAmount; 
	}

	@FindBy(xpath="(//div[text()='Actions'])")
	WebElement ActionsIcon;

	public void TapOnActionsIcon() {
		WaitForTheElementToBeClickable(ActionsIcon);
		ActionsIcon.click();
	}

	@FindBy(xpath="(//div[text()='0.00'])[3]")
	WebElement PaymentAllocationsIcon;
	@FindBy(name="valueToAllocate")
	WebElement PaymentAllocationsTab;


	public void doubleClickTheElement(WebElement Element) {
		Actions actions = new Actions(Driver);
		WaitForTheElementToBeClickable(Element);
		actions.doubleClick(Element).perform();


	}
	public void MakeAllocations(String Text)  {
		try {
			WaitForTheElementToBeClickable(PaymentAllocationsIcon);}catch(StaleElementReferenceException Exp) {}
		doubleClickTheElement(PaymentAllocationsIcon);
		WaitForTheElementToBeClickable(PaymentAllocationsTab);
		PaymentAllocationsTab.sendKeys(Text);
	}

	@FindBy(xpath="//div[normalize-space(text())='Clear Allocations']")
	WebElement ClearAllocationIcon;

	public void TapOnClearAllocations() {
		WaitForTheElementToBeClickable(ClearAllocationIcon);
		ClearAllocationIcon.click();
	}

	@FindBy(xpath="(//div[text()='2000005.00'])")
	WebElement VerifyingElementToSeeIfClearAllocationIsWorking;

	public boolean VerifyingElementToSeeIfClearAllocationIsWorking() {
		try 
		{
			return VerifyingElementToSeeIfClearAllocationIsWorking.isDisplayed();
		}catch(Exception Exp) {return false;}
	}

	@FindBy(xpath="//div[normalize-space(text())='Show All']")
	WebElement ShowAllIcon;
	public void TapOnShowAllIcon() {
		WaitForTheElementToBeClickable(ShowAllIcon);
		ShowAllIcon.click();

	}
	@FindBy(xpath="//div[normalize-space(text())='Show Unallocated']")
	WebElement ShowUnallocatedIcon;

	public void TapOnShowUnallocatedIcon() {
		WaitForTheElementToBeClickable(ShowUnallocatedIcon);
		ShowUnallocatedIcon.click();
	}
	@FindBy(xpath="//div[normalize-space(text())='Add Discounts']")
	WebElement AddDiscountsIcon;

	public void TapOnAddDiscounts() {
		WaitForTheElementToBeClickable(AddDiscountsIcon);
		AddDiscountsIcon.click();
	}

	@FindBy(xpath="//div[normalize-space(text())='Remove Discounts']")
	WebElement RemoveDiscountsIcon;

	public void TapOnRemoveDiscounts() {
		WaitForTheElementToBeClickable(RemoveDiscountsIcon);
		RemoveDiscountsIcon.click();
	}

	@FindBy(xpath="//td[text()='New (']")
	WebElement NewIcon;
	@FindBy(xpath="//td[text()='es - Discard changes']")
	WebElement YesDiscardChangesIcon;

	public void TapOnNewIcon() {
		WaitForTheElementToBeClickable(NewIcon);
		NewIcon.click();
//		WaitForTheElementToBeClickable(NoDontClose);
//		NoDontClose.click();
//		WaitForTheElementToBeClickable(NewIcon);
//		NewIcon.click();
//		WaitForTheElementToBeClickable(YesDiscardChangesIcon);
//		YesDiscardChangesIcon.click();
	}

	@FindBy(xpath="(//input[@name='idCustX'])[2]")
	WebElement CustomerNumberInPaymentForm;

	public void EnterCustomerNumberInPaymentForm(String Text) {
		//		try {
		//			Thread.sleep(2000);
		//		} catch (InterruptedException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		WaitForTheElementToBeClickable(CustomerNumberInPaymentForm);
		CustomerNumberInPaymentForm.sendKeys(Text,Keys.ENTER);
	} 

	@FindBy(xpath="//input[@name='valuePayment']")
	WebElement PaymentNumberInPaymentForm;

	public void EnterThePaymentAmount(String Text) {
		WaitForTheElementToBeClickable(PaymentNumberInPaymentForm);
		doubleClickTheElement(PaymentNumberInPaymentForm);
		PaymentNumberInPaymentForm.sendKeys(Text,Keys.ENTER);
	} 
	@FindBy(xpath="//td[normalize-space(text())='Tendering']")
	WebElement TenderingIcon;

	public void TapOnTenderingIcon() {
		WaitForTheElementToBeClickable(TenderingIcon);
		TenderingIcon.click();
	}

	@FindBy(xpath="(//img[contains(@src,'dropdown2.png')])[3]")
	WebElement PaymentOptionDropDown;
	@FindBy(xpath="//div[normalize-space(text())='Cash']")
	WebElement PaymentOption;
	@FindBy(xpath="(//div[(text()='Pay')])[3]")
	WebElement PayIcon;
	public void TapOnPaymentOptionDropDown() {
		WaitForTheElementToBeClickable(PaymentOptionDropDown);
		PaymentOptionDropDown.click();
	}

	public void TapOnCashIcon() {
		WaitForTheElementToBeClickable(PaymentOption);
		PaymentOption.click();
	}
	//	@FindBy(xpath="//td[contains(text(),'Pay')]")
	//	WebElement TenderingAmount;
	public void TapOnPayIcon() {
		WaitForTheElementToBeClickable(PayIcon);
		PayIcon.click();
	}
	@FindBy(xpath="//b[normalize-space(text())='The payment is under allocated by $200.00']")
	WebElement VerifyElementForTenderingAmount;
	public boolean VerifyIfTenderingAmountIsDisplayed() {
		WaitForTheElementToBeClickable(VerifyElementForTenderingAmount);
		return VerifyElementForTenderingAmount.isDisplayed();
	}

	@FindBy(xpath="//td[text()='Direct Deposit']")
	WebElement DirectDepositIcon;
	public void TapOnDirectDepositIcon() {
		WaitForTheElementToBeClickable(DirectDepositIcon);
		DirectDepositIcon.click();
	}

	@FindBy(xpath="(//div[contains(text(),'$')])[1]")
	WebElement PaymentAmountForVerification;
	public int GetThePaymentAmount() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WaitForTheElementToBeClickable(PaymentAmountForVerification);
		String Amount = PaymentAmountForVerification.getText();
		String inputString = Amount.trim();
		String Value = inputString.replaceAll("[^0-9]", "");
		int PaymentAmount = Integer.parseInt(Value);
		return PaymentAmount; 
		//		WaitForTheElementToBeClickable(PaymentAmountForVerification);
		//		return PaymentAmountForVerification.getText();
		//		
	}

	@FindBy(xpath="(//tr//td[2]//div[contains(text(),'$')])[4]")
	WebElement CurrentDueAmount;
	public int GetTheCurrentDueAmount() {
		WaitForTheElementToBeClickable(CurrentDueAmount);
		String Amount = CurrentDueAmount.getText();
		String inputString = Amount.trim();
		String Value = inputString.replaceAll("[^0-9]", "");
		int CurrentDue = Integer.parseInt(Value);
		return CurrentDue; 
	}

	public void goToCustomerPaymentAndSelectInvoice() {
		TapOnTheHamburgerMenu();
		TapOnTheCustomerPaymentIcon();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CloseCustomerPaymentsTab();
		TapOnTheFindIcon();
		TapOnAnyOneOfTheInvoices();
	}
	@FindBy(xpath="(//img[contains(@src,'checkmark.png')])[1]")
	WebElement SelectionIcon1;
	@FindBy(xpath="(//img[contains(@src,'checkmark.png')])[3]")
	WebElement SelectionIcon2;
	@FindBy(xpath="(//img[contains(@src,'checkmark.png')])[5]")
	WebElement SelectionIcon3;
	@FindBy(xpath="(//img[contains(@src,'checkmark.png')])[7]")
	WebElement SelectionIcon4;
	@FindBy(xpath="(//img[contains(@src,'checkmark.png')])[9]")
	WebElement SelectionIcon5;
	@FindBy(xpath="//td[text()='Save (']")
	WebElement SaveIconForTheCustomerPayment;
	@FindBy(xpath="(//td[@class='gridSummaryCellDisabled']//div)[15]")
	WebElement OverAllAllocatedAmount;

	public int GetTheTextOfOverAllAllocatedAmount() {
		WaitForTheElementToBeClickable(OverAllAllocatedAmount);
		String Amount = OverAllAllocatedAmount.getText();
		String inputString = Amount.trim();
		String Value = inputString.replaceAll("[^0-9]", "");
		int OverAllAllocatedAmount = Integer.parseInt(Value);
		return OverAllAllocatedAmount; 

	}

	public void VerifyIfTheAmountIsAllocatedProperly(Integer PaymentAmount1 ){
		Assert.assertTrue(CorrectAlloctionStatement());
		Assert.assertEquals(PaymentAmount1 , GetTheTextOfOverAllAllocatedAmount(), " The Amounts are matching"  );
	}


	public void VerifyIfInvoiceMatchesWithTheAnyAgeTab(Integer PaymentAmount1 , Integer CurrentDue , Integer ThirtyDaysDue , Integer SixtyDaysDue , Integer NinetyDaysDue ,Integer OneTwentyDaysDue) {

		WaitForTheElementToBeClickable(CurrentDueAmount);
		WaitForTheElementToBeClickable(ThirtyDaysDueAmount);
		WaitForTheElementToBeClickable(SixtyDaysDueAmount);
		WaitForTheElementToBeClickable(NinetyDaysDueAmount);
		WaitForTheElementToBeClickable(OneTwentyDaysDueAmount);
		if(PaymentAmount1 != 0 &&PaymentAmount1.equals(CurrentDue)) 
		{
			goToCustomerPaymentAndSelectInvoice();			
			try{WaitForTheElementToBeClickable(SelectionIcon1);}catch(StaleElementReferenceException exp ) {}
			SelectionIcon1.click();
			VerifyIfTheAmountIsAllocatedProperly(PaymentAmount1);
		}
		else if(PaymentAmount1 != 0 &&PaymentAmount1.equals(ThirtyDaysDue))
		{
			goToCustomerPaymentAndSelectInvoice();			
			try{WaitForTheElementToBeClickable(SelectionIcon2);}catch(StaleElementReferenceException Exp) {}
			SelectionIcon2.click();
			VerifyIfTheAmountIsAllocatedProperly(PaymentAmount1);
		}
		else if(PaymentAmount1 != 0 &&PaymentAmount1.equals(SixtyDaysDue))
		{
			goToCustomerPaymentAndSelectInvoice();	
			try {
				WaitForTheElementToBeClickable(SelectionIcon3);}catch(StaleElementReferenceException Exp) {}
			SelectionIcon3.click();
			VerifyIfTheAmountIsAllocatedProperly(PaymentAmount1);
		}
		else if(PaymentAmount1 != 0 &&PaymentAmount1.equals(NinetyDaysDue))
		{
			goToCustomerPaymentAndSelectInvoice();			
			try{WaitForTheElementToBeClickable(SelectionIcon4);}catch(StaleElementReferenceException Exp) {}
			SelectionIcon4.click();
			VerifyIfTheAmountIsAllocatedProperly(PaymentAmount1);
		}
		else if(PaymentAmount1 != 0 &&PaymentAmount1.equals(OneTwentyDaysDue))
		{
			goToCustomerPaymentAndSelectInvoice();			
			try{WaitForTheElementToBeClickable(SelectionIcon5);}catch(StaleElementReferenceException Exp) {}
			SelectionIcon5.click();
			VerifyIfTheAmountIsAllocatedProperly(PaymentAmount1);
		}
		else 
		{
			System.out.println(" Amounts are not matching");

		}
	}

	public void TapOnSaveIconForTheCustomerPayment()
	{
		WaitForTheElementToBeClickable(SaveIconForTheCustomerPayment);
		SaveIconForTheCustomerPayment.click();

	}
	@FindBy(xpath="(//tr//td[2]//div[contains(text(),'$')])[5]")
	WebElement ThirtyDaysDueAmount;
	@FindBy(xpath="(//tr//td[2]//div[contains(text(),'$')])[6]")
	WebElement SixtyDaysDueAmount;
	@FindBy(xpath="(//tr//td[2]//div[contains(text(),'$')])[7]")
	WebElement NinetyDaysDueAmount;
	@FindBy(xpath="(//tr//td[2]//div[contains(text(),'$')])[8]")
	WebElement OneTwentyDaysDueAmount;

	public Integer GetTheCurrentThirtyDaysAmount() {
		WaitForTheElementToBeClickable(ThirtyDaysDueAmount);
		String Amount = ThirtyDaysDueAmount.getText();
		String inputString = Amount.trim();
		String Value = inputString.replaceAll("[^0-9]", "");
		int ThirtyDaysDue = Integer.parseInt(Value);
		return ThirtyDaysDue; 
	}

	public Integer GetTheCurrentSixtyDaysAmount() {
		WaitForTheElementToBeClickable(SixtyDaysDueAmount);
		String Amount = SixtyDaysDueAmount.getText();
		String inputString = Amount.trim();
		String Value = inputString.replaceAll("[^0-9]", "");
		int SixtyDaysDue = Integer.parseInt(Value);
		return SixtyDaysDue;
	}

	public Integer GetTheCurrentNinetyDaysAmount() {
		WaitForTheElementToBeClickable(NinetyDaysDueAmount);
		String Amount = NinetyDaysDueAmount.getText();
		String inputString = Amount.trim();
		String Value = inputString.replaceAll("[^0-9]", "");
		int NinetyDaysDue = Integer.parseInt(Value);
		return NinetyDaysDue;
	}

	public Integer GetTheCurrentOneTwentyDaysAmount() {
		WaitForTheElementToBeClickable(OneTwentyDaysDueAmount);
		String Amount = OneTwentyDaysDueAmount.getText();
		String inputString = Amount.trim();
		String Value = inputString.replaceAll("[^0-9]", "");
		int OneTwentyDaysDueAmount = Integer.parseInt(Value);
		return OneTwentyDaysDueAmount;
	}
	@FindBy(xpath="//b[text()='The payment is fully allocated, click Save to complete']")
	WebElement CorrectAlloctionStatement;

	public boolean CorrectAlloctionStatement() {
		WaitForTheElementToBeClickable(CorrectAlloctionStatement);
		return CorrectAlloctionStatement.isDisplayed();
	}

	@FindBy(xpath="	//div[text()='Date']")
	WebElement DateHeader;
	@FindBy(xpath="(//div[text()='Inv'])[1]")
	WebElement InvoiceIcon1;

	public void TapOnTheDateIcon() {
		WaitForTheElementToBeClickable(DateHeader);
		DateHeader.click();
	}

	@FindBy(xpath="(//td[@class='cellSelected']//div[contains(text(),'0.00')])[1]")
	WebElement PaymentAmount;
	@FindBy(xpath="(//td[@class='cellSelectedDark']//div[contains(text(),'0.00')])[1]")
	WebElement PaymentAmount1;

	@SuppressWarnings("rawtypes")
	public List GetTheAmountFromTheDataSheet() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String excelFilePath = "D:/Users/Pavithra.Radhakrishn/Downloads/ttArTran.xlsx";
		String targetColumnName = "Balance";
		List<String> stringData = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(excelFilePath);
				Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
			Row headerRow = sheet.getRow(0); // Assuming the first row is the header row
			int targetColumnIndex = -1;

			// Find the column index for the "Balance" column
			for (Cell cell : headerRow) {
				String cleanedHeader = cell.getStringCellValue().trim().replaceAll("\\s+", ""); // Remove spaces and newlines
				System.out.println(cleanedHeader);
				if (cleanedHeader.equalsIgnoreCase(targetColumnName)) {
					targetColumnIndex = cell.getColumnIndex();
					break;
				}
			}

			if (targetColumnIndex == -1) {
				System.out.println("Balance column not found.");

			}

			// Iterate over rows and extract integer data from the "Balance" column
			for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from row 1 to skip the header
				Row row = sheet.getRow(i);
				if (row != null) {
					Cell cell = row.getCell(targetColumnIndex);
					stringData.add(String.valueOf(cell));
					//					System.out.println(stringData);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringData;

	}


	@FindBy(xpath="(//td[contains(@class,'cellSelected')]//div[contains(text(),'$')])[2]")
	WebElement Amount;

	public void PressDownArrow() {
		Actions actions = new Actions(Driver);
		actions.sendKeys(Keys.ARROW_DOWN).perform();
	}


	@FindBy(xpath="(//td[contains(@class,'cellSelected')]//div[contains(text(),'0.00')])[1]")
	WebElement ValueDisAllocate;
	public void AllocateTheAmount(Integer UnallocatedAmount ,List<String> PendingBalance) {
		Integer MaxLimit = PendingBalance.size();


		for(int i=0 ; i < MaxLimit ; i++) {

			try {	
				WaitForTheElementToBeClickable(OverAllAllocatedAmount);
			}catch(StaleElementReferenceException Exp) {WaitForTheElementToBeClickable(OverAllAllocatedAmount);}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String AllocatedAmount = OverAllAllocatedAmount.getText();
			String inputString2 = AllocatedAmount.trim();
			String Value2 = inputString2.replaceAll("[^0-9]", "");
			int AmountToBeAllocated = Integer.parseInt(Value2);

			//			WaitForTheElementToBeClickable(UnderAllocatedAmount);
			//			String PaymentAmount = UnderAllocatedAmount.getText();
			//			String inputString1 = PaymentAmount.trim();
			//			String Value1 = inputString1.replaceAll("[^0-9]", "");
			//			int UnallocatedAmount = Integer.parseInt(Value1);

			String Amount = PendingBalance.get(i);
			String inputString = Amount.trim();
			String Value = inputString.replaceAll("[^0-9]", "");
			int Balance = Integer.parseInt(Value);

			boolean isImageVisible  = isElementVisible(Driver , CorrectAlloctionStatement);

			if( UnallocatedAmount >= Balance &&  AmountToBeAllocated != UnallocatedAmount )
			{
				try {
					WaitForTheElementToBeClickable(PaymentAllocationsTab);
				}catch(StaleElementReferenceException Exp) {}
				PaymentAllocationsTab.sendKeys(Keys.CONTROL + "a");
				PaymentAllocationsTab.sendKeys(Keys.DELETE);
				WaitForTheElementToBeClickable(PaymentAllocationsTab);
				PaymentAllocationsTab.sendKeys(PendingBalance.get(i));
				PressDownArrow();
			}else if(isImageVisible)
			{
				break;
			}
			else{
				String PaymentAmount = UnderAllocatedAmount.getText();
				WaitForTheElementToBeClickable(PaymentAllocationsTab);
				PaymentAllocationsTab.sendKeys(PaymentAmount);
				PressDownArrow();
				break;
			}

		}
	}

	public void TapOnTheInvoiceOption() {
		WaitForTheElementToBeClickable(InvoiceIcon1);
		InvoiceIcon1.click();
	}

	public void TapOnThePaymentIcon() {
		WaitForTheElementToBeClickable(PaymentAmount);
		doubleClickTheElement(PaymentAmount);
	}

	public void TapOnYesDiscard() {
		// TODO Auto-generated method stub
		WaitForTheElementToBeClickable(YesDiscardChangesIcon);
		YesDiscardChangesIcon.click();
	}

	public void EnterHighestPrice(String PaymentAmount) 
	{
		WaitForTheElementToBeClickable(PaymentAllocationsTab);
		PaymentAllocationsTab.sendKeys(PaymentAmount);
	}

	@FindBy(xpath="//div[text()='Do you want to save this data?']")
	WebElement Error;
	public boolean ErrorIsShown() {
		WaitForTheElementToBeClickable(Error);
		return Error.isDisplayed();
	}

	public void TapOnNoDontCloseIcon() {
		WaitForTheElementToBeClickable(NoDontClose);
		NoDontClose.click();
	}

	public void rightClick(WebElement Element) {
		Actions actions = new Actions(Driver);
		actions.contextClick(Element).perform();
	}
	@FindBy(xpath="//div[text()='Export as']")
	WebElement ExportIcon;
	@FindBy(xpath="//div[text()='Excel (.xlsx)']")
	WebElement ExcelIcon;

	public void TapOnExportAsExcel() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WaitForTheElementToBeClickable(InvoiceIcon1);
		rightClick(InvoiceIcon1);
		WaitForTheElementToBeClickable(ExportIcon);
		ExportIcon.click();
		WaitForTheElementToBeClickable(ExcelIcon);
		ExcelIcon.click();
	}

	@FindBy(xpath="//b[contains(text(),'The payment is over allocated by')]")
	WebElement OverAllocatedSentence;
	public boolean OverAllocatedSentence() {
		WaitForTheElementToBeClickable(OverAllocatedSentence);
		return OverAllocatedSentence.isDisplayed();
	}

	@FindBy(xpath="//td[text()='es - Perform Save']")
	WebElement YesPerformSaveIcon;
	@FindBy(xpath="(//td[text()='Close ('])[2]")
	WebElement SecondTabCloseIcon;
	public void TapOnCloseIcon() {
		WaitForTheElementToBeClickable(SecondTabCloseIcon);
		SecondTabCloseIcon.click();

	}

	public void TapOnYesPerformSaveIcon() {
		WaitForTheElementToBeClickable(YesPerformSaveIcon);
		YesPerformSaveIcon.click();
	}
	@FindBy(xpath="//label[text()='Browse']")
	WebElement BrowseIcon;

	public void TapOnBrowseIcon() {
		WaitForTheElementToBeClickable(BrowseIcon);
		BrowseIcon.click();
	}
	@FindBy(xpath="//div[text()='Import Payments']")
	WebElement ImportPaymentIcon;

	//div[text()='Import Payments']
	public void TapOnImportPayments() {
		WaitForTheElementToBeClickable(ImportPaymentIcon);
		ImportPaymentIcon.click();
	}

	@FindBy(xpath="//div[text()='Upload']")
	WebElement UploadIcon;
	@FindBy(xpath="//div[text()='Cancel']")
	WebElement CancelIcon;


	@SuppressWarnings("deprecation")
	public void UploadTheValidPaymentExcel() {
		try {
			Runtime.getRuntime().exec("D:\\Users\\Pavithra.Radhakrishn\\Desktop\\Automation testing\\FileUpload\\xcel.exe");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void TapOnUploadIcon() {
		WaitForTheElementToBeClickable(UploadIcon);
		UploadIcon.click();
	}

}
