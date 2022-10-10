package states;

import events.CloseDoorEvent;

public class DoorOpenState extends SecurityState{
	private static DoorOpenState instance;
private DoorOpenState() {
		
	}
	
	public static DoorOpenState instance() {
		if(instance==null)
			instance= new DoorOpenState();
		return instance;
		
	}
	public void handleEvent(CloseDoorEvent event ) {
		
		
	}
	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}

}
