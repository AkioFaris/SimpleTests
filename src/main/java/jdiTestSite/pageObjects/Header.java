package jdiTestSite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
	@FindBy(xpath = "//a[text()='Home']")
	public WebElement homeBtn;
	
	@FindBy(xpath = "//a[text()='Contact form']")
	public WebElement contactFormBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Service')]")
	public WebElement serviceBtn;
	
	@FindBy(xpath = "//a[text()='Dates']")
	public WebElement datesBtn;

	public LoginForm loginForm;

	public Header(WebDriver driver) {
		PageFactory.initElements(driver, this);
		loginForm = new LoginForm(driver);
	}

	public void openContactFormPage() {
		contactFormBtn.click();
	}
	
	public void openDatesPage() {
		serviceBtn.click();
		datesBtn.click();
	}
}
