package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoppingCartTest {

	public static void main(String[] args) throws InterruptedException {

		//Set up webdriver for firefox
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		

		//Open SauceDemo website
		driver.get("https://www.saucedemo.com/");
		


		//Print page title
		String title = driver.getTitle();
		System.out.println("Page Title:"+" "+title);
		


		//Enter username and password
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		


		//Click Login button
		driver.findElement(By.id("login-button")).click();
		


		//Verify login is successful by checking the current URL
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();

		if(actualUrl.equals(expectedUrl)) {
			System.out.println("Login Successful");
		}
		else {
			System.out.println("Login Failed");
		}
		


		//Print the first product name before sorting
		String firstProductBefore = driver.findElement(By.className("inventory_item_name")).getText();
		System.out.println("First Product Before Sorting: "+firstProductBefore);
		


		//Click the dropdown
		WebElement dropDown = driver.findElement(By.className("product_sort_container"));
		dropDown.click();
		


		//Select price low to high
		Select select = new Select(dropDown);
		select.selectByVisibleText("Price (low to high)");
		


		//Print the first product name before sorting
		String firstProductAfter = driver.findElement(By.className("inventory_item_name")).getText();
		System.out.println("First Product Before Sorting: "+firstProductAfter);
		


		//Add products to the cart
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		


		//Verify the products are added to cart and cart count is updated
		String cartCount = driver.findElement(By.className("shopping_cart_link")).getText();
		System.out.println("Cart count: "+cartCount);
		


		//Go to cart page and print text(Your cart)
		driver.findElement(By.className("shopping_cart_link")).click();
		WebElement cartPageTitle = driver.findElement(By.className("title"));
		System.out.println(cartPageTitle.getText());
		



		//Print cart items before removing
		System.out.println("Your cart before removing product");
		List<WebElement> cartBefore = driver.findElements(By.cssSelector(".cart_item .inventory_item_name"));
		for (WebElement webElement : cartBefore) {
			System.out.println(webElement.getText());
		}
		



		//Remove one product from the cart
		driver.findElement(By.id("remove-sauce-labs-onesie")).click();
		System.out.println("Sauce Labs Onesie is removed from the cart");
		

		

		//Print cart items after removing
		System.out.println("Your cart after removing product");
		List<WebElement>cartAfter = driver.findElements(By.cssSelector(".cart_item .inventory_item_name"));
		for (WebElement webElement1 : cartAfter) {
			System.out.println(webElement1.getText());
		}
		


		//Click Checkout button
		driver.findElement(By.id("checkout")).click();
		System.out.println("Checkout button is clicked and navigated to the checkout page");
		
		
		
		
		//Enter checkout details
		driver.findElement(By.id("first-name")).sendKeys("Vigneshwaran");
		driver.findElement(By.id("last-name")).sendKeys("S");
		driver.findElement(By.id("postal-code")).sendKeys("600001");
		System.out.println("Entered checkout details");
		
		
		
		
		//Click Continue button
		driver.findElement(By.id("continue")).click();
		System.out.println("Clicked continue button and navigated to the overview page");
		
		
		
		
		//Print total amount
		String totalAmount = driver.findElement(By.className("summary_total_label")).getText();
		System.out.println("Total Amount: "+totalAmount);
		
		
		
		//Click Finish button
		driver.findElement(By.id("finish")).click();
		System.out.println("Order placed successfully");
		
		
		
		//Click Back Home button
		driver.findElement(By.id("back-to-products")).click();
		System.out.println("Clicked Back Home button and returned to the Product Page");
		
		
		
		//Logout from the website
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println("Logged out successfully");
		
		
		
		//Close the browser
		driver.quit();
		System.out.println("Browser closed successfully");




	}

	}


