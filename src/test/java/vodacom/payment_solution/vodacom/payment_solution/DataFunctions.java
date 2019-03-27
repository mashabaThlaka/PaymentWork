package vodacom.payment_solution.vodacom.payment_solution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

/*import gui.Functions.JSONObject;
import gui.Functions.JSONParser;
import gui.Functions.ParseException;*/

public class DataFunctions {
	

    private Boolean sAppendReport;
  
    private Long waitTimeOut;
    private String browserDrivers;
    private String browserType;
    private String reportLocation;
    private String imageLocation;

	
	
	
	private String sWebURL;
	private String sVPPWebURL;
	private String sVettingUri;
	public String getsVettingUri() {
		return sVettingUri;
	}


	public void setsVettingUri(String sVettingUri) {
		this.sVettingUri = sVettingUri;
	}

	private String sWebPassword;
	private String sWebUsername;
	private String sVPPWebUsername;
	private String sVPPWebPassword;
	private String sSCWebURL;
	private String sSCWebUsername;
	private String sSCWebPassword;
	
	private String sSadminWebUsername;
	private String sSadminPassword;
	
	
	
	
	private String sVppChannelwebusername;
	private String sVppwebchannelpassword;
	private String sAppLoc;
	private String sAppUsername;
	private String sAppPassword;
	private String sApi;
	private String sOutput;
	private String sDataLocation;
	private String sDataType;
	private String sDBPassword;
	private String sDBUsername;
	private String sEmail;
	private String sEmailFrom;
	private String sEmailTo;
	private String sDBHost;
	private String sBrowser;
	private String sReporthead;
	public String sMultiple;
	public String sReportName;
	public Connection connect;
	private String sFTTHWebURL;
	public java.sql.Connection conn = null;
	public Sheet sheet;
	public Workbook workbook;
	int col,Column_Count,Row_Count;
	int colnNum=0;
	int fillonum = 1;
	
	
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;
	public static XSSFRow Row;
	
	 public static int totalRows;
	 
	 public static int iRows;
	 
	 public String getFTTHWebURL()
		{
			return sFTTHWebURL;
		}

	
	 public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public String getWebURL()
		{
			return sWebURL;
		}
	 public String getVPPWebURL()
		{
			return sVPPWebURL;
		}
	 
	 
	 public String getSadminWebUsername()
		{
			return sSadminWebUsername;
		}
	 public String getSadminPassword()
		{
			return sSadminPassword;
		}

	 public String getReportName()
		{
			return sReportName;
		}
		public String getWebPassword()
		{
			return sWebPassword;
		} 
		
		public String getWebUserName()
		{
			return sWebUsername;
		}
		
		public String getVPPWebUserName()
		{
			return sVPPWebUsername;
		}
		
		public String getVPPWebPassword()
		{
			return sVPPWebPassword;
		}
		
		 public String getSCWebURL()
			{
				return sSCWebURL;
			}
		 
		 public String getSCWebUserName()
			{
				return sSCWebUsername;
			}
		 
			public String getSCWebPassword()
			{
				return sSCWebPassword;
			}
		 
		
		public String getMutlipleExecution()
		{
			return sMultiple;
		}
		public String getWindowsAppLocation()
		{
			return sAppLoc;
		}
		
		public String getWindowsAppUsername()
		{
			return sAppUsername;
		}
		public String getWindowsAppPassword()
		{
			return sAppPassword;
		}
		
		public String getAPI()
		{
			return sApi;
		}
		public String getDataLocation()
		{
			return sDataLocation;
		}
		public String getDBHost()
		{
			return sDBHost;
		}
		public String getDBUsername()
		{
			return sDBUsername;
		}
		public String getDBPassword()
		{
			return sDBPassword;
		}
		
		public String getDataType()
		{
			return sDataType;
		}
		
		public String getSendEmail()
		{
			return sEmail;
		}
		public String getEmailFrom()
		{
			return sEmailFrom;
		}
		public String getEmailTo()
		{
			return sEmailTo;
		}
		public String getBrowser()
		{
			return sBrowser;
		}
		public String getReporthead()
		{
			return sReporthead;
		}
		//user this when using Channel Store partner tests on VPP
		public String getVPPChannelWebusername()
		{
			return sVppChannelwebusername;
		}
		
		public String getVppWebChannelpassword()
		{
			return sVppwebchannelpassword;
		}
		
		/*****************************************************************************
		Function Name: 	getTestData eComms
		Description:	Read data from the spreadsheet
		Date Created:	18/04/2018
		 * @param sDefaultPath 
		******************************************************************************/
		static Workbook book;
		static Sheet sheett;
		
		public static Object [][] getTestData(String SheetName, String TESTDATA_SHEET_PATH){
			
			FileInputStream file = null;
			
			try {
				file = new FileInputStream(TESTDATA_SHEET_PATH);
				
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);		
			}	
			catch (InvalidFormatException e)
			{
				e.printStackTrace();
			}
			
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			sheett = book.getSheet(SheetName);
			Object[][] data = new Object[sheett.getLastRowNum()][sheett.getRow(0).getLastCellNum()];
			for (int i=0; i<sheett.getLastRowNum(); i++) {
				for (int k = 0; k <sheett.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheett.getRow(i+1).getCell(k).toString();
				}
			}
			return data;
			
		}

		
		/*****************************************************************************
		Function Name: 	getTableArray
		Description:	populates data provider array
		Author :Sibusiso Dlamini
		Date Created:	15/11/2017
		 * @param sDefaultPath 
		******************************************************************************/
		public static Object[][] getTableArray(String FilePath, String SheetName,int x) throws Exception 
		{   

			 String[][] tabArray = null;

			try {

			      FileInputStream ExcelFile = new FileInputStream(FilePath);

				   // Access the required test data sheet

				   ExcelWBook = new XSSFWorkbook(ExcelFile);

				   ExcelWSheet = ExcelWBook.getSheet(SheetName);

				   int ci,cj;

				   totalRows = ExcelWSheet.getLastRowNum();
				   	System.out.println(totalRows);
				   // you can write a function as well to get Column count24

				   int totalCols =  ExcelWSheet.getRow(0).getPhysicalNumberOfCells()-x;

				   tabArray=new String[totalRows][totalCols];

				   ci=0;

				   for (iRows=1;iRows<= totalRows;iRows++, ci++) {           	   

					  cj=0;

					   for (int j=0;j< totalCols;j++, cj++){

						   tabArray[ci][cj]=getCellData(iRows,j);

						   System.out.println(tabArray[ci][cj]);  

							}

						}

					}

				catch (FileNotFoundException e){

					System.out.println("Could not read the Excel sheet");

					e.printStackTrace();

					}

				catch (IOException e){

					System.out.println("Could not read the Excel sheet");

					e.printStackTrace();

					}

				return(tabArray);

				}


			public static String getCellData(int RowNum, int ColNum) throws Exception {

				try{

					Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

					int dataType = Cell.getCellType();
					//System.out.println(ExcelWSheet.getRow(0).getPhysicalNumberOfCells()-1);

					if  (dataType ==  ExcelWSheet.getRow(0).getPhysicalNumberOfCells()-1) {

						return "";

					}else{

						String CellData = Cell.getStringCellValue();

						return CellData;
					}
				}
					
					catch (Exception e){

					System.out.println(e.getMessage());

					throw (e);

					}

				}
			

		
		/*****************************************************************************
		Function Name: 	GetEnvironmentVariables
		Description:	gets environment variables from the config json file
		Date Created:	13/09/2017
		 * @param sDefaultPath 
		******************************************************************************//*
		  public void GetEnvironmentVariables(String sDefaultPath) throws IOException, ParseException 
			{
				File f1=null;
		        FileReader fr=null;      
		        
		        JSONParser parser = new JSONParser();
		        try {
		        	f1 = new File(sDefaultPath+"\\conf\\Environment.json");
		            fr = new FileReader(f1);
		        	Object obj = parser.parse(fr);
		        	JSONObject jsonObject = (JSONObject) obj;
		        	//System.out.print(jsonObject);
		        	//String[] env=new String[10];
		        	
		        	sWebURL = (String) jsonObject.get("weburl");
		        	sWebUsername = (String) jsonObject.get("webusername");
		        	sWebPassword = (String) jsonObject.get("webpassword");
		        	sVPPWebURL = (String) jsonObject.get("vppweburl");
		        	sVettingUri = (String) jsonObject.get("vettinguri");
		        	
		        	sVPPWebUsername = (String) jsonObject.get("vppwebusername");
		        	sVPPWebPassword = (String) jsonObject.get("vppwebpassword");
		        	sSCWebURL = (String) jsonObject.get("scweburl");
		        	sSCWebUsername = (String) jsonObject.get("scwebusername");
		        	sSCWebPassword = (String) jsonObject.get("scwebpassword");
		        	sFTTHWebURL = (String) jsonObject.get("ftthweburl");
		        	sAppLoc = (String) jsonObject.get("windowsapplocation");
		        	sAppUsername = (String) jsonObject.get("windowsappusername");
		        	sAppPassword = (String) jsonObject.get("windowsapppassword");
		        	sApi = (String) jsonObject.get("API");
		        	sDataLocation = (String) jsonObject.get("datalocation");
		        	sDataType = (String) jsonObject.get("datatype");
		        	sDBHost = (String) jsonObject.get("dbhost");
		        	sDBPassword = (String) jsonObject.get("dbpass");
		        	sDBUsername = (String) jsonObject.get("dbusername");
		        	sEmail = (String) jsonObject.get("sendemail");
		        	sEmailFrom = (String) jsonObject.get("emailfrom");
		        	sEmailTo = (String) jsonObject.get("emailto");
		        	sBrowser = (String) jsonObject.get("Browser");
		        	sMultiple = (String) jsonObject.get("MultipleExecution");
		        	sReportName = (String) jsonObject.get("ReportName");
		        	sReportName = (String) jsonObject.get("ReportName");
		        	sVppChannelwebusername = (String) jsonObject.get("vppchannelwebusername");
		        	sVppwebchannelpassword = (String) jsonObject.get("vppwebchannelpassword");
		        	sSadminWebUsername = (String) jsonObject.get("sadminwebusername");
		        	sSadminPassword = (String) jsonObject.get("sadminwebpassword");
		        	
		        	
		        	
		     
		        } finally {
		            try{
		               fr.close();       
		           
		            }catch(IOException ioe)

		            {
		                ioe.printStackTrace();
		            }
		        }

		    }
*/		  
		  /*****************************************************************************
			Function Name: 	WriteToTextFile
			Description:	Write a value to a text file
			Date Created:	13/09/2017
			******************************************************************************/
		  	public void setDataOtput(String sOutput)
		    {
		        this.sOutput = sOutput;
		    }

			 public void WriteTextFile(String filePath)throws IOException{
	
				    Writer output = null;
				    File file = new File(filePath);
				    output = new BufferedWriter(new FileWriter(file));

			    	String outputData=sOutput;
					output.write(outputData);
				    output.write("\r\n");
				    output.close();



				} 
			 
			 public Sheet ReadExcel(String FILE_NAME,String sheetname) throws IOException
			 {
				 FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
		            workbook = new XSSFWorkbook(excelFile);
		            sheet = workbook.getSheet(sheetname);
		            return sheet;
			 }			
			 
			 public Recordset ConnectFillo(String path, String Query) throws FilloException 
			 {

				 	Fillo fillo=new Fillo();
					
					Recordset record;
					//List<String> data = new ArrayList<String>();		
					
						String value = null;
					
							connect=fillo.getConnection(path);	
							record=connect.executeQuery(Query);	
							
							/*while(record.next())
							{	
								String valContain=record.getField("Used_By");
								
								if (valContain.isEmpty()) 
									{
										value=record.getField(vColumnValue);
										break;
									}					
							}
							*/
											
						return record;				
					
			 }
			 
				
				public String getCellData(String strColumn, int iRow, Sheet sheet, Recordset record,ResultSet resultset, String Type ) throws Exception{
					String sValue = null;
					switch (Type.toUpperCase())
					{ 
					
						case "EXCEL":	
						
							
							Row row = sheet.getRow(0);
							for (int i =0;i<columnCount(sheet);i++)
							{
								if (row.getCell(i).getStringCellValue().trim().equals(strColumn))
								{
									Row raw = sheet.getRow(iRow);
									Cell cell = raw.getCell(i);
									 DataFormatter formatter = new DataFormatter();
									sValue = formatter.formatCellValue(cell);
									break;
								}
								
							}
							break;
						
							
						case "FILLO":
							
							if (iRow == fillonum)
							{
								if(record.next())
								{	
									fillonum = iRow+1;
									 sValue=record.getField(strColumn);
								}
							}else{sValue=record.getField(strColumn);}
							break;
							
						case "SQLSERVER":
							
							if (iRow == fillonum)
							{
								if(resultset.next())
								{	
									fillonum = iRow+1;
									 sValue=resultset.getString(strColumn);
								}
							}else{sValue=resultset.getString(strColumn);}
							break;
								
						}

					return sValue;				

					
				}
				
				
				public int rowCount(Sheet sheet, Recordset record, ResultSet resultset, String Type) throws Exception{
					int count = 0;
					switch (Type.toUpperCase())
					{
					case "EXCEL":	
						count = sheet.getPhysicalNumberOfRows();
						break;
					case "FILLO":
						
						count = record.getCount();
						break;
					case "SQLSERVER":
						int i = 0;
						while (resultset.next())
						{
							i++;
						}
						count = i;
					}
					return count;
				}
				public int columnCount(Sheet sheet) throws Exception{
					return sheet.getRow(0).getLastCellNum();
				}
				
				public void writeData(String[] sColumn,int Row,String[] sData,String filepath,  String Type, String sQuery) throws IOException, InvalidFormatException, FilloException, SQLException
				{
					switch (Type.toUpperCase())
					{
						case "EXCEL":
							int CoulmnNo = 0 ;
							FileInputStream file = new FileInputStream(filepath);
							Workbook wb = WorkbookFactory.create(file);
					        sheet = wb.getSheetAt(0);
					    
					      
					        org.apache.poi.ss.usermodel.Cell cell = null;
					        Row row = sheet.getRow(0); 
					       
					          for (int c = 0;c<sColumn.length; c++)
					          {
					        	  for( int i=0; i<row.getLastCellNum();i++)
					  	          {
					  	        	if(row.getCell(i).getStringCellValue().trim().equals(sColumn[c]))
					  	        	{
					  	        		CoulmnNo=i;
					  	        		Row raw = sheet.getRow(Row);
					  	        		cell = raw.createCell(CoulmnNo);
					  	     	      cell.setCellValue((String) sData[c]);
					  	     	      break;
					  	        	}
					  	          }
					          }
						     
						     
						      
						      FileOutputStream fileOut = new FileOutputStream(filepath);
						      wb.write(fileOut);	        
						        fileOut.close();
							
						break;
					case "FILLO":	
						System.setProperty("ROW", "1");//Table start row				 	
						connect.executeUpdate(sQuery);
						//connect.close();
						break;
					case "SQLSERVER":
						Statement st = conn.createStatement(); 
						st.execute(sQuery);	
					}
			          
				}
				
				public ResultSet ConnectAndQuerySQLServer(String sDBURL, String sUserName,String  sPassword,  String sQuery)
				{
					
					 ResultSet rs = null;
					 
			        try 
			        {
			 
			            String dbURL = sDBURL;
			            String user = sUserName;
			            String pass = sPassword;
			            conn = DriverManager.getConnection(sDBURL, user, pass);
			            Statement stmt = conn.createStatement();
			             rs = stmt.executeQuery(sQuery);
			   
			            
			        } catch (SQLException ex) {
			            ex.printStackTrace();
			       
			        }
					return rs;
				}
				
				/*****************************************************************************
				Function Name: 	ReadData eComms
				Description:	Read data from the spreadsheet
				Date Created:	18/04/2018
				 * @param sDefaultPath 
				******************************************************************************/
				public void WriteData(String strQuery, String strStart)	{
					
					 System.setProperty("ROW", strStart);
					 
					 try {
						 connect.executeUpdate(strQuery);
						 connect.close();
						
					} catch (Exception e) {
						
						e.getMessage();
						System.out.println("Update to the excel sheet not successful" +e.getMessage());
						// TODO: handle exception
					}
				}
				

				
				public String getBrowserDrivers() {
			        return browserDrivers;
			    }

				    public boolean getAppendReport() {
				        return sAppendReport;
				    }

				   

				    public String getBrowserType() {
				        return browserType;
				    }

				    public Long getWaitTimeOut() {
				        return waitTimeOut;
				    }

				    public String getReportLocation() {
				        return reportLocation;
				    }

				    public String getImageLocation() {
				        return imageLocation;
				    }

				  
				    /*****************************************************************************
				     Function Name: 	GetEnvironmentVariables
				     Description:	gets environment variables from the config json file
				     Date Created:	13/09/2017
				     ******************************************************************************//*
				    public void GetEnvironmentVariables() throws IOException, ParseException {
				        File f1 = null;
				        FileReader fr = null;

				        JSONParser parser = new JSONParser();
				        try {
				            f1 = new File("conf/Environment.json");
				            fr = new FileReader(f1);
				            Object obj = parser.parse(fr);
				            JSONObject jsonObject = (JSONObject) obj;

				            sWebURL = (String) jsonObject.get("weburl");
				            sWebUsername = (String) jsonObject.get("webusername");
				            sWebPassword = (String) jsonObject.get("webpassword");
				            sAppLoc = (String) jsonObject.get("windowsapplocation");
				            sAppUsername = (String) jsonObject.get("windowsappusername");
				            sAppPassword = (String) jsonObject.get("windowsapppassword");
				            sApi = (String) jsonObject.get("API");
				            sDataLocation = (String) jsonObject.get("datalocation");
				            sDataType = (String) jsonObject.get("datatype");
				            sDBHost = (String) jsonObject.get("dbhost");
				            sDBPassword = (String) jsonObject.get("dbpass");
				            sDBUsername = (String) jsonObject.get("dbusername");
				            sEmail = (String) jsonObject.get("sendemail");
				            sEmailFrom = (String) jsonObject.get("emailfrom");
				            sEmailTo = (String) jsonObject.get("emailto");
				            sAppendReport = (Boolean) jsonObject.get("appendreport");
				            browserDrivers = (String) jsonObject.get("browserDrivers");
				            browserType = (String) jsonObject.get("browserType");
				            waitTimeOut = (Long) jsonObject.get("waitTimeOut");
				            reportLocation = (String) jsonObject.get("reportLocation");
				            imageLocation = (String) jsonObject.get("imageLocation");

				        } finally {
				            try {
				                fr.close();

				            } catch (IOException ioe)

				            {
				                ioe.printStackTrace();
				            }
				        }

				    }
*/
				 
				
				  	   
	    public void modifyExistingWorkbook(String updateValue, String FileName, int Index) throws InvalidFormatException, IOException {
				        // Obtain a workbook from the excel file
				        Workbook workbook = WorkbookFactory.create(new File(FileName));

				        // Get Sheet at index 0
				        Sheet sheet = workbook.getSheetAt(Index);

				        // Get Row at index 1
				        Row row = sheet.getRow(1);

				        // Get the Cell at index 2 from the above row
				        Cell cell = row.getCell(5);

				        // Update the cell's value
				        // cell.setCellType(CellType.STRING);
				        cell.setCellValue(updateValue);

				        // Write the output to the file
				        FileOutputStream fileOut = new FileOutputStream(FileName);
				        workbook.write(fileOut);
				        fileOut.close();

				        // Closing the workbook
				        workbook.close();
				    }


}
