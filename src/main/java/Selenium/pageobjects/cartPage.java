package Selenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {
	WebDriver driver;
	
	public cartPage(WebDriver driver) {
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartWrap"));
	//boolean cartItemsCheck = cartItems.stream().anyMatch(cart->cart.findElement(By.tagName("h3")).getText().equalsIgnoreCase(productName));
	
	
	@FindBy(css=".cartWrap") List<WebElement> cartItems;
	@FindBy(xpath="//button[text()='Checkout']") WebElement checkOutButton;
	By name = By.tagName("h3");
	
	public boolean cartItemsCheck(String productName)
	{
		boolean check = cartItems.stream().anyMatch(cart->cart.findElement(name).getText().equalsIgnoreCase(productName));
		//Assert.assertTrue(check);
		return  check;
	}
	
	public checkOutPage checkOut()
	{
		//driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		checkOutButton.click();
		checkOutPage checkOutPage = new checkOutPage(driver);
		return checkOutPage;
	}

}
