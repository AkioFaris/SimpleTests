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

	public LoginForm loginForm;

	public Header(WebDriver driver) {
		PageFactory.initElements(driver, this);
		loginForm = new LoginForm(driver);
	}

	public void openContactFormPage() {
		contactFormBtn.click();
	}
}
