package singledocumentshell.src.main.java;

import ilusr.iroshell.documentinterfaces.DocumentType;
import ilusr.iroshell.main.ApplicationFeatures;
import ilusr.iroshell.main.MainShell;

public class SingleDocumentShell extends MainShell{

	public SingleDocumentShell() {
		super.applicationSettings.setDocumentType(DocumentType.SDI);
		super.applicationSettings.applicationName("SDI Shell");
		super.applicationSettings.version("Alpha 1.0");
		super.applicationSettings.applicationFeatures(ApplicationFeatures.PERSISTENCE_MANAGEMENT);
		super.applicationSettings.components().add(new SDIComponent());
	}
}
