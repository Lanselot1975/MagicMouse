package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class Continue {
	
    private static WebElement element = null;
    private static Select dropdown = null;
    
    public static WebElement txtbx_Email(WebDriver driver){
    	
    		try {
    	
    	    WebDriverWait wait = new WebDriverWait(driver, 15);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='billingemail']")));
        
        Log.info("Billing email found");
        
        return element;
        
    		} catch (Exception e){

	    Log.error("Billing email is not found");
	    
	    throw(e);
	    
    		}

	    

	}
    
    public static WebElement txtbx_Fname(WebDriver driver){
    	
    		try {

	    element = driver.findElement(By.xpath("//input[@title='billingfirstname']"));
	    
	    Log.info("Billing Fname found");
	    
	    return element;
	    
    		}catch (Exception e){
	    
	    Log.error("Billing Fname is not found");
	    
		throw(e);
	    
    		}

	}
    
    public static WebElement txtbx_Lname(WebDriver driver){
    	
    		try {

	    element = driver.findElement(By.xpath("//input[@title='billinglastname']"));
	    
	    Log.info("Billing Lname found");
	    
	    return element;
	    
    		}catch (Exception e){
	    
	    Log.error("Billing Lname is not found");
	    
	    throw(e);
	    
    		}

	}
    
    public static WebElement txtbx_Address(WebDriver driver){
    	
    		try {

	    element = driver.findElement(By.xpath("//textarea[@title='billingaddress']"));
	    
	    Log.info("Billing Address found");

	    return element;
	    
    		}catch (Exception e){
	    
	    Log.error("Billing Address is not found");
	    
	    throw(e);
	    
    		}

	}
    
    public static WebElement txtbx_City(WebDriver driver){
    	
    		try {

	    element = driver.findElement(By.xpath("//input[@title='billingcity']"));
	    
	    Log.info("Billing City found");
	    
	    return element;
	    
    		}catch (Exception e){
	    
	    Log.error("Billing City is not found");
	    
	    throw(e);
	    
    		}

	}

    public static WebElement txtbx_Phone(WebDriver driver){
    	
    	try {

	    element = driver.findElement(By.xpath("//input[@title='billingphone']"));
	    
	    Log.info("Billing Phone number found");
	    
	    return element;
	    
    		}catch (Exception e){
	    
	    Log.error("Billing Phone number is not found");
	    
	    throw(e);
	    
    		}

	}
    
    public static Select dropdown_Country(WebDriver driver){
    	
    		try {

    	    dropdown = new Select(driver.findElement(By.id("wpsc_checkout_form_7")));
    	    
    	    Log.info("Dropdownbox  Country found");
    	    
    	    return dropdown;
    	    
    		}catch (Exception e){
    	    
    	    Log.error("Dropdownbox Country is not found");
    	    
    	    throw(e);
    	    
    		}

	}
    
    public static WebElement txtbx_State(WebDriver driver){
    	
    		try {

	    element = driver.findElement(By.xpath("//input[@title='billingstate']"));
	    
	    Log.info("Billing State number found");
	    
	    return element;
	    
    		}catch (Exception e){
	    
	    Log.error("Billing State number is not found");
	    
	    throw(e);
	    
    		}

	}
    
    public static WebElement txtbx_ShipState(WebDriver driver){
    	
    		try {

	    element = driver.findElement(By.xpath("//input[@title='shippingstate']"));
	    
	    Log.info("Shipping State number found");
	    
	    return element;
	    
    		}catch (Exception e){
	    
	    Log.error("Shipping State number is not found");
	    
	    throw(e);
	    
    		}

	}
    
    public static WebElement purchase_btn(WebDriver driver){
    	
    		try {

	    element = driver.findElement(By.xpath("//input[@value='Purchase']"));
	    
	    Log.info("Purchase button found");
	    
	    return element;
	    
    		}catch (Exception e){
	    
	    Log.error("Purchase button is not found");
	    
	    throw(e);
	    
    		}

	}
}
