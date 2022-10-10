package buttons;

import events.PasswordEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

public class ConfirmButton  extends GUIButton implements EventHandler<ActionEvent>{

	public ConfirmButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent arg0) {
		SecurityContext.instance().handleEvent(PasswordEvent.instance());
	}

}
