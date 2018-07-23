package beans;

import interfaces.Disk;
import interfaces.Player;

public class CdPlayer implements Player {

	private Disk disk;
	
	public CdPlayer(Disk disk) {
		super();
		this.disk = disk;
	}

	@Override
	public void play() {
		System.out.println(disk.getContent());
	}

}