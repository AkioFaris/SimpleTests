package jdiTestSite.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdiTestSite.enums.ContFormElem;

public class RightSection {
	@FindBy(xpath = "//div[contains(text(),'Log')]/following-sibling::*")
	private WebElement logPanel;

	@FindBy(xpath = "//div[contains(text(),'Result')]/following-sibling::*")
	private WebElement resultPanel;

	@FindBy(xpath = "//*[@class='panel-body-list logs']/li")
	private List<WebElement> logList;

	@FindBy(xpath = "//*[@class='panel-body-list results']/li")
	private List<WebElement> resultList;

	public RightSection(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean elementsAreVisible() {
		return logPanel.isDisplayed() && resultPanel.isDisplayed();
	}

	public boolean logContains(ContFormElem contFormEl, String value) {
		boolean contains = false;
		contains = logList.parallelStream()
				.filter(entry -> entry.getText().contains(contFormEl.tag) && entry.getText().contains(value)).findAny()
				.isPresent();
		return contains;
	}
	
	/* This method is similar to the method above, but also uses WebDriverWait */
	public boolean logContains(WebDriver driver, ContFormElem contFormEl, String value) {
		boolean contains = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[@class='panel-body-list logs']/li[contains(text(),'" + value + "')]")));
		} catch (NoSuchElementException e) {
			contains = false;
		}
		return contains;
	}

	public boolean resultContains(ContFormElem contFormEl, String value) {
		boolean contains = false;
		contains = resultList.parallelStream()
				.filter(entry -> entry.getText().contains(contFormEl.tag) && entry.getText().contains(value)).findAny()
				.isPresent();
		return contains;
	}
	
	/* This method is similar to the method above, but also uses WebDriverWait */
	public boolean resultContains(WebDriver driver, ContFormElem contFormEl, String value) {
		boolean contains = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//*[@class='panel-body-list results']/li[contains(text(),'" + value + "')]")));
		} catch (NoSuchElementException e) {
			contains = false;
		}
		return contains;
	}
}
