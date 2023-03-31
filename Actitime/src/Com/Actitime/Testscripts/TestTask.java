package Com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.Actitime.GenericLibrary.Baseclass;
import Com.Actitime.GenericLibrary.FileLibrary;
import Com.Actitime.Pom.HomePage;
import Com.Actitime.Pom.TaskPage;

public class TestTask extends  Baseclass {
@Test
  public void createCustomer() throws EncryptedDocumentException, IOException {
	HomePage h = new HomePage(driver);
	h.getTasklink().click();
	TaskPage tp= new TaskPage(driver);
	tp.getAddnewbtn().click();
	tp.getNewcust().click();
	
    FileLibrary f= new FileLibrary();
	String name = f.readDataFromExcel("Sheet1",3,1);
	tp.getCustname().sendKeys(name);
	String desc = f.readDataFromExcel("Sheet1",3,2);
	tp.getCustdesc().sendKeys(desc);
	
	tp.getCreatecust().click();
	
}

}
