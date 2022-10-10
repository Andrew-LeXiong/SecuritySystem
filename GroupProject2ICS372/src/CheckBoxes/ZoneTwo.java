package CheckBoxes;

import events.CloseDoorEvent;
import events.OpenDoorEvent;
import javafx.event.ActionEvent;
import states.SecurityContext;
import states.DoorClosedState;
import states.DoorOpenState;
public class ZoneTwo extends GUICheckBox{

	public ZoneTwo(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent arg0) {
		if(this.isSelected()==false) {
			SecurityContext.instance().setZoneTwo(DoorOpenState.instance());
			SecurityContext.instance().handleEvent(OpenDoorEvent.instance());
			
		}
		else {
			SecurityContext.instance().setZoneTwo(DoorClosedState.instance());
			SecurityContext.instance().handleEvent(CloseDoorEvent.instance());
		}
		
		
	}

}
