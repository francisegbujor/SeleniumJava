package webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class demoPage {
	
	private static WebElement element = null;
	
	public static WebElement textInputField(WebDriver driver){
		element = driver.findElement(By.id("myTextInput"));
		return element;
	}
	
	
	public static WebElement svgRgbColor(WebDriver driver) {
		element = driver.findElement(By.xpath("(//*[name()='rect'][@id='svgRect'])[1]"));
		return element;
	}
	
	public static WebElement iFrameCheckBox(WebDriver driver) {
		element = driver.findElement(By.name("checkBoxName6"));
		return element;
	}
	
	public static Select selectDropDown(WebDriver driver) {
		WebElement dropdownElement = driver.findElement(By.name("selectName"));
		return new Select(dropdownElement);
	}

}
