package states;

import events.AwayEvent;
import events.OpenDoorEvent;
import events.StayEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

public class ReadyState extends SecurityState implements Notifiable {
	private static ReadyState instance;
	Timer timer;

	private ReadyState() {

	}

	public static ReadyState instance() {
		if (instance == null) {
			instance = new ReadyState();
		}
		return instance;
	}

	public void handleEvent(OpenDoorEvent event) {
		SecurityContext.instance().changeState(UnReadyState.instance());
	}

	public void handleEvent(AwayEvent event) {
		
		SecurityContext.instance().changeState(WarningStateAway.instance());
	}

	public void handleEvent(StayEvent event) {
		SecurityContext.instance().changeState(WarningStateStay.instance());
	}

	

	@Override
	public void enter() {
		SecurityContext.instance().showReady();
	}

	@Override
	public void leave() {
		SecurityContext.instance().showTimeLeft(0);
		
	}
}
