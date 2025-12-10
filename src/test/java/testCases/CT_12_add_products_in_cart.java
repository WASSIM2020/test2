package testCases;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import data.Donnees_diverses;

public class CT_12_add_products_in_cart {

	public static void main(String[] args) {
		// open chrome
		WebDriver driver = new ChromeDriver();
		// maximize
		driver.manage().window().maximize();
		// implicity wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// open URL
		driver.get(Donnees_diverses.basic.url);
		// Verify that home page is visible successfully
		WebElement txt_home = driver.findElement(By.xpath("//a[text()=' Home']"));
		String couleur_obtenu = txt_home.getCssValue("color");
		Assert.assertEquals(couleur_obtenu, Donnees_diverses.couleur.couleur_attendu);
		// Click 'Products' button
		WebElement bt_products=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[2]//a"));
		bt_products.click();
		// Hover over first product and click 'Add to cart'
		Actions action=new Actions(driver);
		WebElement first_product=driver.findElements(By.xpath("//div[@class='productinfo text-center']")).get(0);
		WebElement bt_add_to_cart_1=driver.findElement(By.xpath("//a[@data-product-id='1']"));
		action.moveToElement(first_product).perform();
		bt_add_to_cart_1.click();
		//Click 'Continue Shopping' button
		WebElement bt_continue_shopping=driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']"));
		bt_continue_shopping.click();
		//Hover over second product and click 'Add to cart'
		WebElement second_product=driver.findElements(By.xpath("//div[@class='productinfo text-center']")).get(1);
		WebElement bt_add_to_cart_2=driver.findElement(By.xpath("//a[@data-product-id='2']"));
		action.moveToElement(second_product).perform();
		bt_add_to_cart_2.click();
		//Click 'View Cart' button
		WebElement bt_view_cart=driver.findElement(By.xpath("//p[@class='text-center']//a//u"));
		bt_view_cart.click();
		//Verify both products are added to Cart
		WebElement product_1=driver.findElement(By.xpath("//tr[@id='product-1']"));
		Assert.assertTrue(product_1.isDisplayed());
		WebElement product_2=driver.findElement(By.xpath("//tr[@id='product-2']"));
		Assert.assertTrue(product_2.isDisplayed());
		//Verify their prices, quantity and total price
		WebElement price_1 = driver.findElement(By.xpath("//tr[1]//td[@class='cart_price']/p"));
        WebElement quantity_1 = driver.findElement(By.xpath("//tr[1]//td[@class='cart_quantity']/button"));
        WebElement total_1 = driver.findElement(By.xpath("//tr[1]//td[@class='cart_total']/p"));

        WebElement price_2 = driver.findElement(By.xpath("//tr[2]//td[@class='cart_price']/p"));
        WebElement quantity_2 = driver.findElement(By.xpath("//tr[2]//td[@class='cart_quantity']/button"));
        WebElement total_2 = driver.findElement(By.xpath("//tr[2]//td[@class='cart_total']/p"));
        
        System.out.println("Product 1: Price = " + price_1.getText() + ", Quantity = " + quantity_1.getText() + ", Total = " + total_1.getText());
        System.out.println("Product 2: Price = " + price_2.getText() + ", Quantity = " + quantity_2.getText() + ", Total = " + total_2.getText());

        Assert.assertTrue(price_1.getText().startsWith("Rs."));
        Assert.assertTrue(price_2.getText().startsWith("Rs."));
        
        // close driver
        driver.close();
		
		
		

	}

}
