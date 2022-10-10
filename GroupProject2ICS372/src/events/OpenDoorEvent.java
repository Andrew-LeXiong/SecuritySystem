package events;

public class OpenDoorEvent extends SecurityEvent{
	private static OpenDoorEvent instance;
	private OpenDoorEvent() {
		
	}
	public static OpenDoorEvent instance() {
		if (instance==null) {
			instance= new OpenDoorEvent();
		}
		return instance;
	}

}
