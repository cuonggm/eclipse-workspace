package com.cuong.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cuong.beans.ProPlayer;

public class TestMissionInjection {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("config.xml");
		
		ProPlayer proPlayer = (ProPlayer) context.getBean("ProPlayer");
		proPlayer.doMission();
		
		context.close();
	}

}
