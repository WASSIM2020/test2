package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ExerciceTaperSubmit {

	public static void main(String[] args) throws InterruptedException {
		//ouvrir chrome
	    WebDriver driver = new ChromeDriver();
	    //maximize
	    driver.manage().window().maximize();
	    //ouvrir url
	    driver.get("https://demoqa.com/text-box");
	    //sleep 7s
	    Thread.sleep(7000);
	    //declaration des elements
	    WebElement FullName,Email,CurrentAdress,PermanentAdress,bt_submit;
	    //identification des elements
	    FullName=driver.findElement(By.xpath("//input[@id='userName']"));
	    FullName.sendKeys("Wassim Ghanmi");
	    Email=driver.findElement(By.xpath("//input[@id='userEmail']"));
	    Email.sendKeys("ghanmi.wassim58@gmail.com");
	    CurrentAdress=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
	    CurrentAdress.sendKeys("15 rue de la liberté tunis");
	    PermanentAdress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
	    PermanentAdress.sendKeys("14 rue mohamed 5 tunis");
	    bt_submit=driver.findElement(By.xpath("//button[@id='submit']"));
	    //action
	    bt_submit.click();
	    //verification
	    //declaration
	    WebElement resultat_bt_submit;
	    //identification
	    resultat_bt_submit=driver.findElement(By.xpath("//div[@style='border: 1px solid rgb(229, 229, 229); margin-top: 50px; padding: 50px;']"));
	    //action
	    String message_obtenu=resultat_bt_submit.getText();
	    String message_voulu="Name:Wassim Ghanmi"+" Email:ghanmi.wassim58@gmail.com"+" Current Address :15 rue de la liberté tunis"+" Permanent Address :14 rue mohamed 5 tunis";
	    //comparaison
	    Assert.assertEquals(message_obtenu, message_voulu);
	    System.out.println("Test OK");
	    
	    driver.close();
	}

}
