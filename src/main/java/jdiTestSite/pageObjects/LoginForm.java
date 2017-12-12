package jdiTestSite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginForm {
	@FindBy(xpath = "//div[@class='profile-photo']/following-sibling::span")
	public WebElement caret;

	@FindBy(xpath = "//input[@id='Login']")
	public WebElement userLogin;

	@FindBy(xpath = "//input[@id='Password']")
	public WebElement password;

	@FindBy(xpath = "//input[@id='Password']/ancestor::*/button")
	public WebElement submitBtn;

	@FindBy(xpath = "//span[contains(text(),'Logout')]/..")
	public WebElement logoutBtn;

	@FindBy(xpath = "//div[@class='profile-photo']/span")
	public WebElement profile;

	LoginForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String user, String pass) {
		caret.click();
		userLogin.sendKeys(user);
		password.sendKeys(pass);
		submitBtn.click();
	}

	public void verifyUserName(String username) {
		Assert.assertTrue(profile.getText().equalsIgnoreCase(username));
	}
	
	public void logout() {
		caret.click();
		logoutBtn.click();
	}
}
