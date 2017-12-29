package jdiTestSite;

import static utils.DataHandler.readPersInfFromFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatesPageTest extends JdiSiteInitializer {

	@BeforeMethod
	public void testPreparation() {
		/* Open test site by URL */
		naigateToApiUrl(jdiTestSiteUrl);
		Assert.assertTrue(header.loginForm.caret.isDisplayed());

		/* Perform login */
		header.loginForm.login(userLogin, userPass);

		Assert.assertTrue(header.contactFormBtn.isDisplayed());

		/* Open Dates page */
		header.openDatesPage();

		Assert.assertTrue(rightSect.logPanel.isDisplayed());
		Assert.assertTrue(rightSect.resultPanel.isDisplayed());
	}

	@Test
	public void verifyInfoSubmitting() throws IOException, URISyntaxException, InterruptedException {
		String iPersInfoPath = "\\src\\test\\resources\\personal_info.txt";
		String imgPath = "\\src\\test\\resources\\yaeji.jpeg";
		String imgFileName = "yaeji.jpeg";
		String date = "12/04/2017";

		List<String> personalInfo = readPersInfFromFile(iPersInfoPath);
		Assert.assertTrue(personalInfo.size() >= 3);
		String firstName = personalInfo.get(0);
		String lastName = personalInfo.get(1);
		String descr = personalInfo.get(2);
		Integer[] range1 = {60, 80};
		Integer[] range2 = {20, 80};
		

		Assert.assertTrue(persInfoForm.name.isDisplayed());
		Assert.assertTrue(persInfoForm.lastName.isDisplayed());
		Assert.assertTrue(persInfoForm.descr.isDisplayed());
		Assert.assertTrue(persInfoForm.submitBtn.isDisplayed());
		
		/*Set some date in the past*/
		datesPage.setDate(date);
		
		/*Set range1*/
		datesPage.setRange1(range1[0], range1[1]);

		/* Fill the form with first name, last name and description */
		persInfoForm.fill(firstName, lastName, descr);
		
		/* Upload an image*/
		datesPage.uploadImg(imgPath);

		/* Use waits to check that files information shows up in log field*/
		Assert.assertTrue(rightSect.logContains(firstName));
		Assert.assertTrue(rightSect.logContains(lastName));
		Assert.assertTrue(rightSect.logContains(descr));
		Assert.assertTrue(rightSect.logContains(imgFileName));

				
		/* Press submit */
//		persInfoForm.submit();
//		
//		/* Check the result: assert values for range 1 and range 2 and Name */
//		Assert.assertTrue(rightSect.resultContains(range2[0].toString()));
//		Assert.assertTrue(rightSect.resultContains(range2[1].toString()));
	}
}