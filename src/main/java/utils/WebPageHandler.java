package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageHandler {
	private WebDriver driver;

	@FindBy(xpath = "//html")
	private WebElement html;

//	private Actions builder;

	public WebPageHandler(WebDriver driver) {
		this.driver = driver;
//		builder = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	public void zoomOutByPct(Integer percentage) {
		String pct = percentage.toString();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.body.style.zoom='" + pct + "70%';");
		//executor.executeScript("document.body.style.webkitTransform='scale(0.3)';"); - wrong effect 
	}

	public void zoomOutByNumb(Integer number) {
		// builder.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT)).build();
		for (int i = 0; i < number; ++i) {
			// This doesn't work:
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

			// This doesn't work either:
			// builder.perform();
		}

	}
}
