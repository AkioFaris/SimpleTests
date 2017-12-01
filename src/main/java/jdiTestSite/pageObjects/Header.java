package jdiTestSite.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Header {
    @FindBy(xpath = "//A[@href='page1.htm'][text()='Contact form']")
    private WebElement contactFormBtn;
    
    public LoginForm loginForm;
 
	
	public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        loginForm = new LoginForm(driver);
	}

    public void openContactFormPage() {
    	contactFormBtn.click();
    }
}
