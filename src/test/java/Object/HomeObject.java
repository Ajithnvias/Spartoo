package Object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeObject {
	
public ChromeDriver driver;
	
	public HomeObject(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[@id='callNumber']")
	WebElement customerId;
	
	public WebElement customerId()
	{
		return customerId;
	}
	
	@FindBy(xpath="//span[@id=\"call_horaires\"]")
	WebElement callhour;
	
	public WebElement callhour()
	{
		return callhour;
	}
	
	@FindBy(xpath="//div[@class='text_topLivraison']")
	WebElement location;
	
	public WebElement location()
	{
		return location;
	}
	
	@FindBy(xpath = "//div[@class='cookies_info']/div/div[3]/button[1]")
	WebElement cookies;
	
	public WebElement cookie()
	{
		return cookies;
	}
	
	public WebElement searchBox()
	{
		By searchBox = By.xpath("//form[@class='search headerSearch']/input");
		return driver.findElement(searchBox);
		
	}
	
	
	
	public List<WebElement> searchlist()
	{
		By searchlist = By.xpath("//div[@id='completeDiv']/div/span");
		return driver.findElements(searchlist);
	}
	
	public WebElement scroll1()
	{
		By Scroll1 = By.xpath("//div[@id='homeContent']/div[6]/div[1]");
		return driver.findElement(Scroll1);
	}
	
	public List<WebElement> shoemodelname()
	{
		By shoemodelname = By.xpath("//div[@class='home_carousel 8']/div/div/a[2]/span");
		return driver.findElements(shoemodelname);
	}

}
