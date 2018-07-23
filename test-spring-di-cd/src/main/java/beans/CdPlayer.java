package beans;

import interfaces.Disk;
import interfaces.Player;

public class CdPlayer implements Player {

	private Disk disk;
	private String description = "";

	public CdPlayer(Disk disk) {
		this.disk = disk;
	}

	@Override
	public void play() {
		System.out.println(disk.getContent());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
