import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoOnMultipleWindowsOrTabs {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// Handling multiple windows...
		
		chromeDriver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = chromeDriver.getWindowHandles();
		Iterator<String> handleIterator = handles.iterator();
		String parentHandle = handleIterator.next();
		String childHandle = handleIterator.next();
		chromeDriver.switchTo().window(childHandle);
		chromeDriver.get("https://courses.rahulshettyacademy.com/courses");
		String courseName = chromeDriver.findElement(By.cssSelector(".course-listing-subtitle")).getText();
		Thread.sleep(1000);
		chromeDriver.close();
		Thread.sleep(1000);
		chromeDriver.switchTo().window(parentHandle);

		WebElement courseNameWebElement = chromeDriver.findElement(By.cssSelector("input[name='name']"));
		courseNameWebElement.sendKeys(courseName);

		//	Capturing partial screen shots...
		File courseNameFile = courseNameWebElement.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(courseNameFile, new File("C:\\Users\\Vara\\courseName.png"));

		//  Capturing dimensions of UX elements...
		System.out.println("Height : " + courseNameWebElement.getRect().height);
		System.out.println("Width  : " + courseNameWebElement.getRect().width);
		
		System.out.println("Height : " + courseNameWebElement.getRect().getDimension().height);
		System.out.println("Width :  " + courseNameWebElement.getRect().getDimension().width);
		
		Thread.sleep(1000);
		chromeDriver.quit();
	}
}
