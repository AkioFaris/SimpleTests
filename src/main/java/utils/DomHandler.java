package utils;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class DomHandler {
	public static String getTagTextContent(Document document, String tagXpath) throws XPathExpressionException {
		XPathFactory pathFactory = XPathFactory.newInstance();
		XPath xpath = pathFactory.newXPath();
		XPathExpression expr = xpath.compile(tagXpath);
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		if (nodes.getLength() == 0)
			return "";
		return nodes.item(0).getTextContent();
	}

	public static int countTagOccurrences(Document document, String tagXpath) throws XPathExpressionException {
		XPathFactory pathFactory = XPathFactory.newInstance();
		XPath xpath = pathFactory.newXPath();
		XPathExpression expr = xpath.compile(tagXpath);
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		return nodes.getLength();
	}
}
