package com.cuong.beans;

import com.cuong.interfaces.Mission;

public class ProPlayer {
	
	private Mission mission;

	public ProPlayer(Mission mission) {
		super();
		this.mission = mission;
	}
	
	public void doMission() {
		mission.start();
	}

}
