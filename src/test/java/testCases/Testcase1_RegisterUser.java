package testCases;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import data.Donnees_diverses;

public class Testcase1_RegisterUser {

	public static void main(String[] args) {
		// ouvrir chrome
				WebDriver driver = new ChromeDriver();
				// maximize
				driver.manage().window().maximize();
				// implicity wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				// ouvir URL
				driver.get(Donnees_diverses.basic.url);
				// Verify that home page is visible successfully
				WebElement txt_home = driver.findElement(By.xpath("//a[text()=' Home']"));
				String couleur_obtenu = txt_home.getCssValue("color");
				Assert.assertEquals(couleur_obtenu, Donnees_diverses.couleur.couleur_attendu);
				// Click on 'Signup / Login' button
				WebElement bt_signUpLogin = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
				bt_signUpLogin.click();
				// Verify 'New User Signup!' is visible
				WebElement txt_new_user = driver.findElement(By.xpath("//div[@class='signup-form']/h2"));
				String resultat_new_user = txt_new_user.getText();
				Assert.assertEquals(resultat_new_user, Donnees_diverses.message.new_user_signup);
				// Enter name and email address
				// Click 'Signup' button
				WebElement txt_name = driver.findElement(By.xpath("//input[@name='name']"));
				WebElement txt_email = driver.findElements(By.xpath("//input[@name='email']")).get(1);
				WebElement bt_signup = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
				txt_name.sendKeys(Donnees_diverses.basic.name);
				txt_email.sendKeys(Donnees_diverses.basic.email);
				bt_signup.click();
				// Verify that 'ENTER ACCOUNT INFORMATION' is visible
				List<WebElement> ls_txt_entrer_account = driver.findElements(By.xpath("//b[text()='Enter Account Information']"));
				Assert.assertTrue(ls_txt_entrer_account.size() == 1);
				// remplir formulaire et cliquer sur account create
				WebElement Title_Mrs = driver.findElement(By.id("id_gender2"));
				WebElement Passeword = driver.findElement(By.xpath("//input[@id='password']"));
				WebElement liste_jour = driver.findElement(By.xpath("//select[@id='days']"));
				WebElement liste_mois = driver.findElement(By.xpath("//select[@id='months']"));
				WebElement liste_année = driver.findElement(By.xpath("//select[@id='years']"));
				WebElement newsletter = driver.findElement(By.xpath("//input[@id='newsletter']"));
				WebElement special_offers = driver.findElement(By.xpath("//input[@id='optin']"));
				WebElement txt_firest_name = driver.findElement(By.name("first_name"));
				WebElement txt_last_name = driver.findElement(By.name("last_name"));
				WebElement txt_adress = driver.findElement(By.name("address1"));
				WebElement ld_country = driver.findElement(By.name("country"));
				WebElement txt_state = driver.findElement(By.name("state"));
				WebElement txt_zipe = driver.findElement(By.name("zipcode"));
				WebElement txt_mobile = driver.findElement(By.name("mobile_number"));
				WebElement txt_city = driver.findElement(By.name("city"));
				WebElement bt_create_account = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
				Title_Mrs.click();
				Passeword.sendKeys(Donnees_diverses.basic.password);
				// selection jour
				Select Select_day = new Select(liste_jour);
				Select_day.selectByValue(Donnees_diverses.basic.jour);
				// selection mois
				Select Select_month = new Select(liste_mois);
				Select_month.selectByValue(Donnees_diverses.basic.mois);
				// selection year
				Select Select_year = new Select(liste_année);
				Select_year.selectByValue(Donnees_diverses.basic.annee);
				// Cocher newsletter
				newsletter.click();
				// Cocher specialoffers
				special_offers.click();
				txt_firest_name.sendKeys(Donnees_diverses.basic.name);
				txt_last_name.sendKeys(Donnees_diverses.basic.prename);		
				//selection country
				Select Select_country = new Select(ld_country);
				Select_country.selectByValue(Donnees_diverses.basic.country);
				txt_adress.sendKeys(Donnees_diverses.basic.address);
				txt_state.sendKeys(Donnees_diverses.basic.state);
				txt_city.sendKeys(Donnees_diverses.basic.city);
				txt_zipe.sendKeys(Donnees_diverses.basic.zip);
				txt_mobile.sendKeys(Donnees_diverses.basic.tel);
				
				bt_create_account.click();
				// Verify that 'ACCOUNT CREATED!' is visible
				List<WebElement> ls_txt_account_created = driver.findElements(By.xpath("//b[text()='Account Created!']"));
				Assert.assertTrue(ls_txt_account_created.size() == 1);
				
				//Click 'Continue' button
				WebElement bt_continuer = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
				bt_continuer.click();
				
				//Verify that 'Logged in as username' is visible
				
				WebElement txt_nom_profil = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[10]//b"));
				String resultat_nom_profil = txt_nom_profil.getText();
				Assert.assertEquals(resultat_nom_profil, Donnees_diverses.basic.name);
				
				//fermer driver
				driver.close();
	}
}
