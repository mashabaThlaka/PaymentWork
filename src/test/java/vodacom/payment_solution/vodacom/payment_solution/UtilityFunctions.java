package vodacom.payment_solution.vodacom.payment_solution;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class UtilityFunctions {
	private String processName;	
	private File outputFile;
	static String pathToSubfolder;
	 public void ScreenshotParentFolder(String packageName, String sDefaultPath)
	    {	
	       // String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	        Path pathParentDirectory = Paths.get(sDefaultPath+"\\screenshots"+"/"+"_"+packageName);
	        
	        outputFile = new File(sDefaultPath+"\\screenshots"+"/"+"_"+packageName);
	        if (Files.notExists(pathParentDirectory,LinkOption.NOFOLLOW_LINKS)) 
	        {
	        	outputFile.mkdir();
		        //System.out.println(outputFile);
	        }
	        
	    }
	 public static String getPathToSubfolder()	{
			
			return pathToSubfolder;
		}
	    
	//This is for second time folder creation
	    public String subfolderCreation(String className, String timestamp){
	    	
	        String st = outputFile.getAbsolutePath();
	        //System.out.println("The first path is"+st);
	        outputFile = new File(st+"/"+className+timestamp);
	        outputFile.mkdirs();
	        System.out.println(outputFile);
	        pathToSubfolder = outputFile.getPath();
	        //String pathToSubfolder = outputFile.getPath();
	        return pathToSubfolder;
	    }
	public WebDriver initializeWedriver(String sdriverName, String sDefaultPath)
	{
		WebDriver driver = null;
		try
			
		{

			 switch (sdriverName.toUpperCase())
			  {
				  case "CHROME":
					  System.setProperty("webdriver.chrome.driver", sDefaultPath+"\\drivers\\ChromeDriver.exe");
					  driver = new ChromeDriver();
					  break;
				  
				  case "FIREFOX":
					  System.setProperty("webdriver.gecko.driver", sDefaultPath+"\\drivers\\geckodriver.exe");
					  driver = new FirefoxDriver();
				      break;
				      
				  case "IE":
					  System.setProperty("webdriver.ie.driver", sDefaultPath+"\\drivers\\IEDriverServer.exe");
					  driver = new InternetExplorerDriver();
				      break;
			  }
			 
		}catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		return driver;
		
	}
	
	/*******************************************************************************General Function Area***********************************************************************/
	  public void WindowsProcess(String processName)
	    {
	        this.processName = processName;
	    }

	    public void CloseRunningProcess() throws Exception
	{
	    if (isRunning())
	    {
	        getRuntime().exec("taskkill /F /IM " + processName);
	    }
	}

	    private boolean isRunning() throws Exception
	    {
	        Process listTasksProcess = getRuntime().exec("tasklist");
	        BufferedReader tasksListReader = new BufferedReader(
	                new InputStreamReader(listTasksProcess.getInputStream()));

	        String tasksLine;

	        while ((tasksLine = tasksListReader.readLine()) != null)
	        {
	            if (tasksLine.contains(processName))
	            {
	                return true;
	            }
	        }

	        return false;
	    }

	    private Runtime getRuntime()
	    {
	        return Runtime.getRuntime();
	    }
	    
	    public void navigate(WebDriver driver, String URL)
	    {
	    	 	driver.get(URL);
			   // driver.manage().window().maximize();
	    }
	    
	    

	    
		   public String getCurrentTimeStamp()
		   
		   {
			   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			    Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
				return sdf.format(timestamp);
			    
		   }

		   public ExtentReports initializeExtentReports(String sReportName, String sDefaultPath)
		   {
			   ExtentHtmlReporter htmlReporter;
				  ExtentReports extent;
			// initialize the HtmlReporter
				htmlReporter = new ExtentHtmlReporter(sDefaultPath+"\\report\\"+sReportName+".html");
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
				return extent;
		   }
		   //Alex commented this 
		   /*  public  void SendEmail(String sfrom, String sto, String sReportName, String sDefaultPath) {
			      // Recipient's email ID needs to be mentioned.
			      String to = sto;

			      // Sender's email ID needs to be mentioned
			      String from = sfrom;

			      final String username = "mbucwa@gmail.com";//change accordingly
			      final String password = "Z1@qwenhliva";//change accordingly

			      // Assuming you are sending email through relay.jangosmtp.net
			      String host = "smtp.gmail.com";

			      Properties props = new Properties();
			      props.put("mail.smtp.auth", "true");
			      props.put("mail.smtp.starttls.enable", "true");
			      props.put("mail.smtp.host", host);
			      props.put("mail.smtp.port", "25");

			    // Get the Session object.
			      Session session = Session.getInstance(props,
			         new javax.mail.Authenticator() {
			            protected PasswordAuthentication getPasswordAuthentication() {
			               return new PasswordAuthentication(username, password);
			            }
			         });

			      try {
			         // Create a default MimeMessage object.
			         Message message = new MimeMessage(session);

			         // Set From: header field of the header.
			         message.setFrom(new InternetAddress(from));

			         // Set To: header field of the header.
			         message.setRecipients(Message.RecipientType.TO,
			            InternetAddress.parse(to));

			         // Set Subject: header field
			         message.setSubject("Please see attached automation results");

			         // Create the message part
			         BodyPart messageBodyPart = new MimeBodyPart();

			         // Now set the actual message
			         messageBodyPart.setText("This is message body");

			         // Create a multipar message
			         Multipart multipart = new MimeMultipart();

			         // Set text message part
			         multipart.addBodyPart(messageBodyPart);

			         // Part two is attachment
			         messageBodyPart = new MimeBodyPart();
			         String filename = sDefaultPath+"\\report\\"+sReportName+".html";
			         DataSource source = new FileDataSource(filename);
			         
			         messageBodyPart.setDataHandler(new DataHandler(source));
			         messageBodyPart.setFileName(filename);
			         multipart.addBodyPart(messageBodyPart);

			         // Send the complete message parts
			         message.setContent(multipart);

			         // Send message
			         Transport.send(message);

			         System.out.println("Sent message successfully to: "+sto);
			  
			      } catch (MessagingException e) {
			         throw new RuntimeException(e);
			      }
			   }
		   */
	 /********************************************************************************************************************************************
	  * Extent Reporting
	 * @param xmlpath 
	 * @throws Exception 
	  */
	  public void ExtentLogPassFail(WebDriver driver, String sObject, String sMessagePass, String sMessageFail, ExtentTest logger, Boolean Screenshot, String sDefaultPath, String xmlpath) throws Exception
	  {
		  
		  if (checkIfObjectIsDisplayed(driver,sObject, sDefaultPath+xmlpath))
		  {
			  
			  ExtentLogPass(driver, sMessagePass, logger, Screenshot, sDefaultPath); 
			  
		  }
		  else
		  {
			  ExtentLogFail(driver, sMessageFail, logger, Screenshot, sDefaultPath); 
		  }
		 
	  }
	  
	  
	  public void ExtentLogPass(WebDriver driver, String sMessagePass, ExtentTest logger, Boolean Screenshot, String sDefaultPath) throws Exception
	  {
		  
		
		  if (Screenshot)
		  {
			  String fileName=takeScreenShot(driver,"ExtentLogPass", sDefaultPath);
			  logger.pass(sMessagePass, MediaEntityBuilder.createScreenCaptureFromPath(fileName).build());
			 // logger.addScreenCaptureFromPath(fileName);
		  }
		  else
		  {
			  logger.pass(sMessagePass);
		  }
	  }
	  
	  public void ExtentLogFail(WebDriver driver, String sMessageFail, ExtentTest logger, Boolean Screenshot, String sDefaultPath) throws Exception
	  {
		  
		
		  if (Screenshot)
		  {
			  String fileName=takeScreenShot(driver,"ExtentLogFail", sDefaultPath);
			  logger.fail(sMessageFail, MediaEntityBuilder.createScreenCaptureFromPath(fileName).build());
			 // logger.addScreenCaptureFromPath(fileName);
		  }
		  else
		  {
			  logger.fail(sMessageFail);
		  }
	  }
	  
	  public void ExtentLogInfo(WebDriver driver, String sMessageInfo, ExtentTest logger, Boolean Screenshot, String sDefaultPath) throws Exception
	  {
		  
		
		  if (Screenshot)
		  {
			  String fileName=takeScreenShot(driver,"ExtentLogFail", sDefaultPath);
			  logger.info(sMessageInfo, MediaEntityBuilder.createScreenCaptureFromPath(fileName).build());
			 // logger.addScreenCaptureFromPath(fileName);
		  }
		  else
		  {
			  logger.info(sMessageInfo);
			  
		  }
	  }
	  
	  
	  
	  public String takeScreenShot(WebDriver driver,String FileName,String sDefaultPath) throws Exception {
			 String fileName="Empty";
			 
		       	  try
		       	 {
		           
		           File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			      String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			      fileName =sDefaultPath+"\\screenshots\\"+FileName+timeStamp+".png";
			      
			      // try {
			           FileUtils.copyFile(scrFile, new File(fileName));
			       } catch (Exception e1) {
			           e1.printStackTrace();
			       }
			       
			       return fileName;
			  }
			  
	 /********************************************************************************************************************************************
	  	Selenium Area*/
	    
	  
	  
	  

		/*****************************************************************************
		Function Name: 	ClickObject
		Description:	click an object in an application using either xpath, ID, Name, linktext and CssSelector and maximum wait time
		Date Created:	13/09/2017
		 * @throws ParserConfigurationException 
		 * @throws IOException 
		 * @throws SAXException 
		******************************************************************************/	
	    public void ClickObject(WebDriver driver, String property, String path) throws SAXException, IOException, ParserConfigurationException
		{
	    	//get object properties from the xml file repository
			String[] element = xmlParser(path, property);
			switch (element[0].toUpperCase())
			  {
				  case "XPATH":
					  driver.findElement(By.xpath(element[1])).click();	
					  break;
				  
				  case "ID":
					  driver.findElement(By.id(element[1])).click();
					  break;
					  
				  case "NAME":
					  driver.findElement(By.name(element[1])).click();	
					  break;
						
				  case "LINKTEXT":
					  driver.findElement(By.linkText(element[1])).click();
					  break;
					  
				  case "CSSSELECTOR":
					  driver.findElement(By.cssSelector(element[1])).click();
					  break;
				
			  }
			
			
		}

	 
		
		/*****************************************************************************
		Function Name: 	ClickObjectUsingAction
		Description:	click on the application using action builder using either xpath, ID, Name, linktext and CssSelector and maximum wait time
		Date Created:	13/09/2017
		 * @throws ParserConfigurationException 
		 * @throws IOException 
		 * @throws SAXException 
		******************************************************************************/	
		public void ClickObjectUsingAction(WebDriver driver, String property, String path) throws SAXException, IOException, ParserConfigurationException
		{
				Actions action = new Actions(driver);
				//get object properties from the xml file repository
				String[] element = xmlParser(path, property);
				switch (element[0].toUpperCase())
				  {
					  case "XPATH":
						  action.moveToElement(driver.findElement(By.name(element[1]))).click().build().perform();	
						  break;
					  
					  case "ID":
						  action.moveToElement(driver.findElement(By.name(element[1]))).click().build().perform();
						  break;
						  
					  case "NAME":
						  action.moveToElement(driver.findElement(By.name(element[1]))).click().build().perform();	
						  break;
							
					  case "LINKTEXT":
						  action.moveToElement(driver.findElement(By.name(element[1]))).click().build().perform();
						  break;
						  
					  case "CSSSELECTOR":
						  action.moveToElement(driver.findElement(By.name(element[1]))).click().build().perform();	
						  break;
					
				  }
											
		}
		
	    
		
		/*****************************************************************************
		Function Name: 	DoubleClickObjectUsingActionBuilder
		Description:	double click on the application using action builder using either xpath, ID, Name, linktext and CssSelector and maximum wait time
		Date Created:	13/09/2017
		 * @throws ParserConfigurationException 
		 * @throws IOException 
		 * @throws SAXException 
		******************************************************************************/	
		public void DoubleClickObjectUsingActionBuilder(WebDriver driver, String property, String path) throws SAXException, IOException, ParserConfigurationException
		{

				Actions action = new Actions(driver);
				//get object properties from the xml file repository
				String[] element = xmlParser(path, property);
				switch (element[0].toUpperCase())
				  {
					  case "XPATH":
						  action.moveToElement(driver.findElement(By.name(element[1]))).doubleClick().build().perform();
						  break;
					  
					  case "ID":
						  action.moveToElement(driver.findElement(By.name(element[1]))).doubleClick().build().perform();
						  break;
						  
					  case "NAME":
						  action.moveToElement(driver.findElement(By.name(element[1]))).doubleClick().build().perform();
						  break;
							
					  case "LINKTEXT":
						  action.moveToElement(driver.findElement(By.name(element[1]))).doubleClick().build().perform();
						  break;
						  
					  case "CSSSELECTOR":
						  action.moveToElement(driver.findElement(By.name(element[1]))).doubleClick().build().perform();
						  break;
					
				  }
								
		}
		


		/*****************************************************************************
		Function Name: 	EnterText
		Description:	Enter text to the application using either xpath, ID, Name, linktext and CssSelector and maximum wait time
		Date Created:	13/09/2017
		******************************************************************************/	
		public void EnterText(WebDriver driver, String property, String sText,String path) throws SAXException, IOException, ParserConfigurationException
		{
			//get object properties from the xml file repository
			String[] element = xmlParser(path, property);
			switch (element[0].toUpperCase())
			  {
				  case "XPATH":
					  driver.findElement(By.xpath(element[1])).sendKeys(sText);
					  break;
				  
				  case "ID":
					  driver.findElement(By.id(element[1])).sendKeys(sText);	
					  break;
					  
				  case "NAME":
					  driver.findElement(By.name(element[1])).sendKeys(sText);
					  break;
						
				  case "LINKTEXT":
					  driver.findElement(By.linkText(element[1])).sendKeys(sText);	
					  break;
					  
				  case "CSSSELECTOR":
					  driver.findElement(By.cssSelector(element[1])).sendKeys(sText);	
					  break;
				
			  }
						
							
		}
		

		/*****************************************************************************
		Function Name: 	SelectTextByUsingValue
		Description:	Select text using value from the dropdown using either xpath, ID, Name, linktext and CssSelector and maximum wait time
		Date Created:	13/09/2017
		******************************************************************************/	
		public void SelectTextUsingValue(WebDriver driver, String property, String sText, String path) throws SAXException, IOException, ParserConfigurationException
		{
			//get object properties from the xml file repository
			String[] element = xmlParser(path, property);
			Select oSelect = null;
			switch (element[0].toUpperCase())
			  {
				  case "XPATH":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
				  
				  case "ID":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
					  
				  case "NAME":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
						
				  case "LINKTEXT":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
					  
				  case "CSSSELECTOR":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
				
			  }	
			 
			oSelect.selectByValue(sText);			
							
		}
		
	
		
		/*****************************************************************************
		Function Name: 	SelectTextByUsingIndex
		Description:	Select text using an index from the dropdown using either xpath, ID, Name, linktext and CssSelector and maximum wait time
		Date Created:	13/09/2017
		******************************************************************************/	
		public void SelectTextUsingIndex(WebDriver driver, String property, int iIndex,String path) throws SAXException, IOException, ParserConfigurationException
		{
			//get object properties from the xml file repository
			String[] element = xmlParser(path, property);
			Select oSelect = null;
			switch (element[0].toUpperCase())
			  {
				  case "XPATH":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
				  
				  case "ID":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
					  
				  case "NAME":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
						
				  case "LINKTEXT":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
					  
				  case "CSSSELECTOR":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
				
			  }	
			 
			oSelect.selectByIndex(iIndex);			
							
		}
		
	
		
		
		/*****************************************************************************
		Function Name: 	SelectTextByUsingVisibeText
		Description:	Select text using a visible text from the dropdown using either xpath, ID, Name, linktext and CssSelector and maximum wait time
		Date Created:	13/09/2017
		******************************************************************************/		
		public void SelectTextUsingVisibeText(WebDriver driver, String property, String sText, String path) throws SAXException, IOException, ParserConfigurationException
		{
			//get object properties from the xml file repository
			String[] element = xmlParser(path, property);
			Select oSelect = null;
			switch (element[0].toUpperCase())
			  {
				  case "XPATH":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
				  
				  case "ID":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
					  
				  case "NAME":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
						
				  case "LINKTEXT":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
					  
				  case "CSSSELECTOR":
					   oSelect = new Select(driver.findElement(By.name(element[1])));
					   break;
				
			  }	
			
			 
			oSelect.selectByVisibleText(sText);			
							
		}
	
	
		
		/*****************************************************************************
		Function Name: 	waitforProperty
		Description:	wait for the property to appear using either xpath, ID, Name, linktext and CssSelector and maximum wait time
		Date Created:	13/09/2017
		******************************************************************************/		
		public void waitforProperty(WebDriver driver, String property, int sWait, String path) throws SAXException, IOException, ParserConfigurationException
		{
			WebDriverWait wait = new WebDriverWait(driver,sWait);
			//get object properties from the xml file repository
			String[] element = xmlParser(path, property);
			switch (element[0].toUpperCase())
			  {
				  case "XPATH":
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element[1])));
					  break;
				  
				  case "ID":
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element[1])));
					  break;
					  
				  case "NAME":
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element[1])));
					  break;
						
				  case "LINKTEXT":
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element[1])));
					  break;
					  
				  case "CSSSELECTOR":
					  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element[1])));
					  break;
				
			  }	
							
		}
	
		
		/*****************************************************************************
		Function Name: 	GetText
		Description:	get text from the application using either xpath, ID, Name, linktext and CssSelector
		Date Created:	13/09/2017
		******************************************************************************/		
		public String GetText(WebDriver driver, String property, String path) throws SAXException, IOException, ParserConfigurationException
		{
			String strTextToReturn = null;
			//get object properties from the xml file repository
			String[] element = xmlParser(path, property);
			switch (element[0].toUpperCase())
			  {
				  case "XPATH":
					  strTextToReturn = driver.findElement(By.name(element[1])).getText();
					  break;
				  
				  case "ID":
					  strTextToReturn = driver.findElement(By.name(element[1])).getText();
					  break;
					  
				  case "NAME":
					  strTextToReturn = driver.findElement(By.name(element[1])).getText();
					  break;
						
				  case "LINKTEXT":
					  strTextToReturn = driver.findElement(By.name(element[1])).getText();
					  break;
					  
				  case "CSSSELECTOR":
					  strTextToReturn = driver.findElement(By.cssSelector(element[1])).getText();
					  break;
				
			  }	
			return strTextToReturn;
							
		}
		
	
		
		
		/*****************************************************************************
		Function Name: 	GetAttributeValue
		Description:	get an attribute value from the application using either xpath, ID, Name, linktext and CssSelector
		Date Created:	13/09/2017
		******************************************************************************/
		public String GetAttributeValue(WebDriver driver, String property, String attribute, String path) throws SAXException, IOException, ParserConfigurationException
		{
			String strTextToReturn = null;
			//get object properties from the xml file repository
			String[] element = xmlParser(path, property);
			switch (element[0].toUpperCase())
			  {
				  case "XPATH":
					  strTextToReturn = driver.findElement(By.name(element[1])).getAttribute(attribute);
					  break;
				  
				  case "ID":
					  strTextToReturn = driver.findElement(By.name(element[1])).getAttribute(attribute);
					  break;
					  
				  case "NAME":
					  strTextToReturn = driver.findElement(By.name(element[1])).getAttribute(attribute);
					  break;
						
				  case "LINKTEXT":
					  strTextToReturn = driver.findElement(By.name(element[1])).getAttribute(attribute);
					  break;
					  
				  case "CSSSELECTOR":
					  strTextToReturn = driver.findElement(By.cssSelector(element[1])).getAttribute(attribute);
					  break;
				
			  }
			return strTextToReturn;
							
		}
		
	
		
		/*****************************************************************************
		Function Name: 	ClearObject
		Description:	Clear object on the application using either xpath, ID, Name, linktext and CssSelector
		Date Created:	13/09/2017
		******************************************************************************/
		public void ClearObject(WebDriver driver, String property, String path) throws SAXException, IOException, ParserConfigurationException
		{
			//get object properties from the xml file repository
			String[] element = xmlParser(path, property);
			switch (element[0].toUpperCase())
			  {
				  case "XPATH":
					  driver.findElement(By.name(element[1])).clear();
					  break;
				  
				  case "ID":
					  driver.findElement(By.name(element[1])).clear();
					  break;
					  
				  case "NAME":
					  driver.findElement(By.name(element[1])).clear();
					  break;
						
				  case "LINKTEXT":
					  driver.findElement(By.name(element[1])).clear();
					  break;
					  
				  case "CSSSELECTOR":
					  driver.findElement(By.cssSelector(element[1])).clear();
					  break;
				
			  }
			
			
		}
		


		/*****************************************************************************
		Function Name: 	checkIfObjectExists
		Description:	Checks if an object exists using either an xpath, ID or a Name
		Date Created:	13/09/2017
		******************************************************************************/
		
		public boolean checkIfObjectExists(WebDriver driver, String property, String path)
		{
			boolean exists = false;
			try
			{
				//get object properties from the xml file repository
				String[] element = xmlParser(path, property);
				switch (element[0].toUpperCase())
				  {
					  case "XPATH":
						  if((driver.findElement(By.xpath(element[1]))!= null)||(driver.findElements(By.xpath(element[1])).isEmpty())){
								exists=true;
								}else{
								exists=false;
								}
						  break;
					  
					  case "ID":
						  if((driver.findElement(By.id(element[1]))!= null)||(driver.findElements(By.id(element[1])).isEmpty())){
								exists=true;
								}else{
								exists=false;
								}
						  break;
					      
					  case "NAME":
						  if((driver.findElement(By.name(element[1]))!= null)||(driver.findElements(By.name(element[1])).isEmpty())){
								exists=true;
								}else{
								exists=false;
								}
						  break;
					  case "LINKTEXT":
						  if((driver.findElement(By.linkText(element[1]))!= null)||(driver.findElements(By.linkText(element[1])).isEmpty())){
								exists=true;
								}else{
								exists=false;
								}
						  break;
				  }
			 
			}
			catch(Exception e)
				{
					System.out.println(e.getMessage());
					exists=false;
				}
			return exists;

							
		}
		
		
		
		/*****************************************************************************
		Function Name: 	checkIfObjectIsClicked
		Description:	Checks if an object exists using either an xpath, ID or a Name
		Date Created:	27/03/2019
		Author: Mash 
		******************************************************************************/
		
		public boolean checkIfObjectIsClicked(WebDriver driver, String property, String path)
		{
			boolean exists = false;
			try
			{
				//get object properties from the xml file repository
				String[] element = xmlParser(path, property);
				switch (element[0].toUpperCase())
				  {
					  case "XPATH":
						  if((driver.findElement(By.xpath(element[1]))).isSelected() == true){
								exists=true;
								}else{
								exists=false;
								}
						  break;
					  
					  case "ID":
						  if((driver.findElement(By.xpath(element[1]))).isSelected() == true){
								exists=true;
								}else{
								exists=false;
								}
						  break;
					      
					  case "NAME":
						  if((driver.findElement(By.xpath(element[1]))).isSelected() == true){
								exists=true;
								}else{
								exists=false;
								}
						  break;
					  case "LINKTEXT":
						  if((driver.findElement(By.xpath(element[1]))).isSelected() == true) {
								exists=true;
								}else{
								exists=false;
								}
						  break;
				  }
			 
			}
			catch(Exception e)
				{
					System.out.println(e.getMessage());
					exists=false;
				}
			return exists;

							
		}

		/*****************************************************************************
		Function Name: 	checkIfObjectIsDisplayed
		Description:	Checks if an object is displayed using either an xpath, ID or a Name
		Date Created:	13/09/2017
		******************************************************************************/
		public boolean checkIfObjectIsDisplayed(WebDriver driver, String property, String path)
		{
			boolean exists = false;
			try
			{
				//get object properties from the xml file repository
				String[] element = xmlParser(path, property);
				switch (element[0].toUpperCase())
				  {
					  case "XPATH":
						  if(driver.findElement(By.xpath(element[1])).isDisplayed() == true){
								exists=true;
								}else{
								exists=false;
								}
						  break;
					  
					  case "ID":
						  if(driver.findElement(By.id(element[1])).isDisplayed() == true){
								exists=true;
								}else{
								exists=false;
								}
						  break;
					      
					  case "NAME":
						  if(driver.findElement(By.name(element[1])).isDisplayed() == true){
								exists=true;
								}else{
								exists=false;
								}
						  break;
					  case "LINKTEXT":
						  if(driver.findElement(By.linkText(element[1])).isDisplayed() == true){
								exists=true;
								}else{
								exists=false;
								}
						  break;
				  }
			}
			catch(Exception e)
				{
					System.out.println(e.getMessage());
					exists=false;
				}
			return exists;
							
		}
		
	
		
		
		
		/*****************************************************************************
		Function Name: 	checkIfObjectEnabled
		Description:	Checks if an object is enabled using either an xpath, ID or a Name
		Date Created:	13/09/2017
		 * @param sDefaultPath 
		******************************************************************************/
		public boolean checkIfObjectEnabled(WebDriver driver, String property, String path)
		{
			
			boolean exists = false;
			try
			{
				String[] element = xmlParser(path, property);
				switch (element[0].toUpperCase())
				  {
					  case "XPATH":
						  if(driver.findElement(By.xpath(element[1])).isEnabled() == true){
								exists=true;
								}else{
								exists=false;
								}
						  break;
					  
					  case "ID":
						  if(driver.findElement(By.id(element[1])).isEnabled() == true){
								exists=true;
								}else{
								exists=false;
								}
						  break;
					      
					  case "NAME":
						  if(driver.findElement(By.name(element[1])).isEnabled() == true){
								exists=true;
								}else{
								exists=false;
								}
						  break;
				  }
						
			}
			
			catch(Exception e)
				{
					System.out.println(e.getMessage());
					exists=false;
				}
			return exists;

							
		}
		
		
				
			//xmlParser(String xmlPath, String tagName, String fieldName);
		
		/************************************************************end Selenium***************************************************************************************/
		
		/*****************************************************robot******************************************************************************************************/
		
		//Press Shift and Tab
		public void PressEnter(int iteration) throws InterruptedException, AWTException
		{
			int i=1;
			while(i<=iteration)
			{
				Thread.sleep(1000);
				Robot robot = new Robot();		
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				i++;
			}
		}
		
		//Press Down Key on a page
		public void PressDownKey() throws InterruptedException, AWTException
		{
			Thread.sleep(5000);
			Robot robot = new Robot();		
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		}
		
		//Press Down Key on a page
		public void PressUpKey() throws InterruptedException, AWTException
		{
			Thread.sleep(5000);
			Robot robot = new Robot();		
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
		}
		
		
		//Press Down Key on a page
		public void RefreshPage() throws InterruptedException, AWTException
		{
			Thread.sleep(5000);
			Robot robot = new Robot();		
			robot.keyPress(KeyEvent.VK_F5);
			robot.keyRelease(KeyEvent.VK_F5);
		}
		
		//Press Shift and Tab
		public void PressShiftTab(int iteration) throws InterruptedException, AWTException
		{
			int i=1;
			while(i<=iteration)
			{
				Thread.sleep(1000);
				Robot robot = new Robot();		
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_TAB);
				i++;
			}
		}
		
		//Press Shift and Tab
		public void PressLeftArrow(int iteration) throws InterruptedException, AWTException
		{
			int i=1;
			while(i<=iteration)
			{
				Thread.sleep(1000);
				Robot robot = new Robot();		
				robot.keyPress(KeyEvent.VK_LEFT);
				robot.keyRelease(KeyEvent.VK_LEFT);
				i++;
			}
		}
		
		 public void pressTAB()throws AWTException, InterruptedException
		 {
				
			 	Robot r = new Robot();
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(1000);
		 }
		   
		 public void pressF2()throws AWTException, InterruptedException
		 {
				
			 	Robot r = new Robot();
				r.keyPress(KeyEvent.VK_F2);
				r.keyRelease(KeyEvent.VK_F2);
				Thread.sleep(1000);
		 }
		 
		 public void pressA()throws AWTException, InterruptedException
		 {
				
			 	Robot r = new Robot();
				r.keyPress(KeyEvent.VK_A);
				r.keyRelease(KeyEvent.VK_A);
				Thread.sleep(1000);
		 }
			
		  public void pressTAB(int iterations)throws AWTException, InterruptedException
		    {
		
		     int i=1;
		     while(i<=iterations)
		     {
		      Robot r = new Robot();
		     r.keyPress(KeyEvent.VK_TAB);
		     r.keyRelease(KeyEvent.VK_TAB);
		     Thread.sleep(1000);
		     i++;
		     }
		    }
		  
		  //Press Down Key on a page
		    public void pressCtrlShiftA() throws InterruptedException, AWTException
		    {
		      Thread.sleep(5000);
		      Robot robot = new Robot();  
		      robot.keyPress(KeyEvent.VK_CONTROL);
		      robot.keyPress(KeyEvent.VK_SHIFT);
		      robot.keyPress(KeyEvent.VK_A);
		      robot.keyRelease(KeyEvent.VK_CONTROL);
		      robot.keyRelease(KeyEvent.VK_SHIFT);
		      robot.keyRelease(KeyEvent.VK_A);
		     
		    }
		    
		    /*****************************************************************end robot*************************************************************************************/
		    
		    public String[] xmlParser(String xmlPath, String tagName) throws SAXException, IOException, ParserConfigurationException {
				// File fXmlFile = new File();
				//InputStream requestContent = new InputStr();
				//String sLine = outputData;
		        //requestContent.append(sLine);
				//String element = null;
				String[] element2 = new String[2];
				File fXmlFile = new File(xmlPath);
				DocumentBuilderFactory dbFactory =
				DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder =
				dbFactory.newDocumentBuilder();
				
				Document doc = dBuilder.parse(fXmlFile);
				
				/*InputSource is = new InputSource(new
				StringReader(outputData));
				org.w3c.dom.Document doc = dBuilder.parse(is);*/

				
				doc.getDocumentElement().normalize();

			//	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

				NodeList nList = doc.getElementsByTagName(tagName);


				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);

					//System.out.println("\nCurrent Element :" + nNode.getNodeName());

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;

						String element = eElement.getElementsByTagName("identifier").item(0).getTextContent();
						String element1 = eElement.getElementsByTagName("Element").item(0).getTextContent();
						element2[0] = element;
						element2[1] = element1;

				
					} // end if
				} // end for loop
				
				return element2;
			} // end function
		    
		    public void VerifyElement(WebDriver driver, String property, String path) throws Exception
		    {
		    	String[] element = xmlParser(path, property);
		    	
		    	WebDriverWait wait = new WebDriverWait(driver,60);
      	     // WebElement WebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element[1])));
		    	
				switch (element[0].toUpperCase())
				  {
					  case "XPATH":
						  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element[1])));	
						  break;
					  
					  case "ID":						 
	            	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element[1])));
						  break;
						  
					  case "NAME":
						  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element[1])));	
						  break;
							
					  case "LINKTEXT":						  
						  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element[1])));
						  break;
						  
					  case "CSSSELECTOR":
						  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element[1])));
						  break;
					
				  }
		    }
		    
		    public void VerifyElementNotDisplayed(WebDriver driver, String property, String path) throws Exception
		    {
		    	String[] element = xmlParser(path, property);
		    	
		    	WebDriverWait wait = new WebDriverWait(driver,60);
      	     // WebElement WebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element[1])));
		    	
				switch (element[0].toUpperCase())
				  {
					  case "XPATH":
						  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element[1])));	
						  break;
					  
					  case "ID":						 
	            	      wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(element[1])));
						  break;
						  
					  case "NAME":
						  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(element[1])));	
						  break;
							
					  case "LINKTEXT":						  
						  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(element[1])));
						  break;
						  
					  case "CSSSELECTOR":
						  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(element[1])));
						  break;
					
				  }
		    }
		    
		    public void switch_window(WebDriver driver) {
		    	//store the current window handle
		    	//static WebDriver driver ;
				 @SuppressWarnings("unused")
				 String windowHandleBefore = driver.getWindowHandle();
				 //Perform the click operation that opens the new window
				 //Switch to new window opened
				 for(String winHandle : driver.getWindowHandles())
				 {
				  driver.switchTo().window(winHandle);
				 }
		    }
		    
		  
}
