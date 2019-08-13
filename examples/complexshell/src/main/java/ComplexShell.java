package complexshell.src.main.java;

import ilusr.iroshell.documentinterfaces.DocumentType;
import ilusr.iroshell.main.MainShell;

public class ComplexShell extends MainShell{

	public ComplexShell() {
		super.applicationSettings.setDocumentType(DocumentType.MDI);
		super.applicationSettings.applicationName("Complex Shell");
		super.applicationSettings.version("2.0");
		super.applicationSettings.preApplicationScreens().add(new PatchScreen());
		super.applicationSettings.preApplicationScreens().add(new LoginScreen());
	}
}
