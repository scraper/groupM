package seleniumTests;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import pageFactory.MetaWeatherCityPage;
import pageFactory.MetaWeatherMainPage;

public class UiTest {
	WebDriver driver;
	MetaWeatherMainPage weather;
	MetaWeatherCityPage cityWeather;
	
	@BeforeMethod
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		
		driver.get("https://www.metaweather.com/");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void viewWeather() {
		weather = new MetaWeatherMainPage(driver);
		weather.searchCityWeather("Berlin");
		cityWeather = new MetaWeatherCityPage(driver);
		
		Assert.assertTrue(cityWeather.location.getText().contains("Berlin"));
	}
	
	@Test
	public void viewDetailedWeather() {
		weather = new MetaWeatherMainPage(driver);
		weather.searchCityWeather("Berlin");
		cityWeather = new MetaWeatherCityPage(driver);
		cityWeather.openWeatherToday();
		Calendar cal = Calendar.getInstance();
		String date = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		
		Assert.assertTrue(driver.getTitle().contains("Berlin"));
		Assert.assertTrue(driver.getTitle().contains(date));
	}
}
