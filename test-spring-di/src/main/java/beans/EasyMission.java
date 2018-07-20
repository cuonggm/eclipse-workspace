package beans;

import interfaces.Mission;

public class EasyMission implements Mission {

	@Override
	public void mission() {
		System.out.println("Doing Easy Mission");
	}

}
