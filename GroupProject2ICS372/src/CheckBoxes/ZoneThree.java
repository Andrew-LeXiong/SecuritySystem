package CheckBoxes;

import events.CloseDoorEvent;
import events.OpenDoorEvent;
import javafx.event.ActionEvent;
import states.SecurityContext;
import states.DoorClosedState;
import states.DoorOpenState;
public class ZoneThree extends GUICheckBox{

	public ZoneThree(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent arg0) {
		if(this.isSelected()==false) {
			SecurityContext.instance().setZoneThree(DoorOpenState.instance());
			SecurityContext.instance().handleEvent(OpenDoorEvent.instance());
			
		}
		else {
			SecurityContext.instance().setZoneThree(DoorClosedState.instance());
			SecurityContext.instance().handleEvent(CloseDoorEvent.instance());
		}
		
		
	}

}
