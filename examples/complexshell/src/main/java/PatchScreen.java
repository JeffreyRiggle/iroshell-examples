package complexshell.src.main.java;

import ilusr.iroshell.features.IPreApplicationScreen;
import ilusr.iroshell.features.PreApplicationCompletionResult;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PatchScreen implements IPreApplicationScreen{

	private PatchView patchView;
	
	public PatchScreen() {
		patchView = new PatchView();
	}
	
	@Override
	public void run(Stage stage) {
		stage.initStyle(StageStyle.UTILITY);
		stage.setTitle("Patch");
		stage.setScene(new Scene(patchView));
	}
	
	@Override
	public void setOnCompleted(EventHandler<PreApplicationCompletionResult> handler) {
		patchView.setEventHandler(handler);
	}

}
