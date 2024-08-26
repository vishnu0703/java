package com.RunnerClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {
	@Test
	private void fileData() throws AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.filemail.com/share/upload-file");
		driver.findElement(By.xpath("//span[text()='Add Files']")).click();
		
		Robot r = new Robot();
		r.delay(2000);
		StringSelection ss = new StringSelection("C:\\Users\\VISHNU\\OneDrive\\Pictures\\Screenshots\\interface.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		

	}

}
