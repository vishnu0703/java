package com.BaseClass;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class BaseClass {
	
	public static WebDriver driver;   
	
	public static ExtentReports extentReports;
	
	public static File file;
	
	// browser
	protected static WebDriver browserLaunch(String  browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		return driver;
	}
	
     // launching UrlLink
	protected static void launchingUrl(WebDriver driver, String urlLink) {
		try {
			driver.get(urlLink);
		} catch (Exception e) {
	
			e.printStackTrace();
			System.err.println("Error in Launch");
		}
	}
	
  // send keys
	protected static void inputPassing(WebDriver driver, WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("The errors in basemethod inputpassing");
		}
	}

	//navigation 
	
	protected static void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}
	
	protected static void navigateRefresh(WebDriver driver) {
		driver.navigate().refresh();
	} 
	
	protected static void navigateForward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	protected static void navigareTo(WebDriver driver,String element) {
		driver.navigate().to(element);
	}
	
	// action
	protected static void mouseAction(WebDriver driver,WebElement element, String action) {
		Actions act = new Actions(driver);
		if(action.equalsIgnoreCase("click")) {
			act.click(element).build().perform();
		} else if (action.equalsIgnoreCase("doubleclick")) {
			act.doubleClick(element).build().perform();
		} else if (action.equalsIgnoreCase("rightclick")) {
			act.contextClick(element).build().perform();
		}
	}
	
	//actiondrag and drop
	
	protected static void mouseDragandDrop(WebDriver driver,WebElement element1,WebElement element2,String action) {
		Actions act = new Actions(driver);
		act.dragAndDrop(element1, element2);
	}
    	
	// keyboard action
	
	protected static void keyboardAction(String key) throws AWTException {
		Robot keyboard = new Robot();
		keyboard.keyPress(KeyEvent.VK_ENTER);
	}
	
	
	//get click
	protected static void clickElement(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			 wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
	}
		}

	
	
	// get title
	protected static String getTitle(WebDriver driver) {
		
		String title = driver.getTitle();
		return title;
	}
	
	//get text
	protected static String getText(WebDriver driver,WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;
	}
	
	
	// AlertSimple
	protected static void SimAlert(WebDriver driver, String simple) {
		
	 driver.switchTo().alert();
		
	}
	
	// AlertConfirm
	protected static void confirmAlert(WebDriver driver, String Confirm) {
		
		driver.switchTo().alert();
		
	}
	
	
	//     simple DropDown
	protected static void selectDropdown(WebElement element, String selectBytype, String selectbyvalue) {
		Select dropdown = new Select(element);
		if (selectBytype.equalsIgnoreCase("text")) {
			dropdown.selectByVisibleText(selectbyvalue);
		} else if(selectBytype.equalsIgnoreCase("value")) {
			dropdown.selectByValue(selectbyvalue);
		} else if(selectBytype.equalsIgnoreCase("index")) {
			
			try {
				int index = Integer.parseInt(selectbyvalue);
				dropdown.selectByIndex(index);
				} catch(NumberFormatException e) {
					e.printStackTrace();
					System.err.println("Error in dropdown");
				}
		}
	}
	
	
	// quit
	protected static void terminateBrowser(WebDriver driver) {
		
		driver.quit();
	}
	
	// close
	protected static void closeBrowser(WebDriver driver) {
		driver.close();
	}
	
	//Screenshot
	protected static void takeScreenShot(String fileName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;                             
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destin = new File("C:\\Users\\VISHNU\\eclipse-workspace\\SeleniumTesting\\ScreensShot\\" + fileName +".png");
		FileHandler.copy(source, destin); 
	}
		
	
	// clear
	protected static void clear(WebDriver driver, WebElement element) {
		
		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Alert
	
	protected static void alertSimple() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
    protected static void alerConfirm() {
    	Alert a = driver.switchTo().alert();
    	a.dismiss();
    }
	
	protected static void alertprompt(WebElement element, String input) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(input);
	}
	
	
	
	// implicity wait
	
	protected static void implicityWait(WebDriver driver, int sec) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	
	
	}
	
	//window handles
	
	protected static void windowHandles(WebDriver driver, int value) {
		try {
			List<String> list = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(list.get(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void extentReportStart(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("Java.version"));
	}
	
	
	public static void extentReportTearDown(String location) throws IOException {
		extentReports.flush();
		file = new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}
 
	public String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("ScreenShort\\.png" + "_" + timeStamp + ".png");
		FileUtils.copyFile(scrfile, destfile);
		return destfile.getAbsolutePath();
	}
	
	public static void validation(WebDriver act, String ect) {
		Assert.assertEquals(act.getTitle(), ect);
	}
	
	public static void validationone(WebElement act, String ect) {
		Assert.assertEquals(act.getText(), ect);
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}
 
		
	}
	
	
	

	
	
	
	
	

