package jdiTestSite.robotFrameworkTests;

import static jdiTestSite.enums.EvenNumb.EIGHT;
import static jdiTestSite.enums.EvenNumb.TWO;
import static jdiTestSite.enums.OddNumb.FIVE;
import static jdiTestSite.enums.OddNumb.THREE;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jdiTestSite.enums.EvenNumb;
import jdiTestSite.enums.OddNumb;

public class ContactFormPageTest extends JdiSiteInitializer {

	@BeforeMethod
	public void testPreparation() {
		/* Open test site by URL */
		naigateToApiUrl(jdiTestSiteUrl);

		Assert.assertTrue(header.loginForm.caret.isDisplayed());

		/* Perform login */
		header.loginForm.login(userLogin, userPass);

		Assert.assertTrue(header.contactFormBtn.isDisplayed());

		/* Open Contact form */
		header.openContactFormPage();

		Assert.assertTrue(rightSect.logPanel.isDisplayed());
		Assert.assertTrue(rightSect.resultPanel.isDisplayed());
	}

	@AfterMethod
	public void afterTest() {
		header.loginForm.logout();
	}

	@Test
	public void verifyPersonalInfoSubmitting() {
		String firstName = "Mahoko";
		String lastName = "Yoshimoto";
		String descr = "Also known as Banana Yoshimoto";

		Assert.assertTrue(persInfoForm.name.isDisplayed());
		Assert.assertTrue(persInfoForm.lastName.isDisplayed());
		Assert.assertTrue(persInfoForm.descr.isDisplayed());
		Assert.assertTrue(persInfoForm.submitBtn.isDisplayed());

		/*
		 * Input first, last name and description in text fields without clicking the
		 * submit button
		 */
		persInfoForm.fill(firstName, lastName, descr);

		Assert.assertTrue(rightSect.logContains(contFormPage.name, firstName));
		Assert.assertTrue(rightSect.logContains(contFormPage.lastNameLog, lastName));
		Assert.assertTrue(rightSect.logContains(descr));

		/* Input first, last name and description in text fields and click "submit" */
		persInfoForm.submit(firstName, lastName, descr);

		Assert.assertTrue(rightSect.logContains(contFormPage.submitLog, "clicked"));
		Assert.assertTrue(rightSect.resultContains(firstName));
		Assert.assertTrue(rightSect.resultContains(contFormPage.lastNameRes, lastName));
		Assert.assertTrue(rightSect.resultContains(contFormPage.descript, descr));
	}

	@Test
	public void verifyEvenOddSum() {
		EvenNumb even = EIGHT;
		OddNumb odd = THREE;
		Integer sum = even.addOdd(odd);

		/* Select even and odd numbers radio buttons */
		evenOddForm.fill(TWO, FIVE);

		Assert.assertTrue(rightSect.logContains(TWO.number));
		Assert.assertTrue(rightSect.logContains(contFormPage.summary, FIVE.number));

		/* Select even and odd numbers radio buttons and click "calculate" */
		evenOddForm.submit(even, odd);

		Assert.assertTrue(rightSect.logContains(contFormPage.submitLog, "clicked"));
		Assert.assertTrue(rightSect.resultContains(contFormPage.summary, sum.toString()));
	}
}
