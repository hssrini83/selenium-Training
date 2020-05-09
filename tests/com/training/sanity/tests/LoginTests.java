package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1, enabled=true)
	public void validLoginTest() {
		/*
Test case name =RETC_011
* 1. Click on New Launch tab
Result:application should display the new launches
2. Click on prestige (http://realty-real-estate.upskills.in/prestige-33/)
Result:: Right side down "For Enquires" Should get displayed
3. Enter valid credentials in Your Name textbox
Result::Entered credentials in Your Name textbox should get displayed
4. Enter valid credentials in Your Email textbox
Result::Entered credentials in Your Email textbox should get displayed
5. Enter valid credentials in Subject textbox
Result:: Entered credentials in Subject textbox should get displayed
6. Enter valid credentials in Your Message textbox
Result::Entered credentials in Your Message textbox should get displayed
7. Click on Send button
Result::There was an error trying to send your message. Please try again later should be displayed.
		 */
		
		/*
		 * loginPOM.sendUserName("admin"); loginPOM.sendPassword("admin@123");
		 * loginPOM.clickLoginBtn(); screenShot.captureScreenShot("First");
		 * loginPOM.createDescription();
		 */
		loginPOM.clickNew_Launch();
		loginPOM.click_prestige();
		loginPOM.inputtext(loginPOM.Your_Name, "manzoor");
		loginPOM.inputtext(loginPOM.Email, "manzoor@gmail.com");
		loginPOM.inputtext(loginPOM.subject, "apartments");
		loginPOM.inputtext(loginPOM.your_message, "looking for an apartments");
		loginPOM.clickBtn(loginPOM.Send);
		loginPOM.messgaeValidate(loginPOM.ErrorSendingyourmessage,"Message");
	}
	
	@Test(priority=2, enabled=true)
	public void loginApp() {
		loginPOM.clickBtn(loginPOM.Login_Register);
		loginPOM.inputtext(loginPOM.Username, "manzoor@gmail.com");
		loginPOM.inputtext(loginPOM.Password,"manzoor");
		loginPOM.clickBtn(loginPOM.Sign_In);
		loginPOM.messgaeValidate(loginPOM.AdminDashboard,"Dashboard");
	}
	
	@Test(priority=3, enabled=true)
	public void forgotPass() {
		loginPOM.clickBtn(loginPOM.Login_Register);
		loginPOM.clickBtn(loginPOM.Lostyourpassword);
		loginPOM.inputtext(loginPOM.Email_Address_Textbox, "manzoor@gmail.com");
		loginPOM.clickBtn(loginPOM.ResetPassword);
		loginPOM.messgaeValidate(loginPOM.ErrorMessage, "Error Message");
		
	}
}


