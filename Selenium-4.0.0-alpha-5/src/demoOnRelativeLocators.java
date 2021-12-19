import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class demoOnRelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 *    selenium 4.0 Relative Locators:
		 *    
		 *    		above() : Element located above with respect to the specified element
					Below() : Element located below with respect to the specified element
					toLeftOf() : Element located to the left of specified element
					toRightOf() : Element located to the right of the specified element.

						Syntax:

								driver.findElement(withTagName("XX").above(webElement))
		 */

		
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//input[@name='name']
		//input[@name='name' and @class='form-control ng-untouched ng-pristine ng-invalid']
		
		// WebElement webElement = chromeDriver.findElement(By.xpath("//input[@name='name' and @class='form-control ng-untouched ng-pristine ng-invalid']" ));
		Thread.sleep(2000);
		
		WebElement aboveWebElement = chromeDriver.findElement(By.cssSelector("input[name='name']"));
		System.out.println(chromeDriver.findElement(withTagName("label").above(aboveWebElement)).getText());
		

		Thread.sleep(2000);
		
		WebElement belowWebElement = chromeDriver.findElement(By.xpath("//label[@for='dateofBirth']"));
		chromeDriver.findElement(withTagName("input").below(belowWebElement)).sendKeys("20/10/2021");
		
		
		
		WebElement rightWebElement = chromeDriver.findElement(By.cssSelector("#inlineRadio1"));
		System.out.println(chromeDriver.findElement(withTagName("label").toRightOf(rightWebElement)).getText());
		
		
		/* 
		WebElement leftWebElement = chromeDriver.findElement(By.cssSelector("label[for='inlineRadio2']"));
		chromeDriver.findElement(withTagName("input").toLeftOf(leftWebElement)).click();
		*/
		
		// WebElement leftWebElement = chromeDriver.findElement(By.xpath("//label[text()='Employed']"));
		chromeDriver.findElement(By.cssSelector("#inlineRadio2")).click();
		// chromeDriver.findElement(withTagName("input").toLeftOf(leftWebElement)).click();
		
		Thread.sleep(2000);
		//chromeDriver.close();
		
	}

}
