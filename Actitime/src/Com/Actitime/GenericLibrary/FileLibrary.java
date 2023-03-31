package Com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is a generic class which is having non static methods to perform data driven testing
 * @author Sarika
 *
 */
public class FileLibrary {
	/**
	 * This method is used to read data from property files
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	
	
public String readDataFromProperty(String key) throws IOException {
	FileInputStream fis= new FileInputStream("./Testdata/commondata.property");
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	
}
/**
 * This method is used to read data from property file.
 * @throws IOException 
 * @throws EncryptedDocumentException 
 * 
 */



    public String readDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis1=new FileInputStream("./TestData/TestData.xlsx");
    Workbook wb = WorkbookFactory.create(fis1);
    String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
    return value;
    
    
    }   
}

