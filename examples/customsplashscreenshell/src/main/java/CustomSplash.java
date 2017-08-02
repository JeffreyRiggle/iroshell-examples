package customsplashscreenshell.src.main.java;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class CustomSplash extends GridPane{

	public CustomSplash() {
		FXMLLoader splashLoader = new FXMLLoader(getClass().getResource("CustomSplash.fxml"));
		splashLoader.setRoot(this);
		splashLoader.setController(this);
		
		try {
			splashLoader.load();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
