package eshop_merchant;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import transmart_properties.properties_extender;
import vodacom.payment_solution.vodacom.payment_solution.ReadExcelData;
import vodacom.payment_solution.vodacom.payment_solution.UtilityFunctions;
import vodacom.payment_solution.vodacom.payment_solution.WriteExcelData;

public class eshop_merchant {
	
	static ReadExcelData getdata=new ReadExcelData();
	static WriteExcelData writedata= new WriteExcelData();
	static properties_extender ext=new properties_extender();
	static UtilityFunctions utils = new UtilityFunctions();
	
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
			/**T_0002_transactions_Payments_Preauth()**/
			public void T_0002_transactions_Payments_Preauth(WebDriver driver,ExtentTest logger, String sDefaultPath) {

				
				//dpath=sDefaultPath+dDefaultPath;
				//String rpath=sDefaultPath+rDefaultPath;
				dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
				rDefaultPath=sDefaultPath;// assigning a new repository folder
				//screenshot=sDefaultPath+transactions_screenshots;// assigning a new screenshot folder
				//System.out.println("0000000000");
				try {
														

				//read data
				//get parameters from external file 
				// execute= Get.ReadExcel(row, col, sheetno, path, filename)
					//getdata.ReadData(filename, sheetname, colname, rownum);
				transactions_url =getdata.ReadData("DataExcel", "transactions", "url", 2);
				
				Payment_Type = getdata.ReadData("DataExcel", "transactions", "Payment Type", 2);	
				Name_on_Card= getdata.ReadData("DataExcel", "transactions", "Name on Card", 2);	
				Card_number = getdata.ReadData("DataExcel", "transactions", "Card number", 2);
				Expiry_Month = getdata.ReadData("DataExcel", "transactions", "Expiry-Month", 2);	
				Expiry_Year = getdata.ReadData("DataExcel", "transactions", "Expiry-Year", 2);
				CVV = getdata.ReadData("DataExcel", "transactions", "CVV", 2);
				

				driver.manage().window().maximize();
				Thread.sleep(2000);
				transactions_url.toString();
				utils.navigate(driver,transactions_url.toString());
				Thread.sleep(2000);
				//inserting data
				
				utils.RefreshPage();
				Thread.sleep(2000);
				utils.ExtentLogPassFail(driver, "first", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				Thread.sleep(2000);
				utils.VerifyElement(driver, "preauth02", rDefaultPath+transactions);
				Thread.sleep(1000);
				utils.ClickObject(driver, "preauth02", rDefaultPath+transactions);
				Thread.sleep(2000);
				utils.ExtentLogPassFail(driver, "btn_continue", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				Thread.sleep(2000);
				utils.ClickObject(driver, "paymenttype",rDefaultPath+transactions);
				Thread.sleep(2000);	
				utils.SelectTextUsingVisibeText(driver, "paymenttype",Payment_Type,rDefaultPath+transactions);
				Thread.sleep(1000);
				utils.EnterText(driver, "cardname",Name_on_Card,rDefaultPath+transactions);
				Thread.sleep(1000);
				utils.EnterText(driver, "cardno",Card_number,rDefaultPath+transactions);
				Thread.sleep(1000);
				utils.ClickObject(driver, "months", rDefaultPath+transactions);
				Thread.sleep(2000);
				utils.SelectTextUsingVisibeText(driver, "months",Expiry_Month,rDefaultPath+transactions);
				//utils.SelectTextUsingValue(driver, "months", "11", rDefaultPath+transactions);
				Thread.sleep(1000);
				utils.ClickObject(driver, "year", rDefaultPath+transactions);
				Thread.sleep(2000);
				utils.SelectTextUsingVisibeText(driver, "year",Expiry_Year,rDefaultPath+transactions);
				Thread.sleep(2000);
				utils.ClickObject(driver, "CCVNO", rDefaultPath+transactions);
				Thread.sleep(1000);
				utils.EnterText(driver, "CCVNO",CVV, rDefaultPath+transactions);
				Thread.sleep(1000);
				utils.ExtentLogPassFail(driver, "btn_continue", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				Thread.sleep(3000);
				
				utils.ClickObject(driver, "btn_continue", rDefaultPath+transactions);
				Thread.sleep(1000);
				utils.ExtentLogPassFail(driver, "submit_btns", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				Thread.sleep(2000);
				utils.EnterText(driver, "submit_txt", "test123", rDefaultPath+transactions);
				Thread.sleep(2000);
				utils.ClickObject(driver, "submit_btns", rDefaultPath+transactions);
				//utils.ClickObject(driver, "btn_continue2", rDefaultPath+transactions);
				//utils.ExtentLogPassFail(driver, "results", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				Thread.sleep(2000);
				Thread.sleep(2000);
				String transaction_id=utils.GetText(driver, "results", rDefaultPath+transactions);
				String id=utils.GetText(driver, "results", rDefaultPath+transactions);
				Thread.sleep(2000);
				//utils.ExtentLogPassFail(driver, "results", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
				
				Thread.sleep(2000);
				Thread.sleep(2000);
				Thread.sleep(2000);
				System.out.println("trans id"+transaction_id);
				//exporting transaction id to external file
				//write.WriteExcel(rows, cols, sheetno, path, sData, filename);
				//write.WriteExcel(1, 8, 0, dDefaultPath,transaction_id,"DataExcel");
				//writedata.WriteExcel("transactions",transaction_id,1, 8);
				
				Thread.sleep(2000);
				Thread.sleep(2000);	
				
				//.out.println("00000"+transaction_id);
				//System.out.println(transaction_id);
				if (transaction_id.equals("")) {
				utils.ExtentLogPassFail(driver, "year", ""," \t\t FAILED", logger,true, rDefaultPath,transactions);
				}else {
				
				utils.ExtentLogPassFail(driver, "valid", "\t\t PASSED","", logger,true, rDefaultPath,transactions);
				}
				
				
				}catch(Exception e){
				System.out.println(e.getMessage());
				//driver.quit();
				}
	}
		

	/**T_0002_transactions_Payments_Preauth()**/

	/**T_0003_transactions_Payments_Preauth_and_Settle()**/
			
	public void T_0003_transactions_Payments_Preauth_and_Settle(WebDriver driver,ExtentTest logger, String sDefaultPath) {

						
						//dpath=sDefaultPath+dDefaultPath;
						//String rpath=sDefaultPath+rDefaultPath;
						dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
						rDefaultPath=sDefaultPath;// assigning a new repository folder
						//screenshot=sDefaultPath+transactions_screenshots;// assigning a new screenshot folder
						//System.out.println("0000000000");
						try {
																

						//read data
						//get parameters from external file 
						// execute= Get.ReadExcel(row, col, sheetno, path, filename)
							//getdata.ReadData(filename, sheetname, colname, rownum);
						transactions_url =getdata.ReadData("DataExcel", "transactions", "url", 2);
						Payment_Type = getdata.ReadData("DataExcel", "transactions", "Payment Type", 2);	
						Name_on_Card= getdata.ReadData("DataExcel", "transactions", "Name on Card", 2);	
						Card_number = getdata.ReadData("DataExcel", "transactions", "Card number", 2);
						Expiry_Month = getdata.ReadData("DataExcel", "transactions", "Expiry-Month", 2);	
						Expiry_Year = getdata.ReadData("DataExcel", "transactions", "Expiry-Year", 2);
						CVV = getdata.ReadData("DataExcel", "transactions", "CVV", 2);
						//Amount = getdata.ReadData("DataExcel", "transactions-preauth", "Amount", 2);
						//transaction_ID = getdata.ReadData("DataExcel", "transactions-preauth", "transaction ID	", 2);
						
						//launch browser 
						//pass parameters to the web browser
						//take screenshots  
						
						driver.manage().window().maximize();
						Thread.sleep(2000);
						transactions_url.toString();
						utils.navigate(driver,transactions_url.toString());
						Thread.sleep(2000);
						//inserting data
						
						utils.RefreshPage();
						Thread.sleep(2000);
						utils.ExtentLogPassFail(driver, "first", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
						
						Thread.sleep(1000);
						utils.ClickObject(driver, "authsettle01", rDefaultPath+transactions);
						Thread.sleep(2000);
						utils.ExtentLogPassFail(driver, "btn_continue", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
						Thread.sleep(2000);
						utils.ClickObject(driver, "paymenttype",rDefaultPath+transactions);
						Thread.sleep(2000);	
						utils.SelectTextUsingVisibeText(driver, "paymenttype",Payment_Type,rDefaultPath+transactions);
						Thread.sleep(1000);
						utils.EnterText(driver, "cardname",Name_on_Card,rDefaultPath+transactions);
						Thread.sleep(1000);
						utils.EnterText(driver, "cardno",Card_number,rDefaultPath+transactions);
						Thread.sleep(1000);
						utils.ClickObject(driver, "months", rDefaultPath+transactions);
						Thread.sleep(2000);
						utils.SelectTextUsingVisibeText(driver, "months",Expiry_Month,rDefaultPath+transactions);
						//utils.SelectTextUsingValue(driver, "months", "11", rDefaultPath+transactions);
						Thread.sleep(1000);
						utils.ClickObject(driver, "year", rDefaultPath+transactions);
						Thread.sleep(2000);
						utils.SelectTextUsingVisibeText(driver, "year",Expiry_Year,rDefaultPath+transactions);
						Thread.sleep(2000);
						utils.ClickObject(driver, "CCVNO", rDefaultPath+transactions);
						Thread.sleep(1000);
						utils.EnterText(driver, "CCVNO",CVV, rDefaultPath+transactions);
						Thread.sleep(1000);
						utils.ExtentLogPassFail(driver, "btn_continue", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
						Thread.sleep(3000);
						
						utils.ClickObject(driver, "btn_continue", rDefaultPath+transactions);
						Thread.sleep(1000);
						utils.ExtentLogPassFail(driver, "submit_btns", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
						Thread.sleep(2000);
						utils.EnterText(driver, "submit_txt", "test123", rDefaultPath+transactions);
						Thread.sleep(2000);
						utils.ClickObject(driver, "submit_btns", rDefaultPath+transactions);
						//utils.ClickObject(driver, "btn_continue2", rDefaultPath+transactions);
						//utils.ExtentLogPassFail(driver, "results", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
						Thread.sleep(2000);
						Thread.sleep(2000);
						String transaction_id=utils.GetText(driver, "results", rDefaultPath+transactions);
						String id=utils.GetText(driver, "results", rDefaultPath+transactions);
						Thread.sleep(2000);
						//utils.ExtentLogPassFail(driver, "results", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
						
						Thread.sleep(2000);
						Thread.sleep(2000);
						Thread.sleep(2000);
						System.out.println("trans id"+transaction_id);
						//exporting transaction id to external file
						//write.WriteExcel(rows, cols, sheetno, path, sData, filename);
						//write.WriteExcel(1, 8, 0, dDefaultPath,transaction_id,"DataExcel");
						writedata.WriteExcel("transactions",transaction_id,1, 8);
						
						Thread.sleep(2000);
						Thread.sleep(2000);	
						
						//.out.println("00000"+transaction_id);
						//System.out.println(transaction_id);
						if (transaction_id.equals("")) {
						utils.ExtentLogPassFail(driver, "year", ""," \t\t FAILED", logger,true, rDefaultPath,transactions);
						}else {
						
						utils.ExtentLogPassFail(driver, "valid", "\t\t PASSED","", logger,true, rDefaultPath,transactions);
						}
						
						
						}catch(Exception e){
						System.out.println(e.getMessage());
						//driver.quit();
						}
	}

	/**T_0003_transactions_Payments_Preauth_and_Settle()**/

	/**T_0004_transactions_Payments_Auth()**/
	public void T_0004_transactions_Payments_Auth(WebDriver driver,ExtentTest logger, String sDefaultPath) {

		
		//dpath=sDefaultPath+dDefaultPath;
		//String rpath=sDefaultPath+rDefaultPath;
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder
		//screenshot=sDefaultPath+transactions_screenshots;// assigning a new screenshot folder
		//System.out.println("0000000000");
		try {
												

		//read data
		//get parameters from external file 
		// execute= Get.ReadExcel(row, col, sheetno, path, filename)
			//getdata.ReadData(filename, sheetname, colname, rownum);
		transactions_url =getdata.ReadData("DataExcel", "transactions", "url", 2);
		Payment_Type = getdata.ReadData("DataExcel", "transactions", "Payment Type", 2);	
		Name_on_Card= getdata.ReadData("DataExcel", "transactions", "Name on Card", 2);	
		Card_number = getdata.ReadData("DataExcel", "transactions", "Card number", 2);
		Expiry_Month = getdata.ReadData("DataExcel", "transactions", "Expiry-Month", 2);	
		Expiry_Year = getdata.ReadData("DataExcel", "transactions", "Expiry-Year", 2);
		CVV = getdata.ReadData("DataExcel", "transactions", "CVV", 2);
		//Amount = getdata.ReadData("DataExcel", "transactions-preauth", "Amount", 2);
		//transaction_ID = getdata.ReadData("DataExcel", "transactions-preauth", "transaction ID	", 2);
		
		//launch browser 
		//pass parameters to the web browser
		//take screenshots  
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		transactions_url.toString();
		utils.navigate(driver,transactions_url.toString());
		Thread.sleep(2000);
		//inserting data
		
		utils.RefreshPage();
		Thread.sleep(2000);
		utils.ExtentLogPassFail(driver, "first", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		Thread.sleep(2000);
		utils.VerifyElement(driver, "fullauth03", rDefaultPath+transactions);
		Thread.sleep(1000);
		utils.ClickObject(driver, "fullauth03", rDefaultPath+transactions);
		Thread.sleep(2000);
		utils.ExtentLogPassFail(driver, "btn_continue", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		Thread.sleep(2000);
		utils.ClickObject(driver, "paymenttype",rDefaultPath+transactions);
		Thread.sleep(2000);	
		utils.SelectTextUsingVisibeText(driver, "paymenttype",Payment_Type,rDefaultPath+transactions);
		Thread.sleep(1000);
		utils.EnterText(driver, "cardname",Name_on_Card,rDefaultPath+transactions);
		Thread.sleep(1000);
		utils.EnterText(driver, "cardno",Card_number,rDefaultPath+transactions);
		Thread.sleep(1000);
		utils.ClickObject(driver, "months", rDefaultPath+transactions);
		Thread.sleep(2000);
		utils.SelectTextUsingVisibeText(driver, "months",Expiry_Month,rDefaultPath+transactions);
		//utils.SelectTextUsingValue(driver, "months", "11", rDefaultPath+transactions);
		Thread.sleep(1000);
		utils.ClickObject(driver, "year", rDefaultPath+transactions);
		Thread.sleep(2000);
		utils.SelectTextUsingVisibeText(driver, "year",Expiry_Year,rDefaultPath+transactions);
		Thread.sleep(2000);
		utils.ClickObject(driver, "CCVNO", rDefaultPath+transactions);
		Thread.sleep(1000);
		utils.EnterText(driver, "CCVNO",CVV, rDefaultPath+transactions);
		Thread.sleep(1000);
		utils.ExtentLogPassFail(driver, "btn_continue", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		Thread.sleep(3000);
		
		utils.ClickObject(driver, "btn_continue", rDefaultPath+transactions);
		Thread.sleep(1000);
		utils.ExtentLogPassFail(driver, "submit_btns", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		Thread.sleep(2000);
		utils.EnterText(driver, "submit_txt", "test123", rDefaultPath+transactions);
		Thread.sleep(2000);
		utils.ClickObject(driver, "submit_btns", rDefaultPath+transactions);
		//utils.ClickObject(driver, "btn_continue2", rDefaultPath+transactions);
		//utils.ExtentLogPassFail(driver, "results", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		Thread.sleep(2000);
		Thread.sleep(2000);
		String transaction_id=utils.GetText(driver, "results", rDefaultPath+transactions);
		String id=utils.GetText(driver, "results", rDefaultPath+transactions);
		Thread.sleep(2000);
		//utils.ExtentLogPassFail(driver, "results", "\t\t PASSED", ""+"\t\t FAILED", logger,true, rDefaultPath,transactions);
		
		Thread.sleep(2000);
		Thread.sleep(2000);
		Thread.sleep(2000);
		System.out.println("trans id"+transaction_id);
		//exporting transaction id to external file
		//write.WriteExcel(rows, cols, sheetno, path, sData, filename);
		//write.WriteExcel(1, 8, 0, dDefaultPath,transaction_id,"DataExcel");
		//writedata.WriteExcel("transactions",transaction_id,1, 8);
		
		Thread.sleep(2000);
		Thread.sleep(2000);	
		
		//.out.println("00000"+transaction_id);
		//System.out.println(transaction_id);
		if (transaction_id.equals("")) {
		utils.ExtentLogPassFail(driver, "year", ""," \t\t FAILED", logger,true, rDefaultPath,transactions);
		}else {
		
		utils.ExtentLogPassFail(driver, "valid", "\t\t PASSED","", logger,true, rDefaultPath,transactions);
		}
		
		
		}catch(Exception e){
		System.out.println(e.getMessage());
		//driver.quit();
		}
	}

	/**T_0004_transactions_Payments_Auth()**/

}
