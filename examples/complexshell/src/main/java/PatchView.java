package complexshell.src.main.java;

import java.net.URL;
import java.util.ResourceBundle;

import ilusr.iroshell.features.PreApplicationCompletionResult;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

public class PatchView extends AnchorPane implements Initializable {

	@FXML
	private WebView webView;
	
	@FXML
	private Button cont;
	
	@FXML
	private Button exit;
	
	private EventHandler<PreApplicationCompletionResult> handler;
	
	private PreApplicationCompletionResult event1;
	private PreApplicationCompletionResult event2;
	
	public PatchView() {
		event1 = new PreApplicationCompletionResult(false);
		event2 = new PreApplicationCompletionResult(true);
		
		FXMLLoader viewLoader = new FXMLLoader(getClass().getResource("PatchView.fxml"));
		viewLoader.setRoot(this);
		viewLoader.setController(this);
		
		try {
			viewLoader.load();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		webView.getEngine().load(getClass().getResource("PatchInfo.html").toExternalForm());
		
		cont.setOnAction((e) -> {
			finish();
		});
		
		exit.setOnAction((e) -> {
			exit();
		});
		
		if (handler != null) {
			cont.addEventHandler(event1.eventType(), handler);
			exit.addEventHandler(event2.eventType(), handler);
		}
	}
	
	public void setEventHandler(EventHandler<PreApplicationCompletionResult> handler) {
		if (cont != null && this.handler != null) {
			cont.removeEventHandler(event1.eventType(), this.handler);
			exit.removeEventHandler(event2.eventType(), this.handler);
		}
		
		this.handler = handler;
		
		if (cont != null && handler != null) {
			cont.addEventHandler(event1.eventType(), handler);
			exit.addEventHandler(event2.eventType(), handler);
		}
	}
	
	private void finish() {
		if (handler == null) {
			return;
		}
		
		cont.fireEvent(event1);
	}
	
	private void exit() {
		if (handler == null) {
			return;
		}
		
		exit.fireEvent(event2);
	}
}
