package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MoveElement {

	public static void main(String[] args) throws InterruptedException {
		//ouvrir chrome
	    WebDriver driver = new ChromeDriver();
	    //maximize
	    driver.manage().window().maximize();
	    //ouvrir url
	    String url ="https://demoqa.com/menu";
	    driver.get(url);
	    //sleep 5s
	    Thread.sleep(5000);
	    //declaration et identification
	    WebElement menu1=driver.findElement(By.xpath("//a[text()='Main Item 2']"));
	    //action
	    Actions action=new Actions(driver);
	    action.moveToElement(menu1).perform();
	    
	    WebElement sub_sub_element=driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
	    //action
	    action.moveToElement(sub_sub_element).perform();
	    
	    //verification
	    WebElement sous_menu1=driver.findElement(By.xpath("//a[text()='Sub Item']"));
	    Assert.assertTrue(sous_menu1.isDisplayed());
	    
	    WebElement sous_sous_menu1=driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
	    Assert.assertTrue(sous_sous_menu1.isDisplayed());
	    
	    
	    System.out.println("test ok");
	    
	    driver.close();

	}

}
