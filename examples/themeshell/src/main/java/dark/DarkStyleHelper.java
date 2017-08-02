package themeshell.src.main.java.dark;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ilusr.core.io.StreamUtilities;
import ilusr.iroshell.core.StyleArea;
import ilusr.iroshell.dockarea.overlay.OverlayStyleNames;

public class DarkStyleHelper {

	public static Map<String, String> generateMap() throws IOException {
		Map<String, String> darkStyleMap = new HashMap<String, String>();

		darkStyleMap.put(StyleArea.MENU, getResourceFile("menu.css"));
		darkStyleMap.put(StyleArea.STATUS, getResourceFile("status.css"));
		darkStyleMap.put(StyleArea.APP, getResourceFile("app.css"));
		darkStyleMap.put(StyleArea.DOCKAREA, getResourceFile("dockarea.css"));
		darkStyleMap.put(StyleArea.DOCKPANEL, getResourceFile("panel.css"));
		darkStyleMap.put(OverlayStyleNames.DEFAULT_ARROW, getResourceFile("defaultarrow.css"));
		darkStyleMap.put(OverlayStyleNames.HOVER_ARROW, getResourceFile("hoverarrow.css"));
		darkStyleMap.put(OverlayStyleNames.PREVIEW_DROP, getResourceFile("preview.css"));

		return darkStyleMap;
	}

	private static String getResourceFile(String r) throws IOException {
		return StreamUtilities.getStreamContents(DarkStyleHelper.class.getResourceAsStream(r));
	}
}
