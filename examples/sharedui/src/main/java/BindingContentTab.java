package examples.sharedui;

import examples.sharedui.BindingView;
import ilusr.iroshell.services.TabContent;
import javafx.scene.control.MenuItem;

public class BindingContentTab extends TabContent{

	public BindingContentTab(BindingView view) {
		super.content().set(view);
		super.titleGraphic("Binding");
		super.toolTip().set("Binding view");
		super.canClose().set(true);
		super.customData().bind(view.model().textProperty());
		super.contextMenuItems().add(new MenuItem("Test Menu"));
	}
}
