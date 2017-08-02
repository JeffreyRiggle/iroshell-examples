package examples.sharedui;

import examples.sharedui.WebBrowserView;
import ilusr.iroshell.services.TabContent;

public class WebBrowserContentTab extends TabContent {

	public WebBrowserContentTab(WebBrowserView view) {
		super.content().set(view);
		super.titleGraphic("Web Browser");
		super.toolTip().set("Web Browser view");
		super.canClose().set(true);
	}
}
