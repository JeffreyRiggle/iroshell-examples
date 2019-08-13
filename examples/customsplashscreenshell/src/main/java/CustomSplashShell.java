package customsplashscreenshell.src.main.java;

import ilusr.iroshell.documentinterfaces.DocumentType;
import ilusr.iroshell.main.ApplicationFeatures;
import ilusr.iroshell.main.MainShell;

public class CustomSplashShell extends MainShell{

	public CustomSplashShell() {
		super.applicationSettings.setDocumentType(DocumentType.SDI);
		super.applicationSettings.applicationName("Splash Shell");
		super.applicationSettings.version("2.0");
		super.applicationSettings.applicationFeatures(ApplicationFeatures.SPLASH_SCREEN);
		super.applicationSettings.splashOptions().customSplashScreenCreator(new SplashCreator());
	}
}
