package CheckBoxes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

public abstract class GUICheckBox extends CheckBox implements EventHandler<ActionEvent> {
	public GUICheckBox(String string) {
		super(string);
		setOnAction(this);
	}

}
