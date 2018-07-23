package com.cuong.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cuong.beans.SayHelloWorld;

public class TestApp {
	
	public static void main(String[] argv) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("say-hello-world.xml");
		
		SayHelloWorld sayHelloWorld = (SayHelloWorld) context.getBean("sayHelloWorld");
		sayHelloWorld.sayHello("I love u");
		context.close();
	}
	
}
