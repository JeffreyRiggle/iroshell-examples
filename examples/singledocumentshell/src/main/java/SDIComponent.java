package singledocumentshell.src.main.java;

import java.util.Map;
import java.util.TreeMap;

import ilusr.iroshell.main.IComponent;
import ilusr.iroshell.main.LoadData;
import ilusr.iroshell.services.LayoutService;
import ilusr.iroshell.statusbar.IStatusBarService;
import javafx.scene.Node;
import examples.sharedui.*;

public class SDIComponent implements IComponent{

	private LayoutService _layoutService;
	private IStatusBarService _statusBarService;
	
	@Override
	public void load(LoadData data) {
		_layoutService = data.serviceManager().<LayoutService>get("LayoutService");
		_statusBarService = data.serviceManager().<IStatusBarService>get("IStatusBarService");
		
		Map<String, Node> viewMap = buildViewMap();
		TreeSelector selector = new TreeSelector(viewMap);
		
		_statusBarService.hideWhenEmpty().set(true);
		
		try {
			_layoutService.setSelector(selector);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Map<String, Node> buildViewMap() {
		Map<String, Node> retVal = new TreeMap<String, Node>();
		retVal.put("Notepad", new NotepadView());
		retVal.put("WebView", new WebBrowserView());
		retVal.put("Binding", new BindingView());
		return retVal;
	}
}
