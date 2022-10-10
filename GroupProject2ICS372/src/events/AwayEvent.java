package events;

public class AwayEvent extends SecurityEvent {
	private static AwayEvent instance;
	
	private AwayEvent() {
		
	}
	
	
	public static AwayEvent instance() {
		if(instance==null) {
			instance= new AwayEvent();
		}
		return instance;
	}
}
