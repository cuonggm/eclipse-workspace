package com.cuong.beans;

import org.springframework.stereotype.Component;

@Component
public class RealDisc implements CompactDisc {

	private String title = "JAV-A";
	private String artist = "Maria Ozawa";
	
	@Override
	public void play() {
		System.out.printf("Playing %s of %s!\n", title, artist);
	}

}
