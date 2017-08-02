package multipledocumentshell.src.main.java;

import ilusr.iroshell.services.IToolBarBluePrint;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class TestToolBarBluePrint implements IToolBarBluePrint {

	@Override
	public ToolBar create() {
		ToolBar tb = new ToolBar();
		tb.getItems().add(new Button("Test Button"));
		return tb;
	}

}
