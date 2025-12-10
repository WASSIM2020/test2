package automationExercice;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct {
	WebDriver driver;
	@Given("ouvrir navigateur chrome")
	public void ouvrir_navigateur_chrome() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("saisir url {string}")
	public void saisir_url(String string) {
	  driver.get(string);  
	}

	@Then("verifier que la couleur de menu home est {string}")
	public void verifier_que_la_couleur_de_menu_home_est(String string) {
		WebElement txt_home = driver.findElement(By.xpath("//a[text()=' Home']"));
		String couleur_obtenu = txt_home.getCssValue("color");
		Assert.assertEquals(couleur_obtenu, string);  
	}

	@When("cliquer sur le bouton products")
	public void cliquer_sur_le_bouton_products() {
		WebElement bt_products = driver.findElement(By.xpath("//a[text()=' Products']"));
		bt_products.click();
	}

	@Then("verifier affichage de {string}")
	public void verifier_affichage_de(String string) {
	    WebElement txt_affiche=driver.findElement(By.xpath("//h2[@class='title text-center']"));
	    String resultat_obtenue=txt_affiche.getText();
		Assert.assertEquals(resultat_obtenue, string);  

	}

	@When("saisir le nom de produit suivant {string}")
	public void saisir_le_nom_de_produit_suivant(String string) {
	    WebElement txt_search_product=driver.findElement(By.id("search_product"));
	    txt_search_product.sendKeys(string);

	}

	@When("cliquer sur le bouton search")
	public void cliquer_sur_le_bouton_search() {
	    WebElement bt_search=driver.findElement(By.id("submit_search"));
	    bt_search.click();

	}


	@Then("verifier le prix produit affiche {string}")
	public void verifier_le_prix_produit_affiche(String string) {
	    WebElement txt_prix=driver.findElement(By.xpath("//div[@class='productinfo text-center']//h2"));
	    String resultat_obtenue=txt_prix.getText();
	    Assert.assertTrue(resultat_obtenue.contains(string));

	}

}
