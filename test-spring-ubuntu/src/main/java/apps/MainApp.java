package apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import interfaces.Player;

public class MainApp {
	
	public static void main(String[] argv) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("config.xml");
		Player player = (Player) context.getBean("CdPlayer");
		player.play();
		context.close();
	}
	
}
