package jdiTestSite.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RightSection {
	@FindBy(xpath = "//div[contains(text(),'Log')]/following-sibling::*")
	public WebElement logPanel;

	@FindBy(xpath = "//div[contains(text(),'Result')]/following-sibling::*")
	public WebElement resultPanel;

	@FindBy(xpath = "//*[@class='panel-body-list logs']/li")
	private List<WebElement> logList;

	@FindBy(xpath = "//*[@class='panel-body-list results']/li")
	private List<WebElement> resultList;
	
	private WebDriver driver;

	public RightSection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean logContains(String contFormEl, String value) {
		return logList.parallelStream()
				.anyMatch(entry -> entry.getText().contains(contFormEl) && entry.getText().contains(value));
	}
	
	/* This method is similar to the method above, but also uses WebDriverWait */
	public boolean logContains(String value) {
		boolean contains = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[@class='panel-body-list logs']/li[contains(text(),'" + value + "')]")));
		} catch (TimeoutException e) {
			contains = false;
		}
		return contains;
	}

	public boolean resultContains(String contFormEl, String value) {
		return resultList.parallelStream()
				.anyMatch(entry -> entry.getText().contains(contFormEl) && entry.getText().contains(value));
	}
	
	/* This method is similar to the method above, but also uses WebDriverWait */
	public boolean resultContains(String value) {
		boolean contains = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[@class='panel-body-list results']/li[contains(text(),'" + value + "')]")));
		} catch (TimeoutException e) {
			contains = false;
		}
		return contains;
	}
}
