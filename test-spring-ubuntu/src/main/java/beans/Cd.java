package beans;

import interfaces.Disk;

public class Cd implements Disk {

	private String title;
	
	public Cd() {
		super();
		this.title = "";
	}

	@Override
	public String getContent() {
		return title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
