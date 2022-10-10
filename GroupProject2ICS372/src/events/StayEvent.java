package events;

public class StayEvent extends SecurityEvent{
	private static StayEvent instance;
	
	private StayEvent() {
		
	}
	
	
	
	public static StayEvent instance() {
		if(instance==null) {
			instance= new StayEvent();
		}
		return instance;
	}
}
