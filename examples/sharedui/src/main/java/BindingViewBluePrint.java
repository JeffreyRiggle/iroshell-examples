package examples.sharedui;

import ilusr.core.ioc.ServiceManager;
import ilusr.iroshell.services.ITabContent;
import ilusr.iroshell.services.ITabContentBluePrint;

public class BindingViewBluePrint implements ITabContentBluePrint {

	@Override
	public ITabContent create() {
		return ServiceManager.getInstance().<BindingContentTab>get("BindingContentTab");
	}

	@Override
	public ITabContent create(String customData) {
		BindingContentTab tab = ServiceManager.getInstance().<BindingContentTab>get("BindingContentTab");
		((BindingView)tab.content().get()).model().textProperty().set(customData);
		return tab;
	}

}
