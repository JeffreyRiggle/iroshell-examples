package examples.sharedui;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ilusr.iroshell.services.RegistrationType;
import ilusr.iroshell.services.StyleContainerService;

public class ThemeService {

	private Map<String, Map<String, String>> _themeMap;
	private List<IThemeListener> _themeListeners;
	private StyleContainerService _styleService;

	public ThemeService(StyleContainerService styleService) {
		_styleService = styleService;
		_themeMap = new HashMap<String, Map<String, String>>();
		_themeListeners = new ArrayList<IThemeListener>();
	}

	public void addStyle(String style, Map<String, String> propertyFiles) {
		_themeMap.put(style, propertyFiles);
	}

	public void addListener(IThemeListener listener) {
		_themeListeners.add(listener);
	}

	public void removeListener(IThemeListener listener) {
		_themeListeners.remove(listener);
	}

	public List<String> getRegisteredStyles() {
		List<String> retVal = new ArrayList<String>();
		retVal.addAll(_themeMap.keySet());
		return retVal;
	}

	public void changeStyle(String style) {
		Map<String, String> styleMap = _themeMap.get(style);
		
		for(Entry<String, String> entry : styleMap.entrySet()) {
			try {
				_styleService.register(entry.getKey(), entry.getValue(), RegistrationType.Override);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for(IThemeListener listener : _themeListeners) {
			listener.themeChanged(style);
		}
	}
}
