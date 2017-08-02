package customsplashscreenshell.src.main.java;

import ilusr.iroshell.features.ISplashScreenCreator;
import javafx.scene.Parent;

public class SplashCreator implements ISplashScreenCreator {

	@Override
	public Parent create() {
		return new CustomSplash();
	}
}
