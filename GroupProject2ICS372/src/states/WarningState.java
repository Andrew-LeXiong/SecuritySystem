package states;

import events.PasswordEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class WarningState extends SecurityState implements Notifiable {
	private static WarningState instance;
	private Timer timer;

	private WarningState() {

	}

	public static WarningState instance() {
		if (instance == null)
			instance = new WarningState();
		return instance;
	}

	public void handleEvent(TimerRanOutEvent event) {
		SecurityContext.instance().changeState(AlarmState.instance());
	}

	public void handleEvent(PasswordEvent event) {
		if (SecurityContext.instance().getPassword()
				.equalsIgnoreCase(SecurityContext.instance().getPasswordEntered())) {
			SecurityContext.instance().changeState(UnReadyState.instance());
		}
		SecurityContext.instance().setPasswordEntered("");
	}

	public void handleEvent(TimerTickedEvent event) {
		SecurityContext.instance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 15);
		SecurityContext.instance().showTimeLeft(timer.getTimeValue());
		SecurityContext.instance().showWarning();
		SecurityContext.instance().setPasswordEntered("");
	}

	@Override
	public void leave() {
		timer.stop();
		SecurityContext.instance().showTimeLeft(0);
	}
}
