package jdiTestSite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Log {
	@FindBy(xpath = "//ul[contains(@class, 'panel-body-list logs')]/li[1]\n")
	private WebElement log;

	public Log(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void verigyLogContains(String text) {
		Assert.assertTrue(log.getAttribute("textContent").contains(text));
	}
}
