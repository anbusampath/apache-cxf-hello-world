package io.anbu.cxf.demo;

import org.springframework.stereotype.Component;

@Component
public class WelcomeComponent {

	public String welcomeMessage() {
		return "Welcome to CXF RS Spring Boot World!!!";
	}
}
