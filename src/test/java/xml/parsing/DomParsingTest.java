package xml.parsing;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParsingTest {
	private Document document = null;

	@BeforeMethod
	public void createDom() {
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = documentBuilder.parse("src\\test\\resources\\document.xml");
		} catch (ParserConfigurationException | SAXException | IOException ex) {
			ex.printStackTrace(System.out);
		}
	}

	private String getTagTextContent(Document document, String tagXpath) throws XPathExpressionException {
		XPathFactory pathFactory = XPathFactory.newInstance();
		XPath xpath = pathFactory.newXPath();
		XPathExpression expr = xpath.compile(tagXpath);
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		if (nodes.getLength() == 0)
			return null;
		return nodes.item(0).getTextContent();
	}

	@Test
	public void checkCoutryTag() {
		if (document != null) {
			try {
				String country = getTagTextContent(document, "//country");
				Assert.assertEquals(country, "HONG_KONG");
			} catch (XPathExpressionException ex) {
				ex.printStackTrace(System.out);
			}
		} else
			System.out.println("Documnet was not opened.");
	}

	@Test
	public void checkParagrapthTitle() {
		if (document != null) {
			try {
				String title = getTagTextContent(document, "//paragraph[@id='593ASECT1']/title");
				Assert.assertTrue(title.contains("Section"));
			} catch (XPathExpressionException ex) {
				ex.printStackTrace(System.out);
			}
		} else
			System.out.println("Documnet was not opened.");
	}
	
	private int countTagOccurrences(Document document, String tagXpath) throws XPathExpressionException {
		XPathFactory pathFactory = XPathFactory.newInstance();
		XPath xpath = pathFactory.newXPath();
		XPathExpression expr = xpath.compile(tagXpath);
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		return nodes.getLength();
	}
	
	@Test
	public void checkHeadingTagNumber() {
		if (document != null) {
			try {
				int numOfOccurr = countTagOccurrences(document, "//heading");
				Assert.assertTrue(numOfOccurr > 1);
				System.out.println("Number of tag 'heading' occurrences: " + numOfOccurr);
			} catch (XPathExpressionException ex) {
				ex.printStackTrace(System.out);
			}
		} else
			System.out.println("Documnet was not opened.");
	}


}
