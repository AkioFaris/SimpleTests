package frameworksCmp;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TableTest extends HotFrameworksSiteInitializer {
	
	
	@BeforeMethod
	public void beforeTest() {
		/* Open test site by URL */
		naigateToApiUrl(HotFrameworksUrl);
		
		table.fillTblMap();
	}

	@Test
	public void verifyRowKeyIsPresent() {
		String frameworkName = "Koa";
		
		/* Verify that frameworkName exists among row keys */
		Assert.assertTrue(table.verifyRowKeysContains(frameworkName));
	}
	
	@Test
	public void verifyRowKeyIsNotPresent() {
		String frameworkName = "Matryoshka";
		
		/* Verify that frameworkName doesn't exist among row keys */
		Assert.assertFalse(table.verifyRowKeysContains(frameworkName));
	}
	
	@Test
	public void verifyColumnContainsValue() {
		String colName = "Github Score";
		String value = "100";
		
		/* Verify that column colName contains the value */
		Assert.assertTrue(table.verifyColContainsValue(colName, value));
	}
}
