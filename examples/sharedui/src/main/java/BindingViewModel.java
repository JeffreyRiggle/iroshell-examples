package examples.sharedui;

import javafx.beans.property.SimpleStringProperty;

public class BindingViewModel {

	private SimpleStringProperty _text;
	
	public BindingViewModel() {
		_text = new SimpleStringProperty();
	}
	
	public SimpleStringProperty textProperty() {
		return _text;
	}
}
