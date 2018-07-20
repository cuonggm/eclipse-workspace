package beans;

import interfaces.Mission;
import interfaces.Player;

public class NewbiePlayer implements Player {
	
	Mission mission;

	public NewbiePlayer(Mission mission) {
		super();
		this.mission = mission;
	}

	@Override
	public void doMission() {
		mission.mission();
	}
	
}
