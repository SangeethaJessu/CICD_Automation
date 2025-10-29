package Selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderPage {
	
	WebDriver driver;

	public orderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		

	}
	
	
	
	@FindBy(css="tr td:nth-child(3)") List<WebElement> orderNames;
	
	public boolean VerifyOrders(String productName)
	{
		boolean check = orderNames.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
		//Assert.assertTrue(check);
		return  check;
	}
	

}
