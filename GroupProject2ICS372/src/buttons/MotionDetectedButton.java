package buttons;

import events.MotionDetectedEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

public class MotionDetectedButton extends GUIButton implements  EventHandler<ActionEvent>{

	public MotionDetectedButton(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(MotionDetectedEvent.instance());
		// TODO Auto-generated method stub
		
	}

}
