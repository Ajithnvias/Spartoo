package TestScript;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonUtils.CommonMethods;
import Object.HomeObject;

public class HomePage {
	
	public ChromeDriver driver;
	public Logger log = LogManager.getLogger(HomePage.class);
	
	@Test(priority=0)
	public void cookies() throws IOException
	{
		driver = new ChromeDriver();
		
		CommonMethods cm = new CommonMethods();
		driver.get(cm.getProperty("Homeurl"));
		driver.manage().window().maximize();
		HomeObject ho = new HomeObject(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		ho.cookie().click();
		log.info(driver.getTitle());
		int i;
		
			
	}
	
	@Test(priority=1)
	public void title() throws IOException 
	{
		CommonMethods cm = new CommonMethods();
		HomeObject ho = new HomeObject(driver);
		String customerid = ho.customerId().getText();
		Assert.assertEquals(customerid, cm.getProperty("customernumber"));
		
		Actions action = new Actions(driver);
		action.moveToElement(ho.customerId()).perform();
		String call = ho.callhour().getText();
		
		String loc[]=ho.location().getText().split(" ");
		log.info(customerid);
		log.info(call);
		log.info(loc[3]);
			
	}
	
	@Test(priority=2)
	public void search() throws InterruptedException
	{
		CommonMethods cm = new CommonMethods();
		HomeObject ho = new HomeObject(driver);
		
		List<String> searchBox = cm.searchData();
		System.out.println(searchBox.size());
		for(String searchText:searchBox)
		{
			System.out.println(searchText);
			ho.searchBox().sendKeys(searchText);
			Thread.sleep(10000);
			List<WebElement> options = ho.searchlist();
			for(WebElement option : options)
			{
				System.out.println(option.getText());
			}	
			
			ho.searchBox().clear();
		}
	}
	
	@Test(priority=3, enabled=true)
	public void Shoes() throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scroll(0,3500)");
		 
		 List<WebElement> carousel =  driver.findElements(By.xpath("//div[@class='home_op_bg']/div[2]/div[@id='carousel_8']/div"));
		 
		 int size = carousel.size();
	   
		 for(int i = 1 ; i < size ; i++)
		 {
			 List<WebElement> productName = driver.findElements(By.xpath("//div[@class='home_op_bg']/div[2]/div[@id='carousel_8']/div["+i+"]/a[2]"));
			 for(WebElement name : productName)
			 {
				 System.out.println(name.getText());
				 List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='home_op_bg']/div[2]/div[@id='carousel_8']/div["+i+"]/a[4]"));
				 for(WebElement price : productPrice)
				 {
					 System.out.println(price.getText());
				 }
				 
				// productPrice.stream().map(s -> s.getText()).forEach(s -> System.out.println(s));
			 }
			 if(i == 6 || i == 9 || i == 12)
			 {
				 int step = 0;
					while(step < 2)
					{
					 WebElement bu = driver.findElement(By.cssSelector("div[class='home_carousel 8'] i[class='icon-flecheDroite suiv']")); 
					 bu.click();
					 step++;
					}
					Thread.sleep(10000);
			 }
		 }
	 
	}

		 
		 
		 
		
	}


