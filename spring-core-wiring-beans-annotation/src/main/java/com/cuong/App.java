package com.cuong;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cuong.beans.CdConfig;
import com.cuong.beans.RealDisc;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(CdConfig.class);
		RealDisc disc = context.getBean(RealDisc.class);
		disc.play();
		System.out.println("Hello, World!");
		context.close();
	}
}
