package testCases;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoard_event {

	public static void main(String[] args) {
		//ouvrir chrome
	    WebDriver driver = new ChromeDriver();
	    //maximize
	    driver.manage().window().maximize();
	    //implicity wait
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    //ouvrir url
	    String url ="https://demoqa.com/text-box";
	    driver.get(url);
	    //declaration des elements
	    WebElement txt_name=driver.findElement(By.xpath("//input[@id='userName']"));
	    WebElement txt_email=driver.findElement(By.xpath("//input[@id='userEmail']"));
	    WebElement txt_currentAdress=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
	    WebElement txt_permanentAdress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
	    WebElement bt_submit=driver.findElement(By.xpath("//button[@id='submit']"));
	    
	    String name="Mohamed";
	    String mail="Mohamed.ahmed@gmail.com";
	    String adress="140 avenus de paris tunis";
	    //action
	    txt_name.sendKeys(name);
	    txt_email.sendKeys(mail);
	    txt_currentAdress.sendKeys(adress);
	    Actions action=new Actions(driver);
	    //copier
	    action.keyDown(txt_currentAdress, Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
	    //coller
	    action.keyDown(txt_permanentAdress, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	    bt_submit.click();
	    
	    //verification
	    //declaration et identification
	    WebElement txt_resultat_adresse_permanente=driver.findElement(By.xpath("//p[@id='permanentAddress']"));
	    //action
	    String resultat_obtenue=txt_resultat_adresse_permanente.getText();
	    //assert verification
	    Assert.assertTrue(resultat_obtenue.contains(adress));
	    System.out.println("test copier coller ok");
	    
	    driver.close();
	    

	    

	}

}
