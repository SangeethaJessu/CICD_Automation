package Selenium.AbtractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.pageobjects.cartPage;
import Selenium.pageobjects.orderPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']") WebElement addToCart;
	@FindBy(css="button[routerlink='/dashboard/myorders']") WebElement Orders;
	
	public cartPage goToCart()
	{
		addToCart.click();
		cartPage cartPage = new cartPage(driver);
		return cartPage;
	}
	
	public orderPage goToOrderPage()
	{
		Orders.click();
		orderPage orderPage = new orderPage(driver);
		return orderPage;
	}

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public void waitForElementToDisAppear(By findBy1)
	{
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(findBy1));
		
	}
	
	public void AssertCheck()
	{
		//Assert.assertTrue(cartItemsCheck);
		
	}
	

}
