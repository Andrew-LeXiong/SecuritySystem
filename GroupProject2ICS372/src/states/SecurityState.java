package states;

import events.AwayEvent;
import events.CancelEvent;
import events.CloseDoorEvent;
import events.MotionDetectedEvent;
import events.OpenDoorEvent;
import events.PasswordEvent;
import events.StayEvent;
import events.TimerRanOutEvent;
import events.TimerTickedEvent;

public abstract class SecurityState {
	public abstract void enter();
	public abstract void leave();
	
	public void handleEvent(AwayEvent event) {
		
	}
	
	public void handleEvent(CancelEvent event) {
		
	}
	public void handleEvent(MotionDetectedEvent event) {
		
	}
	
	public void handleEvent(PasswordEvent event) {
		
	}
	
	public void handleEvent(StayEvent event) {
		
	}
	
	
	public void handleEvent(TimerRanOutEvent event) {
		
	}
	public void handleEvent(TimerTickedEvent event) {
		
	}
	public void handleEvent(OpenDoorEvent event) {
		
	}
	public void handleEvent(CloseDoorEvent event) {
		
	}
	
	
	

}
