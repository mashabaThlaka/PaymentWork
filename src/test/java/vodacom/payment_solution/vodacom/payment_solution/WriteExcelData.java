package vodacom.payment_solution.vodacom.payment_solution;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelData {
	
	
	public void WriteExcel(String sheetname, String text,int rows,int cells) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\workspace\\vodacom.payment_solution\\data\\DataExcel.xlsx");
        FileOutputStream fos = null;
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetname);
        XSSFRow row = null;
        XSSFCell cell = null;
        XSSFFont font = workbook.createFont();
        XSSFCellStyle style = workbook.createCellStyle();
       
// transaction ID  
        row = sheet.getRow(rows);
        if(row == null)
            row = sheet.createRow(rows);
 
        cell = row.getCell(cells);
       
        if(cell == null)
            cell = row.createCell(cells);
 
        font.setFontName("Calibri");
        font.setFontHeight(11.0);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
 
        style.setFont(font);
        style.setFillForegroundColor(HSSFColor.GREEN.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
 
        cell.setCellStyle(style);
        cell.setCellValue(text);
 
        fos = new FileOutputStream("C:\\workspace\\vodacom.payment_solution\\data\\DataExcel.xlsx");
        workbook.write(fos);
        fos.close();
	}

}
