package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebPageHandler {
	private WebDriver driver;

	private WebElement html;
	
	private Actions builder;

	public WebPageHandler(WebDriver driver) {
		this.driver = driver;
		html = driver.findElement(By.tagName("html"));
		builder = new Actions(driver);
	}

	public void zoomOutByPct(Integer percentage) {
		String pct = percentage.toString();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.body.style.zoom = '" + pct + "%'");
	}

	public void zoomOutByNumb(Integer number) {
		builder.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT)).build();
		for (int i = 0; i < number; ++i) {
			// This doesn't work:
			//html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			
			// This doesn't work either:
			builder.perform();
		}
	}

}
