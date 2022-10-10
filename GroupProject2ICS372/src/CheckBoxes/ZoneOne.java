package CheckBoxes;

import events.CloseDoorEvent;
import events.OpenDoorEvent;
import javafx.event.ActionEvent;
import states.SecurityContext;
import states.DoorClosedState;
import states.DoorOpenState;
public class ZoneOne extends GUICheckBox{

	public ZoneOne(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent arg0) {
		if(this.isSelected()==false) {
			SecurityContext.instance().setZoneOne(DoorOpenState.instance());
			SecurityContext.instance().handleEvent(OpenDoorEvent.instance());
			
		}
		else {
			SecurityContext.instance().setZoneOne(DoorClosedState.instance());
			SecurityContext.instance().handleEvent(CloseDoorEvent.instance());
		}
		
		
	}

}
