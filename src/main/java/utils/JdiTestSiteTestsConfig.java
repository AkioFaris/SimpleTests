package utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class JdiTestSiteTestsConfig {

	@Bean
	public String jdiTestSiteUrl() {
		return "https://jdi-framework.github.io/tests";
	}

	@Bean
	public String homePageTitle() {
		return "Index Page";
	}

	@Bean
	public String contactFormPageTitle() {
		return "Contact Form";
	}
}
