package events;

public class CloseDoorEvent extends SecurityEvent{
	private static CloseDoorEvent instance;
	private CloseDoorEvent() {
		
	}
	public static CloseDoorEvent instance() {
		if (instance==null) {
			instance= new CloseDoorEvent();
		}
		return instance;
}
}
