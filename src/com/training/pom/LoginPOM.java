package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	/*
	 * // Test case RETC_010 "New Launch"
	 */	
	@FindBy(xpath="//a[contains(text(),'New Launch')]")
    private WebElement New_Launch;
	
	@FindBy(xpath="//div[@id='wpmm-megamenu']//div[@class='wpmm-post post-4505']//a[contains(text(),'prestige')]")
    private WebElement prestige1;
	
	@FindBy(xpath="//input[@name='your-name']")
	public WebElement Your_Name;
	
	@FindBy(xpath="//input[@name='your-email']")
	public WebElement Email;
	
	@FindBy(xpath="//input[@name='your-subject']")
	public WebElement subject;
	
	@FindBy(xpath="//textarea[@name='your-message']")
	public WebElement your_message;
	
	@FindBy(xpath="//input[@class='wpcf7-form-control wpcf7-submit']")
	public WebElement Send;
	
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	public WebElement ErrorSendingyourmessage;
	
	/*
	 * // Test case RETC_011 "LOG IN/REGISTER button"
	 */	
	@FindBy(xpath="//a[@class='sign-in']")
	public WebElement Login_Register;
	
	@FindBy(xpath="//input[@id='user_login']")
	public WebElement Username;
	
	@FindBy(xpath="//input[@id='user_pass']")
	public WebElement Password;
	
	@FindBy(xpath="//input[@name='login']")
	public WebElement Sign_In;
	
	@FindBy(xpath="//div[contains(text(),'Dashboard')]")
	public WebElement AdminDashboard;
	
	@FindBy(xpath="//img[contains(@class,'avatar avatar-26 photo')]")
	public WebElement OptionLogout;
	
	@FindBy(xpath="//a[contains(@class,'ab-item')][contains(text(),'Log Out')]")
	public WebElement Logout;
	
	/*
	 * // Test case RETC-012 "LOG IN/REGISTER button"
	 */
	
	@FindBy(xpath="//a[contains(text(),'Lost Your Password?')]")
	public WebElement Lostyourpassword;
	
	@FindBy(xpath="//input[@id='user_login']")
	public WebElement Email_Address_Textbox;
	
	@FindBy(xpath="//input[@name='submit']")
	public WebElement ResetPassword;
	
	@FindBy(xpath="//p[contains(text(),'The email could not be sent.')]")
	public WebElement ErrorMessage;
	
	/*
	 * // End of variable declaration for test cases"
	 */
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickNew_Launch() {
		//this.New_Launch.;
		Actions builder = new Actions(driver);
		Action hover= builder.moveToElement(this.New_Launch).build();
		hover.perform();
		
	}
	public void clickBtn(WebElement S1) {
		S1.click();
	}
	public void click_prestige() {
		this.prestige1.click();
	}
	
	public void inputtext(WebElement I,String S) {
		I.sendKeys(S);
	}
	
	public void messgaeValidate(WebElement W, String S) {
		if (W.isDisplayed()) {
			System.out.println(S+ " displayed");
		}
			else {
				System.err.println(S+ "is not displayed");
				
		
		}
	}
}
