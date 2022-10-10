package buttons;

import events.StayEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

public class StayButton extends GUIButton implements EventHandler<ActionEvent>{

	public StayButton(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent arg0) {
		SecurityContext.instance().handleEvent(StayEvent.instance());
		
	}
	

}
