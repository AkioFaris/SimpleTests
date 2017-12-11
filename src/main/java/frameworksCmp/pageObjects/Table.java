package frameworksCmp.pageObjects;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Table {

	@FindBy(css = ".table.table-striped th")
	private List<WebElement> tblHeaderElems;

	@FindBy(css = ".table.table-striped td")
	private List<WebElement> tblBodyElems;

	private List<String> headerList;
	private int bodyElemsNum;
	private int colNum;

	public Map<String, LinkedHashMap<String, String>> tblMap;

	public Table(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyRowKeysContains(String rowName) {
		Map<String, String> firstColumn = tblMap.get(headerList.get(1));
		Long numOfMatches = firstColumn.entrySet().stream()
				.filter(item -> item.getKey().toLowerCase().equals(rowName.toLowerCase())).count();
		return (numOfMatches > 0);
	}

	public boolean verifyColContainsValue(String colName, String value) {
		Map<String, String> column = tblMap.get(colName);
		Long numOfMatches = new Long(0);
		if (column != null)
			numOfMatches = column.entrySet().stream()
					.filter(item -> item.getValue().toLowerCase().equals(value.toLowerCase())).count();
		return (numOfMatches > 0);
	}

	public String getValue(String colName, String rowName) {
		return tblMap.get(colName).get(rowName);
	}

	public void fillTblMap() {
		bodyElemsNum = tblBodyElems.size();
		colNum = tblHeaderElems.size();
		tblMap = new LinkedHashMap<String, LinkedHashMap<String, String>>();

		/* Convert lists of WebElements to lists of Strings */
		headerList = tblHeaderElems.stream().map(el -> el.getText()).collect(Collectors.toList());
		List<String> bodyList = tblBodyElems.stream().map(el -> el.getText()).collect(Collectors.toList());

		for (int iCol = 1; iCol < colNum; ++iCol) {
			LinkedHashMap<String, String> row = new LinkedHashMap<String, String>();
			tblMap.put(headerList.get(iCol), row);
		}

		for (int iElem = 0; iElem < bodyElemsNum; iElem += colNum) {
			String rowName = "";
			for (int iCol = 0; iCol < colNum; ++iCol) {
				String elemValue = bodyList.get(iElem + iCol);
				if (iCol == 0) { // if this is a first column
					rowName = elemValue;
				} else {
					String colName = headerList.get(iCol);
					String rowValue = elemValue;
					tblMap.get(colName).put(rowName, rowValue);
				}
			}
		}
	}
}
