package aspects;

public class Logger {
	
	public void beforeAction() {
		System.out.println("LOG: Preparing Disk");
	}
	
	public void afterAction() {
		System.out.println("LOG: Finished disk");
	}
	
}
