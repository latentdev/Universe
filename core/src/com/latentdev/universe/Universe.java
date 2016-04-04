package com.latentdev.universe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;;


public class Universe extends ApplicationAdapter {
	SpriteBatch batch;
	Logic logic;
	BitmapFont font;
	GlyphLayout layout;
	String Distance;
	Boolean key;
	@Override
	public void create () {
		batch = new SpriteBatch();
		logic = new Logic(batch);
		FileHandle fontFile = Gdx.files.internal("fonts/universe.ttf");
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 40;
		parameter.borderWidth=3;
		parameter.borderColor=Color.GRAY;
		font = generator.generateFont(parameter);//new BitmapFont();
		layout = new GlyphLayout();
		//font.setColor(Color.WHITE);
		//font.getData().setScale(4*logic.level.scale_width);

		//config.fullscreen = true;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		Distance = String.format("%.2f",logic.level.distance/(256*logic.level.scale_width)) + " meters";
		layout.setText(font, Distance);
		logic.Loop();
		key=Gdx.input.isKeyPressed(Input.Keys.CENTER);
		font.draw(batch, String.format("%.0f", 1 / logic.level.dt) + " fps", 10, Gdx.graphics.getHeight() - 10);
		font.draw(batch, String.format("%.2f",logic.level.distance/(256*logic.level.scale_width)) + " meters", Gdx.graphics.getWidth()-layout.width-10, Gdx.graphics.getHeight() - 10);
		font.draw(batch, "scale: "+ logic.level.tools[0].GetScale(), 10, Gdx.graphics.getHeight() - 80);
		//font.draw(batch, (Gdx.graphics.getWidth()/(float)2560)+" width ratio",10,Gdx.graphics.getHeight()-160);
		//font.draw(batch, Gdx.graphics.getHeight()/(float)1440+" height ratio",10,Gdx.graphics.getHeight()-240);
		batch.end();
	}

}
