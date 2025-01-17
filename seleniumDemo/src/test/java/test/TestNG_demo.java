package test;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webpage.demoPage;

public class TestNG_demo{
	
	// class variable
	private static WebDriver driver = null;
	private static String rgbColor = "";
	
	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumbase.io/demo_page");
	}

	
	@Test
	public void testInputFieldFilled() {

		// Inputting value into text field
		demoPage.textInputField(driver).click();
		demoPage.textInputField(driver).sendKeys("MAPS is boring");
		
		// verifying if field is filled correctly
		String inputValue = demoPage.textInputField(driver).getAttribute("value");
		Assert.assertFalse("Input field is empty", inputValue.isEmpty());
		Assert.assertEquals("MAPS is boring", inputValue);
	}
	
	
	@Test
	public static void getRgbColorTest() {
		// grabbing RGB color from HTML SVG
		demoPage.svgRgbColor(driver).click();
		rgbColor = demoPage.svgRgbColor(driver).getAttribute("stroke");
		System.out.println("RGB Color: " + rgbColor);
	}
	
	
	@Test
	public static void iFrameCheckBoxTest() {		
		// switch to iFrame
		driver.switchTo().frame("frameName3");
		// click on check box
		demoPage.iFrameCheckBox(driver).click();
		
		// confirming check box is clicked
		boolean isCheckBoxSelected = demoPage.iFrameCheckBox(driver).isSelected();
		Assert.assertTrue("Checkbox is clicked", isCheckBoxSelected);
	}
	
	
	@Test
	public static void selectDropDownTest() {
		// switch back to browser
		driver.switchTo().defaultContent();
		// click on drop down
		Select dropdown = demoPage.selectDropDown(driver);
		dropdown.selectByValue("50%");
		
		// asserting HTML meter changes to selected drop down
		String value = driver.findElement(By.id("meterBar")).getAttribute("value");
		double actualValue = Double.parseDouble(value);
		String formattedActualValue = String.format("%.0f%%", actualValue * 100);
		Assert.assertEquals("50%", formattedActualValue);
	}
		
	
	@AfterTest
	public void tearDownTest() {
		
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}
	
}
