package Page;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreditNotesPageObjectModel {

	static WebDriver Driver;
	public CreditNotesPageObjectModel(WebDriver Driver) // We are initiating the Constructor
	{
		CreditNotesPageObjectModel.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}
	@FindBy(xpath="//td[text()='Credit Notes']")
	WebElement creditNoteIcon;
	@FindBy(xpath="//div[text()='New']")
	WebElement creditNoteNewIcon;
	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[3]")
	WebElement typeDropDown;
	@FindBy(xpath="//div[text()='Stock Return']")
	WebElement stockReturnOption;
	@FindBy(xpath="//div[text()='Overcharge']")
	WebElement overchargeOption;
	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[4]")
	WebElement reasonDropDownIcon;
	@FindBy(xpath="//div[text()='70 - Faulty Goods']")
	WebElement stockReturnReasonOption;
	@FindBy(xpath="//div[text()='93 - Overcharge']")
	WebElement overchargeReasonOption;
	@FindBy(xpath="(//img[contains(@src,'search.png')])[3]")
	WebElement docketSearchIcon;
	@FindBy(xpath="(//div[text()='34'])[1]")
	WebElement docketOptionIcon;
	@FindBy(xpath="//td[text()='Use']")
	WebElement useIcon;
	@FindBy(name="idCustX")
	WebElement customerIdTab;
	@FindBy(xpath="//td[text()='Find']")
	WebElement findIcon;
	@FindBy(xpath="(//td[contains(@class,'tallCellSelectedDark')])[9]")
	WebElement creditQuantityTopBar;


	public void driverWait() {
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void longDriverWait() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tapOnCreditNoteIcon() {
		driverWait();
		creditNoteIcon.click();
	}

	public void tapOnNewCreditIcon() {
		driverWait();
		creditNoteNewIcon.click();
	}

	public void enterTheCustomerId(String custID) {
		longDriverWait();
		customerIdTab.sendKeys(custID,Keys.ENTER);
	}

	public void selectTheReturnType() {
		driverWait();
		typeDropDown.click();
	}

	public void selectStockReturnOption() {
		driverWait();
		stockReturnOption.click();
	}

	public void selectReasonDropDown() {
		driverWait();
		reasonDropDownIcon.click();

	}

	public void selectTheReasonOption() {
		driverWait();
		stockReturnReasonOption.click();
	}

	public void selectTheDocketNumber() {
		driverWait();
		docketSearchIcon.click();driverWait();
		findIcon.click();driverWait();
		docketOptionIcon.click();driverWait();
		useIcon.click();
	}

	@FindBy(xpath="//div[text()='Load Details']")
	WebElement loadDetailsIcon;
	@FindBy(xpath="//div[text()='Refund All']")
	WebElement refundAllIcon;
	@FindBy(xpath="//div[text()='Pickup Note']")
	WebElement pickUpNoteIcon;

	public void loadDetailsOfTheDocket() {
		driverWait();
		loadDetailsIcon.click();
	}

	public void tapOnRefundAllIcon() {
		driverWait();
		refundAllIcon.click();
	}

	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[8]")
	WebElement EmailOutputandDespatchMethodDropdown;
	@FindBy(xpath="//div[text()='E-mail']")
	WebElement EmailOutputOption;
	@FindBy(xpath="//td[text()='Go']")
	WebElement GoIcon;
	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[9]")
	WebElement ToDropDownIcon;
	@FindBy(xpath="//b[text()='«Current User»']")
	WebElement CurrentUserIcon;

	public void tapOnPickUpNoteAndTriggerTheMail() {
		driverWait();
		pickUpNoteIcon.click();
		driverWait();
		EmailOutputandDespatchMethodDropdown.click();
		EmailOutputOption.click();
		ToDropDownIcon.click();
		CurrentUserIcon.click();
		GoIcon.click();
	}

	@FindBy(name="quantityOrderedBrowse")
	WebElement returnQuantityIcon;
	@FindBy(xpath="//td[text()='Product Entry']")
	WebElement productEntryIcon;
	@FindBy(xpath="//div[contains(text(),'ASA1003')]")
	WebElement hardwareProductIcon;
	public void enterTheCreditQuantity(String Number) {
		driverWait();
		hardwareProductIcon.click();driverWait();
		creditQuantityTopBar.click(); driverWait();
		returnQuantityIcon.sendKeys(Number);
	}

	@FindBy(xpath="//td[@class=\"cellSelected\"]//div[text()='0']")
	WebElement tallyQuantityIcon;
	@FindBy(xpath="(//td[text()='Save/Close'])")
	WebElement tallySaveIcon;
	@FindBy(xpath="(//div[text()='Tally'])[1]")
	WebElement tallyIcon;
	public void enterTheTallyIfAny(String quantity) {
		driverWait();
		tallyIcon.click();
		tallyQuantityIcon.click();
		returnQuantityIcon.sendKeys(quantity);
		tallySaveIcon.click();

	}

	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[4]")
	WebElement despatchDropDown;
	@FindBy(xpath="//div[text()='ZDDEL - 5. DELV DIRECT SITE']")
	WebElement despatchOption;
	@FindBy(xpath="(//img[contains(@src,'calendar.png')])[3]")
	WebElement deliveryDateCalendar;
	@FindBy(xpath="//div[text()='22']")
	WebElement deliveryDateOption;
	@FindBy(xpath="(//img[contains(@src,'arrow_right.png')])")
	WebElement nextMonthIcon;

	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[5]")
	WebElement requestedTimeDropDown;
	@FindBy(xpath="//div[text()='1159 - AM any time ( before 12)']")
	WebElement requestedTimeOption;
	@FindBy(xpath="(//img[contains(@src,'search.png')])[2]")
	WebElement addressSearchIcon;
	@FindBy(xpath="//td[text()='Despatch Details']")
	WebElement despatchDetailsHeaderIcon;

	public void enterTheDespatchDetails() {
		// TODO Auto-generated method stub
		longDriverWait();
		despatchDetailsHeaderIcon.click();longDriverWait();
		despatchOption.click();driverWait();
		deliveryDateCalendar.click();driverWait();
		nextMonthIcon.click();driverWait();
		deliveryDateOption.click();driverWait();
		requestedTimeDropDown.click();driverWait();
		requestedTimeOption.click();driverWait();
		addressSearchIcon.click();driverWait();
		useIcon.click();driverWait();
		productEntryIcon.click();
	}
	@FindBy(xpath="//div[text()='Finish (']")
	WebElement finishIcon;
	@FindBy(xpath="(//div[text()='Refund'])[2]")
	WebElement accountRefund;

	public void tapOnFinishTheCredit() {
		longDriverWait();
		finishIcon.click();driverWait();

	}

	public void tapOnRefundIcon() {
		longDriverWait();
		accountRefund.click();

	}

	public void selectOverChargeOption() {
		driverWait();
		overchargeOption.click();
	}

	public void selectTheReasonForOvercharge() {
		driverWait();
		overchargeReasonOption.click();

	}



	@FindBy(xpath="(//img[contains(@src,'dropdown.png')])[8]")
	WebElement cashDropdown;
	@FindBy(xpath="(//div[text()='Cash'])[1]")
	WebElement cashIcon;
	@FindBy(xpath="(//div[text()='Refund'])[1]")
	WebElement cashRepayIcon;

	public void tapOnRefundIconViaCash() {
		longDriverWait();
		cashDropdown.click();longDriverWait();
		try {
		driverWait();
		cashIcon.click();driverWait();}catch(StaleElementReferenceException Exp) {cashIcon.click();driverWait();}
		cashRepayIcon.click();
	}

	@FindBy(xpath="(//div[text()='34'])[1]")
	WebElement cashRepayOption;

	public void selectTheDocketNumberforOverCharge() {
		driverWait();
		docketSearchIcon.click();driverWait();
		findIcon.click();driverWait();
		cashRepayOption.click();driverWait();
		useIcon.click();
	}
	@FindBy(xpath="//div[text()='Suspend']")
	WebElement suspendIcon;
	public void suspendTheCreditNote() {
		driverWait();
		suspendIcon.click();
	}
	@FindBy(className="headerItemDisabled")
	WebElement creditNoteHeader;


	public String  getCreditNoteNumber() {
		String creditNoteNumber = creditNoteHeader.getText();
		return creditNoteNumber;

	}
	@FindBy(name="orderNo")
	WebElement orderNumberTab;
	@FindBy(xpath="//a[contains(text(),'38')]")
	WebElement credNote;
	@FindBy(xpath="//div[text()='Find']")
	WebElement credNoteFindIcon;
	public void openTheSuspendedCreditNote(String creditNoteNumber) {
		longDriverWait();
		orderNumberTab.sendKeys(creditNoteNumber);driverWait();
		credNoteFindIcon.click();longDriverWait();
		credNote.click();

	}

	@FindBy(xpath="//img[contains(@src,'error.png')]")
	WebElement errorElement;
	public void verifyIfAnyErrorIsShown() {
	
		Assert.assertFalse(errorElement.isDisplayed());
		
		
	}
	@FindBy(xpath="//div[text()='Void']")
	WebElement voidIcon;

	public void voidCreditNote() {
		driverWait();
		voidIcon.click();
		
	}

	public void selectTheDocketNumberforTheTradeCreditUser() {
		// TODO Auto-generated method stub
		
	}

}
