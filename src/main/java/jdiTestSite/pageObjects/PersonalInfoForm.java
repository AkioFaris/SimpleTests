package jdiTestSite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoForm {
	@FindBy(xpath = "//*[@id='Name']")
	private WebElement name;

	@FindBy(xpath = ".//*[@id='LastName']")
	private WebElement lastName;

	@FindBy(xpath = ".//*[@id='Description']") 
	private WebElement descr;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement submitBtn;

	public PersonalInfoForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean elementsAreVisible() {
		return name.isDisplayed() && lastName.isDisplayed() && descr.isDisplayed() && submitBtn.isDisplayed();
	}

	public void submitFullName(String firstNameStr, String lastNameStr) {
		name.sendKeys(firstNameStr);
		lastName.sendKeys(lastNameStr);
		submitBtn.click();
	}
	
	public void fill(String firstNameStr, String lastNameStr, String descrStr) {
		if (firstNameStr != null)
			name.sendKeys(firstNameStr);
		if (lastNameStr != null)
			lastName.sendKeys(lastNameStr);
		if (descrStr != null) {
			descr.clear();
			descr.sendKeys(descrStr);
		}
		name.click();
	}

	public void submit(String firstNameStr, String lastNameStr, String descrStr) {
		fill(firstNameStr, lastNameStr, descrStr);
		submitBtn.click();
	}

}
