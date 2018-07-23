package apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.CdPlayer;

public class App {
	
	public static void main(String[] argv) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("config.xml");
		
		CdPlayer cdPlayer = (CdPlayer) context.getBean("CdPlayer");
		cdPlayer.play();
		System.out.println(cdPlayer.getDescription());
		
		context.close();
	}
	
}
