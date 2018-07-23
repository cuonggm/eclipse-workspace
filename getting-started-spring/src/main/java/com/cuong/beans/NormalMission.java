package com.cuong.beans;

import com.cuong.interfaces.Mission;

public class NormalMission implements Mission {

	@Override
	public void start() {
		System.out.println("Doing Normal Mission");
	}

}
