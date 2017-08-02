package complexshell.src.main.java;

import java.net.URL;
import java.util.ResourceBundle;

import ilusr.iroshell.features.PreApplicationCompletionResult;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginView extends AnchorPane implements Initializable {

	@FXML
	private Button login;
	
	@FXML
	private Button exit;
	
	@FXML
	private TextField userName;
	
	@FXML
	private PasswordField password;
	
	private EventHandler<PreApplicationCompletionResult> handler;
	
	private PreApplicationCompletionResult event1;
	private PreApplicationCompletionResult event2;
	
	public LoginView() {
		event1 = new PreApplicationCompletionResult(false);
		event2 = new PreApplicationCompletionResult(true);
		
		FXMLLoader viewLoader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
		viewLoader.setRoot(this);
		viewLoader.setController(this);
		
		try {
			viewLoader.load();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		login.setOnAction((e) -> {
			login();
		});
		
		exit.setOnAction((e) -> {
			exit();
		});
		
		if (handler != null) {
			login.addEventHandler(event1.eventType(), handler);
			exit.addEventHandler(event2.eventType(), handler);
		}
	}
	
	public void setEventHandler(EventHandler<PreApplicationCompletionResult> handler) {
		if (login != null && this.handler != null) {
			login.removeEventHandler(event1.eventType(), this.handler);
			exit.removeEventHandler(event2.eventType(), this.handler);
		}
		
		this.handler = handler;
		
		if (login != null && handler != null) {
			login.addEventHandler(event1.eventType(), handler);
			exit.addEventHandler(event2.eventType(), handler);
		}
	}
	
	private void login() {
		if (handler == null) {
			return;
		}
		
		if (userName.getText().isEmpty() || password.getText().isEmpty()) {
			return;
		}
		
		login.fireEvent(event1);
	}
	
	private void exit() {
		if (handler == null) {
			return;
		}
		
		exit.fireEvent(event2);
	}
}
