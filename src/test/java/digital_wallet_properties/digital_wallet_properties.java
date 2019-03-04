package digital_wallet_properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Random;
import com.aventstack.extentreports.ExtentTest;

import transmart_properties.properties_extender;
import vodacom.payment_solution.vodacom.payment_solution.ReadExcelData;
import vodacom.payment_solution.vodacom.payment_solution.UtilityFunctions;
import vodacom.payment_solution.vodacom.payment_solution.WriteExcelData;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
public class digital_wallet_properties {
	static ReadExcelData getdata=new ReadExcelData();
	static WriteExcelData writedata= new WriteExcelData();
	static properties_extender ext=new properties_extender();
	static UtilityFunctions utils = new UtilityFunctions();
	
	//declare varibales 
	private static String dDefaultPath;
	private static String rDefaultPath;
	private static String digital_wallet_url;
	private static String username="alex.kwenene@vcontractor.co.za";
	private static String password="Xolisa@5684";
	private static String cvv="197";
	
	
	
	//folders 
	private static String dpath="\\data\\";//excel external file folder		

	//xml file name 
	private static String vodapay="\\Repository\\vodapay.xml";//xml for front office 
	//preparing Make a payment using a card from the wallet
	public void T_0001_Vodapay(WebDriver driver,ExtentTest logger, String sDefaultPath) {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder		
		try {
			//read data
			digital_wallet_url =getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "url", 2);
			String username=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "user_name", 2);
			String password=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "pass_word", 2);
			String CV=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "CVV", 2);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			digital_wallet_url.toString();
			utils.navigate(driver,digital_wallet_url.toString());
			//inserting data
			Thread.sleep(2000);			
			utils.ClickObject(driver, "dwallet",rDefaultPath+vodapay);			
			utils.ClickObject(driver, "merchant",rDefaultPath+vodapay);
			utils.ClickObject(driver, "smerchant",rDefaultPath+vodapay);
			
			Thread.sleep(2000);
			if(utils.checkIfObjectExists(driver, "continue", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "continue", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver, "continue", rDefaultPath+vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "continuex", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				
			}
			
			Thread.sleep(1000);
			if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "nextbtn", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
			utils.EnterText(driver, "email",username, rDefaultPath+vodapay);
			Thread.sleep(2000);
			//driver.switchTo().defaultContent();
			if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "nextbtn", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver,"nextbtn", rDefaultPath+vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				
			}
			
			//Thread.sleep(2000);
			//utils.pressTAB(1);
			//.PressEnter(1);
			//driver.SwitchTo().Window(driver.WindowHandles.Last());
			//utils.EnterText(driver,"test", "1000", rDefaultPath+vodapay);
			Thread.sleep(2000);
			Thread.sleep(3000);
			utils.switch_window(driver);
			 Thread.sleep(2000);
			 if(utils.checkIfObjectExists(driver, "vodabtn", rDefaultPath+vodapay)) {
				 utils.ExtentLogPassFail(driver, "vodabtn", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "vodabtn", rDefaultPath+vodapay);
			 }else {
				 utils.ExtentLogPassFail(driver, "vodabtnx", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }
			
			utils.EnterText(driver, "usert",username,rDefaultPath+vodapay);
			utils.EnterText(driver, "passt", password,rDefaultPath+vodapay);
			Thread.sleep(2000);
			if(utils.checkIfObjectExists(driver, "logint", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "logint", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver, "logint", rDefaultPath+vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "logintx", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
			Thread.sleep(2000);
			utils.EnterText(driver, "CVV", CV, rDefaultPath+vodapay);
			utils.ClickObject(driver, "paybtn", rDefaultPath+vodapay);
			Thread.sleep(2000);
			utils.EnterText(driver, "secure", "test123", rDefaultPath+vodapay);
			if(utils.checkIfObjectExists(driver, "submit", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "submit", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver, "submit", rDefaultPath+vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "submitx", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
					
			Thread.sleep(2000);
			if(utils.checkIfObjectExists(driver, "sucessw", rDefaultPath+vodapay)) {
				String a=utils.GetText(driver, "sucess", rDefaultPath+vodapay);
				if (a.equals("The request was succesfully processed")) {
					//System.out.print("yes");
					utils.ExtentLogPassFail(driver, "sucessw", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					}
			}else {
				utils.ExtentLogPassFail(driver, "sucesswx", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
			/*//System.out.println(a);
			//a="The request was succesfully processed";
			if (a.equals("The request was succesfully processed")) {
				//System.out.print("yes");
				utils.ExtentLogPassFail(driver, "sucessw","STEP 6 \t\t PASSED","", logger,true, rDefaultPath,vodapay);
				}else {
					
				utils.ExtentLogPassFail(driver, "submit2", "","STEP 6 \t\t FAILED", logger,true, rDefaultPath,vodapay);
				}*/
			
		
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
	
	//preparing Make a payment using a card from the wallet
	public void T_0002_Vodapay(WebDriver driver,ExtentTest logger, String sDefaultPath) {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder		
		try {
			//read data
			digital_wallet_url =getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "url", 2);
			String username=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "user_name", 2);
			String password=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "pass_word", 2);
			String CV=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "CVV", 2);
			String cardname=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "card_name", 2);
			String cardnumber=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "card_number", 2);
			String months=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "months", 2);
			String year=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "year", 2);
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			digital_wallet_url.toString();
			utils.navigate(driver,digital_wallet_url.toString());
			//inserting data
			Thread.sleep(2000);			
			utils.ClickObject(driver, "dwallet",rDefaultPath+vodapay);			
			utils.ClickObject(driver, "merchant",rDefaultPath+vodapay);
			utils.ClickObject(driver, "smerchant",rDefaultPath+vodapay);
		
			Thread.sleep(2000);
			if(utils.checkIfObjectExists(driver, "continue", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "continue", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver, "continue", rDefaultPath+vodapay);
				
			}else {
				utils.ExtentLogPassFail(driver, "continuex", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
			Thread.sleep(2000);
			if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "nextbtn", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver,"nextbtn", rDefaultPath+vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
		
			Thread.sleep(3000);
			utils.switch_window(driver);
			 Thread.sleep(2000);
			 if(utils.checkIfObjectExists(driver, "visabtn", rDefaultPath+vodapay)) {
				 utils.ExtentLogPassFail(driver, "visabtn", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				 utils.ClickObject(driver, "visabtn", rDefaultPath+vodapay); 
			 }else {
				 utils.ExtentLogPassFail(driver, "visabtnx", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }
			 
			 Thread.sleep(2000);			 
			 utils.ClickObject(driver, "checkbtn", rDefaultPath+vodapay);
			 Thread.sleep(2000);
			 utils.EnterText(driver, "cardname",cardname, rDefaultPath+vodapay);
			 utils.EnterText(driver, "cardnumber","5359690000016562", rDefaultPath+vodapay);
			 utils.ClickObject(driver, "months", rDefaultPath+vodapay);
			 utils.SelectTextUsingValue(driver, "months",months, rDefaultPath+vodapay);
			// utils.SelectTextUsingVisibeText(driver,"months","04", rDefaultPath+vodapay);
			// utils.SelectTextUsingIndex(driver, "months", 5, rDefaultPath+vodapay);
			 utils.ClickObject(driver, "year", rDefaultPath+vodapay);
			 utils.SelectTextUsingValue(driver, "year",year, rDefaultPath+vodapay);
			 //utils.pressTAB(1);
			 utils.EnterText(driver, "CVV2",CV, rDefaultPath+vodapay);
			 
			 Thread.sleep(2000);
			 if(utils.checkIfObjectExists(driver, "CVV2", rDefaultPath+vodapay)) {
				 utils.ExtentLogPassFail(driver, "CVV2", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }else {
				 utils.ExtentLogPassFail(driver, "CVV2x", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }
			
			 Thread.sleep(1000);
			 utils.ClickObject(driver, "submit2", rDefaultPath+vodapay);
			 
			 //utils.ExtentLogPassFail(driver, "submit", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 
				Thread.sleep(2000);
			 utils.EnterText(driver, "secure","test123", rDefaultPath+vodapay);
			 if(utils.checkIfObjectExists(driver, "submit", rDefaultPath+vodapay)) {
				 utils.ExtentLogPassFail(driver, "submit", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				 utils.ClickObject(driver, "submit", rDefaultPath+vodapay);
			 }else {
				 utils.ExtentLogPassFail(driver, "submitx", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }
			
			 Thread.sleep(2000);
		
			 if (utils.checkIfObjectExists(driver, "results", rDefaultPath+vodapay)){
				 String a=utils.GetText(driver, "sucess", rDefaultPath+vodapay);
				 System.out.print(a);
				 if (a.equals("The request was succesfully processed")) {				
					 utils.ExtentLogPassFail(driver, "results", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILEDx", logger,true, rDefaultPath,vodapay);
						}
				 
			 }else {
				 utils.ExtentLogPassFail(driver, "resultsx", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILEDb", logger,true, rDefaultPath,vodapay);
				
			 }
			 
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
	//Register for VodaPay DW and pay
	public void T_0003_Vodapay(WebDriver driver,ExtentTest logger, String sDefaultPath) {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder		
		try {
			//read data
			digital_wallet_url =getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "url", 2);
			String username=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "user_name", 2);
			String password=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "pass_word", 2);
			String CV=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "CVV", 2);
			String cardname=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "card_name", 2);
			String cardnumber=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "card_number", 2);
			String months=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "months", 2);
			String year=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "year", 2);
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			digital_wallet_url.toString();
			utils.navigate(driver,digital_wallet_url.toString());
			//inserting data
			Thread.sleep(2000);			
			utils.ClickObject(driver, "dwallet",rDefaultPath+vodapay);			
			utils.ClickObject(driver, "merchant",rDefaultPath+vodapay);
			utils.ClickObject(driver, "smerchant",rDefaultPath+vodapay);
			
			Thread.sleep(2000);
			if(utils.checkIfObjectExists(driver, "continue", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "continue", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver, "continue", rDefaultPath+vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "continuex", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
			Thread.sleep(1000);
			if(utils.checkIfObjectExists(driver, "nextbtn",rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "nextbtn", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
		
		
			Thread.sleep(2000);
			//driver.switchTo().defaultContent();
			if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "nextbtn", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver,"nextbtn", rDefaultPath+vodapay);				
			}else {
				utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
			Thread.sleep(2000);
			Thread.sleep(3000);
			utils.switch_window(driver);
			     Random rand = new Random();
				String user="DigitalWallet_";
				int n = rand.nextInt(500000000);
				String TJ=user+n;
			 Thread.sleep(2000);
			 if(utils.checkIfObjectExists(driver, "vodabtn", rDefaultPath+vodapay)) {
				 utils.ExtentLogPassFail(driver, "vodabtn", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				 utils.ClickObject(driver, "vodabtn", rDefaultPath+vodapay);
			 }else {
				 utils.ExtentLogPassFail(driver, "vodabtnx", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }
			
			 Thread.sleep(2000);
			 utils.EnterText(driver, "reguser",TJ, rDefaultPath+vodapay);
			 utils.EnterText(driver, "regpassword", "testing", rDefaultPath+vodapay);
			 utils.EnterText(driver, "regconfirm", "testing", rDefaultPath+vodapay);
			 utils.EnterText(driver, "regemail", TJ+"@vodacom.co.za", rDefaultPath+vodapay);
			 utils.EnterText(driver, "regmobile", "0826333898", rDefaultPath+vodapay);
			 utils.ExtentLogPassFail(driver, "regmobile", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 Thread.sleep(2000);
			 utils.ClickObject(driver, "regbtn", rDefaultPath+vodapay);
			 
			// utils.ExtentLogPassFail(driver, "tt", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			
			 
			 if(utils.checkIfObjectExists(driver, "tt", rDefaultPath+vodapay)) {
				 String a=utils.GetText(driver, "regmes", rDefaultPath+vodapay);
				 if (a.equals("Success")) {
						//System.out.print("yes");
				 utils.ExtentLogPassFail(driver, "tt", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
						}
			 }else {
				 utils.ExtentLogPassFail(driver, "ttx", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }
			
				
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
	 //Register via opt-in
	public void T_0004_Vodapay(WebDriver driver,ExtentTest logger, String sDefaultPath) {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder		
		try {
			//read data
			digital_wallet_url =getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "url", 2);
			String username=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "user_name", 2);
			String password=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "pass_word", 2);
			String CV=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "CVV", 2);
			String cardname=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "card_name", 2);
			String cardnumber=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "card_number", 2);
			String months=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "months", 2);
			String year=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "year", 2);
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			digital_wallet_url.toString();
			utils.navigate(driver,digital_wallet_url.toString());
			//inserting data
			
			Thread.sleep(2000);		
			utils.ClickObject(driver, "dwallet",rDefaultPath+vodapay);			
			utils.ClickObject(driver, "merchant",rDefaultPath+vodapay);
			utils.ClickObject(driver, "smerchant",rDefaultPath+vodapay);
			
			Thread.sleep(2000);
			if(utils.checkIfObjectExists(driver, "continue", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "continue", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver, "continue", rDefaultPath+vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "continuex", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
			Thread.sleep(1000);
			if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "nextbtn", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
		
			Thread.sleep(2000);
			if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "nextbtn", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver,"nextbtn", rDefaultPath+vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
			
			Thread.sleep(2000);
			Thread.sleep(3000);
			utils.switch_window(driver);
			 Thread.sleep(2000);
			 if(utils.checkIfObjectExists(driver, "visabtn", rDefaultPath+vodapay)) {
				 utils.ExtentLogPassFail(driver, "visabtn", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				 utils.ClickObject(driver, "visabtn", rDefaultPath+vodapay);
			 }else {
				 utils.ExtentLogPassFail(driver, "visabtnx", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }
			 
			 Thread.sleep(2000);
			 //utils.ClickObject(driver, "checkbtn", rDefaultPath+vodapay);
			 Thread.sleep(2000);
			 utils.EnterText(driver, "cardname",cardname, rDefaultPath+vodapay);
			 utils.EnterText(driver, "cardnumber",cardnumber, rDefaultPath+vodapay);
			 utils.ClickObject(driver, "months", rDefaultPath+vodapay);
			 utils.SelectTextUsingValue(driver, "months",months, rDefaultPath+vodapay);
			// utils.SelectTextUsingVisibeText(driver,"months","04", rDefaultPath+vodapay);
			// utils.SelectTextUsingIndex(driver, "months", 5, rDefaultPath+vodapay);
			 utils.ClickObject(driver, "year", rDefaultPath+vodapay);
			 utils.SelectTextUsingValue(driver, "year",year, rDefaultPath+vodapay);
			 //utils.pressTAB(1);
			 utils.EnterText(driver, "CVV2",CV, rDefaultPath+vodapay);
			 Thread.sleep(2000);
			 if(utils.checkIfObjectExists(driver, "CVV2", rDefaultPath+vodapay)) {
				 utils.ExtentLogPassFail(driver, "CVV2", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }else {
				 utils.ExtentLogPassFail(driver, "CVV2x", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }
		
			 Thread.sleep(1000);
			   Random rand = new Random();
				String user="DigitalWallet_";
				int n = rand.nextInt(500000000);
				String TJ=user+n;
			 Thread.sleep(2000);
			// utils.ExtentLogPassFail(driver, "vodabtn", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			// utils.ClickObject(driver, "vodabtn", rDefaultPath+vodapay);
			 Thread.sleep(2000);
			 utils.EnterText(driver, "reguser",TJ, rDefaultPath+vodapay);
			 utils.EnterText(driver, "regpassword", "testing", rDefaultPath+vodapay);
			 utils.EnterText(driver, "regconfirm", "testing", rDefaultPath+vodapay);
			 utils.EnterText(driver, "regemail", TJ+"@vodacom.co.za", rDefaultPath+vodapay);
			 utils.EnterText(driver, "regmobile", "0826333898", rDefaultPath+vodapay);
			 
			 if(utils.checkIfObjectExists(driver, "regmobile", rDefaultPath+vodapay)) {
				 utils.ExtentLogPassFail(driver, "regmobile", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }else {
				 utils.ExtentLogPassFail(driver, "regmobilex", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }
			 
			 
			 Thread.sleep(2000);
			 utils.ClickObject(driver, "regpay", rDefaultPath+vodapay);
			 
				Thread.sleep(2000);
				utils.EnterText(driver, "secure", "test123", rDefaultPath+vodapay);
				if(utils.checkIfObjectExists(driver, "submit", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "submit", "STEP 7\t\t PASSED", "STEP 7"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "submit", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "submitx", "STEP 7\t\t PASSED", "STEP 7"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				Thread.sleep(2000);
			
				
			   if(utils.checkIfObjectExists(driver, "jj", rDefaultPath+vodapay)) {
					String a=utils.GetText(driver, "regresults", rDefaultPath+vodapay);
				   if (a.equals("The request was succesfully processed")) {
					   utils.ExtentLogPassFail(driver, "jj", "STEP 8\t\t PASSED", "STEP 8"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
						}
			   }else {
				   utils.ExtentLogPassFail(driver, "jjx", "STEP 8\t\t PASSED", "STEP 8"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			   }
				
				
				/*if (a.equals("The request was succesfully processed")) {
					//System.out.print("yes");
					utils.ExtentLogPassFail(driver, "jj","STEP 8 \t\t PASSED","", logger,true, rDefaultPath,vodapay);
					}else {
						
					utils.ExtentLogPassFail(driver, "submit2", "","STEP 8 \t\t FAILED", logger,true, rDefaultPath,vodapay);
					}*/
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
	public void T_0005_Vodapay(WebDriver driver,ExtentTest logger, String sDefaultPath) {
		dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
		rDefaultPath=sDefaultPath;// assigning a new repository folder		
		try {
			//read data
			digital_wallet_url =getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "url", 2);
			String username=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "user_name", 2);
			String password=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "pass_word", 2);
			String CV=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "CVV", 2);
			String cardname=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "card_name", 2);
			String cardnumber=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "card_number", 2);
			String months=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "months", 2);
			String year=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "year", 2);
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			digital_wallet_url.toString();
			utils.navigate(driver,digital_wallet_url.toString());
			//inserting data
			
			Thread.sleep(2000);			
			utils.ClickObject(driver, "dwallet",rDefaultPath+vodapay);			
			utils.ClickObject(driver, "merchant",rDefaultPath+vodapay);
			utils.ClickObject(driver, "smerchant",rDefaultPath+vodapay);
			
			Thread.sleep(2000);
			if(utils.checkIfObjectExists(driver, "continue", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "continue", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver, "continue", rDefaultPath+vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "continuex", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				
			}
			
			Thread.sleep(1000);
			if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "nextbtn", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}else {
				utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			}
			
			
		
			Thread.sleep(2000);
			//driver.switchTo().defaultContent();
			if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
				utils.ExtentLogPassFail(driver, "nextbtn", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver,"nextbtn", rDefaultPath+vodapay);
			}
			else {
				utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				
			}
			
			//Thread.sleep(2000);
			//utils.pressTAB(1);
			//.PressEnter(1);
			//driver.SwitchTo().Window(driver.WindowHandles.Last());
			//utils.EnterText(driver,"test", "1000", rDefaultPath+vodapay);
			Thread.sleep(2000);
			Thread.sleep(3000);
			 //store the current window handle
			utils.switch_window(driver);
			     Random rand = new Random();
				String user="DigitalWallet_";
				int n = rand.nextInt(500000000);
				String TJ=user+n;
			 Thread.sleep(2000);
			 if(utils.checkIfObjectExists(driver, "vodabtn", rDefaultPath+vodapay)) {
				 utils.ExtentLogPassFail(driver, "vodabtn", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				 utils.ClickObject(driver, "vodabtn", rDefaultPath+vodapay);
			 }else {
				 utils.ExtentLogPassFail(driver, "vodabtnx", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				
			 }
			 
			 Thread.sleep(2000);
			 utils.ClickObject(driver, "loginlink", rDefaultPath+vodapay);
			 utils.ClickObject(driver, "reglink", rDefaultPath+vodapay);
			utils.EnterText(driver, "reguser",TJ, rDefaultPath+vodapay);
			 utils.EnterText(driver, "regpassword", "testing", rDefaultPath+vodapay);
			 utils.EnterText(driver, "regconfirm", "testing", rDefaultPath+vodapay);
			 utils.EnterText(driver, "regemail", TJ+"@vodacom.co.za", rDefaultPath+vodapay);
			 utils.EnterText(driver, "regmobile", "0826333898", rDefaultPath+vodapay);
			 
			 if(utils.checkIfObjectExists(driver, "", rDefaultPath+vodapay)) {
				 utils.ExtentLogPassFail(driver, "regmobile", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }else {
				 utils.ExtentLogPassFail(driver, "regmobilex", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 }
			 
			 Thread.sleep(2000);
			 utils.ClickObject(driver, "regbtn", rDefaultPath+vodapay);
			 Thread.sleep(2000);		
			 utils.EnterText(driver, "treg",cardname, rDefaultPath+vodapay);
			 utils.EnterText(driver, "areg",cardnumber, rDefaultPath+vodapay);
			 utils.ClickObject(driver, "mreg", rDefaultPath+vodapay);
			 utils.SelectTextUsingValue(driver, "mreg",months, rDefaultPath+vodapay);
			// utils.SelectTextUsingVisibeText(driver,"months","04", rDefaultPath+vodapay);
			// utils.SelectTextUsingIndex(driver, "months", 5, rDefaultPath+vodapay);
			 utils.ClickObject(driver, "yreg", rDefaultPath+vodapay);
			 utils.SelectTextUsingValue(driver, "yreg","2022", rDefaultPath+vodapay);
			 utils.EnterText(driver, "aliasreg","000000", rDefaultPath+vodapay);
			 //utils.pressTAB(1);
			// utils.EnterText(driver, "CVV2",CV, rDefaultPath+vodapay);
			 Thread.sleep(2000);/*
			 utils.ExtentLogPassFail(driver, "CVV2", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 Thread.sleep(1000);
			 utils.ClickObject(driver, "submit2", rDefaultPath+vodapay);
			 Thread.sleep(2000);
			 utils.ExtentLogPassFail(driver, "submit", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 utils.EnterText(driver, "secure","test123", rDefaultPath+vodapay);
			// utils.ExtentLogPassFail(driver, "submit", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 utils.ClickObject(driver, "submit", rDefaultPath+vodapay);
			 Thread.sleep(2000);*/
			 
			 
			 
			 /*
			 utils.ExtentLogPassFail(driver, "tt", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
			 String a=utils.GetText(driver, "regmes", rDefaultPath+vodapay);
			 System.out.println(a);
			 if (a.equals("Success")) {
					//System.out.print("yes");
					utils.ExtentLogPassFail(driver, "tt","STEP 6 \t\t PASSED","", logger,true, rDefaultPath,vodapay);
					}else {
						
					utils.ExtentLogPassFail(driver, "submit2", "","STEP 6 \t\t FAILED", logger,true, rDefaultPath,vodapay);
					}
				*/
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}
	 
	//Add Card to the Wallet and proceed with the payment

		public void T_0007_Vodapay(WebDriver driver,ExtentTest logger, String sDefaultPath) {
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder		
			try {
				//read data
				digital_wallet_url =getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "url", 2);
				String username=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "user_name", 2);
				String password=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "pass_word", 2);
				String CV=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "CVV", 2);
				String acc=getdata.ReadData("Digital_Wallet_DataExcel", "Cards", "Account", 2);
				String mon=getdata.ReadData("Digital_Wallet_DataExcel", "Cards", "Exp_mon", 2);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				digital_wallet_url.toString();
				utils.navigate(driver,digital_wallet_url.toString());
				//inserting data
				
				Thread.sleep(2000);		
				utils.ClickObject(driver, "dwallet",rDefaultPath+vodapay);			
				utils.ClickObject(driver, "merchant",rDefaultPath+vodapay);
				utils.ClickObject(driver, "smerchant",rDefaultPath+vodapay);
				Thread.sleep(2000);
				if(utils.checkIfObjectExists(driver, "continue", rDefaultPath+vodapay)){
					utils.ExtentLogPassFail(driver, "continue", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "continue", rDefaultPath+vodapay);
				}else{
					utils.ExtentLogPassFail(driver, "continuex", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				Thread.sleep(1000);
				if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "nextbtn", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				utils.EnterText(driver, "email",username, rDefaultPath+vodapay);
				Thread.sleep(2000);
				//driver.switchTo().defaultContent();
				if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "nextbtn", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver,"nextbtn", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				//Thread.sleep(2000);
				//utils.pressTAB(1);
				//.PressEnter(1);
				//driver.SwitchTo().Window(driver.WindowHandles.Last());
				//utils.EnterText(driver,"test", "1000", rDefaultPath+vodapay);
				Thread.sleep(2000);
				Thread.sleep(3000);
				utils.switch_window(driver);
				 Thread.sleep(2000);
				 if(utils.checkIfObjectExists(driver, "vodabtn", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "vodabtn", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "vodabtn", rDefaultPath+vodapay);
				 }else {
					 utils.ExtentLogPassFail(driver, "vodabtnx", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay); 
				 }
				 
				utils.EnterText(driver, "usert",username,rDefaultPath+vodapay);
				utils.EnterText(driver, "passt", password,rDefaultPath+vodapay);
				Thread.sleep(2000);
				if(utils.checkIfObjectExists(driver, "logint", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "logint", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "logint", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "logintx", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				Thread.sleep(2000);
				if(utils.checkIfObjectExists(driver, "addcard", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "addcard", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "addcard", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "addcardx", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					
				}
				//utils.ExtentLogPassFail(driver, "addcard", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				//utils.ClickObject(driver, "addcard", rDefaultPath+vodapay);
				utils.EnterText(driver, "CardHolder","Digital wallet",rDefaultPath+vodapay);
				utils.EnterText(driver, "CardNumber",acc,rDefaultPath+vodapay);				
				 
				 //utils.ClickObject(driver, "CardExpiryYear", rDefaultPath+vodapay);
				 //utils.SelectTextUsingValue(driver, "CardExpiryYear","2022", rDefaultPath+vodapay);
				// utils.SelectTextUsingVisibeText(driver, "CardExpiryYear","2022", rDefaultPath+vodapay);
				// utils.SelectTextUsingIndex(driver, "CardExpiryYear", 5, rDefaultPath+vodapay);
				 utils.ClickObject(driver, "CardExpiryMonth", rDefaultPath+vodapay);
				 utils.SelectTextUsingValue(driver, "CardExpiryMonth",mon, rDefaultPath+vodapay);
				 utils.EnterText(driver, "callias","Digital wallet",rDefaultPath+vodapay);
				 
				 if(utils.checkIfObjectExists(driver, "btnsave", rDefaultPath+vodapay)) {
					 utils.ExtentLogPassFail(driver, "btnsave", "STEP 7\t\t PASSED", "STEP 7"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					 Thread.sleep(2000);
					utils.ClickObject(driver, "btnsave", rDefaultPath+vodapay);
				 }else {
					 utils.ExtentLogPassFail(driver, "btnsavex", "STEP 7\t\t PASSED", "STEP 7"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				 }
				
				
				String a=utils.GetText(driver, "m2", rDefaultPath+vodapay);
				//String b=utils.GetText(driver, "cardexist", rDefaultPath+vodapay);
				
				System.out.println(a);
				if(utils.checkIfObjectExists(driver, "m22", rDefaultPath+vodapay)) {
					if (a.equals("Success")) {
						 utils.ExtentLogPassFail(driver, "m22", "STEP 8\t\t PASSED", "STEP 8"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
						}
				}else {
					 utils.ExtentLogPassFail(driver, "btnsavex", "STEP 8\t\t PASSED", "STEP 8"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				
				
			
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
		}
		

		public void T_0008_Vodapay(WebDriver driver,ExtentTest logger, String sDefaultPath) {
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder		
			try {
				//read data
				digital_wallet_url =getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "url", 2);
				String username=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "user_name", 2);
				String password=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "pass_word", 2);
				String CV=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "CVV", 2);
				String acc=getdata.ReadData("Digital_Wallet_DataExcel", "Cards", "Account", 3);
				String mon=getdata.ReadData("Digital_Wallet_DataExcel", "Cards", "Exp_mon", 3);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				digital_wallet_url.toString();
				utils.navigate(driver,digital_wallet_url.toString());
				//inserting data
				Thread.sleep(2000);
					
				utils.ClickObject(driver, "dwallet",rDefaultPath+vodapay);			
				utils.ClickObject(driver, "merchant",rDefaultPath+vodapay);
				utils.ClickObject(driver, "smerchant",rDefaultPath+vodapay);
				Thread.sleep(2000);
				if(utils.checkIfObjectExists(driver, "continue", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "continue", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "continue", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "continuex", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				Thread.sleep(1000);
				if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "nextbtn", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					
				}else {
					utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				utils.EnterText(driver, "email",username, rDefaultPath+vodapay);
				Thread.sleep(2000);
				//driver.switchTo().defaultContent();
				if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "nextbtn", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver,"nextbtn", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				//Thread.sleep(2000);
				//utils.pressTAB(1);
				//.PressEnter(1);
				//driver.SwitchTo().Window(driver.WindowHandles.Last());
				//utils.EnterText(driver,"test", "1000", rDefaultPath+vodapay);
				Thread.sleep(2000);
				Thread.sleep(3000);
			    utils.switch_window(driver);
				
				 Thread.sleep(2000);
				 if(utils.checkIfObjectExists(driver, "vodabtn", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "vodabtn", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "vodabtn", rDefaultPath+vodapay);
				 }else {
					 utils.ExtentLogPassFail(driver, "vodabtnx", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				 }
				
				utils.EnterText(driver, "usert",username,rDefaultPath+vodapay);
				utils.EnterText(driver, "passt", password,rDefaultPath+vodapay);
				Thread.sleep(2000);
				if(utils.checkIfObjectExists(driver, "logint", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "logint", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "logint", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "logintx", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				Thread.sleep(2000);
				if(utils.checkIfObjectExists(driver, "addcard", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "addcard", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "addcardx", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				utils.ClickObject(driver, "Card_edit", rDefaultPath+vodapay);
				//utils.SelectTextUsingVisibeText(driver, "Card_edit", "Digital wallet", rDefaultPath+vodapay);
				utils.PressDownKey();
				utils.pressTAB(1);
				if(utils.checkIfObjectExists(driver, "Card_edit1", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "Card_edit1", "STEP 7\t\t PASSED", "STEP 7"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "Card_edit1", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "Card_edit1x", "STEP 7\t\t PASSED", "STEP 7"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				
				utils.EnterText(driver, "CardNumber",acc,rDefaultPath+vodapay);	
				if(utils.checkIfObjectExists(driver, "btnsave", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "btnsave", "STEP 8\t\t PASSED", "STEP 8"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "btnsave", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "btnsavex", "STEP 8\t\t PASSED", "STEP 8"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				String a=utils.GetText(driver, "m2", rDefaultPath+vodapay);
								
			
				
				
				if(utils.checkIfObjectExists(driver, "m22", rDefaultPath+vodapay)) {
					if (a.equals("Success")) {
						utils.ExtentLogPassFail(driver, "m22", "STEP 9\t\t PASSED", "STEP 9"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
						}
				}else {
					utils.ExtentLogPassFail(driver, "m22x", "STEP 9\t\t PASSED", "STEP 9"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
							
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
		}
		

	

		public void T_0009_Vodapay(WebDriver driver,ExtentTest logger, String sDefaultPath) {
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath;// assigning a new repository folder		
			try {
				//read data
				digital_wallet_url =getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "url", 2);
				String username=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "user_name", 2);
				String password=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "pass_word", 2);
				String CV=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "CVV", 2);
				String acc=getdata.ReadData("Digital_Wallet_DataExcel", "Cards", "Account", 3);
				String mon=getdata.ReadData("Digital_Wallet_DataExcel", "Cards", "Exp_mon", 3);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				digital_wallet_url.toString();
				utils.navigate(driver,digital_wallet_url.toString());
				//inserting data
				
				Thread.sleep(2000);			
				utils.ClickObject(driver, "dwallet",rDefaultPath+vodapay);			
				utils.ClickObject(driver, "merchant",rDefaultPath+vodapay);
				utils.ClickObject(driver, "smerchant",rDefaultPath+vodapay);
				Thread.sleep(2000);
				if(utils.checkIfObjectExists(driver, "continue", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "continue", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "continue", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "continuex", "STEP 1\t\t PASSED", "STEP 1"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					
				}
				
				Thread.sleep(1000);
				if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "nextbtn", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 2\t\t PASSED", "STEP 2"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				utils.EnterText(driver, "email",username, rDefaultPath+vodapay);
				Thread.sleep(2000);
				//driver.switchTo().defaultContent();
				if(utils.checkIfObjectExists(driver, "nextbtn", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "nextbtn", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver,"nextbtn", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "nextbtnx", "STEP 3\t\t PASSED", "STEP 3"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					
				}
				
				//Thread.sleep(2000);
				//utils.pressTAB(1);
				//.PressEnter(1);
				//driver.SwitchTo().Window(driver.WindowHandles.Last());
				//utils.EnterText(driver,"test", "1000", rDefaultPath+vodapay);
				Thread.sleep(2000);
				Thread.sleep(3000);
				utils.switch_window(driver);
				 Thread.sleep(2000);
				 if(utils.checkIfObjectExists(driver, "vodabtn", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "vodabtn", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "vodabtn", rDefaultPath+vodapay); 
				 }else {
					 utils.ExtentLogPassFail(driver, "vodabtnx", "STEP 4\t\t PASSED", "STEP 4"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				 }
				
				utils.EnterText(driver, "usert",username,rDefaultPath+vodapay);
				utils.EnterText(driver, "passt", password,rDefaultPath+vodapay);
				Thread.sleep(2000);
				if(utils.checkIfObjectExists(driver, "logint", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "logint", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
					utils.ClickObject(driver, "logint", rDefaultPath+vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "logintx", "STEP 5\t\t PASSED", "STEP 5"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				
				}
				
				Thread.sleep(2000);
				if(utils.checkIfObjectExists(driver, "addcard", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "addcard", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "addcardx", "STEP 6\t\t PASSED", "STEP 6"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				
				utils.ClickObject(driver, "Card_edit", rDefaultPath+vodapay);
				//utils.SelectTextUsingVisibeText(driver, "Card_edit", "Digital wallet", rDefaultPath+vodapay);
				utils.PressDownKey();
				utils.pressTAB(1);
				if(utils.checkIfObjectExists(driver, "delete", rDefaultPath+vodapay)) {
					utils.ExtentLogPassFail(driver, "delete", "STEP 7\t\t PASSED", "STEP 7"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}else {
					utils.ExtentLogPassFail(driver, "deletex", "STEP 7\t\t PASSED", "STEP 7"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}
				//utils.ExtentLogPassFail(driver, "delete", "STEP 7\t\t PASSED", "STEP 7"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				utils.ClickObject(driver, "delete", rDefaultPath+vodapay);
				utils.ClickObject(driver, "yes", rDefaultPath+vodapay);
				
				String a=utils.GetText(driver, "m2", rDefaultPath+vodapay);
				if(utils.checkIfObjectExists(driver, "m22", rDefaultPath+vodapay)) {
					if (a.equals("Success")) {
						utils.ExtentLogPassFail(driver, "m22", "STEP 8\t\t PASSED", "STEP 8"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
						}
					
				}else {
					utils.ExtentLogPassFail(driver, "m22x", "STEP 8\t\t PASSED", "STEP 8"+"\t\t FAILED", logger,true, rDefaultPath,vodapay);
				}				
				
				
				
				
				
							
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
		}
		

	
	
}


