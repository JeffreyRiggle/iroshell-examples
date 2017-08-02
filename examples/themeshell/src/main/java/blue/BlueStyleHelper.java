package themeshell.src.main.java.blue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ilusr.core.io.StreamUtilities;
import ilusr.iroshell.core.StyleArea;
import ilusr.iroshell.dockarea.overlay.OverlayStyleNames;

public class BlueStyleHelper {

	public static Map<String, String> generateMap() throws IOException {
		Map<String, String> blueStyleMap = new HashMap<String, String>();

		blueStyleMap.put(StyleArea.MENU, getResourceFile("menu.css"));
		blueStyleMap.put(StyleArea.STATUS, getResourceFile("status.css"));
		blueStyleMap.put(StyleArea.APP, getResourceFile("app.css"));
		blueStyleMap.put(StyleArea.DOCKAREA, getResourceFile("dockarea.css"));
		blueStyleMap.put(StyleArea.DOCKPANEL, getResourceFile("panel.css"));
		blueStyleMap.put(OverlayStyleNames.DEFAULT_ARROW, getResourceFile("defaultarrow.css"));
		blueStyleMap.put(OverlayStyleNames.HOVER_ARROW, getResourceFile("hoverarrow.css"));
		blueStyleMap.put(OverlayStyleNames.PREVIEW_DROP, getResourceFile("preview.css"));

		return blueStyleMap;
	}

	private static String getResourceFile(String r) throws IOException {
		return StreamUtilities.getStreamContents(BlueStyleHelper.class.getResourceAsStream(r));
	}
}
