package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

 public class Home {

	 
    private static WebElement element = null;
    

 public static WebElement category_tab(WebDriver driver){
	 
	 	try {

	    element = driver.findElement(By.xpath("//a[contains(text(),'Product Category')]"));
	    
	    Log.info("Category tab found");
	    
	    return element;
	    
	 	}catch (Exception e){
	 	    
			Log.error("Category tab is not found");
			
			throw(e);
	    
		}

	}
 
 public static WebElement link_to_Accessories(WebDriver driver){
	 
	 	try {
	 
	    element = driver.findElement(By.xpath("//a[contains(text(),'Accessories')]"));
	    
	    Log.info("Link to Accessories found");
	    
	    return element;
	    
	 	}catch (Exception e){
	    
	 		Log.error("Link to Accessories is not found");
	 		
			throw(e);
		    
		}

	}
 
 public static WebElement link_to_Checkout(WebDriver driver){
	 
	 	try {
	 
	    element = driver.findElement(By.xpath("//a[@title='Checkout']"));
	    
	    Log.info("Link to Checkout found");
	    
	    return element;
	    
	 	}catch (Exception e){
	    
	    Log.error("Link to Checkout is not found");

		throw(e);
	    
	    }

	}

}