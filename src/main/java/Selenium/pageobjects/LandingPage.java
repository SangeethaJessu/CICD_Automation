package Selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbtractComponents.AbstractComponents;


public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	//WebElement email1 = driver.findElement(By.id("userEmail"));
	//WebElement pwd1 = driver.findElement(By.id("userPassword"));
	
	//PageObjects
	@FindBy(id="userEmail") WebElement email;
	@FindBy(id="userPassword") WebElement password;
	@FindBy(id="login") WebElement loginbutton;
	@FindBy(css="[class*='flyInOut']") WebElement ErrorMsg;
	
	public ProductCatalogue  loginApplication(String mail, String pwd)
	{
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginbutton.click();
		ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
		return ProductCatalogue;
	}
	
	public  String getErrorMessage()
	{
		waitForWebElementToAppear(ErrorMsg);
		return ErrorMsg.getText();
		
	}
	
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}


}
