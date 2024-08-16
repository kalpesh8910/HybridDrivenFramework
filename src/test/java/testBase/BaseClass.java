package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;	//log4j
import org.apache.logging.log4j.Logger;	//log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws Exception
	{
		
		 // Logging config.properties file
		 FileReader file = new FileReader("./src//test//resources//config.properties"); 
		 p = new Properties();
		 p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(br.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid browser name...");
		}
			
		// Delete all cookies
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Open the URL
		driver.get(p.getProperty("appURL"));
		
		// Maximize the window
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown()
	{
		// Close all browser window
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedstring =  RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomNumber()
	{
		String generatenumber = RandomStringUtils.randomNumeric(10);
		return generatenumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedstring =  RandomStringUtils.randomAlphabetic(3);
		String generatenumber = RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatenumber);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
