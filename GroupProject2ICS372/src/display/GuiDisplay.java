package display;

import buttons.AwayButton;
import buttons.CancelButton;
import buttons.ConfirmButton;
import buttons.GUIButton;

import CheckBoxes.GUICheckBox;
import CheckBoxes.ZoneOne;
import CheckBoxes.ZoneTwo;
import CheckBoxes.ZoneThree;
import buttons.MotionDetectedButton;
import buttons.NumberButton;
import buttons.StayButton;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.SecurityContext;

public class GuiDisplay extends Application implements SecurityDisplay {
	private GUIButton awayButton;
	private GUIButton stayButton;
	private GUIButton cancelButton;
	private GUIButton motionButton;
	private GUIButton oneButton;
	private GUIButton twoButton;
	private GUIButton threeButton;
	private GUIButton fourButton;
	private GUIButton fiveButton;
	private GUIButton sixButton;
	private GUIButton sevenButton;
	private GUIButton eightButton;
	private GUIButton nineButton;
	private GUIButton zeroButton;
	private GUIButton confirmButton;
	private GUICheckBox zone1;
	private GUICheckBox zone2;
	private GUICheckBox zone3;
	private TextArea textArea;
	private Text stateStatus = new Text("Not ready");
	private Text timerValue = new Text("         ");
	private SecurityContext securityContext;
	private static SecurityDisplay display;

	public static SecurityDisplay getInstance() {
		return display;
	}

	@Override
	public void showTimeLeft(int time) {
		timerValue.setText("" + time);
	}

	@Override
	public void showAway() {
		stateStatus.setText("Away State");
		textArea.setText("House Armed! Any zones opened or movement will trigger alarm");
	}

	@Override
	public void showStay() {
		stateStatus.setText("Stay State");
		textArea.setText("House Armed! Any zones opened will notifiy police");
	}

	@Override
	public void showUnready() {
		stateStatus.setText("Unready State");
		textArea.setText("House cannot be armed yet close all zones");
	}

	@Override
	public void showReady() {
		stateStatus.setText("Ready State");		
		textArea.setText("House is ready to be armed");
	}

	@Override
	public void showWarning() {
		stateStatus.setText("Warning State");
		textArea.setText("Enter Password or police will be called");
	}
	@Override 
	public void showLeave() {
		stateStatus.setText("Warning State");
		textArea.setText("House will be armed soon");
	}

	@Override
	public void showCancel() {
		stateStatus.setText("Cancel State");
		textArea.setText("Enter Password to cancel. Police will be called if not correct");
	}

	@Override
	public void showAlarmed() {
		stateStatus.setText("Alarm State");
		textArea.setText("Policed have been Called.");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		 textArea = new TextArea();
		GridPane topPane = new GridPane();
		GridPane finalPane = new GridPane();

		securityContext = SecurityContext.instance();
		securityContext.setDisplay(this);
		display = this;

		awayButton = new AwayButton("Away");
		stayButton = new StayButton("Stay");
		motionButton = new MotionDetectedButton("Motion Detector");
		cancelButton = new CancelButton("Cancel");
		zone1 = new ZoneOne("Zone 1");
		zone2 = new ZoneTwo("Zone 2");
		zone3 = new ZoneThree("Zone 3");

		oneButton = new NumberButton("1");
		twoButton = new NumberButton("2");
		threeButton = new NumberButton("3");
		fourButton = new NumberButton("4");
		fiveButton = new NumberButton("5");
		sixButton = new NumberButton("6");
		sevenButton = new NumberButton("7");
		eightButton = new NumberButton("8");
		nineButton = new NumberButton("9");
		zeroButton = new NumberButton("0"); 
		confirmButton = new ConfirmButton("Confirm");
		
		// text area:
		GridPane textPane = new GridPane();
		textArea.setPrefWidth(350);
		textArea.setPrefHeight(100);
		textPane.add(textArea, 0, 1);
		textArea.setText("Hello");

		// number pad area:
		GridPane numPane = new GridPane();
		numPane.add(oneButton, 1, 1);
		numPane.add(twoButton, 2, 1);
		numPane.add(threeButton, 3, 1);
		numPane.add(fourButton, 1, 2);
		numPane.add(fiveButton, 2, 2);
		numPane.add(sixButton, 3, 2);
		numPane.add(sevenButton, 1, 3);
		numPane.add(eightButton, 2, 3);
		numPane.add(nineButton, 3, 3);
		numPane.add(zeroButton, 2, 4);
		numPane.add(confirmButton, 3, 4);

		// button area:
		GridPane buttonPane = new GridPane();
		buttonPane.setPrefHeight(80);
		buttonPane.setHgap(10);
		buttonPane.setVgap(10);

		buttonPane.add(zone1, 0, 0);
		buttonPane.add(zone2, 1, 0);
		buttonPane.add(zone3, 2, 0);
		buttonPane.add(stayButton, 3, 0);
		buttonPane.add(awayButton, 4, 0);
		buttonPane.add(cancelButton, 5, 0);
		buttonPane.add(motionButton, 4, 1);
		buttonPane.add(stateStatus, 1, 1);
		buttonPane.add(timerValue, 2, 1);

		topPane.add(numPane, 0, 0);
		topPane.add(textPane, 1, 0);
		finalPane.add(topPane, 0, 0);
		finalPane.add(buttonPane, 0, 1);
		Scene scene = new Scene(finalPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Security System");
		try {
			while (securityContext == null) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}
}
