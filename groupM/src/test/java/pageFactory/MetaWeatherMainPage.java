package pageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MetaWeatherMainPage {
	WebDriver driver;
	
	@FindBy(name="q")
	WebElement query;
	
	public MetaWeatherMainPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void searchCityWeather(String city) {
		query.sendKeys(city);
		query.sendKeys(Keys.RETURN);
	}
}
