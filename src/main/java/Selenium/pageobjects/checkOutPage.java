package Selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.AbtractComponents.AbstractComponents;

public class checkOutPage extends AbstractComponents{
	
	WebDriver driver;
	public checkOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")  WebElement clickCountry;
	@FindBy(xpath="(//button[@type='button']/span)[2]") WebElement selectCountry;
	@FindBy(css=".btnn") WebElement placeOrder;
	
	By waiting = By.cssSelector(".ta-item");
	

	public void clickCountry(String countryName)
	{
		clickCountry.sendKeys(countryName);
		waitForElementToAppear(waiting);
	}
	
	public void chooseCountry()
	{
		waitForElementToAppear(waiting);
		selectCountry.click();
	}
	
	public OrderDetails clickOnplaceOrder()
	{
		//driver.findElement(By.cssSelector(".btnn")).click();
		placeOrder.click();
		OrderDetails OrderDetails = new OrderDetails(driver);
		return OrderDetails;
	}
	
}
