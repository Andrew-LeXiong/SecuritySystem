package states;

public class DoorClosedState extends SecurityState {
	private static DoorClosedState instance;
private DoorClosedState() {
		
	}
	
	public static DoorClosedState instance() {
		if(instance==null)
			instance= new DoorClosedState();
		return instance;
		
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
