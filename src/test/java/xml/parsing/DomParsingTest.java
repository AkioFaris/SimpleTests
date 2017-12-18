package xml.parsing;

import static utils.DomHandler.countTagOccurrences;
import static utils.DomHandler.getTagTextContent;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DomParsingTest {
	private Document document = null;

	@BeforeMethod
	public void createDom() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		document = documentBuilder.parse("src\\test\\resources\\document.xml");
	}

	@Test
	public void checkCoutryTag() throws XPathExpressionException {
		Assert.assertNotNull(document);

		String country = getTagTextContent(document, "//country");
		Assert.assertEquals(country, "HONG_KONG");
	}

	@Test
	public void checkParagrapthTitle() throws XPathExpressionException {
		Assert.assertNotNull(document);

		String title = getTagTextContent(document, "//paragraph[@id='593ASECT1']/title");
		Assert.assertTrue(title.contains("Section"));
	}

	@Test
	public void checkHeadingTagNumber() throws XPathExpressionException {
		Assert.assertNotNull(document);
		
		int numOfOccurr = countTagOccurrences(document, "//heading");
		Assert.assertTrue(numOfOccurr > 1);
		System.out.println("Number of tag 'heading' occurrences: " + numOfOccurr);
	}

}
