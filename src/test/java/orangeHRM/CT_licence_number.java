package orangeHRM;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CT_licence_number {
	WebDriver driver;
	
	@Given("ouvrir chrome")
	public void ouvrir_chrome() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}

	@Given("saisir URL {string}")
	public void saisir_url(String string) {
		driver.get(string);
	    
	}

	@When("saisir le username {string}")
	public void saisir_le_username(String string) {
		WebElement txt_username = driver.findElement(By.name("username"));
		txt_username.sendKeys(string);
		

	    
	}

	@When("saisir mot de passe {string}")
	public void saisir_mot_de_passe(String string) {
		WebElement txt_password = driver.findElement(By.name("password"));
		txt_password.sendKeys(string);
	    
	}

	@When("cliquer sur le bouton login")
	public void cliquer_sur_le_bouton_login() {
		WebElement bt_login=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		bt_login.click();
	    
	}

	@Then("verifier nom profil {string}")
	public void verifier_nom_profil(String string) {
		WebElement txt_profil=driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
		String resultat_profil_obtenue=txt_profil.getText();
		Assert.assertEquals(resultat_profil_obtenue, string);


	    
	}

	@When("cliquer sur le bouton My info")
	public void cliquer_sur_le_bouton_my_info() {
		WebElement bt_my_info=driver.findElements(By.xpath("//a[@class='oxd-main-menu-item']")).get(5);
		bt_my_info.click();
	    
	}

	@Then("verifier le numero de licence {string}")
	public void verifier_le_numero_de_licence(String string) {
		WebElement txt_licence_number=driver.findElements(By.xpath("//input[@class=\"oxd-input oxd-input--active\"]")).get(3);
		String resultat_licence_number_obtenue=txt_licence_number.getAttribute("value");
		System.out.println(resultat_licence_number_obtenue);
		Assert.assertEquals(resultat_licence_number_obtenue, string);


	    
	}


}
