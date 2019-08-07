package themeshell.src.main.java;

import ilusr.iroshell.documentinterfaces.DocumentType;
import ilusr.iroshell.main.MainShell;

public class ThemeShell extends MainShell{

	public ThemeShell() {
		super.applicationSettings.setDocumentType(DocumentType.MDI);
		super.applicationSettings.applicationName("Theme Shell");
		super.applicationSettings.version("2.0");
		super.applicationSettings.components().add(new ThemeComponent());
	}
}
