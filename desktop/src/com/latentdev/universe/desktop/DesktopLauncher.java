package com.latentdev.universe.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.latentdev.universe.Universe;;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Universe";
		config.height = 768;
		config.width = 1366;
		config.fullscreen = true;
		new LwjglApplication(new Universe(), config);
	}
}
