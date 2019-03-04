package digitalwallet;

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

import digital_wallet_properties.digital_wallet_properties;
import transmart_properties.properties_extender;
import vodacom.payment_solution.vodacom.payment_solution.ReadExcelData;
import vodacom.payment_solution.vodacom.payment_solution.UtilityFunctions;
import vodacom.payment_solution.vodacom.payment_solution.WriteExcelData;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class digital_wallet_main {
	static ReadExcelData getdata=new ReadExcelData();
	static WriteExcelData writedata= new WriteExcelData();
	static properties_extender ext=new properties_extender();
	static UtilityFunctions utils = new UtilityFunctions();
	static digital_wallet_properties digital = new digital_wallet_properties();
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
				extent = utils.initializeExtentReports("Digital wallet Report_"+browers+utils.getCurrentTimeStamp(), sDefaultPath); 
				
				//System.out.print(browers);
				
	}


        @Test
    	public void T_0002_vodapay() throws Exception {		
    		//Make a payment without registering for VodaPay DW

            testcase=getdata.ReadData("Digital_Wallet_Controller", "CRL", "TEST CASES", 2);
            execute=getdata.ReadData("Digital_Wallet_Controller", "CRL", "EXECUTE", 2);
            System.out.println(testcase);
            System.out.println(execute);
            if (execute.toString().equals("YES")){
            	//create report
            	//System.out.println("0000000");
        		logger = extent.createTest(testcase); 
        		logger.assignCategory("Category:\t\tDigital\t\t Wallet \t\t ");
        		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
            	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
        		Thread.sleep(3000);	        		
        		digital.T_0002_Vodapay(driver, logger, sDefaultPath);
        		Thread.sleep(2000);			
        		driver.close();
        		driver.quit();
        		extent.flush();	
            	
           }else {
            	System.out.println(testcase+"\t not selected");
            }
        }
            @Test
        	public void T_0003_vodapay() throws Exception {		
        		//Register for VodaPay DW and pay
                testcase=getdata.ReadData("Digital_Wallet_Controller", "CRL", "TEST CASES", 3);
                execute=getdata.ReadData("Digital_Wallet_Controller", "CRL", "EXECUTE", 3);
                if (execute.toString().equals("YES")){
                	//create report
            		logger = extent.createTest(testcase); 
            		logger.assignCategory("Category:\t\tDigital\t\t Wallet \t\t ");
            		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
                	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
            		Thread.sleep(3000);		
            		digital.T_0003_Vodapay(driver, logger, sDefaultPath);
            		Thread.sleep(2000);			
            		driver.close();
            		driver.quit();
            		extent.flush();	
                	
                }else {
                	System.out.println(testcase+"\t not selected");
                }     
	   }
           
            @Test
        	public void T_0004_vodapay() throws Exception {		
            	 //Register via opt-in
                testcase=getdata.ReadData("Digital_Wallet_Controller", "CRL", "TEST CASES", 4);
                execute=getdata.ReadData("Digital_Wallet_Controller", "CRL", "EXECUTE", 4);
                if (execute.toString().equals("YES")){
                	//create report
            		logger = extent.createTest(testcase); 
            		logger.assignCategory("Category:\t\tDigital\t\t Wallet \t\t ");
            		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
                	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
            		Thread.sleep(3000);		
            		digital.T_0004_Vodapay(driver, logger, sDefaultPath);
            		Thread.sleep(2000);			
            		driver.close();
            		driver.quit();
            		extent.flush();	
                	
                }else {
                	System.out.println(testcase+"\t not selected");
                }     
	   }
            @Test
        	public void T_0005_vodapay() throws Exception {		
            	 //Register via the “Register” link
                testcase=getdata.ReadData("Digital_Wallet_Controller", "CRL", "TEST CASES",5 );
                execute=getdata.ReadData("Digital_Wallet_Controller", "CRL", "EXECUTE", 5);
                if (execute.toString().equals("YES")){
                	//create report
            		logger = extent.createTest(testcase); 
            		logger.assignCategory("Category:\t\tDigital\t\t Wallet \t\t ");
            		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
                	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
            		Thread.sleep(3000);		
            		digital.T_0005_Vodapay(driver, logger, sDefaultPath);
            		Thread.sleep(2000);			
            		driver.close();
            		driver.quit();
            		extent.flush();	
                	
                }else {
                	System.out.println(testcase+"\t not selected");
                }     
	   }
        	@Test
        	public void T_0006_vodapay() throws Exception {		
        		//preparing Make a payment using a card from the wallet
                testcase=getdata.ReadData("Digital_Wallet_Controller", "CRL", "TEST CASES", 6);
                execute=getdata.ReadData("Digital_Wallet_Controller", "CRL", "EXECUTE", 6);
                if (execute.toString().equals("YES")){
                	//create report
            		logger = extent.createTest(testcase); 
            		logger.assignCategory("Category:\t\tDigital\t\t Wallet \t\t ");
            		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
                	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
            		Thread.sleep(3000);		
            		digital.T_0001_Vodapay(driver, logger, sDefaultPath);
            		Thread.sleep(2000);			
            		driver.close();
            		driver.quit();
            		extent.flush();	
                	
                }else {
                	System.out.println(testcase+"\t not selected");}
                }
        	@Test
        	public void T_0007_vodapay() throws Exception {		
        		//preparing Make a payment using a card from the wallet
                testcase=getdata.ReadData("Digital_Wallet_Controller", "CRL", "TEST CASES", 7);
                execute=getdata.ReadData("Digital_Wallet_Controller", "CRL", "EXECUTE", 7);
                if (execute.toString().equals("YES")){
                	//create report
            		logger = extent.createTest(testcase); 
            		logger.assignCategory("Category:\t\tDigital\t\t Wallet \t\t ");
            		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
                	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
            		Thread.sleep(3000);		
            		digital.T_0007_Vodapay(driver, logger, sDefaultPath);
            		Thread.sleep(2000);			
            		driver.close();
            		driver.quit();
            		extent.flush();	
                	
                }else {
                	System.out.println(testcase+"\t not selected");}
                }
        	@Test
        	public void T_0008_vodapay() throws Exception {		
        		//preparing Make a payment using a card from the wallet
                testcase=getdata.ReadData("Digital_Wallet_Controller", "CRL", "TEST CASES", 8);
                execute=getdata.ReadData("Digital_Wallet_Controller", "CRL", "EXECUTE", 8);
                if (execute.toString().equals("YES")){
                	//create report
            		logger = extent.createTest(testcase); 
            		logger.assignCategory("Category:\t\tDigital\t\t Wallet \t\t ");
            		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
                	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
            		Thread.sleep(3000);		
            		digital.T_0008_Vodapay(driver, logger, sDefaultPath);
            		Thread.sleep(2000);			
            		driver.close();   
            		driver.quit();
            		extent.flush();	
            		
                }else {
                	System.out.println(testcase+"\t not selected");}
                }
        	@Test
        	public void T_0009_vodapay() throws Exception {		
        		//preparing Make a payment using a card from the wallet
                testcase=getdata.ReadData("Digital_Wallet_Controller", "CRL", "TEST CASES", 9);
                execute=getdata.ReadData("Digital_Wallet_Controller", "CRL", "EXECUTE", 9);
                if (execute.toString().equals("YES")){
                	//create report
            		logger = extent.createTest(testcase); 
            		logger.assignCategory("Category:\t\tDigital\t\t Wallet \t\t ");
            		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
                	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
            		Thread.sleep(3000);		
            		digital.T_0009_Vodapay(driver, logger, sDefaultPath);
            		Thread.sleep(2000);	
               		driver.close();
               		driver.quit();
            		extent.flush();	
                	
                }else {
                	System.out.println(testcase+"\t not selected");}
                }
}
