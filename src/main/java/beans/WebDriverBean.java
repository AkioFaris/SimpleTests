package beans;

import org.openqa.selenium.WebDriver;

public class WebDriverBean {
	private String driverClassName = null;
	private String systemPropertyKey = null;
	private String systemPropertyValue = null;
	private WebDriver driver = null;

	public WebDriverBean(String driverClassName, String systemPropertyKey, String systemPropertyValue) {
		this.driverClassName = driverClassName;
		this.systemPropertyKey = systemPropertyKey;
		this.systemPropertyValue = systemPropertyValue;
	}

	public WebDriver getWebDriver() {
		if (driverClassName != null) {
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

	public String getSystemPropertyKey() {
		return systemPropertyKey;
	}

	public String getSystemPropertyValue() {
		return systemPropertyValue;
	}
}
