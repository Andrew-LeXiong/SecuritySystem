package states;

import display.SecurityDisplay;
import events.AwayEvent;
import events.CancelEvent;
import events.CloseDoorEvent;
import events.MotionDetectedEvent;
import events.OpenDoorEvent;
import events.PasswordEvent;
import events.StayEvent;

public class SecurityContext {
	private SecurityDisplay display;
	private SecurityState ZoneOne;
	private SecurityState ZoneTwo;
	private SecurityState ZoneThree;
	private SecurityState currentState;

	private static String password = "1234";
	private String passwordEntered = "";
	private static SecurityContext instance;

	private SecurityContext() {
		instance = this;
		currentState = UnReadyState.instance();
		ZoneOne = DoorOpenState.instance();
		ZoneTwo = DoorOpenState.instance();
		ZoneThree = DoorOpenState.instance();
	}

	public SecurityState getCurrentState() {
		return currentState;
	}

	public String getPasswordEntered() {
		return passwordEntered;
	}
	
	public void addToPassword(int num) {
		passwordEntered += num;
	}

	public SecurityState getZoneOne() {
		return ZoneOne;
	}

	public void setZoneOne(SecurityState zoneOne) {
		ZoneOne = zoneOne;
	}

	public SecurityState getZoneTwo() {
		return ZoneTwo;
	}

	public void setZoneTwo(SecurityState zoneTwo) {
		ZoneTwo = zoneTwo;
	}

	public SecurityState getZoneThree() {
		return ZoneThree;
	}

	public void setZoneThree(SecurityState zoneThree) {
		ZoneThree = zoneThree;
	}

	public static SecurityContext instance() {
		if (instance == null)
			instance = new SecurityContext();
		return instance;
	}

	public void changeState(SecurityState state) {
		currentState.leave();
		currentState = state;
		currentState.enter();
	}

	public void changeZoneState1(SecurityState state) {
		ZoneOne = state;
	}

	public void changeZoneState2(SecurityState state) {
		ZoneTwo = state;
	}

	public void changeZoneState3(SecurityState state) {
		ZoneThree = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPasswordEntered(String passwordEntered) {
		this.passwordEntered = passwordEntered;
	}

	public void setDisplay(SecurityDisplay display) {
		this.display = display;
	}

	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}

	public void handleEvent(AwayEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(MotionDetectedEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(CancelEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PasswordEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(StayEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(OpenDoorEvent event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(CloseDoorEvent event) {
		currentState.handleEvent(event);
	}

	public void checkClosed() {
		if ((ZoneOne.equals(DoorClosedState.instance())) && (ZoneTwo.equals(DoorClosedState.instance()))
				&& (ZoneThree.equals(DoorClosedState.instance()))) {
			this.changeState(ReadyState.instance());
		}
		
	}
	public void checkClosedClock() {
		if ((ZoneOne.equals(DoorClosedState.instance())) && (ZoneTwo.equals(DoorClosedState.instance()))
				&& (ZoneThree.equals(DoorClosedState.instance()))) {
			this.changeState(AwayState.instance());
		}
		else {
			this.changeState(UnReadyState.instance());
		}
		
	}
	public void checkClosedClock2() {
		if ((ZoneOne.equals(DoorClosedState.instance())) && (ZoneTwo.equals(DoorClosedState.instance()))
				&& (ZoneThree.equals(DoorClosedState.instance()))) {
			this.changeState(StayState.instance());
		}
		else {
			this.changeState(UnReadyState.instance());
		}
		
	}
	

	public void showAway() {
		display.showAway();
	}

	public void showStay() {
		display.showStay();
	}

	public void showAlarm() {
		display.showAlarmed();
	}

	public void showUnready() {
		display.showUnready();
	}

	public void showReady() {
		display.showReady();
	}

	public void showWarning() {
		display.showWarning();
	}

	public void showCancel() {
		display.showCancel();
	}
	public void showLeave() {
		display.showLeave();
	}

}
