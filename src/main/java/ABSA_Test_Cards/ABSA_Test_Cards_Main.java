package ABSA_Test_Cards;

import java.sql.ResultSet;

import org.apache.poi.ss.usermodel.Sheet;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.fillo.Recordset;
import com.gargoylesoftware.htmlunit.javascript.host.Window;

import Absa_test_Cards_propetties.Cards;
import digital_wallet_properties.digital_wallet_properties;
import transmart_properties.properties_extender;
import vodacom.payment_solution.vodacom.payment_solution.ReadExcelData;
import vodacom.payment_solution.vodacom.payment_solution.UtilityFunctions;
import vodacom.payment_solution.vodacom.payment_solution.WriteExcelData;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ABSA_Test_Cards_Main {
	static ReadExcelData getdata=new ReadExcelData();
	static WriteExcelData writedata= new WriteExcelData();
	static properties_extender ext=new properties_extender();
	static UtilityFunctions utils = new UtilityFunctions();
	static digital_wallet_properties digital = new digital_wallet_properties();
	static Cards cards_object = new Cards();
	static ExtentTest logger;
	static  ExtentReports extent;
	Sheet sheet;
	Recordset record;
	static String sDefaultPath;
	static String dDefaultPath;//excel external file folder
	static String rDefaultPath;//repository folder
	ResultSet resultset;
	
	static String browers;
	static WebDriver driver ;
	static String testcase;
	static String execute;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//folders
		sDefaultPath = System.getProperty("user.dir");
		sDefaultPath = sDefaultPath.replace("batch", "");
		dDefaultPath=sDefaultPath+"\\data\\";// assigning a new data folder for external file 
		rDefaultPath=sDefaultPath+"\\Repository\\";// assigning a new repository folder
		
		//web drivers
		utils.WindowsProcess("IEDriverServer.exe");
		utils.CloseRunningProcess();
		utils.WindowsProcess("chromedriver.exe");
		utils.CloseRunningProcess();
		utils.WindowsProcess("geckodriver.exe");
		utils.CloseRunningProcess();
		
						 
		
	}
	
	@Test
	public void T_0001() throws Exception {
				browers=getdata.ReadData("Digital_Wallet_DataExcel", "Digital_wallet", "url", 3);
				extent = utils.initializeExtentReports("ABSA Cards Report_"+browers+utils.getCurrentTimeStamp(), sDefaultPath); 
				
				//System.out.print(browers);
				
	}
	 @Test
 	public void T_0002_Absa() throws Exception {		
 		//payment in different cards

         
         for(int i=2;i<=11;i++) {
        	 testcase=getdata.ReadData("ABSA_Cards_Controller", "CRL", "TEST CASES", i);
             execute=getdata.ReadData("ABSA_Cards_Controller", "CRL", "EXECUTE", i);
             
         if (execute.toString().equals("YES")){
         	//create report
         	//System.out.println("0000000");
     		logger = extent.createTest(testcase); 
     		logger.assignCategory("Category:\t\tDigital\t\t Wallet \t\t ");
     		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
         	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
     		Thread.sleep(3000);	        		
     		cards_object.Absa_transactions_Payments_Preauth_and_Settle(driver, logger, sDefaultPath, i);
     		Thread.sleep(2000);			
     		driver.close();
     		driver.quit();
     		extent.flush();	
         	
        }else {
         	System.out.println(testcase+"\t not selected");
         }
     }
	 }

}
