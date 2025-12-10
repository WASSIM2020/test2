package automationExercice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import data.Donnees_diverses;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

     
@SuppressWarnings("deprecation")
public class Authentification {
    
	WebDriver driver;
	
	@Given("ouvrir le navigateur chrome")
	public void ouvrir_le_navigateur_chrome() {
		    driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	}

	@Given("saisir url")
	public void saisir_url() {
		   driver.get(Donnees_diverses.basic.url_signup);
	}

	@When("saisir l'adresse email")
	public void saisir_l_adresse_email() {
	     WebElement txt_mail=driver.findElements(By.name("email")).get(0);
	     txt_mail.sendKeys(Donnees_diverses.basic.email);
	}

	@When("saisir le mot de passe")
	public void saisir_le_mot_de_passe() {
	     WebElement txt_password=driver.findElement(By.name("password"));
	     txt_password.sendKeys(Donnees_diverses.basic.password);

	}

	@When("cliquer sur le bouton se connecter")
	public void cliquer_sur_le_bouton_se_connecter() {
	    WebElement bt_login=driver.findElement(By.xpath("//button[@data-qa='login-button']"));
	    bt_login.click();
	}

	@Then("verifier le nom de profil")
	public void verifier_le_nom_de_profil() {
	    WebElement txt_nom_profil=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[10]//b"));
	    String profil_obtenu = txt_nom_profil.getText();
	    Assert.assertEquals(profil_obtenu, Donnees_diverses.basic.name);

	}

}
