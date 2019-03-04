package vodacom.payment_solution.vodacom.payment_solution;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
public XSSFCell cell = null;
	
	public String ReadData(String filename,String sheetname,String colname,int rownum ) throws Exception
    {
        FileInputStream fis = new FileInputStream("C:\\workspace\\vodacom.payment_solution\\data\\"+filename+".xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetname);
        XSSFRow row = sheet.getRow(0);
 
        int col_num = -1;
 
        for(int i=0; i < row.getLastCellNum(); i++)
        {
            //if(row.getCell(i).getStringCellValue().trim().equals("Payment Type"))
                //col_num = i;
        	if(row.getCell(i).getStringCellValue().trim().equals(colname.trim()))
                col_num = i;
        }
        row = sheet.getRow(rownum - 1);
        cell = row.getCell(col_num);
       
		return cell.toString();
    }
}
