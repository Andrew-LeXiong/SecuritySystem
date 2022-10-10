package events;

public class PasswordEvent extends SecurityEvent{
	private static PasswordEvent instance;

	public static PasswordEvent instance() {
		if(instance == null) {
			instance= new PasswordEvent();
		}
		return instance;
	}
}
