package beans;

import interfaces.Disk;

public class Cd implements Disk {

	private String title = "";
	
	@Override
	public String getContent() {
		return "CD Title: " + title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
