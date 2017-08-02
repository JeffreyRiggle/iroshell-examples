package examples.sharedui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

public class WebBrowserView extends AnchorPane implements Initializable{

	@FXML
	private WebView browser;
	
	@FXML
	private TextArea nav;
	
	public WebBrowserView() {
		FXMLLoader webLoader = new FXMLLoader(getClass().getResource("WebBrowserView.fxml"));
		webLoader.setRoot(this);
		webLoader.setController(this);
		
		try {
			webLoader.load();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		nav.styleProperty().set("-fx-background-color:#00ccff;");
		browser.getEngine().load("http://www.google.com");
		
		nav.setOnKeyPressed((e) -> {
			if (e.getCode() == KeyCode.ENTER) {
				e.consume();
				tryNavigate();
			}
		});
	}
	
	private void tryNavigate() {
		try {
			browser.getEngine().load(nav.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
