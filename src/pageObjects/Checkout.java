package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class Checkout {

    private static WebElement element = null;
    
    public static WebElement btn_continue(WebDriver driver){
    	
    		try {

    	    element = driver.findElement(By.xpath("//a[span[contains(text(),'Continue')]]"));
    	    
    	    Log.info("Link to Continue found");
    	    
    	    return element;
    	    
    		}catch (Exception e){
    	    
    	    Log.error("Link to Continue is not found");
    	    
    	    throw(e);
    	     
    		} 

	    

	}
    
    public static String get_Product_Name(WebDriver driver){

	    return driver.findElement(By.xpath("//td[@class='wpsc_product_name wpsc_product_name_0']/child::*")).getText();

    }
    
    public static String get_Amount_oF_Order(WebDriver driver){
    	
    		try {

	    element = driver.findElement(By.xpath("//td[@class='wpsc_product_quantity wpsc_product_quantity_0']/child::*"));
	    
	    Log.info("Top Product Quantity found");
	    
	    return element.findElement(By.xpath("//input[@name='quantity']")).getAttribute("value");
	    
    		}catch (Exception e){
	    
	    Log.error("Top Product Quantity is not found");
	    
	    throw(e);
	     
		} 

    }
}
