package themeshell.src.main.java;

import examples.sharedui.ThemeView;
import ilusr.iroshell.services.TabContent;

public class ThemeContentTab extends TabContent{

	public ThemeContentTab(ThemeView view) {
		super.content().set(view);
		super.titleGraphic("Theme");
		super.toolTip().set("Theme view");
		super.canClose().set(true);
	}
}
