package examples.sharedui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class BindingView extends AnchorPane implements Initializable{

	@FXML
	private BindingViewModel model;
	
	@FXML
	private TextArea typeArea;
	
	@FXML
	private Label viewArea;
	
	//TODO: Find a way to bind via the fxml file.
	public BindingView() {
		FXMLLoader bindingLoader = new FXMLLoader(getClass().getResource("BindingView.fxml"));
		bindingLoader.setRoot(this);
		bindingLoader.setController(this);
		
		try {
			bindingLoader.load();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public BindingViewModel model() {
		return model;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		model.textProperty().bindBidirectional(typeArea.textProperty());
		viewArea.textProperty().bind(model.textProperty());
	}
}
