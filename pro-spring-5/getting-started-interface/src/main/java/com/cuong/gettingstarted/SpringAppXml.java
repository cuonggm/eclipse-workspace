package com.cuong.gettingstarted;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppXml {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("app-context.xml");
		
		MessageRenderer messageRenderer =
				context.getBean(StandardOutMessageRenderer.class);
		messageRenderer.render();
		
		context.close();
	}
	
}
