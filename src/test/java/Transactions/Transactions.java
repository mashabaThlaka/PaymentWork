package Transactions;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import transmart_properties.properties_extender;
import vodacom.payment_solution.vodacom.payment_solution.ReadExcelData;
import vodacom.payment_solution.vodacom.payment_solution.UtilityFunctions;
import vodacom.payment_solution.vodacom.payment_solution.WriteExcelData;

public class Transactions {
	static ReadExcelData getdata=new ReadExcelData();
	static WriteExcelData writedata= new WriteExcelData();
	static properties_extender ext=new properties_extender();
	static UtilityFunctions utils = new UtilityFunctions();
	static Transactions trans =new Transactions();
	
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
	
	//folders 
		private static String dpath="\\data\\";//excel external file folder		

		//xml file name 
		private static String transactions="\\Repository\\test_eshop.xml";// xml file for transactions payment
		//private static String transactions="\\Repository\\transactions.xml";//xml for front office 
		private static String supplier="\\Repository\\supplier.xml";//xml for supplier
	
	/*****T_003_view_transactions()***/
	public void T_view_transactions(WebDriver driver, ExtentTest logger, String sDefaultPath,String subfolderPath) {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder

		try {
		if(utils.checkIfObjectExists(driver, "trans_tab", rDefaultPath+transactions)) {
			utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
			Thread.sleep(2000);		
			utils.ExtentLogPass(driver, "Passed", logger, true, subfolderPath);
			utils.ClickObject(driver, "view", rDefaultPath+transactions);
			Thread.sleep(2000);			
		}else {
		
			utils.ExtentLogFail(driver, "Failed", logger, true, subfolderPath);
		}
		
		if(utils.checkIfObjectExists(driver, "viewbtn", rDefaultPath+transactions)) {
			utils.ClickObject(driver, "viewbtn", rDefaultPath+transactions);
			utils.ExtentLogPass(driver, "Passed", logger, true, subfolderPath);
			
			Thread.sleep(2000);
			Thread.sleep(2000);			
			Thread.sleep(2000);
		
		}else {
			utils.ExtentLogFail(driver, "Failed", logger, true, subfolderPath);
		}

		}catch(Exception e) {}
		
	}
	/*****T_003_view_transactions()***/

	/*****refund transactions 
	 * @throws Exception **/
	public void T_0006_refund_transactions(WebDriver driver, ExtentTest logger, String sDefaultPath) throws Exception {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder
		transaction_ID=getdata.ReadData("DataExcel", "transactions", "transaction ID", 2);
		try {
			
			url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
			username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 2);
			password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 2);
			driver.manage().window().maximize();
			Thread.sleep(2000);		
			utils.navigate(driver,url.toString());
			////ext.transamrt_login(driver, logger, rDefaultPath,username,password);
			//Thread.sleep(2000);	
			//utils.ClickObject(driver, "t", rDefaultPath+transactions);
			utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
			Thread.sleep(2000);	
			utils.ExtentLogPassFail(driver, "Refundt", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			utils.ClickObject(driver, "Refundt", rDefaultPath+transactions);
			Thread.sleep(2000);
			utils.ExtentLogPassFail(driver, "Transaction_id", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			utils.EnterText(driver, "Transaction_id",transaction_ID.toString(), rDefaultPath+transactions);
			Thread.sleep(2000);
			utils.ExtentLogPassFail(driver, "buttonSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);		
			utils.ClickObject(driver, "buttonSubmit", rDefaultPath+transactions);
			Thread.sleep(2000);	
			
			utils.ExtentLogPassFail(driver, "validate", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);		
			//*[@id="content"]/table/tbody/tr/td
			/*if(driver.getPageSource().contains("The transaction was refunded successfully")){
				   Thread.sleep(1000);
				   utils.ExtentLogPassFail(driver, "test2","\t\t PASSED", "-1", logger,true, rDefaultPath,transactions);
				   Thread.sleep(1000);
				}else{
					Thread.sleep(1000);
				   utils.ExtentLogPassFail(driver, "refund", "-2", " \t\t FAILED", logger,true, rDefaultPath,transactions);
				   Thread.sleep(1000);
				  
				}*/
			
		}catch(Exception e) {}
		
	}
	/*****refund transactions **/

	/******find transaction front office ***/
	public void find_transactions(WebDriver driver, ExtentTest logger, String sDefaultPath) throws Exception {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder
		transaction_ID=getdata.ReadData("DataExcel", "view_transactions", "Transaction_id", 2);
		
		
		try {

			utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
			utils.ExtentLogPassFail(driver, "findt", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			utils.ClickObject(driver, "findt", rDefaultPath+transactions);
			 utils.ExtentLogPassFail(driver, "tranid", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.EnterText(driver, "tranid", "106220000000000000149", rDefaultPath+transactions);
			 utils.ExtentLogPassFail(driver, "tranid", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "findButton", rDefaultPath+transactions);
			 utils.ExtentLogPassFail(driver, "findButton", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			// utils.ExtentLogPassFail(driver, sObject, sMessagePass, sMessageFail, logger, Screenshot, sDefaultPath, xmlpath);
			} catch(Exception e) {}
		}

	/****find transaction***/

	/******back office**/
	public void find_transactions_back(WebDriver driver, ExtentTest logger, String sDefaultPath) throws Exception {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder
		transaction_ID=getdata.ReadData("DataExcel", "view_transactions", "Transaction_id", 2);
		 System.out.print(transaction_ID);
		
		try {

			url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
			username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 3);
			password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 3);
			
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			driver.manage().window().maximize();
			Thread.sleep(2000);		
			utils.navigate(driver,url.toString());
			//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
			Thread.sleep(2000);	
			utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
			utils.ExtentLogPassFail(driver, "findt", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "findt", rDefaultPath+transactions);
			 utils.ExtentLogPassFail(driver, "tranid", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.EnterText(driver, "tranid", "106220000000000000149", rDefaultPath+transactions);
			 utils.ExtentLogPassFail(driver, "tranid", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			 utils.ClickObject(driver, "findButton", rDefaultPath+transactions);
			 utils.ExtentLogPassFail(driver, "findButton", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			/// utils.ExtentLogPassFail(driver, sObject, sMessagePass, sMessageFail, logger, Screenshot, sDefaultPath, xmlpath);
			} catch(Exception e) {}
		}
	/*****back office***/

	/*****T_003_view_transactions()***/
	public void T_0005_view_transactions_front(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder
		

		try {
			
			url=getdata.ReadData("DataExcel","view_transactions","url",2);
			username=getdata.ReadData("DataExcel","view_transactions","user_name",2);
			password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 2);
		
			
			System.out.print(url);
			//getdata.ReadData(filename, sheetname, colname, rownum)
			//System.out.println(url);
			//System.out.println(username);
			//System.out.println(password);
			driver.manage().window().maximize();
			Thread.sleep(2000);		
			utils.navigate(driver,url.toString());
			//.transamrt_login(driver, logger, rDefaultPath,username,password);
			Thread.sleep(2000);
			utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
			//driver.findElement(By.linkText("Transactions")).click();
			Thread.sleep(2000);
			utils.ExtentLogPassFail(driver, "view", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			utils.ClickObject(driver, "view", rDefaultPath+transactions);
			Thread.sleep(2000);			
			utils.ExtentLogPassFail(driver, "viewbtn", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			utils.ClickObject(driver, "viewbtn", rDefaultPath+transactions);
			Thread.sleep(2000);
			Thread.sleep(2000);			
			Thread.sleep(2000);
					
			utils.ExtentLogPassFail(driver, "viewbtn", " \t\t PASSED", " \t\t PASSED", logger,true, rDefaultPath,transactions);
			
		}catch(Exception e) {}
		
	}
	/*****T_003_view_transactions()***/

	public void confirm_refund(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder
		try {
			
			url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
			username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 3);
			password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 3);
			String a=getdata.ReadData("DataExcel", "transactions", "transaction ID", 2);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			url.toString();
			System.out.println(a);
			

			utils.navigate(driver,url.toString());
			driver.manage().window().maximize();
			Thread.sleep(2000);		
			utils.navigate(driver,url.toString());
			//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
			Thread.sleep(2000);	
			utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
			if(utils.checkIfObjectExists(driver, "conF", rDefaultPath+transactions)){
				utils.ExtentLogPassFail(driver, "conF", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.ClickObject(driver, "conF", rDefaultPath+transactions);
			}else{
				utils.ExtentLogPassFail(driver, "conFx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			}
			
			if(utils.checkIfObjectExists(driver, "search", rDefaultPath+transactions)){
				utils.ExtentLogPassFail(driver, "search", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.EnterText(driver, "search", a, rDefaultPath+transactions);
			}else{
				utils.ExtentLogPassFail(driver, "searchx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			}
			
			if(utils.checkIfObjectExists(driver, "findButton", rDefaultPath+transactions)){
				utils.ExtentLogPassFail(driver, "findButton", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.ClickObject(driver, "findButton", rDefaultPath+transactions);
			}else{
				utils.ExtentLogPassFail(driver, "findButtonx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			}
			
			if(utils.checkIfObjectExists(driver, "buttonconfirm", rDefaultPath+transactions)){
				utils.ExtentLogPassFail(driver, "buttonconfirm", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.ClickObject(driver, "buttonconfirm", rDefaultPath+transactions);
			}else{
				utils.ExtentLogPassFail(driver, "buttonconfirm", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			}
			
			if(utils.checkIfObjectExists(driver, "warn", rDefaultPath+transactions)){
				utils.ExtentLogPassFail(driver, "warn", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.ClickObject(driver, "warn", rDefaultPath+transactions);
			}else{
				utils.ExtentLogPassFail(driver, "warnx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			}
			
			if(utils.checkIfObjectExists(driver, "buttonSubmit", rDefaultPath+transactions)){
				utils.ExtentLogPassFail(driver, "buttonSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.ClickObject(driver, "buttonSubmit", rDefaultPath+transactions);
			}else{
				utils.ExtentLogPassFail(driver, "buttonSubmitx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			}
			String r=utils.GetText(driver, "results1", rDefaultPath+transactions);
			 if(utils.checkIfObjectExists(driver, "results2", rDefaultPath+transactions)) {
				 if(r.equals("The refund was confirmed successfully")) {
					 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				
				 }else {utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);}
				 
				 //utils.ClickObject(driver, "confirmbtn", rDefaultPath+transactions);
			 }else {
				 utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			// 
		    
			/*if(utils.checkIfObjectExists(driver, "content", rDefaultPath+transactions)){
				utils.ExtentLogPassFail(driver, "content", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				//utils.ClickObject(driver, "content", rDefaultPath+transactions);
			}else{
				utils.ExtentLogPassFail(driver, "contentx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			}*/
		
		
	}catch(Exception e) {}	
	}


	public void reject_refund(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder
		try {
			
			url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
			username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 3);
			password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 3);
			String a=getdata.ReadData("DataExcel", "transactions", "transaction ID", 2);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			url.toString();
			System.out.println(a);
			

			utils.navigate(driver,url.toString());
			driver.manage().window().maximize();
			Thread.sleep(2000);		
			utils.navigate(driver,url.toString());
			//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
			Thread.sleep(2000);	
			utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);

			if(utils.checkIfObjectExists(driver, "conF", rDefaultPath+transactions)){
				utils.ExtentLogPassFail(driver, "conF", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.ClickObject(driver, "conF", rDefaultPath+transactions);
			}else{
				utils.ExtentLogPassFail(driver, "conFx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			}
			
			if(utils.checkIfObjectExists(driver, "findButton", rDefaultPath+transactions)){
				utils.ExtentLogPassFail(driver, "findButton", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.ClickObject(driver, "findButton", rDefaultPath+transactions);
			}else{
				utils.ExtentLogPassFail(driver, "findButtonx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			}
			
			if(utils.checkIfObjectExists(driver, "reject", rDefaultPath+transactions)){
				utils.ExtentLogPassFail(driver, "reject", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.ClickObject(driver, "reject", rDefaultPath+transactions);
			}else{
				utils.ExtentLogPassFail(driver, "rejectx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			}
			
			if(utils.checkIfObjectExists(driver, "content", rDefaultPath+transactions)){
				utils.ExtentLogPassFail(driver, "content", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.ClickObject(driver, "content", rDefaultPath+transactions);
			}else{
				utils.ExtentLogPassFail(driver, "contentx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			}
		
			
			
			
		
	}catch(Exception e) {}	
	}

	public void charge_back(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//charge back
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder
		String transaction_id;
		try {
			  transaction_id=getdata.ReadData("DataExcel", "transactions", "transaction ID", 2);
			  url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
			  username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
			  password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
			  driver.manage().window().maximize();
				Thread.sleep(2000);
				url.toString();	
				utils.navigate(driver,url.toString());
				//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
				Thread.sleep(2000);	
			 //create data
				utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
				utils.ClickObject(driver, "view", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_d", rDefaultPath+transactions);
				utils.SelectTextUsingVisibeText(driver, "View_d", "refunded", rDefaultPath+transactions);						
				utils.ClickObject(driver, "viewbtn", rDefaultPath+transactions);
				String c=utils.GetText(driver, "charge_back_id", rDefaultPath+transactions);
				//System.out.println(a);/*
				writedata.WriteExcel("Charge_backs",c,1, 0);
				utils.ClickObject(driver, "go-back", rDefaultPath+transactions);
				Thread.sleep(2000);
			
			 if(utils.checkIfObjectExists(driver, "trans_tab", rDefaultPath+transactions)) {
				 utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
				 utils.ExtentLogPassFail(driver, "trans_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }else {
				  utils.ExtentLogPassFail(driver, "trans_tabx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			 
			  if(utils.checkIfObjectExists(driver, "chargebacks", rDefaultPath+transactions)) {
				  utils.ExtentLogPassFail(driver, "chargebacks", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  Thread.sleep(1000);	
				  utils.ClickObject(driver, "chargebacks", rDefaultPath+transactions);
					
				  }else {
					  utils.ExtentLogPassFail(driver, "chargebacksx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
			
			  if(utils.checkIfObjectExists(driver, "Transaction_id", rDefaultPath+transactions)) {
				  utils.EnterText(driver, "Transaction_id", c, rDefaultPath+transactions);
				  //System.out.println(transaction_id);
					 utils.ExtentLogPassFail(driver, "Transaction_id", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }else {
					  utils.ExtentLogPassFail(driver, "Transaction_idx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
			 
			  if(utils.checkIfObjectExists(driver, "Warn", rDefaultPath+transactions)) {
				  utils.ClickObject(driver, "Warn", rDefaultPath+transactions);
					 utils.ExtentLogPassFail(driver, "Warn", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }else {
					  utils.ExtentLogPassFail(driver, "Warnx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
			  
			  if(utils.checkIfObjectExists(driver, "buttonSubmit", rDefaultPath+transactions)) {
				 
					 utils.ExtentLogPassFail(driver, "buttonSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					 utils.ClickObject(driver, "buttonSubmit", rDefaultPath+transactions);
			  }else {
					  utils.ExtentLogPassFail(driver, "buttonSubmitx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
			  //The transaction was charged back successfully
			 
			 if(utils.checkIfObjectExists(driver, "chargeback_c1", rDefaultPath+transactions)) {
				 String a=utils.GetText(driver, "chargeback_c", rDefaultPath+transactions);
				
				 if(a.equals("The transaction was charged back successfully")){
					 utils.ExtentLogPassFail(driver, "chargeback_c1", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 }else {
					 utils.ExtentLogPassFail(driver, "chargeback_cx", "\t\t PASSED", "zzzzz"+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 }
					
				  }else {
					  utils.ExtentLogPassFail(driver, "chargeback_cx", "\t\t PASSED", "3"+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
			 
			 
			 
		       
		       
		}catch(Exception e) {}
		
	}
	public void Confirm_charge_back(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//confirm charge back
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder
			String transaction_id;
			try {
				  transaction_id=getdata.ReadData("DataExcel", "Charge_backs", "transaction_id", 2);
				  url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
				  username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
				  password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
				  driver.manage().window().maximize();
					Thread.sleep(2000);
					url.toString();	
					utils.navigate(driver,url.toString());
					//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
					Thread.sleep(2000);	
					System.out.println(transaction_id);
				  
				  if(utils.checkIfObjectExists(driver, "trans_tab", rDefaultPath+transactions)) {
					 utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
					 utils.ExtentLogPassFail(driver, "trans_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }else {
					  utils.ExtentLogPassFail(driver, "trans_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
				  
				  if(utils.checkIfObjectExists(driver, "chargeback_confirm", rDefaultPath+transactions)) {					 
						 utils.ExtentLogPassFail(driver, "chargeback_confirm", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
						 utils.ClickObject(driver, "chargeback_confirm", rDefaultPath+transactions);
				  }else {
						  utils.ExtentLogPassFail(driver, "chargeback_confirmx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					  }
				
				  if(utils.checkIfObjectExists(driver, "Transaction_id", rDefaultPath+transactions)) {
						 utils.ExtentLogPassFail(driver, "Transaction_id", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
						 utils.EnterText(driver, "Transaction_id", transaction_id, rDefaultPath+transactions);
				  }else {
						  utils.ExtentLogPassFail(driver, "Transaction_idx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					  }
				 
				  if(utils.checkIfObjectExists(driver, "buttonSubmit", rDefaultPath+transactions)) {
						 utils.ExtentLogPassFail(driver, "buttonSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
						 utils.ClickObject(driver, "buttonSubmit", rDefaultPath+transactions);
				  }else {
						  utils.ExtentLogPassFail(driver, "buttonSubmitx", "S\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					  }
				  //
				  if(utils.checkIfObjectExists(driver, "c_chargeback_c1", rDefaultPath+transactions)) {
					  String a= utils.GetText(driver, "c_chargeback_c", rDefaultPath+transactions);
					  //System.out.println("test>>"+a);
					  if(a.equals("The chargeback was confirmed successfully")) {
						  utils.ExtentLogPassFail(driver, "c_chargeback_c1", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					  }else {
						  utils.ExtentLogPassFail(driver, "c_chargeback_c1x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					  }
					
						 
				  }else {
						  utils.ExtentLogPassFail(driver, "c_chargeback_c1x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					  }
				  
			}catch(Exception e) {}
	}
	public void Confirm_Multiple_Chargebacks(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//Confirm Multiple Chargebacks  
		//Transaction_Status_Report
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder
			
			try {
				url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
				username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
				password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
				String a=getdata.ReadData("DataExcel", "Charge_backs", "transaction_id", 3);
				String b=getdata.ReadData("DataExcel", "Charge_backs", "transaction_id", 4);
			
				driver.manage().window().maximize();
				Thread.sleep(2000);
				url.toString();
				utils.navigate(driver,url.toString());
				//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
				Thread.sleep(2000);
				
				 if(utils.checkIfObjectExists(driver, "transation_tab", rDefaultPath+transactions)) {
					 utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
					 utils.ExtentLogPassFail(driver, "transation_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }else {
					  utils.ExtentLogPassFail(driver, "transation_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
				 
				 if(utils.checkIfObjectExists(driver, "con_mult_charge", rDefaultPath+transactions)) {
					 utils.ExtentLogPassFail(driver, "con_mult_charge", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					 utils.ClickObject(driver, "con_mult_charge", rDefaultPath+transactions);
				 }else {
					  utils.ExtentLogPassFail(driver, "con_mult_chargex", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
			 
				
				 if(utils.checkIfObjectExists(driver, "TransactionID", rDefaultPath+transactions)) {
					 utils.ExtentLogPassFail(driver, "TransactionID", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					 utils.EnterText(driver, "TransactionID", a+"\n"+b, rDefaultPath+transactions);
				 }else {
					  utils.ExtentLogPassFail(driver, "TransactionIDx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
			 
				 
				 if(utils.checkIfObjectExists(driver, "confirmbtn", rDefaultPath+transactions)) {
					 utils.ExtentLogPassFail(driver, "confirmbtn", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					 utils.ClickObject(driver, "confirmbtn", rDefaultPath+transactions);
				 }else {
					  utils.ExtentLogPassFail(driver, "confirmbtnx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
				 String r=utils.GetText(driver, "results1", rDefaultPath+transactions);
				 if(utils.checkIfObjectExists(driver, "results2", rDefaultPath+transactions)) {
					 if(r.equals("The chargebacks were confirmed successfully")) {
						 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					
					 }else {utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);}
					 
					 //utils.ClickObject(driver, "confirmbtn", rDefaultPath+transactions);
				 }else {
					 utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
				 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				// 
			 
			}catch(Exception e) {}
	}
	public void Sales_Summary(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//Sales Summary

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
			//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
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

	public void View_Payment_Changes(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//View Payment Changes  


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
			//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
			Thread.sleep(2000);
			
			 if(utils.checkIfObjectExists(driver, "transation_tab", rDefaultPath+transactions)) {
				 utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
				 utils.ExtentLogPassFail(driver, "transation_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }else {
				  utils.ExtentLogPassFail(driver, "transation_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			
			 if(utils.checkIfObjectExists(driver, "view_payment_changes", rDefaultPath+transactions)) {			 
				 utils.ExtentLogPassFail(driver, "view_payment_changes", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 utils.ClickObject(driver, "view_payment_changes", rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "view_payment_changesx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			
			 if(utils.checkIfObjectExists(driver, "Supplier_d", rDefaultPath+transactions)) {
				 utils.ExtentLogPassFail(driver, "Supplier_d", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 utils.ClickObject(driver, "Supplier_d", rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "Supplier_dx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			
			 if(utils.checkIfObjectExists(driver, "Supplier_ds", rDefaultPath+transactions)) {
				 utils.ExtentLogPassFail(driver, "Supplier_ds", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 utils.ClickObject(driver, "Supplier_ds", rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "Supplier_dsx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			 
			 if(utils.checkIfObjectExists(driver, "Supplier_ds1", rDefaultPath+transactions)) {
				 utils.ExtentLogPassFail(driver, "Supplier_ds1", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 utils.ClickObject(driver, "Supplier_ds1", rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "Supplier_ds1x", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			 utils.ExtentLogPassFail(driver, "Supplier_ds1", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			
		}catch(Exception e) {}
	}

	public void Multiple_Chargebacks(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//Multiple Chargebacks  
		
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder
			
			try {
				url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
				username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
				password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
				//String x=getdata.ReadData("DataExcel", "Charge_backs", "transaction_id", 2);
			
				driver.manage().window().maximize();
				Thread.sleep(2000);
				url.toString();
				utils.navigate(driver,url.toString());
				//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
				Thread.sleep(2000);
				//create data
				utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
				utils.ClickObject(driver, "view_transactions", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_d", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_refunded", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_btn1", rDefaultPath+transactions);
				String a=utils.GetText(driver, "charge_back_id1", rDefaultPath+transactions);
				String b=utils.GetText(driver, "charge_back_id2", rDefaultPath+transactions);
				//System.out.println(a);
				writedata.WriteExcel("Charge_backs",a,2, 0);
				writedata.WriteExcel("Charge_backs",b,3, 0);
				Thread.sleep(2000);
				utils.ClickObject(driver,"go-back", rDefaultPath+transactions);
				
			 if(utils.checkIfObjectExists(driver, "transation_tab", rDefaultPath+transactions)) {
					 utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
					 utils.ExtentLogPassFail(driver, "transation_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }else {
					  utils.ExtentLogPassFail(driver, "transation_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
				 
				 if(utils.checkIfObjectExists(driver, "mulit", rDefaultPath+transactions)) {
					 utils.ExtentLogPassFail(driver, "mulit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					 utils.ClickObject(driver, "mulit", rDefaultPath+transactions);
				 }else {
					  utils.ExtentLogPassFail(driver, "mulitx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
				  
				  if(utils.checkIfObjectExists(driver, "warn", rDefaultPath+transactions)) {
						 utils.ExtentLogPassFail(driver, "warn", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
						 utils.ClickObject(driver, "warn", rDefaultPath+transactions);
					 }else {
						  utils.ExtentLogPassFail(driver, "warnx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					  }
				 
				 if(utils.checkIfObjectExists(driver, "TransactionID", rDefaultPath+transactions)) {
					 utils.ExtentLogPassFail(driver, "TransactionID", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					 utils.EnterText(driver, "TransactionID", a+"\n"+b, rDefaultPath+transactions);
				 }else {
					  utils.ExtentLogPassFail(driver, "TransactionIDx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
				 
				 if(utils.checkIfObjectExists(driver, "confirmbtn", rDefaultPath+transactions)) {
					 utils.ExtentLogPassFail(driver, "confirmbtn", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					 utils.ClickObject(driver, "confirmbtn", rDefaultPath+transactions);
				 }else {
					  utils.ExtentLogPassFail(driver, "confirmbtnx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
				
				 String r=utils.GetText(driver, "results1", rDefaultPath+transactions);
				 //System.out.println(r);
				if(utils.checkIfObjectExists(driver, "results2", rDefaultPath+transactions)) {
					 if(r.equals("The transactions were charged back successfully")) {
						 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					
					 }else {utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);}
					 
					 //utils.ClickObject(driver, "confirmbtn", rDefaultPath+transactions);
				 }else {
					 utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
				 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				// 
				
			}catch(Exception e) {}
	}


	public void Settle_Transaction(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//Settle Transaction  

		
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder
			
			try {
				url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
				username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
				password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
				//String x=getdata.ReadData("DataExcel", "Charge_backs", "transaction_id", 2);
			
				driver.manage().window().maximize();
				Thread.sleep(2000);
				url.toString();
				utils.navigate(driver,url.toString());
				//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
				Thread.sleep(2000);
				//create data
				utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
				utils.ExtentLogPassFail(driver, "trans_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.ClickObject(driver, "view", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_d", rDefaultPath+transactions);
				utils.SelectTextUsingVisibeText(driver, "View_d", "preauthorisations", rDefaultPath+transactions);		
				
				
				utils.ClickObject(driver, "NoToReturn", rDefaultPath+transactions);
				utils.SelectTextUsingVisibeText(driver, "NoToReturn", "100", rDefaultPath+transactions);
				utils.ExtentLogPassFail(driver, "viewbtn", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				utils.ClickObject(driver, "viewbtn", rDefaultPath+transactions);
				Thread.sleep(4000);
				utils.ExtentLogPassFail(driver, "transactionid_link", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		    	utils.ClickObject(driver, "transactionid_link", rDefaultPath+transactions);	    	
		    	Thread.sleep(2000);
		    	String a=utils.GetText(driver, "tran100", rDefaultPath+transactions);
		    	//String a=driver.findElement(By.id("tran100")).getText();
		    	System.out.println("oppps"+a);
		    	//utils.ExtentLogPassFail(driver, "buttonSubmit", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		    	//utils.ClickObject(driver, "buttonSubmit", rDefaultPath+transactions);	  
		    	
				/*String a=utils.GetText(driver, "transactionid_text", rDefaultPath+transactions);
			
				Thread.sleep(2000);
				utils.ClickObject(driver,"go-back", rDefaultPath+transactions);
			
			 if(utils.checkIfObjectExists(driver, "transation_tab", rDefaultPath+transactions)) {
					 utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
					 utils.ExtentLogPassFail(driver, "transation_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }else {
					  utils.ExtentLogPassFail(driver, "transation_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
			// utils.ClickObject(driver, "settle11", rDefaultPath+transactions);
			 if(utils.checkIfObjectExists(driver, "settle11", rDefaultPath+transactions)){
					utils.ExtentLogPassFail(driver, "settle11", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					 utils.ClickObject(driver, "settle11", rDefaultPath+transactions);
				}else{
					utils.ExtentLogPassFail(driver, "settlex", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				}
			 
			 if(utils.checkIfObjectExists(driver, "TransactionID", rDefaultPath+transactions)){
					utils.ExtentLogPassFail(driver, "TransactionID", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					utils.EnterText(driver, "TransactionID", a, rDefaultPath+transactions);
				}else{
					utils.ExtentLogPassFail(driver, "TransactionIDx", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				}
			 
			 if(utils.checkIfObjectExists(driver, "mulit_btn", rDefaultPath+transactions)){
					utils.ExtentLogPassFail(driver, "mulit_btn", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					utils.ClickObject(driver, "mulit_btn", rDefaultPath+transactions);
				}else{
					utils.ExtentLogPassFail(driver, "mulit_btnx", "\t\t PASSED", "S"+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				}
			//  
			 String r=utils.GetText(driver, "results1", rDefaultPath+transactions);
			 if(utils.checkIfObjectExists(driver, "results2", rDefaultPath+transactions)) {
				 if(r.equals("The transaction was settled successfully")) {
					 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				
				 }else {utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);}
				 
				 //utils.ClickObject(driver, "confirmbtn", rDefaultPath+transactions);
			 }else {
				 utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			// 
			 */
			}catch(Exception e) {}
	}

	public void Multiple_Refunds(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//Settle Transaction  

		
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder
			
			try {
				url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
				username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
				password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
				//String x=getdata.ReadData("DataExcel", "Charge_backs", "transaction_id", 2);
			
				driver.manage().window().maximize();
				Thread.sleep(2000);
				url.toString();
				utils.navigate(driver,url.toString());
				//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
				Thread.sleep(2000);
			/*	//create data
				utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
				utils.ClickObject(driver, "view_transactions", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_d12", rDefaultPath+transactions);
				utils.ClickObject(driver, "tran1", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_btn1", rDefaultPath+transactions);
				//utils.ClickObject(driver, "transactionid_link", rDefaultPath+transactions);
				String a=utils.GetText(driver, "text2", rDefaultPath+transactions);
				String b=utils.GetText(driver, "text1", rDefaultPath+transactions);
				
				System.out.print(a);
				System.out.print(b);
			
			Thread.sleep(2000);
				utils.ClickObject(driver,"go-back", rDefaultPath+transactions);
			
			 if(utils.checkIfObjectExists(driver, "transation_tab", rDefaultPath+transactions)) {
					 utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
					 utils.ExtentLogPassFail(driver, "transation_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }else {
					  utils.ExtentLogPassFail(driver, "transation_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
			 
			
			 if(utils.checkIfObjectExists(driver, "mult1", rDefaultPath+transactions)) {			 
				 utils.ExtentLogPassFail(driver, "mult1", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 utils.ClickObject(driver, "mult1", rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "mult1x", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			
			 if(utils.checkIfObjectExists(driver, "TransactionID", rDefaultPath+transactions)) {			 
				 utils.ExtentLogPassFail(driver, "TransactionID", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 utils.EnterText(driver, "TransactionID", a+"\n"+b, rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "TransactionIDx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			 
			 if(utils.checkIfObjectExists(driver, "supplier_s2", rDefaultPath+transactions)) {			 
				 utils.ExtentLogPassFail(driver, "supplier_s2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 utils.ClickObject(driver, "supplier_s2", rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "supplier_s2x", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			 
			 //
			 String r=utils.GetText(driver, "results1", rDefaultPath+transactions);
			 if(utils.checkIfObjectExists(driver, "results2", rDefaultPath+transactions)) {
				 if(r.equals("The transactions were refunded successfully ")) {
					 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					  


				 }else {utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);}
				 
				 //utils.ClickObject(driver, "confirmbtn", rDefaultPath+transactions);
			 }else {
				 utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			// */
			}catch(Exception e) {}
	}

	  
	public void Supplier_Statement (WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//Supplier Statement  
	 

		
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder
			
			try {
				url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
				username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
				password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
				//String x=getdata.ReadData("DataExcel", "Charge_backs", "transaction_id", 2);
			
				driver.manage().window().maximize();
				Thread.sleep(2000);
				url.toString();
				utils.navigate(driver,url.toString());
				//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
				Thread.sleep(2000);
				
				//utils.ClickObject(driver,"go-back", rDefaultPath+transactions);
			
			 if(utils.checkIfObjectExists(driver, "trans_tab", rDefaultPath+transactions)) {
					 utils.ClickObject(driver, "trans_tab", rDefaultPath+transactions);
					 utils.ExtentLogPassFail(driver, "trans_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }else {
					  utils.ExtentLogPassFail(driver, "trans_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
		          utils.ClickObject(driver, "Supplier_Statement",  rDefaultPath+transactions);
			 	
			 	if(utils.checkIfObjectExists(driver, "Supplier_d", rDefaultPath+transactions)) {			 
					 utils.ExtentLogPassFail(driver, "Supplier_d", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					 utils.ClickObject(driver, "Supplier_d", rDefaultPath+transactions);
					 utils.SelectTextUsingVisibeText(driver, "Supplier_d", "DVD Shop", rDefaultPath+transactions);
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
				
				Thread.sleep(2000);
			}catch(Exception e) {}
	}


	public void Cancel_Preauthorisation(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//Cancel Preauthorisation  
	 


		
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder
			
			try {
				url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
				username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
				password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
				//String x=getdata.ReadData("DataExcel", "Charge_backs", "transaction_id", 2);
			
				driver.manage().window().maximize();
				Thread.sleep(2000);
				url.toString();
				utils.navigate(driver,url.toString());
				//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
				Thread.sleep(2000);
				
				//utils.ClickObject(driver,"go-back", rDefaultPath+transactions);
			
			//create data
				utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
				utils.ClickObject(driver, "view_transactions", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_d12", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_d1", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_btn1", rDefaultPath+transactions);
				utils.ClickObject(driver, "transactionid_link", rDefaultPath+transactions);
				String a=utils.GetText(driver, "transactionid_text", rDefaultPath+transactions);
			    //System.out.print(a);
				Thread.sleep(2000);
				utils.ClickObject(driver,"go-back", rDefaultPath+transactions);

				 if(utils.checkIfObjectExists(driver, "transation_tab", rDefaultPath+transactions)) {
						 utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
						 utils.ExtentLogPassFail(driver, "transation_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					  }else {
						  utils.ExtentLogPassFail(driver, "transation_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					  }
				 utils.ClickObject(driver, "cancel", rDefaultPath+transactions);
				 utils.EnterText(driver, "TransactionID", a,  rDefaultPath+transactions);
				 utils.ClickObject(driver, "supplier_s2", rDefaultPath+transactions);
				 
		
			}catch(Exception e) {}
	}



	public void Reverse_Multiple_Chargebacks(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//Reverse_Multiple Chargebacks 
	 

		
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder
			
			try {
				url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
				username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
				password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
				//String x=getdata.ReadData("DataExcel", "Charge_backs", "transaction_id", 2);
			
				driver.manage().window().maximize();
				Thread.sleep(2000);
				url.toString();
				utils.navigate(driver,url.toString());
				//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
				Thread.sleep(2000);
				
				
				//create data
				utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
				utils.ClickObject(driver, "view_transactions", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_d", rDefaultPath+transactions);
				utils.ClickObject(driver, "option4", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_btn1", rDefaultPath+transactions);
				String a=utils.GetText(driver, "charge_back_id1", rDefaultPath+transactions);
				String b=utils.GetText(driver, "charge_back_id2", rDefaultPath+transactions);
				  //System.out.println(a);
				  //System.out.println(b);
				utils.ClickObject(driver,"go-back", rDefaultPath+transactions);
				Thread.sleep(2000);
				 if(utils.checkIfObjectExists(driver, "transation_tab", rDefaultPath+transactions)) {
					 utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
					 utils.ExtentLogPassFail(driver, "transation_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }else {
					  utils.ExtentLogPassFail(driver, "transation_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
		  
		  
		  if(utils.checkIfObjectExists(driver, "r_charges", rDefaultPath+transactions)) {			 
				 utils.ExtentLogPassFail(driver, "r_charges", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 utils.ClickObject(driver,"r_charges", rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "reportx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }		
		
		  if(utils.checkIfObjectExists(driver, "TransactionID", rDefaultPath+transactions)) {			 
				 utils.ExtentLogPassFail(driver, "TransactionID", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  utils.EnterText(driver, "TransactionID", a+"\n"+b, rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "TransactionIDx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
		  
		  
		  if(utils.checkIfObjectExists(driver, "supplier_s2", rDefaultPath+transactions)) {			 
				 utils.ExtentLogPassFail(driver, "supplier_s2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 utils.ClickObject(driver,"supplier_s2", rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "supplier_s2x", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
		  String r=utils.GetText(driver, "results1", rDefaultPath+transactions);
			 if(utils.checkIfObjectExists(driver, "results2", rDefaultPath+transactions)) {
				 if(r.equals("The chargebacks were reversed successfully")) {
					 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					  


				 }else {utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);}
				 
				 //utils.ClickObject(driver, "confirmbtn", rDefaultPath+transactions);
			 }else {
				 utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			// 
			 
			}catch(Exception e) {}
	}
	public void Reverse_Chargebacks(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//Reverse Chargeback  

	 

		
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder
			
			try {
				url=getdata.ReadData("DataExcel", "view_transactions", "url", 2);
				username=getdata.ReadData("DataExcel", "view_transactions", "user_name", 4);
				password=getdata.ReadData("DataExcel", "view_transactions", "pass_word", 4);
				//String x=getdata.ReadData("DataExcel", "Charge_backs", "transaction_id", 2);
			
				driver.manage().window().maximize();
				Thread.sleep(2000);
				url.toString();
				utils.navigate(driver,url.toString());
				//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
				Thread.sleep(2000);
				
				
				//create data
				utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
				utils.ClickObject(driver, "view_transactions", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_d", rDefaultPath+transactions);
				utils.ClickObject(driver, "option4", rDefaultPath+transactions);
				utils.ClickObject(driver, "View_btn1", rDefaultPath+transactions);
				String a=utils.GetText(driver, "charge_back_id1", rDefaultPath+transactions);
				//String b=utils.GetText(driver, "charge_back_id2", rDefaultPath+transactions);
				  //System.out.println(a);
				  //System.out.println(b);
				utils.ClickObject(driver,"go-back", rDefaultPath+transactions);
				Thread.sleep(2000);
				 if(utils.checkIfObjectExists(driver, "transation_tab", rDefaultPath+transactions)) {
					 utils.ClickObject(driver, "transation_tab", rDefaultPath+transactions);
					 utils.ExtentLogPassFail(driver, "transation_tab", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }else {
					  utils.ExtentLogPassFail(driver, "transation_tabx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  }
		  
		  
		  if(utils.checkIfObjectExists(driver, "reverse", rDefaultPath+transactions)) {			 
				 utils.ExtentLogPassFail(driver, "reverse", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 utils.ClickObject(driver,"reverse", rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "reversex", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }		
		
		  if(utils.checkIfObjectExists(driver, "TransactionID", rDefaultPath+transactions)) {			 
				 utils.ExtentLogPassFail(driver, "TransactionID", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				  utils.EnterText(driver, "TransactionID", a, rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "TransactionIDx", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
		  
		  
		  if(utils.checkIfObjectExists(driver, "supplier_s2", rDefaultPath+transactions)) {			 
				 utils.ExtentLogPassFail(driver, "supplier_s2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				 utils.ClickObject(driver,"supplier_s2", rDefaultPath+transactions);
			 }else {
				  utils.ExtentLogPassFail(driver, "supplier_s2x", " \t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
		  String r=utils.GetText(driver, "results1", rDefaultPath+transactions);
			 if(utils.checkIfObjectExists(driver, "results2", rDefaultPath+transactions)) {
				 if(r.equals("The chargeback was reversed successfully")) {
					 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
					 


				 }else {utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);}
				 
				 //utils.ClickObject(driver, "confirmbtn", rDefaultPath+transactions);
			 }else {
				 utils.ExtentLogPassFail(driver, "results2x", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			  }
			 utils.ExtentLogPassFail(driver, "results2", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
			// 
			 
			}catch(Exception e) {}
	}

	public void Transaction_Status_Report(WebDriver driver, ExtentTest logger, String sDefaultPath) {
		//Transaction_Status_Report
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
			//ext.transamrt_login(driver, logger, rDefaultPath,username,password);
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
}
