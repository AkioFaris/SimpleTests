package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactForm {
	@FindBy(xpath = "//*[@id='Name']")
	private WebElement name;

	@FindBy(xpath = ".//*[@id='LastName']")
	private WebElement lastName;

	@FindBy(xpath = "//BUTTON[@class='uui-button dark-blue']")
	private WebElement submit;

	public ContactForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
	}

	public void submitFullName(String firstNameStr, String lastNameStr) {
		name.sendKeys(firstNameStr);
		lastName.sendKeys(lastNameStr);
		submit.click();
	}

}
