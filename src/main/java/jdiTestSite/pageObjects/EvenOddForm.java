package jdiTestSite.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jdiTestSite.enums.EvenNumb;
import jdiTestSite.enums.OddNumb;

public class EvenOddForm {
	@FindBy(xpath = "//input[@name='custom_radio_even']/..")
	private List<WebElement> evenNumbers;

	@FindBy(xpath = "//input[@name='custom_radio_odd']/..") 
	private List<WebElement> oddNumbers;

	@FindBy(xpath = "//p[@class='radio']/parent::*/following-sibling::*/button")
	private WebElement calcBtn;

	public EvenOddForm(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fill(EvenNumb even, OddNumb odd) { 
		WebElement evenRadio = evenNumbers.stream().filter(ev -> ev.getText().equals(even.number)).findAny().orElse(null);
		if (evenRadio != null)
			evenRadio.click();
		WebElement oddRadio = oddNumbers.stream().filter(od -> od.getText().equals(odd.number)).findAny().orElse(null);
		if (oddRadio != null)
			oddRadio.click();
		calcBtn.click();
	}

	public void submit(EvenNumb even, OddNumb odd) { 
		fill(even, odd);
		calcBtn.click();
	}
}
