package complexshell.src.main.java;

import ilusr.iroshell.features.IPreApplicationScreen;
import ilusr.iroshell.features.PreApplicationCompletionResult;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginScreen implements IPreApplicationScreen {

	private LoginView loginView;
	
	public LoginScreen() {
		loginView = new LoginView();
	}
	
	@Override
	public void run(Stage stage) {
		stage.initStyle(StageStyle.UTILITY);
		stage.setTitle("Login");
		stage.setScene(new Scene(loginView));
	}

	@Override
	public void setOnCompleted(EventHandler<PreApplicationCompletionResult> handler) {
		loginView.setEventHandler(handler);
	}
}
