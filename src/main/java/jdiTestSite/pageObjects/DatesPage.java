package jdiTestSite.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DataHandler.executeScript;

import java.io.IOException;

public class DatesPage {
	// @FindBy(xpath = "//span[@class='up']/following-sibling::*")
	// @FindBy(xpath = "//span[@class='up']")
	@FindBy(xpath = "//span[@class='up']/..")
	private WebElement uploadImgBtn;

	public DatesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setRange1(Integer from, Integer to) {

	}

	public void setDate(String date) {

	}

	public void uploadImg(String imgPath) throws IOException {
		uploadImgBtn.click();
		executeScript("\\src\\test\\resources\\load_pic.exe");
		// uploadImgBtn.sendKeys(currentDirectory + imgPath);
	}

}
