package SeleniumFramework.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Selenium.pageobjects.LandingPage;
import Selenium.pageobjects.OrderDetails;
import Selenium.pageobjects.ProductCatalogue;
import Selenium.pageobjects.cartPage;
import Selenium.pageobjects.checkOutPage;
import Selenium.pageobjects.orderPage;
import SeleniumFramework.TestComponents.BaseTest;

public class StandAloneTest2 extends BaseTest{
	
	//String productName = "ZARA COAT 3";

	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException
	{
		
		
		String productName1 = "ind";
		ProductCatalogue ProductCatalogue = LandingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = ProductCatalogue.getProductList();
		ProductCatalogue.addProductToCart(input.get("product"));
		cartPage cartPage = ProductCatalogue.goToCart(); //remember this step
		boolean check = cartPage.cartItemsCheck(input.get("product"));
		Assert.assertTrue(check);
		checkOutPage checkOutPage = cartPage.checkOut();
		checkOutPage.clickCountry(productName1);
		checkOutPage.chooseCountry();
		OrderDetails OrderDetails = checkOutPage.clickOnplaceOrder();
		OrderDetails.getOrderDetails();
		String msg = OrderDetails.getconfirmationMsg();
		Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");
		

}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void checkHistoryOrder()
	{
		LandingPage.loginApplication("Anjali1111@gmail.com", "Anjali@123");
		orderPage orderPage  = LandingPage.goToOrderPage();
		//Assert.assertTrue(orderPage.VerifyOrders(productName));
	}
	/*
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][]  { {"Anjali@gmail.com", "Anjali@gmail.com1", "ADIDAS ORIGINAL"}, {"Anjali1111@gmail.com", "Anjali@123",  "ZARA COAT 3"}};
		//{{"Anjali1111@gmail.com", "Anjali@123",  "ZARA COAT 3"}};
	}
	*/
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "Anjali@gmail.com");
		map.put("password", "Anjali@gmail.com1");
		map.put("product", "ADIDAS ORIGINAL");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "Anjali1111@gmail.com");
		map1.put("password", "Anjali@123");
		map1.put("product", "ZARA COAT 3");
		
		return new Object[][]  { {map}, {map1}};

	}
	
	

	
}
