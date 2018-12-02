package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class Accessories {
    private static WebElement element = null;
    

    public static WebElement button_Add_Magic_Mouse(WebDriver driver){
    	
    		try {

	    		//	element = driver.findElement(By.xpath("//input[@name='Buy']"));
				element = driver.findElement(By.className("wpsc_buy_button"));
				Log.info("Magic Mouse Add To Cart Button found");
	    
				return element;
	    
    		}catch (Exception e){
	    
	    Log.error("Magic Mouse Add To Cart Button is not found");
	    
	    throw(e);
	    
    		}

	}
    
    public static Boolean item_added(WebDriver driver){
    
    if(driver.findElement(By.xpath("//div[@class='alert addtocart' and @style='display: block;']"))!= null)
    {  	Log.info("Item Has Been Added");
    	 	return true;
    }
    	
    else return false;
    	}

}
