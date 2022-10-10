package events;

public class CancelEvent extends SecurityEvent {
	private static CancelEvent instance;
	
	public static CancelEvent instance() {
		if(instance==null)
			instance= new CancelEvent();
	
	return instance;
	}
}
