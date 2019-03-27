package Roles_properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.junit.internal.runners.statements.ExpectException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import transmart_properties.properties_extender;
import vodacom.payment_solution.vodacom.payment_solution.ReadExcelData;
import vodacom.payment_solution.vodacom.payment_solution.UtilityFunctions;
import vodacom.payment_solution.vodacom.payment_solution.WriteExcelData;

public class Roles_properties {
	static ReadExcelData getdata=new ReadExcelData();
	static WriteExcelData writedata= new WriteExcelData();
	static properties_extender ext=new properties_extender();
	static UtilityFunctions utils = new UtilityFunctions();
	static Roles_extender Roles_ext =new Roles_extender();
	
	
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
	private static String user_name;
	private static String pass_word;
	private static String roles; 

	//folders 
		private static String dpath="\\data\\";//excel external file folder		

		//xml file name 
		private static String transactions="\\Repository\\test_eshop.xml";// xml file for transactions payment
		//private static String transactions="\\Repository\\transactions.xml";//xml for front office 
		private static String supplier="\\Repository\\supplier.xml";//xml for supplier

/*****roles_view_transactions()***/
public void Roles_view_transactions(WebDriver driver, ExtentTest logger, String sDefaultPath,String user_name,String pass_word) {
	dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
	rDefaultPath=sDefaultPath;// assigning a new repository folder
	

	try {
		
		 url=getdata.ReadData("Roles_DataExcel", "users", "url", 2);
		 roles=getdata.ReadData("Roles_DataExcel", "users", "roles", 2);
		//user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
		// pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
	
		 
		
		//getdata.ReadData(filename, sheetname, colname, rownum)
		//System.out.println(url);
		//System.out.println(username);
		//System.out.println(password);
		driver.manage().window().maximize();
		Thread.sleep(2000);		
		utils.navigate(driver,url.toString());
		//ext.transamrt_login(driver, logger, rDefaultPath,user_name,pass_word);
		Roles_ext.transamrt_login(driver, logger, sDefaultPath, user_name, pass_word);
		Thread.sleep(2000);
		utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
		Thread.sleep(2000);
		utils.ExtentLogPassFail(driver, "trans_tab", "\t\t PASSED", ""+"\t\t FAILED1", logger,true, rDefaultPath,transactions);
	    utils.ClickObject(driver, "view", rDefaultPath+transactions);
		Thread.sleep(2000);			
		utils.ExtentLogPassFail(driver, "viewbtn", "\t\t PASSED", ""+"\t\t FAILED2", logger,true, rDefaultPath,transactions);
		utils.ClickObject(driver, "viewbtn", rDefaultPath+transactions);
		Thread.sleep(2000);
		Thread.sleep(2000);			
		Thread.sleep(2000);
				
		utils.ExtentLogPassFail(driver, "viewbtn", " \t\t PASSED", " \t\t PASSED3", logger,true, rDefaultPath,transactions);
		
	}catch(Exception e) {}
	
}
/*****role view_transactions()***/
/*****view_supplier payments()***/
public void Roles_view_supplier_payments(WebDriver driver, ExtentTest logger, String sDefaultPath,String user_name,String pass_word) {
	dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
	rDefaultPath=sDefaultPath;// assigning a new repository folder
	

	try {
		
		 url=getdata.ReadData("Roles_DataExcel", "users", "url", 2);
		 roles=getdata.ReadData("Roles_DataExcel", "users", "roles", 2);
		// user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
		// pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
	
		
		
		//getdata.ReadData(filename, sheetname, colname, rownum)
		//System.out.println(url);
		//System.out.println(username);
		//System.out.println(password);
		driver.manage().window().maximize();
		Thread.sleep(2000);		
		utils.navigate(driver,url.toString());
		//ext.transamrt_login(driver, logger, rDefaultPath,user_name,pass_word);
		Roles_ext.transamrt_login(driver, logger, sDefaultPath, user_name, pass_word);
		Thread.sleep(2000);
		if (utils.checkIfObjectExists(driver, "trans_tab", rDefaultPath+transactions)) {
			utils.ExtentLogPassFail(driver, "trans_tab", "\t\t PASSED", ""+"\t\t FAILED1", logger,true, rDefaultPath,transactions);
			utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
		}else {
			utils.ExtentLogPassFail(driver, "trans_tabx", "\t\t PASSED", ""+"\t\t FAILED1", logger,true, rDefaultPath,transactions);
		}
		
		Thread.sleep(2000);
		if (utils.checkIfObjectExists(driver, "payment_changes", rDefaultPath+transactions)) {
			utils.ExtentLogPassFail(driver, "payment_changes", "\t\t PASSED", ""+"\t\t FAILED1", logger,true, rDefaultPath,transactions);
			utils.ClickObject(driver, "payment_changes", rDefaultPath+transactions);
		}else {
			utils.ExtentLogPassFail(driver, "payment_changesx", "\t\t PASSED", ""+"\t\t FAILED1", logger,true, rDefaultPath,transactions);
		}
		Thread.sleep(2000);	
		if (utils.checkIfObjectExists(driver, "Supplier_d", rDefaultPath+transactions)) {
			utils.ExtentLogPassFail(driver, "Supplier_d", "\t\t PASSED", ""+"\t\t FAILED1", logger,true, rDefaultPath,transactions);
			utils.ClickObject(driver, "Supplier_d", rDefaultPath+transactions);
			utils.SelectTextUsingVisibeText(driver, "Supplier_d", "EShop Merchant", rDefaultPath+transactions);
		}else {
			utils.ExtentLogPassFail(driver, "Supplier_dx", "\t\t PASSED", ""+"\t\t FAILED1", logger,true, rDefaultPath,transactions);
		}
				
		Thread.sleep(2000);
		if (utils.checkIfObjectExists(driver, "buttonSubmit", rDefaultPath+transactions)) {
			utils.ExtentLogPassFail(driver, "buttonSubmit", "\t\t PASSED", ""+"\t\t FAILED1", logger,true, rDefaultPath,transactions);
			utils.ClickObject(driver, "buttonSubmit", rDefaultPath+transactions);
		}else {
			utils.ExtentLogPassFail(driver, "buttonSubmitx", "\t\t PASSED", ""+"\t\t FAILED1", logger,true, rDefaultPath,transactions);
		}
		utils.ExtentLogPassFail(driver, "buttonSubmit", "\t\t PASSED", ""+"\t\t FAILED1", logger,true, rDefaultPath,transactions);
		
	}catch(Exception e) {}
	
}
/*****view_view_supplier payments()***/

public void Roles_Sales_Summary(WebDriver driver, ExtentTest logger, String sDefaultPath,String user_name,String pass_word) {
	//Sales Summary

	dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
	rDefaultPath=sDefaultPath;// assigning a new repository folder
	
	try {
		 url=getdata.ReadData("Roles_DataExcel", "users", "url", 2);
		 roles=getdata.ReadData("Roles_DataExcel", "users", "roles", 2);
		// user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
		// pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
	
		
		
		//getdata.ReadData(filename, sheetname, colname, rownum)
		//System.out.println(url);
		//System.out.println(username);
		//System.out.println(password);
		driver.manage().window().maximize();
		Thread.sleep(2000);		
		utils.navigate(driver,url.toString());
		//ext.transamrt_login(driver, logger, rDefaultPath,user_name,pass_word);
		Roles_ext.transamrt_login(driver, logger, sDefaultPath, user_name, pass_word);
		Thread.sleep(2000);
		
		 if(utils.checkIfObjectExists(driver, "trans_tab", rDefaultPath+transactions)) {
			 utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
			 utils.ExtentLogPassFail(driver, "trans_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }else {
			  utils.ExtentLogPassFail(driver, "trans_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		
		 if(utils.checkIfObjectExists(driver, "sales_summary", rDefaultPath+transactions)) {			 
			 utils.ExtentLogPassFail(driver, "sales_summary", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "sales_summary", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "sales_summaryx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		
		 if(utils.checkIfObjectExists(driver, "Supplier_d", rDefaultPath+transactions)) {
			 utils.ExtentLogPassFail(driver, "Supplier_d", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "Supplier_d", rDefaultPath+transactions);
			 utils.SelectTextUsingVisibeText(driver, "Supplier_d", "A1M", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "Supplier_dx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		
		/* if(utils.checkIfObjectExists(driver, "Supplier_ds", rDefaultPath+transactions)) {
			 utils.ExtentLogPassFail(driver, "Supplier_ds", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "Supplier_ds", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "Supplier_dsx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }*/
		 
		 if(utils.checkIfObjectExists(driver, "buttonSubmit", rDefaultPath+transactions)) {
			 utils.ExtentLogPassFail(driver, "buttonSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "buttonSubmit", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "buttonSubmitx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		 utils.ExtentLogPassFail(driver, "buttonSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		
	}catch(Exception e) {}
}
public void Roles_Transaction_Status_Report(WebDriver driver, ExtentTest logger, String sDefaultPath,String user_name,String pass_word) {
	//Transaction_Status_Report
	dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
	rDefaultPath=sDefaultPath;// assigning a new repository folder
	
	try {
		 url=getdata.ReadData("Roles_DataExcel", "users", "url", 2);
		 roles=getdata.ReadData("Roles_DataExcel", "users", "roles", 2);
		 //user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
		// pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
	
		
		
		//getdata.ReadData(filename, sheetname, colname, rownum)
		//System.out.println(url);
		//System.out.println(username);
		//System.out.println(password);
		driver.manage().window().maximize();
		Thread.sleep(2000);		
		utils.navigate(driver,url.toString());
		//ext.transamrt_login(driver, logger, rDefaultPath,user_name,pass_word);
		Roles_ext.transamrt_login(driver, logger, sDefaultPath, user_name, pass_word);
		Thread.sleep(2000);
		
		 if(utils.checkIfObjectExists(driver, "trans_tab", rDefaultPath+transactions)) {
			 utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
			 utils.ExtentLogPassFail(driver, "trans_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }else {
			  utils.ExtentLogPassFail(driver, "trans_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		
		 if(utils.checkIfObjectExists(driver, "report", rDefaultPath+transactions)) {			 
			 utils.ExtentLogPassFail(driver, "report", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "report", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "reportx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		
		 if(utils.checkIfObjectExists(driver, "Supplier_d", rDefaultPath+transactions)) {
			 utils.ExtentLogPassFail(driver, "Supplier_d", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "Supplier_d", rDefaultPath+transactions);
			 utils.SelectTextUsingVisibeText(driver, "Supplier_d", "A1M", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "Supplier_dx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		 
		
		 if(utils.checkIfObjectExists(driver, "buttonSubmit", rDefaultPath+transactions)) {
			 utils.ExtentLogPassFail(driver, "buttonSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "buttonSubmit", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "buttonSubmitx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		 utils.ExtentLogPassFail(driver, "buttonSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		
	}catch(Exception e) {}
}
/******find transaction  ***/
public void Roles_find_transactions(WebDriver driver, ExtentTest logger, String sDefaultPath,String user_name,String pass_word) throws Exception {
	dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
	rDefaultPath=sDefaultPath;// assigning a new repository folder
	transaction_ID=getdata.ReadData("DataExcel", "view_transactions", "Transaction_id", 2);
	 System.out.print(transaction_ID);
	
	try {

		 url=getdata.ReadData("Roles_DataExcel", "users", "url", 2);
		 roles=getdata.ReadData("Roles_DataExcel", "users", "roles", 2);
		// user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
		// pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
	
		
		
		//getdata.ReadData(filename, sheetname, colname, rownum)
		//System.out.println(url);
		//System.out.println(username);
		//System.out.println(password);
		driver.manage().window().maximize();
		Thread.sleep(2000);		
		utils.navigate(driver,url.toString());
		//ext.transamrt_login(driver, logger, rDefaultPath,user_name,pass_word);
		Roles_ext.transamrt_login(driver, logger, sDefaultPath, user_name, pass_word);
		Thread.sleep(2000);
	
		utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
		utils.ExtentLogPassFail(driver, "findt", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		utils.ClickObject(driver, "findt", rDefaultPath+transactions);
		 utils.ExtentLogPassFail(driver, "tranid", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		 utils.EnterText(driver, "tranid", "105460000000000001237", rDefaultPath+transactions);
		 utils.ExtentLogPassFail(driver, "tranid", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		 utils.ClickObject(driver, "findButton", rDefaultPath+transactions);
		 utils.ExtentLogPassFail(driver, "findButton", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		// utils.ExtentLogPassFail(driver, sObject, sMessagePass, sMessageFail, logger, Screenshot, sDefaultPath, xmlpath);
		} catch(Exception e) {}
	}

/****find transaction***/
public void Roles_Supplier_Details_Lookup(WebDriver driver, ExtentTest logger, String sDefaultPath,String user_name,String pass_word) {
	//Sales Summary

	dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
	rDefaultPath=sDefaultPath;// assigning a new repository folder
	
	try {
		 url=getdata.ReadData("Roles_DataExcel", "users", "url", 2);
		 roles=getdata.ReadData("Roles_DataExcel", "users", "roles", 2);
		 //user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
		 //pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
	
		
		
		//getdata.ReadData(filename, sheetname, colname, rownum)
		//System.out.println(url);
		//System.out.println(username);
		//System.out.println(password);
		driver.manage().window().maximize();
		Thread.sleep(2000);		
		utils.navigate(driver,url.toString());
		//ext.transamrt_login(driver, logger, rDefaultPath,user_name,pass_word);
		Roles_ext.transamrt_login(driver, logger, sDefaultPath, user_name, pass_word);
		Thread.sleep(2000);
		
		 if(utils.checkIfObjectExists(driver, "Supplierlink", rDefaultPath+transactions)) {
			 utils.ClickObject(driver, "Supplierlink", rDefaultPath+transactions);
			 utils.ExtentLogPassFail(driver, "Supplierlink", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }else {
			  utils.ExtentLogPassFail(driver, "Supplierlinkx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		
		 if(utils.checkIfObjectExists(driver, "Lookup", rDefaultPath+transactions)) {		
			 utils.ExtentLogPassFail(driver, "Lookup", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "Lookup", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "Lookupx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		 
		 if(utils.checkIfObjectExists(driver, "Supplier_d", rDefaultPath+transactions)) {		
			 utils.ExtentLogPassFail(driver, "Supplier_d", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "Supplier_d", rDefaultPath+transactions);
			 utils.SelectTextUsingVisibeText(driver, "Supplier_d", "EShop Merchant", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "Supplier_dx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		 
		 if(utils.checkIfObjectExists(driver, "btnSubmit", rDefaultPath+transactions)) {		
			 utils.ExtentLogPassFail(driver, "btnSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "btnSubmit", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "btnSubmitx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		 String a=utils.GetText(driver, "General_Details", rDefaultPath+transactions);
		 if(a.equals("General Details")) {
			 utils.ExtentLogPassFail(driver, "General_Details1", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		 }else {
			 utils.ExtentLogPassFail(driver, "btnSubmitx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		 }
		
	}catch(Exception e) {}
}
public void Roles_View_Supplier_Setup(WebDriver driver, ExtentTest logger, String sDefaultPath,String user_name,String pass_word) {
	//Sales Summary

	dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
	rDefaultPath=sDefaultPath;// assigning a new repository folder
	
	try {
		 url=getdata.ReadData("Roles_DataExcel", "users", "url", 2);
		 roles=getdata.ReadData("Roles_DataExcel", "users", "roles", 2);
		// user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
		// pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
	
		
		
		//getdata.ReadData(filename, sheetname, colname, rownum)
		//System.out.println(url);
		//System.out.println(username);
		//System.out.println(password);
		driver.manage().window().maximize();
		Thread.sleep(2000);		
		utils.navigate(driver,url.toString());
		//ext.transamrt_login(driver, logger, rDefaultPath,user_name,pass_word);
		Roles_ext.transamrt_login(driver, logger, sDefaultPath, user_name, pass_word);
		Thread.sleep(2000);
		
		 if(utils.checkIfObjectExists(driver, "Supplierlink", rDefaultPath+transactions)) {
			 utils.ClickObject(driver, "Supplierlink", rDefaultPath+transactions);
			 utils.ExtentLogPassFail(driver, "Supplierlink", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }else {
			  utils.ExtentLogPassFail(driver, "Supplierlinkx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		
		 if(utils.checkIfObjectExists(driver, "Supplier_setup", rDefaultPath+transactions)) {		
			 utils.ExtentLogPassFail(driver, "Supplier_setup", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "Supplier_setup", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "Supplier_setupx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		 
		 if(utils.checkIfObjectExists(driver, "Supplier_d", rDefaultPath+transactions)) {		
			 utils.ExtentLogPassFail(driver, "Supplier_d", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "Supplier_d", rDefaultPath+transactions);
			 utils.SelectTextUsingVisibeText(driver, "Supplier_d", "EShop Merchant", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "Supplier_dx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		 
		 if(utils.checkIfObjectExists(driver, "btnSubmit", rDefaultPath+transactions)) {		
			 utils.ExtentLogPassFail(driver, "btnSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "btnSubmit", rDefaultPath+transactions);
		 }else {
			  utils.ExtentLogPassFail(driver, "btnSubmitx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		  }
		 String a=utils.GetText(driver, "Transaction_Fees", rDefaultPath+transactions);
		 if(a.equals("Transaction Fees")) {
			 utils.ExtentLogPassFail(driver, "Transaction_Fees1", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		 }else {
			 utils.ExtentLogPassFail(driver, "Transaction_Fees1x", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions); 
		 }
		
	}catch(Exception e) {}
}
}
