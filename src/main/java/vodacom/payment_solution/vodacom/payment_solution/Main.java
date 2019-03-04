package vodacom.payment_solution.vodacom.payment_solution;

import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.fillo.Recordset;

import transmart_properties.properties;
import transmart_properties.properties_extender;

import java.sql.ResultSet;

import org.apache.poi.ss.usermodel.Sheet;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.binary.Base64;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Main {
	static ReadExcelData getdata=new ReadExcelData();
	static WriteExcelData writedata= new WriteExcelData();
	static properties_extender ext=new properties_extender();
	static UtilityFunctions utils = new UtilityFunctions();
	static properties  prop = new properties();
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
		// System.out.print(sDefaultPath);
		//web drivers
		utils.WindowsProcess("IEDriverServer.exe");
		utils.CloseRunningProcess();
		utils.WindowsProcess("chromedriver.exe");
		utils.CloseRunningProcess();
		utils.WindowsProcess("geckodriver.exe");
		utils.CloseRunningProcess();
		
						 
		
	}
	
	@Test
	public void T_01() throws Exception {
		
	
		browers=getdata.ReadData("Controller", "transactions", "Browsers", 2);
		extent = utils.initializeExtentReports("Transmart Report_"+browers+utils.getCurrentTimeStamp(), sDefaultPath); 	
	
		
		
	}
	//transactions 
	@Test
	public void T_02_Eshop_Payments_Preauthandsettle() throws Exception {		
		//preparing to execute preauth and settle transactions
		        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 2);
		        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 2);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		prop.T_0003_transactions_Payments_Preauth_and_Settle(driver, logger, sDefaultPath);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
			}
	
	@Test
	public void T_03_Eshop_Payments_Preauth() throws Exception {		
			//preparing to execute Preauth transactions
		        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES",10);
		        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 10);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		prop.T_0002_transactions_Payments_Preauth(driver, logger, sDefaultPath);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
			}
	@Test
	public void T_04_Eshop_Payments_auth() throws Exception {		
			//preparing to execute auth transactions
		        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 11);
		        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 11);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		prop.T_0004_transactions_Payments_Auth(driver, logger, sDefaultPath);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
			}
	
	@Test
	public void T_05_find_transation() throws Exception {		
				//preparing to execute find created transactions
		        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 4);
		        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 4);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		prop.find_transactions(driver, logger, sDefaultPath);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
        	
	}
	@Test
	public void T_06_find_transation_back() throws Exception {		
				//preparing to execute find created transactions 
		        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 7);
		        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 7);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		prop.find_transactions_back(driver, logger, sDefaultPath);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
        	
	}
	@Test
	public void T_07_view_transactions() throws Exception {
		//preparing to view transactions 
		testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 6);
		 execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 6);
		 //System.out.println(testcase);
		 //System.out.println(execute);
		 if (execute.toString().equals("YES")){
				//create report
				logger = extent.createTest(testcase); 
				logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
				logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
				driver = utils.initializeWedriver(browers, sDefaultPath);
				prop.T_0005_view_transactions(driver, logger, sDefaultPath);
				Thread.sleep(2000);			
				Thread.sleep(2000);			
				driver.close();
				extent.flush();
		 }else {
			 
		 }
    
	}
	@Test
	public void T_08_view_transactions_font() throws Exception {
		//preparing to view transactions 
		testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 3);
		 execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 3);
		 //System.out.println(testcase);
		 //System.out.println(execute);
		 if (execute.toString().equals("YES")){
				//create report
				logger = extent.createTest(testcase); 
				logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
				logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
				driver = utils.initializeWedriver(browers, sDefaultPath);
				prop.T_0005_view_transactions_front(driver, logger, sDefaultPath);
				Thread.sleep(2000);			
				Thread.sleep(2000);			
				driver.close();
				extent.flush();
		 }else {
			
		 }
    
	}
	@Test
	public void T_09_refund_transactions() throws Exception {
		//preparing to refund transactions 
		testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 5);
		 execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 5);
		 if (execute.toString().equals("YES")){
				//create report
				logger = extent.createTest(testcase); 
				logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
				logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
				driver = utils.initializeWedriver(browers, sDefaultPath);
				prop.T_0006_refund_transactions(driver, logger, sDefaultPath);
				Thread.sleep(2000);			
				Thread.sleep(2000);			
				driver.close();
				extent.flush();
		 }else {
			 
		 }
    
	}
	@Test
	public void T_11_confirm_refund() throws Exception {		
			//preparing to confirm transactions 
		        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 8);
		        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 8);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		prop.confirm_refund(driver, logger, sDefaultPath);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
			}
	@Test
	public void T_12_reject_refund() throws Exception {		
			//preparing to execute reject transactions 
		        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 9);
		        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 9);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		prop.reject_refund(driver, logger, sDefaultPath);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
			}
	@Test
	public void T_13_Chargebacks() throws Exception {		
			//preparing to execute reject transactions 
		        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 12);
		        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 12);
		      
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		
		    		prop.charge_back(driver, logger, sDefaultPath);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
			}
	@Test
	public void T_14_Confirm_Chargeback() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 13);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 13);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.Confirm_charge_back(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_15_Transaction_Status_Report() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 14);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 14);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.Transaction_Status_Report(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_16_Acquirer_Setup() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 9);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 9);
	        if (execute.toString().equals("YESx")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		//prop.reject_refund(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_17_Multiple_Refunds() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 22);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 22);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.Multiple_Refunds(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_17_Multiple_Chargebacks()throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 16);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 16);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.Multiple_Chargebacks(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	
	@Test
	public void T_18_Import_MarkOff_File() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 9);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 9);
	        if (execute.toString().equals("YESx")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		//prop.reject_refund(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_19_Sales_Summary() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 18);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 18);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.Sales_Summary(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_21_View_Payment_Changes() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 19);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 19);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.View_Payment_Changes(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_22_Settle_Transaction() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 20);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 20);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.Settle_Transaction(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		//driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_23_Supplier_Statement() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 21);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE",21);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.Supplier_Statement(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_24_Confirm_Multiple_Chargebacks() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 30);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 30);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.Confirm_Multiple_Chargebacks(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_25_Reverse_Multiple_Chargebacks() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES",23);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 23);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.Reverse_Multiple_Chargebacks(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_26_View_Discrepancies() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 9);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 9);
	        if (execute.toString().equals("YESx")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		//prop.reject_refund(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_27_Credit_Card_Reconciliation() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 9);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 9);
	        if (execute.toString().equals("YESx")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		//prop.reject_refund(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_28_View_Supplier_Payments() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 9);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 9);
	        if (execute.toString().equals("YESx")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		//prop.reject_refund(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_29_Add_Payment_Change() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 9);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 9);
	        if (execute.toString().equals("YESx")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		//prop.reject_refund(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_31_Reverse_Chargeback() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 28);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 28);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.Reverse_Chargebacks(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_32_Credit_Card_Accounts_Setup() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 9);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 9);
	        if (execute.toString().equals("YESx")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		//prop.reject_refund(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_33_Multiple_Chargebacks() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 9);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 9);
	        if (execute.toString().equals("YESx")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		//prop.reject_refund(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	@Test
	public void T_34_Cancel_Preauthorisation() throws Exception {		
		//preparing to execute reject transactions 
	        testcase=getdata.ReadData("Controller", "transactions", "TEST CASES", 31);
	        execute=getdata.ReadData("Controller", "transactions", "EXECUTE", 31);
	        if (execute.toString().equals("YES")){
	        	//create report
	    		logger = extent.createTest(testcase); 
	    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
	    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
	        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
	    		Thread.sleep(3000);		
	    		prop.Cancel_Preauthorisation(driver, logger, sDefaultPath);
	    		Thread.sleep(2000);			
	    		//driver.close();
	    		extent.flush();	
	        	
	        }else {
	        	
	        }
		}
	
	
	// supplier modules
	@Test
	public void T_35_Supplier_Merchant_on_boarding() throws Exception {		
			//preparing to execute register merchant 
		        testcase=getdata.ReadData("Controller", "supplier", "TEST CASES", 2);
		        execute=getdata.ReadData("Controller", "supplier", "EXECUTE", 2);
		        if (execute.toString().equals("YESx")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		prop.Merchant_on_boarding(driver, logger, sDefaultPath);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
			}
	@Test
	public void T_36_Supplier_Merchant_on_boarding() throws Exception {		
			//preparing to execute create merchant via wizard 
		        testcase=getdata.ReadData("Controller", "supplier", "TEST CASES", 3);
		        execute=getdata.ReadData("Controller", "supplier", "EXECUTE", 3);
		        if (execute.toString().equals("YESx")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		prop.Merchant_on_boarding_wizard(driver, logger, sDefaultPath);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        }
			}
}
