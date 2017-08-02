package examples.sharedui;

import ilusr.core.ioc.ServiceManager;
import ilusr.iroshell.services.ITabContent;
import ilusr.iroshell.services.ITabContentBluePrint;

public class WebBrowserViewBluePrint implements ITabContentBluePrint {

	@Override
	public ITabContent create() {
		return ServiceManager.getInstance().<WebBrowserContentTab>get("WebBrowserContentTab");
	}

	@Override
	public ITabContent create(String customData) {
		WebBrowserContentTab tab = ServiceManager.getInstance().<WebBrowserContentTab>get("WebBrowserContentTab");
		tab.customData().set(customData);
		return tab;
	}

}
