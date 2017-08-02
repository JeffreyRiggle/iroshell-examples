package multipledocumentshell.src.main.java;

import ilusr.iroshell.documentinterfaces.DocumentType;
import ilusr.iroshell.features.ExceptionDisplay;
import ilusr.iroshell.main.ApplicationFeatures;
import ilusr.iroshell.main.MainShell;

public class MultipleDocumentShell extends MainShell{

	public MultipleDocumentShell() {
		super.applicationSettings.setDocumentType(DocumentType.MDI);
		super.applicationSettings.applicationName("MDI Shell");
		super.applicationSettings.version("Alpha 1.0");
		super.applicationSettings.applicationFeatures(ApplicationFeatures.EXCEPTION_HANDLING | ApplicationFeatures.PERSISTENCE_MANAGEMENT);
		super.applicationSettings.exceptionOptions().displayType(ExceptionDisplay.Default);
		super.applicationSettings.components().add(new MDIComponent());
	}
}
