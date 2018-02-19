package utils;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* A facade for the DOM parser*/

public class DomHandler {

	public static Document parseDocument(String documentPath)
			throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		return documentBuilder.parse(documentPath);
	}

	public static String getTagTextByXpath(Document document, String tagXpath) throws XPathExpressionException {
		XPathFactory pathFactory = XPathFactory.newInstance();
		XPath xpath = pathFactory.newXPath();
		XPathExpression expr = xpath.compile(tagXpath);
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		if (nodes.getLength() == 0)
			return "";
		return nodes.item(0).getTextContent();
	}

	public static String getTagTextByTagName(Document document, String tagName) {
		NodeList nodes = document.getElementsByTagName(tagName);
		if (nodes.getLength() == 0)
			return "";
		return nodes.item(0).getTextContent();
	}

	public static int countTagOccurrences(Document document, String tagName) {
		NodeList nodes = document.getElementsByTagName(tagName);
		return nodes.getLength();
	}
}
