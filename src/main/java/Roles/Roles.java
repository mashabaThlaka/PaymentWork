package Roles;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.fillo.Recordset;

import Roles_properties.Roles_extender;
import Roles_properties.Roles_properties;
import transmart_properties.properties;
import transmart_properties.properties_extender;
import vodacom.payment_solution.vodacom.payment_solution.ReadExcelData;
import vodacom.payment_solution.vodacom.payment_solution.UtilityFunctions;
import vodacom.payment_solution.vodacom.payment_solution.WriteExcelData;

import java.sql.ResultSet;

import org.apache.poi.ss.usermodel.Sheet;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.binary.Base64;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Roles {
	static ReadExcelData getdata=new ReadExcelData();
	static WriteExcelData writedata= new WriteExcelData();
	static properties_extender ext=new properties_extender();
	static UtilityFunctions utils = new UtilityFunctions();
	static properties  prop = new properties();
	static  Roles_properties roles  =new Roles_properties();
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
	static String user_name;
	static String pass_word;
	 
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
	
		browers=getdata.ReadData("Roles_Controller", "Call_Centre", "Browsers", 2);
		extent = utils.initializeExtentReports("Roles_Report_"+browers+utils.getCurrentTimeStamp(), sDefaultPath); 
		
		
	}
	@Test
	public void T_02_Call_centre_view_transactions() throws Exception {	
		
		
		        testcase=getdata.ReadData("Roles_Controller", "Call_Centre", "TEST CASES", 4);
		        execute=getdata.ReadData("Roles_Controller", "Call_Centre", "EXECUTE", 4);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_view_transactions(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_02_Call_centre_view_supplie_payments_changes() throws Exception {	
		
		//Call centre view transactions 
		        testcase=getdata.ReadData("Roles_Controller", "Call_Centre", "TEST CASES", 5);
		        execute=getdata.ReadData("Roles_Controller", "Call_Centre", "EXECUTE", 5);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
		        //System.out.println(testcase);
		        //.out.println(execute);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_view_supplier_payments(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_03_Call_centre_Sales_Summary() throws Exception {	
		
		//Call centre view transactions 
		        testcase=getdata.ReadData("Roles_Controller", "Call_Centre", "TEST CASES", 6);
		        execute=getdata.ReadData("Roles_Controller", "Call_Centre", "EXECUTE", 6);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_Sales_Summary(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_04_Call_Transaction_Status_Report() throws Exception {	
		
		//Call centre view transactions 
		        testcase=getdata.ReadData("Roles_Controller", "Call_Centre", "TEST CASES", 7);
		        execute=getdata.ReadData("Roles_Controller", "Call_Centre", "EXECUTE", 7);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_Transaction_Status_Report(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_04_Call_find_transactions() throws Exception {	
		
		//Call centre view transactions 
		        testcase=getdata.ReadData("Roles_Controller", "Call_Centre", "TEST CASES", 8);
		        execute=getdata.ReadData("Roles_Controller", "Call_Centre", "EXECUTE", 8);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_find_transactions(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}

	@Test
	public void T_05_Call_centre_Supplier_Details_Lookup() throws Exception {	
		
		//Call centre view transactions 
		        testcase=getdata.ReadData("Roles_Controller", "Call_Centre", "TEST CASES", 2);
		        execute=getdata.ReadData("Roles_Controller", "Call_Centre", "EXECUTE", 2);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_Supplier_Details_Lookup(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_06_View_Supplier_Setup() throws Exception {	
		
		//Call centre view transactions 
		        testcase=getdata.ReadData("Roles_Controller", "Call_Centre", "TEST CASES", 3);
		        execute=getdata.ReadData("Roles_Controller", "Call_Centre", "EXECUTE", 3);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 2);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 2);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_View_Supplier_Setup(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_07_Finance_Supplier_Details_Lookup() throws Exception {	
		
		
		        testcase=getdata.ReadData("Roles_Controller", "Finance", "TEST CASES", 2);
		        execute=getdata.ReadData("Roles_Controller", "Finance", "EXECUTE", 2);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 5);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 5);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_Supplier_Details_Lookup(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_08_Finance_View_Supplier_Setup () throws Exception {	
		
		
		        testcase=getdata.ReadData("Roles_Controller", "Finance", "TEST CASES", 6);
		        execute=getdata.ReadData("Roles_Controller", "Finance", "EXECUTE", 6);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 5);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 5);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_View_Supplier_Setup(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_09_Finance_View_Transactions () throws Exception {	
		
		
		        testcase=getdata.ReadData("Roles_Controller", "Finance", "TEST CASES", 7);
		        execute=getdata.ReadData("Roles_Controller", "Finance", "EXECUTE", 7);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 5);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 5);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_view_transactions(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_10_Finance_View_Payment_Changes() throws Exception {	
		
		
		        testcase=getdata.ReadData("Roles_Controller", "Finance", "TEST CASES", 11);
		        execute=getdata.ReadData("Roles_Controller", "Finance", "EXECUTE", 11);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 5);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 5);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_view_supplier_payments(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_11_Finance_Sales_Summary() throws Exception {			
		
		        testcase=getdata.ReadData("Roles_Controller", "Finance", "TEST CASES", 10);
		        execute=getdata.ReadData("Roles_Controller", "Finance", "EXECUTE", 10);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 5);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 5);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_Sales_Summary(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_12_Finance_Find_Transactions () throws Exception {			
		
		        testcase=getdata.ReadData("Roles_Controller", "Finance", "TEST CASES", 12);
		        execute=getdata.ReadData("Roles_Controller", "Finance", "EXECUTE", 12);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 5);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 5);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_find_transactions(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	
	@Test
	public void T_13_Finance_Transaction_Status_Report() throws Exception {			
		
		        testcase=getdata.ReadData("Roles_Controller", "Finance", "TEST CASES", 13);
		        execute=getdata.ReadData("Roles_Controller", "Finance", "EXECUTE", 13);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 5);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 5);
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_Transaction_Status_Report(driver, logger, sDefaultPath,user_name,pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_14_sales_Supplier_Details_Lookup () throws Exception {			
		
		        testcase=getdata.ReadData("Roles_Controller", "Sales", "TEST CASES", 2);
		        execute=getdata.ReadData("Roles_Controller", "Sales", "EXECUTE", 2);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 7);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 7);
				
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_Supplier_Details_Lookup(driver, logger, sDefaultPath, user_name, pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	
	@Test
	public void T_15_View_Transactions () throws Exception {			
		
		        testcase=getdata.ReadData("Roles_Controller", "Sales", "TEST CASES", 12);
		        execute=getdata.ReadData("Roles_Controller", "Sales", "EXECUTE", 12);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 7);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 7);
				
				
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_view_transactions(driver, logger, sDefaultPath, user_name, pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_16_Sales_View_Payment_Changes() throws Exception {			
		
		        testcase=getdata.ReadData("Roles_Controller", "Sales", "TEST CASES", 13);
		        execute=getdata.ReadData("Roles_Controller", "Sales", "EXECUTE", 13);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 7);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 7);
				
				
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_view_supplier_payments(driver, logger, sDefaultPath, user_name, pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_17_Sales_Sales_Summary() throws Exception {			
		
		        testcase=getdata.ReadData("Roles_Controller", "Sales", "TEST CASES", 14);
		        execute=getdata.ReadData("Roles_Controller", "Sales", "EXECUTE", 14);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 7);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 7);
				
				
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_Sales_Summary(driver, logger, sDefaultPath, user_name, pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_18_Sales_Transaction_Status_Report() throws Exception {			
		
		        testcase=getdata.ReadData("Roles_Controller", "Sales", "TEST CASES", 15);
		        execute=getdata.ReadData("Roles_Controller", "Sales", "EXECUTE", 15);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 7);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 7);
				
				
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_Transaction_Status_Report(driver, logger, sDefaultPath, user_name, pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_19_Sales_Find_Transactions() throws Exception {			
		
		        testcase=getdata.ReadData("Roles_Controller", "Sales", "TEST CASES", 16);
		        execute=getdata.ReadData("Roles_Controller", "Sales", "EXECUTE", 16);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 7);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 7);
				
				
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_find_transactions(driver, logger, sDefaultPath, user_name, pass_word);
		    		Thread.sleep(2000);			
		    		driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
	@Test
	public void T_21_Sales_View_Supplier_Setup () throws Exception {			
		
		        testcase=getdata.ReadData("Roles_Controller", "Sales", "TEST CASES", 6);
		        execute=getdata.ReadData("Roles_Controller", "Sales", "EXECUTE", 6);
		        user_name=getdata.ReadData("Roles_DataExcel", "users", "user_name", 7);
				pass_word=getdata.ReadData("Roles_DataExcel", "users", "pass_word", 7);
				
				
		        if (execute.toString().equals("YES")){
		        	//create report
		    		logger = extent.createTest(testcase); 
		    		logger.assignCategory("Category:\t\tTRANSMAT\t\t PAYMENT \t\t SOLUTIONS");
		    		logger.assignAuthor("Author:\t\tAlex\t\t\t\tKwenene");	
		        	driver = utils.initializeWedriver(browers, sDefaultPath);		        	
		    		Thread.sleep(3000);		
		    		roles.Roles_View_Supplier_Setup(driver, logger, sDefaultPath, user_name, pass_word);
		    		Thread.sleep(2000);			
		    		//driver.close();
		    		extent.flush();	
		        	
		        }else {
		        	
		        }
		}
}
	

