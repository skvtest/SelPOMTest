import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestSteps {
	//FirefoxDriver driver = null;
	
	WebDriver driver = null;
	@Test
	public void SetUp(){
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D://swati//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://axa.trials.ca.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		
	@Test(priority=0)
	public void login(){
		// login into admin page
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("amar");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("dost1234!");
		driver.findElement(By.xpath(".//*[@id='tenant_id']")).sendKeys("for-automation3");
		driver.findElement(By.xpath(".//*[@id='sppSignInBtn']")).click();
	}
	
	@Test(priority=1)
	public void clickingPerf(){
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,30);
		//this wait is included to verify if the element is visible before clicking,
		// as in some cases, link was not available, and No such element exception was thrown.
		//implicit wait is also included to see if the element is displayed. However, below mention
		// wait condition is suffix to verify.
		WebElement element = wait.until(
		           ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='t_nav_sub_performance']")));

		//click on performance link
		driver.findElement(By.xpath(".//*[@id='t_nav_sub_performance']")).click();
				
		//clicking on the list box and selecting "Last 7 Days"
		Select droplist_1 = new Select(driver.findElement(By.xpath(".//*[@id='t_select_dateRange']")));   
		droplist_1.selectByIndex(1);
				
		//clicking on the list box and selecting "By Day"
		Select droplist_2 = new Select(driver.findElement(By.xpath(".//*[@id='t_select_aggregation']")));   
				droplist_2.selectByIndex(0);
	
	}
	
	@Test(priority=2)
	public void toolTipValue(){
		
		//this is used for mouse hovering on the data.
		Actions ToolTip1 = new Actions(driver);
		//this xpath will move the element focus on the main content.
		//WebElement toolTipValue = driver.findElement(By.xpath(".//*[@id='t_performance_httprequest']/div/div[2]/div/div[2]/div/div/div[2]"));
		WebElement toolTipValue = driver.findElement(By.xpath(".//*[@id='t_performance_httprequest']/div/div[2]/div/div[2]/div/div/div[1]/div/h6"));
		//This xpath will move the focus on to the inner element 
		//ToolTip1.moveToElement(toolTipValue).moveToElement(driver.findElement(By.xpath("(.//*[@class='tooltip-container'])[2]//h6")));
		ToolTip1.moveToElement(toolTipValue);
		ToolTip1.click().build().perform();
		
		String ToolTipText = toolTipValue.getAttribute("title");
		Assert.assertEquals(ToolTipText, "Nov 12, 2016");
	}
		
	@AfterClass
	public void tearDown(){
		//closing the browser instances
		driver.close();
		
	}

}
