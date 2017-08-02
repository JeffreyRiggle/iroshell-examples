package examples.sharedui;

import java.net.URL;
import java.util.ResourceBundle;

import ilusr.core.ioc.ServiceManager;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class ThemeItem extends Label implements Initializable, IThemeListener{

	private final String CURRENT_THEME = "Current Theme: ";
	private final ThemeService _themeService;
	private ContextMenu _selectionMenu;
	
	public ThemeItem() {
		_themeService = ServiceManager.getInstance().<ThemeService>get("ThemeService");
		
		FXMLLoader themeLoader = new FXMLLoader(getClass().getResource("ThemeItem.fxml"));
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
		_themeService.addListener(this);
		_selectionMenu = new ContextMenu();
		buildContextMenu();
		super.contextMenuProperty().set(_selectionMenu);
		
		super.textProperty().set(CURRENT_THEME);
	}

	private void buildContextMenu() {
		for(String style : _themeService.getRegisteredStyles()) {
			MenuItem temp = new MenuItem(style);
			
			temp.setOnAction((e) -> {
				_themeService.changeStyle(temp.getText());
			});
			
			_selectionMenu.getItems().add(temp);
		}
	}
	
	@Override
	public void themeChanged(String theme) {
		super.textProperty().set(CURRENT_THEME + theme);
	}
}
