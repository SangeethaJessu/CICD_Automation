package SeleniumFramework.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.pageobjects.ProductCatalogue;
import Selenium.pageobjects.cartPage;
import SeleniumFramework.TestComponents.BaseTest;
import SeleniumFramework.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTest{
	
	//String productName = "ZARA COAT 3";

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException
	{
		
		
		//String productName1 = "ind";
		//page1
		//ProductCatalogue ProductCatalogue = 
		LandingPage.loginApplication("Anjali2@gmail.com", "Anjali2@gmail.co");
		Assert.assertEquals("Incorrect email  password.", LandingPage.getErrorMessage());
		
}
	
	@Test
	public void ProductErrorValdiation() throws IOException
	{
		
		String productName = "ZARA COAT 3";
		ProductCatalogue ProductCatalogue = LandingPage.loginApplication("Anjali3@gmail.com", "Anjali3@gmail.com");
		List<WebElement> products = ProductCatalogue.getProductList();
		ProductCatalogue.addProductToCart(productName);
		cartPage cartPage = ProductCatalogue.goToCart(); //remember this step
		boolean check = cartPage.cartItemsCheck(productName);
		Assert.assertTrue(check);
	
}
	

	
	
}
