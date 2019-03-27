package Roles_properties;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import vodacom.payment_solution.vodacom.payment_solution.ReadExcelData;
import vodacom.payment_solution.vodacom.payment_solution.UtilityFunctions;
import vodacom.payment_solution.vodacom.payment_solution.WriteExcelData;

public class Roles_extender {
	UtilityFunctions utils = new UtilityFunctions();//utilities object
	static ReadExcelData getdata=new ReadExcelData();
	static WriteExcelData writedata= new WriteExcelData();
	private static Cell Eshop_url;	
	private static Cell Payment_Type;	
	private static Cell Name_on_Card;	
	private static Cell Card_number;
	private static Cell Expiry_Month;	
	private static Cell Expiry_Year;
	private static Cell CVV;
	private static Cell Amount;
	private static Cell transaction_ID;
	private static String dDefaultPath;
	private static String rDefaultPath;
	private static String screenshot;
	private static String username;
	private static String password;
	private static String url;
	//folders 
		private static String dpath="\\data\\";//excel external file folder
		private static String rpath="\\Repository\\";//repository folder
		//screenshots front office
		private static String eshop_screenshots="\\screenshots\\eshop\\";//eshop payment transaction folder
		private static String refund_frontoffice_screenshots="\\screenshots\\refund_frontoffice\\";//refund transaction folder	
		private static String find_frontOffice_screenshots="\\screenshots\\find_frontOffice\\";//find transaction front office folder
		private static String login_screenshots="\\screenshots\\login\\";//login folder
		private static String View_frontoffice="\\screenshots\\View_front_office\\";//view front office folder
		
		////screenshots back office
		private static String confirm_backOffice_screenshots="\\screenshots\\confirm_backOffice\\";//confirm refund back office folder
		private static String find_backOffice_screenshots="\\screenshots\\find_backOffice\\";//find transaction back office folder
		private static String View_backtoffice="\\screenshots\\View_backtoffice\\";//view back office folder
		private static String reject_backtoffice="\\screenshots\\View_backtoffice\\";//reject back office folder
		//xml file name 
		private static String eshop="test_eshop.xml";// xml file for eshop payment
		private static String login="login.xml";//xml for front office 
		private static String backoffice="backoffice.xml";//xml for back office 
		
		public void transamrt_login(WebDriver driver, ExtentTest logger, String sDefaultPath,String username,String password) {
			
			dDefaultPath=sDefaultPath+dpath;// assigning a new data folder for external file 		
			rDefaultPath=sDefaultPath+rpath;// assigning a new repository folder
			screenshot=sDefaultPath+login_screenshots;// assigning a new screenshot folder
			try {
				//read data
				/*
				url=getdata.ReadData("DataExcel","login", "login-url", 2);
				username=getdata.ReadData("DataExcel","login", "Username", 2);
				password=getdata.ReadData("DataExcel","login", "Password", 2);
				
				driver.manage().window().maximize();


				Thread.sleep(2000);
			    utils.navigate(driver,url);
			    Thread.sleep(2000);
			   // utils.ExtentLogPassFail(driver, "main", "STEP 1\t\t PASSED","STEP 1 \t\t FAILED", logger,true, rDefaultPath,frontoffice);
			    Thread.sleep(2000);*/
			  //  utils.ClickObject(driver, "main", rDefaultPath+login);
			   
			    Thread.sleep(2000);
			    utils.RefreshPage();
			    Thread.sleep(2000);
			    
		  for(int i=0;i<2;i++) {
			    //inserting data
			  if(utils.checkIfObjectExists(driver, "username", rDefaultPath+login)) {
				  //int a=1;
				  if(i<=0) {
				  utils.ExtentLogPassFail(driver, "username", " \t\t PASSED", ""+"\t\t FAILED12", logger,true, rDefaultPath,login);
				  }
				  utils.EnterText(driver, "username", username, rDefaultPath+login);
			  }else {
				 // utils.ExtentLogPassFail(driver, "username", " \t\t PASSED", ""+"\t\t FAILED13", logger,true, rDefaultPath,login);
			  }
			    
			    utils.EnterText(driver, "password", password, rDefaultPath+login);
			    Thread.sleep(2000);
			    
			   //utils.ExtentLogPassFail(driver, "loginbtn", "STEP 2\t\t PASSED","STEP 3 \t\t FAILED", logger,true, rDefaultPath,frontoffice);
			    utils.ClickObject(driver, "loginbtn", rDefaultPath+login);
			    
			 
			  //  utils.checkIfObjectIsDisplayed(driver, "Secretblock", sDefaultPath+"\\Repository\\transmart_page_2.xml");
			    //login verification 
			  //Variable assignment for Verification Page
			    Thread.sleep(2000);
			    String Q1= utils.GetText(driver, "FirstQuestion",rDefaultPath+login);
			    Thread.sleep(2000);
			    String Q2= utils.GetText(driver, "SecondQuestion",rDefaultPath+login);
			    
			    //.out.println(Q1);
			   // System.out.println(Q2);
			    Select value = new Select(driver.findElement(By.xpath("//*[@id='FirstLetter']")));
			    Select value1 = new Select(driver.findElement(By.xpath("//*[@id='SecondLetter']")));
			    
			    

			    //Switch for first Question on Verification Page
			    switch (Q1){
			    
			    case "Please select the 1st letter of your secret word":
			    	value.selectByValue("t");
			    	break;
			    
			    case "Please select the 2nd letter of your secret word":
			    	value.selectByValue("e");
			    	break;
			    	
			    case "Please select the 3rd letter of your secret word":
			    	value.selectByValue("s");
			    	break;
			    	
			    case "Please select the 4th letter of your secret word":
			    	value.selectByValue("t");
			    	break;
			    	
			    case "Please select the 5th letter of your secret word":
			    	value.selectByValue("i");
			    	break;
			    	
			    case "Please select the 6th letter of your secret word":
			    	value.selectByValue("n");
			    	break;
			    	
			    case "Please select the 7th letter of your secret word":
			    	value.selectByValue("g");
			    	break;
			    
			    }
			    
			    
			    //Switch for Second Question on Verification
			    switch (Q2){
			    
			    case "Please select the 1st letter of your secret word":
			    	value1.selectByValue("t");
			    	break;
			    
			    case "Please select the 2nd letter of your secret word":
			    	value1.selectByValue("e");
			    	break;
			    	
			    case "Please select the 3rd letter of your secret word":
			    	value1.selectByValue("s");
			    	break;
			    	
			    case "Please select the 4th letter of your secret word":
			    	value1.selectByValue("t");
			    	break;
			    	
			    case "Please select the 5th letter of your secret word":
			    	value1.selectByValue("i");
			    	break;
			    	
			    case "Please select the 6th letter of your secret word":
			    	value1.selectByValue("n");
			    	break;
			    	
			    case "Please select the 7th letter of your secret word":
			    	value1.selectByValue("g");
			    	break;
			    
			    }
			   // utils.ExtentLogPassFail(driver, "LoginButton", "STEP 3\t\t PASSED","STEP 3 \t\t FAILED", logger,true, rDefaultPath,frontoffice);
			   
			    
			    if(utils.checkIfObjectExists(driver, "LoginButton", rDefaultPath+login)) {
			    	if(i<=0) {
					 utils.ExtentLogPassFail(driver, "LoginButton", " \t\t PASSED", ""+"\t\t FAILED11", logger,true, rDefaultPath,login);
			    	}
					  utils.ClickObject(driver, "LoginButton", rDefaultPath+login);
				  }else {
					  utils.ExtentLogPassFail(driver, "LoginButtonx", " \t\t PASSED", ""+"\t\t FAILED10", logger,true, rDefaultPath,login);
				  }
			  
			    //utils.ExtentLogPassFail(driver, "find", "STEP 4\t\t PASSED","STEP 4 \t\t FAILED", logger,true, rDefaultPath,frontoffice);
				
		  }
			    
			}catch(Exception e) {e.getMessage();
			//driver.quit();
			}
			
		}
		
		
}
