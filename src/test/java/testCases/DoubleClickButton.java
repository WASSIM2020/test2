package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DoubleClickButton {

	public static void main(String[] args) throws InterruptedException {
		//ouvrir chrome
		WebDriver driver = new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//ouvrir url
		driver.get("https://demoqa.com/buttons");
		//sleep 5s
		Thread.sleep(5000);
		//declaration des elements
		WebElement bt_double_click;
		//identification des elements
		bt_double_click=driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		//action
		Actions action = new Actions(driver);
		action.doubleClick(bt_double_click).perform();
		//verification
		//declaration
		WebElement txt_resultat_double_click;
		//identification
		txt_resultat_double_click = driver.findElement(By.xpath("//p[@id='doubleClickMessage']"));
		//action
		String message_obtenu = txt_resultat_double_click.getText();
		//comparaison
		Assert.assertEquals(message_obtenu, "You have done a double click");
		System.out.println("Test OK");
		
		driver.close();
	
	}

}
