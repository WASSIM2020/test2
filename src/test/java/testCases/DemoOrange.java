package testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoOrange {

	public static void main(String[] args) throws InterruptedException {
		
		//ouvrir chrome
		WebDriver driver = new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//saisie url
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//pause de 5 secondes
		Thread.sleep(5000);
		
		
		//declaration
		WebElement Username,Password,bt_login,txt_profil;
		//trouver champ Username et taper Admin
		Username = driver.findElement(By.name("username"));
		Username.sendKeys("Admin");
		//trouver champ Password et taper admin123
		Password = driver.findElement(By.name("password"));
		Password.sendKeys("admin123");
		//cliquer sur login
		bt_login=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		bt_login.click();
		
		//pause de 5 secondes
	    Thread.sleep(5000);
				
		
		//verification
		//declaration de l'element contenant la resultat attendue
		txt_profil=driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
		//recuperer le text de l'element
		String resultat_profil_obtenue=txt_profil.getText();
		String resultat_profil_attendue="FirstNameTest LastNameTest";
		//appel assertion pour la comparaison
		Assert.assertEquals(resultat_profil_obtenue, resultat_profil_attendue);
		System.out.println("Test OK");
		
		//fermer chrome
		driver.close();
		

	}

}
