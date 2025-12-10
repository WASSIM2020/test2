package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.junit.Assert;

public class DragDrop {

	public static void main(String[] args) throws InterruptedException {
		//ouvrir chrome
	    WebDriver driver = new ChromeDriver();
	    //maximize
	    driver.manage().window().maximize();
	    //ouvrir url
	    String url="https://demoqa.com/droppable";
	    driver.get(url);
	    //sleep 5s
	    Thread.sleep(5000);
	    //declaration des elements
	    WebElement drag_me,drop_here;
	    //identification des elements
	    drag_me=driver.findElement(By.xpath("//div[@id='draggable']"));
	    drop_here=driver.findElement(By.xpath("//div[@id='droppable']"));
	  //action
	    Actions action = new Actions(driver);
	    action.dragAndDrop(drag_me, drop_here).perform();
	    /****************************************************verification texte***********************************/
	    //declaration
	    WebElement txt_dropped;
	    //identification
	    txt_dropped=driver.findElement(By.xpath("//p[text()='Dropped!']"));
	    //action
	    String message_obtenu=txt_dropped.getText();
	    //Assert
	    Assert.assertTrue(message_obtenu.equals("Dropped!"));
	    System.out.println("verification texte ok");
	    /****************************************************verification couleur***********************************/
	    //declaration
	    //identification
	    //action
	    String couleur_attendue="rgba(70, 130, 180, 1)";
	    String couleur_obtenue=drop_here.getCssValue("background-color");
	    //Assert
	    Assert.assertEquals(couleur_attendue, couleur_obtenue);
	    System.out.println("verification couleur ok");
	    
	    //fermer le driver
	    driver.close();
	    
	    
	    
	    



	}

}
