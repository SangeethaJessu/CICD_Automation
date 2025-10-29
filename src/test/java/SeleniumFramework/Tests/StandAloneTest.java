package SeleniumFramework.Tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Selenium.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String productName = "ZARA COAT 3";
		String productName1 = "xyu";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage LandingPage= new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("Anjali1111@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Anjali@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-lg-4")));
		List<WebElement> products = driver.findElements(By.cssSelector("div.col-lg-4"));
		WebElement prod = products.stream().filter(s->s.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ng-tns-c31-0")));
		//wait.until(ExpectedConditions.invisibilityOf(prod.findElement(By.cssSelector("ng-tns-c31-0"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	

		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartWrap"));
		boolean cartItemsCheck = cartItems.stream().anyMatch(cart->cart.findElement(By.tagName("h3")).getText().equalsIgnoreCase(productName));
		
		Assert.assertTrue(cartItemsCheck);
		
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		//List<WebElement> countryNames = driver.findElements(By.xpath("//button[@type='button']/span"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
		driver.findElement(By.xpath("(//button[@type='button']/span)[2]")).click();
		driver.findElement(By.cssSelector(".btnn")).click();
		//System.out.println(driver.findElement(By.cssSelector("label.ng-star-inserted")).getText());
		String end = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(end, "THANKYOU FOR THE ORDER.");

}
}
