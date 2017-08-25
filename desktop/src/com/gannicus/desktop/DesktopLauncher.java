package com.gannicus.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gannicus.Gannicus;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = 
                        new LwjglApplicationConfiguration();
		new LwjglApplication(new Gannicus(), config);
	}
}
