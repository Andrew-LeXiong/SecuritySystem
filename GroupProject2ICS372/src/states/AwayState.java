package states;

import events.CancelEvent;
import events.MotionDetectedEvent;
import events.OpenDoorEvent;
import timer.Notifiable;

public class AwayState extends SecurityState implements Notifiable {
	private static AwayState instance;

	private AwayState() {
	}

	public static AwayState instance() {
		if (instance == null) {
			instance = new AwayState();
		}
		return instance;
	}

	public void handleEvent(MotionDetectedEvent event) {
		SecurityContext.instance().changeState(WarningState.instance());
	}

	public void handleEvent(OpenDoorEvent event) {
		SecurityContext.instance().changeState(WarningState.instance());
	}

	@Override
	public void enter() {
		SecurityContext.instance().showAway();
	}

	@Override
	public void leave() {
	}
}
