package beans.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageObjects.ContactForm;
import pageObjects.Log;


public class ContactFormPageBean {
   public String title;
   
   public void setTitle(String title)
   {
	   this.title = title;
   }
}
