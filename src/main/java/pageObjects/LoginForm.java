package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginForm {
	@FindBy(css = ".fa-user")
	//@FindBy(xpath = "(//SPAN[@class='caret'])[2]")
	private WebElement caret;

	@FindBy(css = "#Login")
	private WebElement userLogin;

	@FindBy(css = "#Password")
	private WebElement password;

	@FindBy(css = ".fa-sign-in")
	private WebElement submit;

	@FindBy(css = ".profile-photo span")
	private WebElement profile;
	
	public LoginForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
	}

	public void login(String user, String pass) {
		caret.click();
		userLogin.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
	}

	public void verifyUserName(String username) {
		Assert.assertTrue(profile.getText().equalsIgnoreCase(username));
	}
}
