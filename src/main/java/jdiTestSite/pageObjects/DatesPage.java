package jdiTestSite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DataHandler.executeScriptWithParam;
import static utils.DataHandler.currentDirectory;

import java.io.IOException;
import java.util.List;

public class DatesPage {
	@FindBy(xpath = "//span[@class='up']/..")
	private WebElement uploadImgBtn;
	
	@FindBy(xpath = "//span[contains(text(),'From')]/following-sibling::input")
	private List<WebElement> range1Input;
	
	@FindBy(xpath = "//div[@id='datepicker']/child::input")
	private WebElement dataInput;

	public DatesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setRange1(Integer from, Integer to) {
		range1Input.get(0).sendKeys(from.toString());
		range1Input.get(1).sendKeys(to.toString());
	}

	public void setDate(String date) {
		dataInput.sendKeys(date);
	}

	public void uploadImg(String imgLocalPath) throws IOException, InterruptedException {
		uploadImgBtn.click();
		executeScriptWithParam(currentDirectory + "\\src\\test\\resources\\load_pic.exe",
				currentDirectory + imgLocalPath);
	}

}
