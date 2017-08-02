package examples.sharedui;

import ilusr.core.ioc.ServiceManager;
import ilusr.iroshell.services.ITabContent;
import ilusr.iroshell.services.ITabContentBluePrint;

public class NotepadViewBluePrint implements ITabContentBluePrint {

	@Override
	public ITabContent create() {
		return ServiceManager.getInstance().<NotepadContentTab>get("NotepadContentTab");
	}

	@Override
	public ITabContent create(String customData) {
		NotepadContentTab tab = ServiceManager.getInstance().<NotepadContentTab>get("NotepadContentTab");
		tab.customData().set(customData);
		return tab;
	}

}
