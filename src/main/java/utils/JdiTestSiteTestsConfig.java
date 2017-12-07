package utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jdiTestSite.User;

@Configuration
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

	@Bean
	public User user() {
		String login = "epam";
		String password = "1234";
		String name = "Piter Chailovskii";
		return new User(login, password, name);
	}
}
