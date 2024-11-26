package com.NutroFusion.CRM.generic.webdriverutility;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility_NFCRM {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void waitForElementVisibility(WebDriver driver, By locator, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


	public WebDriver launchbrowser(String browser) {
		WebDriver driver=null;
		try {

			if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equals("edge")) {
				driver = new EdgeDriver();
			}
		} catch (Exception E) {
			System.out.println("Browser Launch - issue");

		}

		return driver;
	}

	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String winid = it.next();
			driver.switchTo().window(winid);
			String actUrl = driver.getCurrentUrl();

			if (actUrl.contains(partialURL)) {
				break;
			}
		}

	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String winid = it.next();
			driver.switchTo().window(winid);
			String actUrl = driver.getCurrentUrl();

			if (actUrl.contains(partialTitle)) {
				break;
			}

		}

	}


	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void mouseMoveOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	

	public void quitwindow(WebDriver driver) {
		driver.quit();
		System.err.println("============ Window-Quit-success ========");
	}

	public void closewindow(WebDriver driver) {
		driver.close();
		System.err.println("============Window-Close-success==============");
	}

	public void maximizewindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimizewindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	
	public void takescreenshotdriver(WebDriver driver, String dstpath) throws IOException {
		Date d = new Date();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(dstpath + d.toString().replaceAll(":", "-") + ".jpeg");
		FileHandler.copy(src, dest);
	}



	public void screenrecord() throws AWTException {
		Robot act = new Robot();
		act.keyPress(KeyEvent.VK_WINDOWS);
		act.keyPress(KeyEvent.VK_ALT);
		act.keyPress(KeyEvent.VK_R);
		act.keyRelease(KeyEvent.VK_WINDOWS);
		act.keyRelease(KeyEvent.VK_ALT);
		act.keyRelease(KeyEvent.VK_R);

	}

	

	public void switchToWindowByTitle(WebDriver driver, String windowTitle) {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals(windowTitle)) {
				break;
			}
		}
	}

	

}
