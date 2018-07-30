package com.cuong.gettingstarted;

import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {

	public String getMessage() {
		return "Hello World";
	}
	
}
