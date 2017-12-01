package beans;

import org.openqa.selenium.WebDriver;

public class WebDriverBean {
	private String driverClassName = null;
	private WebDriver driver = null;

	public WebDriverBean(String driverClassName)
	{
		this.driverClassName = driverClassName;
	}
	
	public WebDriver getWebDriver() {
		if (driverClassName != null)
		{
			Class<?> driverClass;
			try {
				driverClass = Class.forName(driverClassName);
				driver = (WebDriver) driverClass.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();			
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
}
