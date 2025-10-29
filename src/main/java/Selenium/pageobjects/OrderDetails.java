package Selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetails {
	
	WebDriver driver;
	public OrderDetails(WebDriver driver)
	{
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "label.ng-star-inserted") WebElement orderId;
	@FindBy(tagName = "h1") WebElement context;
	
	
	
	
	public void getOrderDetails()
	{
		String msg = context.getText();
		System.out.println("OrderId is - " + orderId.getText());
		System.out.println("Order Confirmation - " + msg);
	
	}
	
	public String getconfirmationMsg()
	{
		String msg = context.getText();
		return msg;
	}
	

}
