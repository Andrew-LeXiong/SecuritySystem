package buttons;

import events.CancelEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

public class CancelButton extends GUIButton implements EventHandler<ActionEvent>{

	public CancelButton(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(CancelEvent.instance());
		
	}

}
