package Supplier;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Sheet;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.fillo.Recordset;

import Transactions.Transactions;
import transmart_properties.properties_extender;
import vodacom.payment_solution.vodacom.payment_solution.DataFunctions;
import vodacom.payment_solution.vodacom.payment_solution.UtilityFunctions;

public class Set_options {
	
	static properties_extender login=new properties_extender();	
	static UtilityFunctions utils = new UtilityFunctions();
	static Transactions transactions=new Transactions();
	static DataFunctions data = new DataFunctions();
	Supplier objsupplier =  new Supplier();
	static  ExtentReports extent;
	Sheet sheet;
	Recordset record;
	static String sDefaultPath;
	static String dDefaultPath;//excel external file folder
	static String rDefaultPath;//repository folder
	ResultSet resultset; 
	static WebDriver driver ;
	static String username;
	static String password;
	static String browers;
	static String url;	
	static String FILENAME;
	static ExtentTest logger;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//folders
		sDefaultPath = System.getProperty("user.dir");
		sDefaultPath = sDefaultPath.replace("batch", "");
		dDefaultPath=sDefaultPath+"\\data\\";// assigning a new data folder for external file 
		rDefaultPath=sDefaultPath+"\\Repository\\";// assigning a new repository folder	
		utils.WindowsProcess("IEDriverServer.exe");
		utils.CloseRunningProcess();
		utils.WindowsProcess("chromedriver.exe");
		utils.CloseRunningProcess();
		utils.WindowsProcess("geckodriver.exe");
		utils.CloseRunningProcess();					 
		
	}
	
	@Test
	public void View_transactions() throws Exception {
		//admin view transactions 
		//CreateSubfolderFunction
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		utils.ScreenshotParentFolder(getClass().getPackage().toString(),sDefaultPath);			
		String packageName = getClass().getPackage().toString();			
		//Take the className which is the last part of package name
		utils.subfolderCreation(getClass().getName().substring(packageName.length()-1),timeStamp);
		String subfolderPath = utils.getPathToSubfolder();
		System.out.println(subfolderPath);
		
		extent = utils.initializeExtentReports("Transmart Report_"+utils.getCurrentTimeStamp(),sDefaultPath); 	
		logger = extent.createTest("Set Options"); 
		logger.assignCategory("Category:\t\tSUPPLIER\t\t PAYMENT \t\t SOLUTIONS");
		logger.assignAuthor("Author:\t\tMashaba\t\t\t\tThlaka");
		FILENAME="TransmartData.xlsx";
	
		sheet = data.ReadExcel(sDefaultPath+"\\"+ "data"+"\\"+FILENAME,"Sheet1");
		browers=data.getCellData("Browers", 1, sheet,null,null, "Excel");
		url=data.getCellData("Url", 1, sheet,null,null, "Excel");
		username=data.getCellData("Username", 1, sheet,null,null, "Excel");
		password=data.getCellData("Password", 1, sheet,null,null, "Excel");
	
					
		driver=utils.initializeWedriver(browers, sDefaultPath);
		driver.manage().window().maximize();
		Thread.sleep(2000);		
		utils.navigate(driver,url);
		login.transamrt_login(driver, logger, sDefaultPath, username, password);
		Thread.sleep(2000);
						
		//transactions.T_view_transactions(driver, logger, sDefaultPath,subfolderPath);		
		objsupplier.Set_Options(driver, logger, sDefaultPath, subfolderPath);
		
		//driver.close();
		extent.flush();
	}


}
