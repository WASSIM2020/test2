package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class DemoSelenium {

	public static void main(String[] args) {
		
		//ouvrir chrome
		WebDriver driver = new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//saisie url
		//driver.get("https://www.google.com/?hl=fr");
		driver.navigate().to("https://www.google.com/?hl=fr");
		
		//declaration
		WebElement txt_recherche;
		//identification des elements
		txt_recherche = driver.findElement(By.name("q"));
		//action
		txt_recherche.sendKeys("tunisie");
		//resultat

	}

}
