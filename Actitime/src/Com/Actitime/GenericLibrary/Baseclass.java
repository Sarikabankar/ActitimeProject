package Com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Com.Actitime.Pom.LoginPage;

public class Baseclass {
	public static WebDriver driver;
	FileLibrary f =new FileLibrary();
@BeforeSuite
public void databaseconnected() {
	Reporter.log("Database connected",true);
}
@AfterSuite
public void databasedisconnected() {
	Reporter.log("Database disconnected",true);
}
@BeforeClass
public void launchbrowser() throws IOException {
//	ChromeOptions op = new ChromeOptions();
//	op.addArguments("--remote-allow-origins=*");
	driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String url = f.readDataFromProperty("url");
	driver.get(url);
	Reporter.log("Browser launched",true);
}

@AfterClass
public void closebrowser() {
	driver.close();
	Reporter.log("Browser closed",true);	
}
@BeforeMethod
public void login() throws IOException {
	
	String un = f.readDataFromProperty("username");
	String pw = f.readDataFromProperty("password");
	LoginPage l= new LoginPage(driver);
	l.getUntbx().sendKeys(un);
	l.getPwtbx().sendKeys(pw);
	l.getLgbtn().click();
	Reporter.log("Login done",true);
}
@AfterMethod
public void logout() {
	driver.findElement(By.id("logoutLink")).click();
	Reporter.log("Logout done",true);
	
}

}
