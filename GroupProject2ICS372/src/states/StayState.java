package states;

import events.CancelEvent;
import events.OpenDoorEvent;

public class StayState extends SecurityState {
	private static StayState instance;

	public static StayState instance() {
		if (instance == null) {
			instance = new StayState();

		}
		return instance;
	}

	public void handleEvent(OpenDoorEvent event) {
		SecurityContext.instance().changeState(AlarmState.instance());
	}

	@Override
	public void enter() {
		SecurityContext.instance().showStay();
	}
	public void handleEvent(CancelEvent event) {
		SecurityContext.instance().changeState(CancelState.instance());
	}

	@Override
	public void leave() {
	}
}
