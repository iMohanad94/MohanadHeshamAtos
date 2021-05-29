package FileReader;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExcelReader {

	public static String[][] XslxReader(){

		String[][] data = null;
		XSSFRow row;
	    XSSFCell col;
		
		try {
			FileInputStream EXfile = new FileInputStream("src\\test\\resources\\ExcelData.xlsx");
			XSSFWorkbook excelreader = new XSSFWorkbook(EXfile);

			//Three for loops first one is for sheets,second is for Row then moves Cell by cell using the third Loop
		for(int i = 0 ; i <	excelreader.getNumberOfSheets() ;i++ ) {
			
			XSSFSheet sheet = excelreader.getSheetAt(i);//Depends on the number of sheet in the excel
			int rows = sheet.getPhysicalNumberOfRows();//from sheet class to get the number of Rows
			int cols = sheet.getRow(i).getPhysicalNumberOfCells();//to get the coloumns of the Sheet number "i"
				
			data = new String[rows][cols];
				
			for(int j = 0 ; j < rows ; j++ ) {

				row = sheet.getRow(j);
				 if (row != null) {
				
				for(int y = 0 ; y < cols ; y++) {
					
					col = row.getCell(y);

					switch(col.getCellType()) {//Used to check the cell type and depending on the type its added to the array
					
					case XSSFCell.CELL_TYPE_STRING :
						data[j][y] = col.getStringCellValue();
						break;
						
					case XSSFCell.CELL_TYPE_NUMERIC :
						data[j][y] = "" + col.getNumericCellValue();
						break; 
						
					case XSSFCell.CELL_TYPE_FORMULA :
						data[j][y] = col.getCellFormula();
						break;
						
					case XSSFCell.CELL_TYPE_ERROR :
						data[j][y] = "" + col.getErrorCellValue();
						break;
						
					case XSSFCell.CELL_TYPE_BOOLEAN :
						data[j][y] = "" + col.getBooleanCellValue();
						break;	
						
					case XSSFCell.CELL_TYPE_BLANK :
						data[j][y] = "[BLANK]";
						
						break;
					
					}
					
					
					
					
					
				}//for coloumns
			   }//for condition
			}//for rows	
		}//for sheets
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO /Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		return data;
	}
	
	
}
