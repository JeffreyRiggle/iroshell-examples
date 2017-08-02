package themeshell.src.main.java.green;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ilusr.core.io.StreamUtilities;
import ilusr.iroshell.core.StyleArea;
import ilusr.iroshell.dockarea.overlay.OverlayStyleNames;

public class GreenStyleHelper {

	public static Map<String, String> generateMap() throws IOException {
		Map<String, String> greenStyleMap = new HashMap<String, String>();

		greenStyleMap.put(StyleArea.MENU, getResourceFile("menu.css"));
		greenStyleMap.put(StyleArea.STATUS, getResourceFile("status.css"));
		greenStyleMap.put(StyleArea.APP, getResourceFile("app.css"));
		greenStyleMap.put(StyleArea.DOCKAREA, getResourceFile("dockarea.css"));
		greenStyleMap.put(StyleArea.DOCKPANEL, getResourceFile("panel.css"));
		greenStyleMap.put(OverlayStyleNames.DEFAULT_ARROW, getResourceFile("defaultarrow.css"));
		greenStyleMap.put(OverlayStyleNames.HOVER_ARROW, getResourceFile("hoverarrow.css"));
		greenStyleMap.put(OverlayStyleNames.PREVIEW_DROP, getResourceFile("preview.css"));

		return greenStyleMap;
	}

	private static String getResourceFile(String r) throws IOException {
		return StreamUtilities.getStreamContents(GreenStyleHelper.class.getResourceAsStream(r));
	}
}
