package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MetaWeatherCityPage extends MetaWeatherMainPage {

	public MetaWeatherCityPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[@class=\"col-lg-2 col-md-2 col-sm-2 col-xs-4 \"][1]//h2/a[1]")
	WebElement weatherToday;
	
	@FindBy(css=".location")
	public WebElement location;
	
	@FindBy(xpath="//dd[@class=\"weatherstate\"]")
	public WebElement weatherState;
	
	public void openWeatherToday() {
		weatherToday.click();
	}
}
