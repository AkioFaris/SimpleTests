package jdiTestSite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoForm {
	@FindBy(xpath = "//*[@id='Name']")
	public WebElement name;

	@FindBy(xpath = ".//*[@id='LastName']")
	public WebElement lastName;

	@FindBy(xpath = ".//*[@id='Description']")
	public WebElement descr;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement submitBtn;

	public PersonalInfoForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
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
		submit();
	}

	public void submit() {
		submitBtn.submit();
	}

}
