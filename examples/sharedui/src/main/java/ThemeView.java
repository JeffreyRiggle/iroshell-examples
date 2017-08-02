package examples.sharedui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class ThemeView extends AnchorPane implements Initializable{
	
	@FXML
	private TextArea typeArea;
	
	@FXML
	private Label viewArea;
	
	//TODO: Find a way to bind via the fxml file.
	public ThemeView() {
		FXMLLoader themeLoader = new FXMLLoader(getClass().getResource("ThemeView.fxml"));
		themeLoader.setRoot(this);
		themeLoader.setController(this);
		
		try {
			themeLoader.load();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
