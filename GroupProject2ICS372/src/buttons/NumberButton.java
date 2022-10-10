package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

public class NumberButton extends GUIButton implements EventHandler<ActionEvent>{
	private String number;
	
	public NumberButton(String string) {
		super(string);
		this.number = string;
	}

	@Override
	public void handle(ActionEvent arg0) {
		SecurityContext.instance().addToPassword(Integer.parseInt(number));	
	}

	public String getNumber() {
		return number;
	}

}
