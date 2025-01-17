package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import webpage.demoPage;

public class test_demoPage{
	
	// class variable
	private static WebDriver driver = null;
	private static String rgbColor = "";
	
	public static void main(String[] args) {
		// calls the demoTest method to perform the test
		demoTest();
	}
	

	public static void demoTest() {
		// Chrome driver setup
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			// go to the URL
			driver.get("https://seleniumbase.io/demo_page");
			
			// Inputting value into text field
			demoPage.textInputField(driver).click();
			demoPage.textInputField(driver).sendKeys("MAPS is boring");
			
			
			// grabbing RGB color from HTML SVG
			demoPage.svgRgbColor(driver).click();
			rgbColor = demoPage.svgRgbColor(driver).getAttribute("stroke");
			System.out.println("RGB Color: " + rgbColor);
			
			
			// switch to iFrame
			driver.switchTo().frame("frameName3");
			// click on check box
			demoPage.iFrameCheckBox(driver).click();
			
			
			// switch back to browser
			driver.switchTo().defaultContent();
			// click on drop down
			Select dropdown = demoPage.selectDropDown(driver);
			dropdown.selectByValue("50%");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close browser
			driver.close();
			driver.quit();
			System.out.println("Test Completed Successfully");
		}
		
		
		
	}
	
}
