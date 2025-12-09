package m2.Execise4;

public class MSWord extends Program {
	
	public MSWord(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		String message = "Opening MS Word...";
		this.setIsRunning(true);
		System.out.println(message);
	}
	
	@Override
	public void stop() {
		String message = "Stopping MS Word...";
		this.setIsRunning(false);
      System.out.println(message);
	}
}
