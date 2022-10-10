package start;
import display.GuiDisplay;
import display.SecurityDisplay;
import javafx.application.Application;
import states.SecurityContext;
import timer.Clock;

public class Main2 {

	public static void main(String[] args) {
		Clock.instance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GuiDisplay.class,null);
			}
			
		}.start();
		try {
			while (GuiDisplay.getInstance()==null) {
				Thread.sleep(1000);
			}
		}catch(InterruptedException ie) {	
		}
		SecurityDisplay display=GuiDisplay.getInstance();
		SecurityContext.instance().setDisplay(display);

	}

}
