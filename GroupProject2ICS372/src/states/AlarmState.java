package states;

import events.CancelEvent;
import timer.Notifiable;

public class AlarmState extends SecurityState implements Notifiable {
	private static AlarmState instance;

	private AlarmState() {
		instance = this;
	}

	public static AlarmState instance() {
		if (instance == null) {
			instance = new AlarmState();
		}
		return instance;
	}

	public void handleEvent(CancelEvent event) {
		SecurityContext.instance().changeState(CancelState.instance());
	}

	@Override
	public void enter() {
		SecurityContext.instance().showAlarm();
		
	}

	@Override
	public void leave() {
	}
}
