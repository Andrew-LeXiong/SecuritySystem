package buttons;

import events.AwayEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

public class AwayButton extends GUIButton implements EventHandler<ActionEvent>{

	public AwayButton(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(AwayEvent.instance());
		
	}
	

}
