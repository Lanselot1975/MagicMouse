package test.java;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import utility.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestRunner {
	
    static{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

	public WebDriver driver;
	Properties prop = new Properties();
	InputStream input;

	  @Test (description="Go to http://store.demoqa.com/")
	  public void launchSite() {
		  
		    Log.startTestCase("Go to "+prop.getProperty("Website"));
		    
		    try {
		    	
		    	Log.info("Going to "+prop.getProperty("Website"));
				driver.get(prop.getProperty("Website"));
	    
		    	Log.info("Verifying http://store.demoqa.com/");
				WebDriverWait wait = new WebDriverWait(driver, 15);
		    	wait.until(ExpectedConditions.titleContains("ONLINE STORE"));
				assertEquals(driver.getTitle(), "ONLINE STORE | Toolsqa Dummy Test site");
			
		    }catch (Exception e){

		        Log.error("Error while executing Step 1 Test" + e);
		    }    
		    
		    finally {
		    	
		    	Log.endTestCase("STEP 1");
		    	
		    }
	  }
		
	  @Test (description="Go to Product category and select Accessories")
	  public void selectAccessories(){

		    Log.startTestCase("Go to Product category and select Accessories");
		    
		    try {
		    	
		    	Log.info("Accessories Tab");
				Actions actions = new Actions(driver);
				WebElement menu = Home.category_tab(driver);
				actions.moveToElement(menu);
				WebElement subMenu = Home.link_to_Accessories(driver);
				actions.moveToElement(subMenu);
		
			
				Log.info("Accessories page");
				actions.click().build().perform();
			
				Log.info("Verifying Accessories Page");
				WebDriverWait wait = new WebDriverWait(driver, 15);
		   	 	wait.until(ExpectedConditions.titleContains("Accessories"));
				assertEquals(driver.getTitle(), "Accessories | ONLINE STORE");
			//	assertEquals(driver.getTitle(), "Accessories");
			
		    }catch (Exception e){

		    	Log.error("Error while executing Step 2 Test" + e);
		    	
		    } 
		    
		    finally {
		    	
			Log.endTestCase("STEP 2");
			
		    }
	  }
	  
	  @Test (description="Click on “Add to Cart” for just Magic Mouse")
	  public void addMagicMouseToCart() throws InterruptedException {
		  
		  	Log.startTestCase("Click on “Add to Cart” for just Magic Mouse");
		  	
		  	try {
		  		
		  		Log.info("Add to Cart Button");
				Accessories.button_Add_Magic_Mouse(driver).click();
			
				Log.info("Verifying Item has been added");
				assertTrue(Accessories.item_added(driver));
			
		  	}catch (Exception e){

		    	Log.error("Error while executing Step 3 Test" + e);
		    	
		    } 
		  	
		  	finally {
		  		Log.endTestCase("STEP 3");
		  	}
			
			
	  }
	  
	  @Test (description="Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out Page")
	  public void checkoutAndConfirmMagicMouse() throws InterruptedException {

		  	Log.startTestCase("Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out Page");
		  	
		  	try {

		  		Log.info("Clicking Checkout Button");
				Home.link_to_Checkout(driver).click();

				Log.info("Verifying Checkout page");
				WebDriverWait wait = new WebDriverWait(driver, 10);
		    	wait.until(ExpectedConditions.titleContains("Checkout"));
				assertEquals(driver.getTitle(), "Checkout | ONLINE STORE");

				Log.info("Verifying 1 Magic Mouse");
				assertEquals(Checkout.get_Product_Name(driver),prop.getProperty("Product"));
				assertEquals(Checkout.get_Amount_oF_Order(driver),"1");
			
		  	} catch (Exception e){

		    	Log.error("Error while executing Step 4 Test" + e);
		    	
		    } 
			
		  	finally {
		  		Log.endTestCase("STEP 4");
		  	}

	  }	
	  
	  @Test (description="After confirming, click on Continue")
	  public void clickOnContinue() {

		  	Log.startTestCase("STEP 5: After confirming, click on Continue");
		  	
		  	try {

		  		Log.info("Clicking on Continue Button");
				Checkout.btn_continue(driver).click();

				Log.info("Verifying Checkout Page");
				WebDriverWait wait = new WebDriverWait(driver, 10);
		    	wait.until(ExpectedConditions.titleContains("Checkout"));
				assertEquals(driver.getTitle(), "Checkout | ONLINE STORE");
			
		  	} catch (Exception e){

		    	Log.error("Error while executing Step 5 Test" + e);
		    	
		    } 
			
			finally {
		  		Log.endTestCase("STEP 5");
		  	}

	  }
	  
			
	  @Test (description="Enter test data needed for email,  billing/contact details and billing/contact details and click Purchase")
	  public void enterBillDataAndPurchase() {
		  
	  	  Log.startTestCase("Enter test data needed for email,  billing/contact details and billing/contact details and click Purchase");

		  	try {
		  		
				Log.info("Entering on Billing User Data");
				Continue.txtbx_Email(driver).sendKeys(prop.getProperty("Email"));
				Continue.txtbx_Fname(driver).sendKeys(prop.getProperty("FName"));
				Continue.txtbx_Lname(driver).sendKeys(prop.getProperty("LName"));
				Continue.txtbx_Address(driver).sendKeys(prop.getProperty("Address"));
				Continue.txtbx_City(driver).sendKeys(prop.getProperty("City"));
				Continue.txtbx_Phone(driver).sendKeys(prop.getProperty("PhoneNumber"));
				Continue.dropdown_Country(driver).selectByVisibleText(prop.getProperty("Country"));
				Continue.txtbx_State(driver).sendKeys(prop.getProperty("State"));
				Continue.txtbx_ShipState(driver).sendKeys(prop.getProperty("State"));
			
				Log.info("Clicking Purchase Button");
				Continue.purchase_btn(driver).click();
			
		  	} catch (Exception e){

		    	Log.error("Error while executing Step 6 Test" + e);
		    	
		    }
		  	
		  	finally {
		  		Log.endTestCase("STEP 6");
		  	}
			
			
	  }	
			
	  @Test (description="Confirm that you have placed the Order in ‘Transaction Results’ page")
	  public void confirmOrder() {
		  
		  	Log.startTestCase("Confirm that you have placed the Order in ‘Transaction Results’ page");
		  	
		  	try {
		  	
				Log.info("Verifying Transaction Results Page");
				WebDriverWait wait = new WebDriverWait(driver, 15);
				wait.until(ExpectedConditions.titleContains("Transaction Results"));
				assertEquals(driver.getTitle(), "Transaction Results | ONLINE STORE");

				Log.info("Confirming the 1 Magic Mouse Order");
				assertEquals(Transaction.get_Product_Name(driver), prop.getProperty("Product"));
				assertEquals(Transaction.get_Amount_oF_Order(driver), "1");
		  	
		  	} catch (Exception e){

		    	Log.error("Error while executing Step 7 Test" + e);
		    	
		    }
		  	
		  	finally {
		  		Log.endTestCase("STEP 7");
		  	}
		  
	  }




	  @Parameters("browser")
	  @BeforeSuite(alwaysRun = true)
	  
	  public void setupBeforeSuite(String browser) throws IOException {
		  BasicConfigurator.configure();

		  input = new FileInputStream("data.properties");
		  prop.load(input);

		  Long impWait = Long.parseLong(prop.getProperty("Wait"));

		  try {

			 if(browser.equalsIgnoreCase("chrome")) {

				 System.setProperty("webdriver.chrome.driver", "chromedriver");

				 driver = new ChromeDriver();
			 }

			 else if(browser.equalsIgnoreCase("firefox")) {

				 System.setProperty("webdriver.gecko.driver", "geckodriver");

			     driver = new FirefoxDriver();
			 }
			 else{
				 System.setProperty("webdriver.gecko.driver", "operadriver");

				 driver = new OperaDriver();
			 }

			driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);

		  } catch(Exception e) {
			  throw new IllegalStateException("Can't start browser driver", e);
		  }

	     driver.manage().window().maximize();

	  }

	  @AfterSuite(alwaysRun = true)
	  public void setupAfterSuite() {

	      driver.quit();
		  
	  }
	  

}
