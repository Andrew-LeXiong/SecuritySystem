package states;

import events.PasswordEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class CancelState extends SecurityState implements Notifiable {
	private static CancelState instance;
	private Timer timer;

	private CancelState() {
		instance = this;
	}

	public static CancelState instance() {
		if (instance == null) {
			instance = new CancelState();
		}
		return instance;

	}
/*

 
	public void handleEvent(TimerRanOutEvent event) {
		SecurityContext.instance().changeState(AlarmState.instance());

	}
	*/

	public void handleEvent(PasswordEvent event) {
		if (SecurityContext.instance().getPassword()
				.equalsIgnoreCase(SecurityContext.instance().getPasswordEntered())) { /// Will have to Implement the
																						/// passcode Event
			SecurityContext.instance().changeState(UnReadyState.instance());/// make sure to change to NotReady State
		}
		else{

		}
		SecurityContext.instance().setPasswordEntered("");
	}
	/*
	public void handleEvent(TimerTickedEvent event) {
		SecurityContext.instance().showTimeLeft(timer.getTimeValue());
	}
	*/

	@Override
	public void enter() {
		
		SecurityContext.instance().showCancel();
		SecurityContext.instance().setPasswordEntered("");

	}

	@Override
	public void leave() {
		SecurityContext.instance().showTimeLeft(0);

	}
}
