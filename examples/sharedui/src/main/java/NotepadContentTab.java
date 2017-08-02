package examples.sharedui;

import examples.sharedui.NotepadView;
import ilusr.iroshell.services.TabContent;

public class NotepadContentTab extends TabContent{

	public NotepadContentTab(NotepadView view) {
		super.content().set(view);
		super.titleGraphic("Notepad");
		super.toolTip().set("Notepad view");
		super.canClose().set(true);
	}
}
