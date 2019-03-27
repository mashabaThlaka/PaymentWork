package Supplier;

import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import transmart_properties.properties_extender;
import vodacom.payment_solution.vodacom.payment_solution.DataFunctions;
import vodacom.payment_solution.vodacom.payment_solution.ReadExcelData;
import vodacom.payment_solution.vodacom.payment_solution.UtilityFunctions;
import vodacom.payment_solution.vodacom.payment_solution.WriteExcelData;

public class Supplier {

	static ReadExcelData getdata=new ReadExcelData();
	static WriteExcelData writedata= new WriteExcelData();
	static properties_extender ext=new properties_extender();
	static UtilityFunctions utils = new UtilityFunctions();
	static Supplier Supplier = new 	Supplier();
	static DataFunctions data = new DataFunctions();
	
	
	Sheet sheet;
	private static String transactions_url;	
	private static String Payment_Type;	
	private static String Name_on_Card;	
	private static String Card_number;
	private static String Expiry_Month;	
	private static String Expiry_Year;
	private static String CVV;	
	private static String transaction_ID;
	private static String dDefaultPath;
	private static String rDefaultPath;
	private static String url;
	private static String username;
	private static String password;
	//Set Options Fields
	private static String Supplier_Select;
	private static String BlacklistCardOnRefund;
	private static String Currency;
	private static String DailySupplierCardLimit;
	private static String DaysToClearCheque;
	private static String MarkChequeCleared;
	private static String MimecastShortCode;
	private static String ReverseFees;
	private static String ReverseFeesChargebacks;
	private static String SendCustomerConfirmation;
	private static String SendCustomerInvoice;
	private static String SendPurchaseOrder;
	private static String SendSupplierFeeInvoice;
	private static String SendSupplierSelfbill;
	private static String PermittedSettlementPeriod;
	private static String SaveButton;


	
	static String FILENAME;
	
	//folders 
		private static String dpath="\\data\\";//excel external file folder		

		//xml file name 
		private static String transactions="\\Repository\\test_eshop.xml";// xml file for transactions payment
		//private static String transactions="\\Repository\\transactions.xml";//xml for front office 
		private static String supplier="\\Repository\\supplier.xml";//xml for supplier
		
public void Merchant_on_boarding(WebDriver driver, ExtentTest logger, String sDefaultPath) {
	dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
	rDefaultPath=sDefaultPath;// assigning a new repository folder
	
	try {
		url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
		username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
		password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
	
		driver.manage().window().maximize();
		Thread.sleep(2000);
		url.toString();
	
		

		utils.navigate(driver,url.toString());
		driver.manage().window().maximize();
		Thread.sleep(2000);		
		utils.navigate(driver,url.toString());
		/*if(utils.checkIfObjectExists(driver, "global", rDefaultPath+transactions)){
			utils.ExtentLogPassFail(driver, "global", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			//utils.ClickObject(driver, "global", rDefaultPath+transactions);
		}else{
			utils.ExtentLogPassFail(driver, "supplier_linkx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		}*/
		//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
		Thread.sleep(2000);	
		utils.ClickObject(driver, "supplier_tab", rDefaultPath+supplier);
			
	
		if(utils.checkIfObjectExists(driver, "supplier_link", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "supplier_link", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "supplier_link", rDefaultPath+supplier);
		}else{
			utils.ExtentLogPassFail(driver, "supplier_linkx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		Random rand = new Random();		
		int n = rand.nextInt(500000000);
		String user="Alex_testing_supplier_registration_"+n;
		utils.EnterText(driver, "SupplierName", user, rDefaultPath+supplier);
		utils.ClickObject(driver, "MerchantType", rDefaultPath+supplier);
		utils.PressDownKey();
		utils.PressDownKey();
		utils.EnterText(driver, "BusinessAddress1", "Birch Acres", rDefaultPath+supplier);
		utils.EnterText(driver, "BusinessAddressCity", "Johannesburg", rDefaultPath+supplier);
		utils.EnterText(driver, "BusinessAddressState", "Gauteng", rDefaultPath+supplier);		
		utils.ClickObject(driver, "BusinessAddressCountry", rDefaultPath+supplier);
		utils.ClickObject(driver, "BusinessAddressCountry1", rDefaultPath+supplier);
		utils.EnterText(driver, "BusinessAddressPostCode", "1619", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactName", "Alex kwenene", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactTelephoneNumberAccessCode", "+27", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactTelephoneNumber", "826373859", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactEmailAddress", "alex.kwenene@vcontractor.co.za", rDefaultPath+supplier);
		
		if(utils.checkIfObjectExists(driver, "btnSubmit", rDefaultPath+transactions)){
			utils.ExtentLogPassFail(driver, "btnSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "btnSubmit", rDefaultPath+supplier);
		}else{
			utils.ExtentLogPassFail(driver, "btnSubmitx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		
		if(utils.checkIfObjectExists(driver, "content", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "content", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			//utils.ClickObject(driver, "content", rDefaultPath+transactions);
		}else{
			utils.ExtentLogPassFail(driver, "contentx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}		
		
	}catch(Exception e){}
	
}

public void Merchant_on_boarding_wizard(WebDriver driver, ExtentTest logger, String sDefaultPath) {
	dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
	rDefaultPath=sDefaultPath;// assigning a new repository folder
	
	try {
		url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
		username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
		password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
	
		driver.manage().window().maximize();
		Thread.sleep(2000);
		url.toString();
	
		

		utils.navigate(driver,url.toString());
		driver.manage().window().maximize();
		Thread.sleep(2000);		
		utils.navigate(driver,url.toString());
		/*if(utils.checkIfObjectExists(driver, "global", rDefaultPath+transactions)){
			utils.ExtentLogPassFail(driver, "global", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			//utils.ClickObject(driver, "global", rDefaultPath+transactions);
		}else{
			utils.ExtentLogPassFail(driver, "supplier_linkx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		}*/
		//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
		Thread.sleep(2000);	
		utils.ClickObject(driver, "supplier_tab", rDefaultPath+supplier);
		
	
		if(utils.checkIfObjectExists(driver, "wizard", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "wizard", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "wizard", rDefaultPath+supplier);	
		}else{
			utils.ExtentLogPassFail(driver, "supplier_linkx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		Random rand = new Random();		
		int n = rand.nextInt(500000000);
		String user="Alex_testing_Supplier Setup Wizard _"+n;
		utils.EnterText(driver, "SupplierName", user, rDefaultPath+supplier);
		utils.ClickObject(driver, "MerchantType", rDefaultPath+supplier);
		utils.PressDownKey();
		utils.PressDownKey();
		utils.EnterText(driver, "BusinessAddress1", "Birch Acres", rDefaultPath+supplier);
		utils.EnterText(driver, "BusinessAddressCity", "Johannesburg", rDefaultPath+supplier);
		utils.EnterText(driver, "BusinessAddressState", "Gauteng", rDefaultPath+supplier);		
		utils.ClickObject(driver, "BusinessAddressCountry", rDefaultPath+supplier);
		utils.ClickObject(driver, "BusinessAddressCountry1", rDefaultPath+supplier);
		utils.EnterText(driver, "BusinessAddressPostCode", "1619", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactName", "Alex kwenene", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactTelephoneNumberAccessCode", "+27", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactTelephoneNumber", "826373859", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactEmailAddress", "alex.kwenene@vcontractor.co.za", rDefaultPath+supplier);
		
		if(utils.checkIfObjectExists(driver, "btnSubmit", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "btnSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "btnSubmit", rDefaultPath+supplier);
		}else{
			utils.ExtentLogPassFail(driver, "btnSubmitx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		/*
		if(utils.checkIfObjectExists(driver, "content", rDefaultPath+transactions)){
			utils.ExtentLogPassFail(driver, "content", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			//utils.ClickObject(driver, "content", rDefaultPath+transactions);
		}else{
			utils.ExtentLogPassFail(driver, "contentx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		}
		*/
		if(utils.checkIfObjectExists(driver, "save", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "save", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "save", rDefaultPath+supplier);
		}else{
			utils.ExtentLogPassFail(driver, "savex", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		
		if(utils.checkIfObjectExists(driver, "save", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "save", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "save", rDefaultPath+supplier);
		}else{
			utils.ExtentLogPassFail(driver, "savex", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		utils.ClickObject(driver, "zar", rDefaultPath+supplier);
		Thread.sleep(2000);	
		if(utils.checkIfObjectExists(driver, "addButton", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "addButton", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "addButton", rDefaultPath+supplier);
		}else{
			utils.ExtentLogPassFail(driver, "addButtonx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		
		
		if(utils.checkIfObjectExists(driver, "wizardButton", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "wizardButton", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "wizardButton", rDefaultPath+supplier);
		}else{
			utils.ExtentLogPassFail(driver, "addButtonx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		
		if(utils.checkIfObjectExists(driver, "updateButton", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "updateButton", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "updateButton", rDefaultPath+supplier);
		}else{
			utils.ExtentLogPassFail(driver, "updateButtonx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		//two step missing 
		Random rand1 = new Random();		
		int n1 = rand.nextInt(50);
		utils.EnterText(driver, "TechUser", "Alex_"+1+n1, rDefaultPath+supplier);
		utils.EnterText(driver, "AdminUser", "Alex_"+2+n1, rDefaultPath+supplier);
		utils.EnterText(driver, "Alias", "Alex_"+3+n1, rDefaultPath+supplier);
		
		if(utils.checkIfObjectExists(driver, "continue2", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "continue2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "continue2", rDefaultPath+supplier);
		}else{
			utils.ExtentLogPassFail(driver, "continue2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		if(utils.checkIfObjectExists(driver, "landing", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "landing", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "landing", rDefaultPath+supplier);
		}else{
			utils.ExtentLogPassFail(driver, "landingx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		
	}catch(Exception e){}
	
}

//}

public void Set_Options(WebDriver driver, ExtentTest logger, String sDefaultPath,String subfolderPath) {
	dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
	rDefaultPath=sDefaultPath;// assigning a new repository folder
	
	
	try {

		FILENAME="Supplier.xlsx";
		
		//Read data from the Set Options File		
		
		sheet = data.ReadExcel(sDefaultPath+"\\"+ "data"+"\\"+FILENAME,"set_options");
		//data from excel file set_options sheet || Column name || row no || sheet name || type
		Supplier_Select=data.getCellData("Supplier_Select", 1, sheet,null,null, "Excel");
		BlacklistCardOnRefund=data.getCellData("BlacklistCardOnRefund", 1, sheet,null,null, "Excel");
		Currency=data.getCellData("Currency", 1, sheet,null,null, "Excel");
		DailySupplierCardLimit=data.getCellData("DailySupplierCardLimit", 1, sheet,null,null, "Excel");
		DaysToClearCheque=data.getCellData("DaysToClearCheque", 1, sheet,null,null, "Excel");
		MarkChequeCleared=data.getCellData("MarkChequeCleared", 1, sheet,null,null, "Excel");
		MimecastShortCode=data.getCellData("MimecastShortCode", 1, sheet,null,null, "Excel");
		ReverseFees=data.getCellData("ReverseFees", 1, sheet,null,null, "Excel");
		ReverseFeesChargebacks=data.getCellData("ReverseFeesChargebacks", 1, sheet,null,null, "Excel");
		SendCustomerConfirmation=data.getCellData("SendCustomerConfirmation", 1, sheet,null,null, "Excel");
		SendCustomerInvoice=data.getCellData("SendCustomerInvoice", 1, sheet,null,null, "Excel");
		SendPurchaseOrder=data.getCellData("SendPurchaseOrder", 1, sheet,null,null, "Excel");
		SendSupplierFeeInvoice=data.getCellData("SendSupplierFeeInvoice", 1, sheet,null,null, "Excel");
		SendSupplierSelfbill=data.getCellData("SendSupplierSelfbill", 1, sheet,null,null, "Excel");
		PermittedSettlementPeriod=data.getCellData("PermittedSettlementPeriod", 1, sheet,null,null, "Excel");
		//SaveButton=data.getCellData("SaveButton", 1, sheet, null, null, "Excel");
		
		Thread.sleep(2000);	
		utils.ClickObject(driver, "supplier_tab", rDefaultPath+supplier);
		
		utils.ClickObject(driver, "set_options_link", rDefaultPath+supplier);	
		Thread.sleep(2000);
		////
	
		if(utils.checkIfObjectExists(driver, "supplier_select", rDefaultPath+supplier))
		{
			Thread.sleep(2000);		
			utils.ExtentLogPass(driver, "Passed", logger, true, subfolderPath);
			//utils.ClickObject(driver, "supplier_select", rDefaultPath+supplier);
			utils.SelectTextUsingVisibeText(driver, "supplier_select", Supplier_Select, rDefaultPath+supplier);			
			
		
		}else{
			utils.ExtentLogFail(driver, "Failed", logger, true, subfolderPath);
			 }
		Thread.sleep(2000);
		utils.ClickObject(driver, "suppier_select_btn", rDefaultPath+supplier);
		Thread.sleep(2500);
		
		if(BlacklistCardOnRefund.equals("Yes"))
		{			
			if(utils.checkIfObjectIsClicked(driver, "blacklist_card_checkbx", rDefaultPath+supplier) == false) {
				utils.ClickObject(driver, "blacklist_card_checkbx", rDefaultPath+supplier);
			}
		}
		Thread.sleep(2000);
			//ZAR Select Currency		
			utils.SelectTextUsingValue(driver, "currency_select", Currency, rDefaultPath+supplier);
			Thread.sleep(2000);
			
			//Enter supplier
			utils.ClearObject(driver, "daily_supplier_txt", rDefaultPath+supplier);
			utils.EnterText(driver, "daily_supplier_txt", DailySupplierCardLimit, rDefaultPath+supplier);
			Thread.sleep(2000);
			
			//Clear Cheque		
			utils.ClearObject(driver, "days_to_clear_chq", rDefaultPath+supplier);
			utils.EnterText(driver, "days_to_clear_chq", DaysToClearCheque, rDefaultPath+supplier);
			Thread.sleep(2000);
			
			//Cheque Cleared
			if(MarkChequeCleared.equals("Yes")) {
				if(utils.checkIfObjectIsClicked(driver, "mark_cheque_checkbx", rDefaultPath+supplier) == false) {
					utils.ClickObject(driver, "mark_cheque_checkbx", rDefaultPath+supplier);
				}
				
			}
			utils.ClearObject(driver, "mimecast_short_code", rDefaultPath+supplier);
			utils.EnterText(driver, "mimecast_short_code", MimecastShortCode, rDefaultPath+supplier);
			Thread.sleep(2000);
		// Reverse Fees
		if(ReverseFees.equals("Yes"))
		{			
			if(utils.checkIfObjectIsClicked(driver, "reverse_fees_checkbx", rDefaultPath+supplier) == false) {
				utils.ClickObject(driver, "reverse_fees_checkbx", rDefaultPath+supplier);
			}
		}
		Thread.sleep(2000);
		//Fee Charge Back
		if (ReverseFeesChargebacks.equals("Yes"))
		{
			if (utils.checkIfObjectIsClicked(driver, "rfees_charge_back_checkbx", rDefaultPath+supplier) == false ) {
				utils.ClickObject(driver, "rfees_charge_back_checkbx", rDefaultPath+supplier);
			}
		}
		Thread.sleep(2000);
		//Customer Confirmation
		if (SendCustomerConfirmation.equals("Yes"))
		{
			if (utils.checkIfObjectIsClicked(driver, "send_customer_confirmation_checkbx", rDefaultPath+supplier) == false ) {
				utils.ClickObject(driver, "send_customer_confirmation_checkbx", rDefaultPath+supplier);
			}
		}
		Thread.sleep(2000);
		//Customer invoice
		if (SendCustomerInvoice.equals("Yes"))
		{
			if (utils.checkIfObjectIsClicked(driver, "send_customer_invoice_checkbx", rDefaultPath+supplier) == false ) {
				utils.ClickObject(driver, "send_customer_invoice_checkbx", rDefaultPath+supplier);
			}
		}
		Thread.sleep(2000);
		//Purchase Order
		if (SendPurchaseOrder.equals("Yes"))
		{
			if (utils.checkIfObjectIsClicked(driver, "send_purchase_order_checkbx", rDefaultPath+supplier) == false ) {
				utils.ClickObject(driver, "send_purchase_order_checkbx", rDefaultPath+supplier);
			}
		}
		Thread.sleep(2000);
		//Fee invoice
		if (SendSupplierFeeInvoice.equals("Yes"))
		{
			if (utils.checkIfObjectIsClicked(driver, "send_supplier_fee_inv_checkbx", rDefaultPath+supplier) == false ) {
				utils.ClickObject(driver, "send_supplier_fee_inv_checkbx", rDefaultPath+supplier);
			}
		}
		Thread.sleep(2000);
		//Self bill
		if (SendSupplierSelfbill.equals("Yes"))
		{
			if (utils.checkIfObjectIsClicked(driver, "send_supplier_selfbill_inv_checkbx", rDefaultPath+supplier) == false ) {
				utils.ClickObject(driver, "send_supplier_selfbill_inv_checkbx", rDefaultPath+supplier);
			}
		}
		Thread.sleep(2000);
		//Enter settle period
		//System.out.println("Testing Joe");
		utils.ClearObject(driver, "settle_days_txt", rDefaultPath+supplier);
		utils.EnterText(driver, "settle_days_txt", PermittedSettlementPeriod, rDefaultPath+supplier);
		Thread.sleep(2000);
		
		//Save Button
		//System.out.println("Testing Joe");
		utils.ClickObject(driver, "save_btn", rDefaultPath+supplier);
		Thread.sleep(2500);
	
	   if((driver.findElement(By.className("pageInfoMessage")) != null)) {		   
		
		   		if(driver.findElement(By.className("pageInfoMessage")).getText().equals("The supplier options were updated successfully"))
		   				//utils.GetText(driver, "page_info_msg", rDefaultPath+supplier).contains("'The supplier options were updated successfully'"))
		   		{
		   		utils.ExtentLogPass(driver, "Passed", logger, true, subfolderPath);	    	    	
		   		}
		   		else 
		   		{			   	
		   		utils.ExtentLogFail(driver, "Failed", logger, true, subfolderPath);
		   		}
	   }else
	   {
		   utils.ExtentLogFail(driver, "Failed", logger, true, subfolderPath);		   
	   }
	    	    
		Thread.sleep(2000);
		
		/*
		Random rand = new Random();		
		int n = rand.nextInt(500000000);
		String user="Alex_testing_supplier_registration_"+n;
		utils.EnterText(driver, "SupplierName", user, rDefaultPath+supplier);
		utils.ClickObject(driver, "MerchantType", rDefaultPath+supplier);
		utils.PressDownKey();
		utils.PressDownKey();
		utils.EnterText(driver, "BusinessAddress1", "Birch Acres", rDefaultPath+supplier);
		utils.EnterText(driver, "BusinessAddressCity", "Johannesburg", rDefaultPath+supplier);
		utils.EnterText(driver, "BusinessAddressState", "Gauteng", rDefaultPath+supplier);		
		utils.ClickObject(driver, "BusinessAddressCountry", rDefaultPath+supplier);
		utils.ClickObject(driver, "BusinessAddressCountry1", rDefaultPath+supplier);
		utils.EnterText(driver, "BusinessAddressPostCode", "1619", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactName", "Alex kwenene", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactTelephoneNumberAccessCode", "+27", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactTelephoneNumber", "826373859", rDefaultPath+supplier);
		utils.EnterText(driver, "PrimaryContactEmailAddress", "alex.kwenene@vcontractor.co.za", rDefaultPath+supplier);
		
		if(utils.checkIfObjectExists(driver, "btnSubmit", rDefaultPath+transactions)){
			utils.ExtentLogPassFail(driver, "btnSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			utils.ClickObject(driver, "btnSubmit", rDefaultPath+supplier);
		}else{
			utils.ExtentLogPassFail(driver, "btnSubmitx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}
		
		if(utils.checkIfObjectExists(driver, "content", rDefaultPath+supplier)){
			utils.ExtentLogPassFail(driver, "content", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
			//utils.ClickObject(driver, "content", rDefaultPath+transactions);
		}else{
			utils.ExtentLogPassFail(driver, "contentx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,supplier);
		}*/		
		
	}catch(Exception e){}
	
}
}
