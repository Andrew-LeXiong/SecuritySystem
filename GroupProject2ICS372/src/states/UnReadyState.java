package states;

import events.CloseDoorEvent;

public class UnReadyState extends SecurityState {
	private static UnReadyState instance;

	private UnReadyState() {

	}

	public static UnReadyState instance() {
		if (instance == null) {
			instance = new UnReadyState();
		}
		return instance;
	}

	public void handleEvent(CloseDoorEvent event) {
		SecurityContext.instance().checkClosed();
	}

	@Override
	public void enter() {
		SecurityContext.instance().showUnready();
		///SecurityContext.instance().checkClosed();
	}

	@Override
	public void leave() {
	}
}
