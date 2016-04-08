package com.latentdev.universe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.audio.Music;


public class Universe extends ApplicationAdapter {
	SpriteBatch batch;
	Logic logic;
	BitmapFont font;
	GlyphLayout layout;
	String Distance;
	AssetManager manager;
	float progress;
	boolean finished;

	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = new AssetManager();
		manager.load("steven-256.png", Texture.class);
		manager.load("bubble-256.png", Texture.class);
		manager.load("Battleground.png", Texture.class);
		manager.load("sky.png", Texture.class);
		manager.load("clouds.png", Texture.class);
		manager.load("Hammer.png", Texture.class);
		manager.load("Sword.png", Texture.class);
		manager.load("hatchet.png", Texture.class);
		manager.load("Foreground.png", Texture.class);
		manager.load("arc_fill.png", Texture.class);
		manager.load("arc_outline.png", Texture.class);
		manager.load("vector.png", Texture.class);
		manager.load("Music/gems-piano.ogg", Music.class);
		finished=false;


		FileHandle fontFile = Gdx.files.internal("fonts/universe.ttf");
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 40;
		parameter.color = Color.WHITE;
		parameter.borderWidth=3;
		parameter.borderColor=Color.GRAY;
		font = generator.generateFont(parameter);//new BitmapFont();
		layout = new GlyphLayout();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		if(finished)
		{
			Distance = String.format("%.2f", logic.level.distance / (256 * logic.level.scale_width)) + " meters";
			layout.setText(font, Distance);
			logic.Loop();
			font.draw(batch, String.format("%.0f", 1 / logic.level.dt) + " fps", 10, Gdx.graphics.getHeight() - 10);
			font.draw(batch, String.format("%.2f", logic.level.distance / (256 * logic.level.scale_width)) + " meters", Gdx.graphics.getWidth() - layout.width - 10, Gdx.graphics.getHeight() - 10);
			//font.draw(batch, "scale: " + logic.level.increment_result, 10, Gdx.graphics.getHeight() - 80);
			//font.draw(batch, "vector_rotation: " + logic.level.vector_rotation_result, 10, Gdx.graphics.getHeight() - 160);
			//font.draw(batch, "scale: " + logic.level.tools[0].GetScale(), 10, Gdx.graphics.getHeight() - 240);
			/*batch.draw(manager.get("sky.png",Texture.class),0,0);
			batch.draw(manager.get("clouds.png",Texture.class),0,0);
			batch.draw(manager.get("Battleground.png",Texture.class),0,0);
			batch.draw(manager.get("Foreground.png",Texture.class),0,0);
			font.draw(batch, "Loading done: "+ progress, 10, Gdx.graphics.getHeight() - 10);*/
		}
		else {
			finished=manager.update();
			progress = manager.getProgress();
			String load = "Loading";
			layout.setText(font, load);
			font.draw(batch,load, Gdx.graphics.getWidth()/2-(layout.width/2), Gdx.graphics.getHeight()/2 );
			if (manager.update())
				logic = new Logic(batch,manager);
		}
		batch.end();
	}
	@Override
	public void dispose (){
		manager.dispose();
	}



}
