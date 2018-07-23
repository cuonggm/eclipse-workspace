package apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.NewbiePlayer;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("config.xml");
		NewbiePlayer newbie = (NewbiePlayer) context.getBean("NewbiePlayer");
		newbie.doMission();
		context.close();
	}

}
