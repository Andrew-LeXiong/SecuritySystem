package states;

import events.PasswordEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class WarningStateStay extends SecurityState implements Notifiable {
	private static WarningStateStay instance;
	private Timer timer;

	private WarningStateStay() {

	}

	public static WarningStateStay instance() {
		if (instance == null)
			instance = new WarningStateStay();
		return instance;
	}

	public void handleEvent(TimerRanOutEvent event) {
		SecurityContext.instance().checkClosedClock2();
	}

	

	public void handleEvent(TimerTickedEvent event) {
		SecurityContext.instance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 15);
		SecurityContext.instance().showTimeLeft(timer.getTimeValue());
		SecurityContext.instance().showLeave();
	}

	@Override
	public void leave() {
		timer.stop();
		SecurityContext.instance().showTimeLeft(0);
	}
}
