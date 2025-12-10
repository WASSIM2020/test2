package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selection_Liste_Deroulante {

	public static void main(String[] args) throws InterruptedException {
		//ouvrir chrome
	    WebDriver driver = new ChromeDriver();
	    //maximize
	    driver.manage().window().maximize();
	    //implicity wait
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    //ouvrir url
	    String url ="https://demoqa.com/select-menu";
	    driver.get(url);
	    //selection liste deroulante
	    //declaration et identification
	    WebElement id_couleur=driver.findElement(By.id("oldSelectMenu"));
	    //action
	    Select select_couleur=new Select(id_couleur);
	    select_couleur.selectByValue("5");
	    Thread.sleep(3000);
	    select_couleur.selectByVisibleText("Aqua");
	    
	    

	}

}
