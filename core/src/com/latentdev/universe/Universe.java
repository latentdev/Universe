package com.latentdev.universe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


public class Universe extends ApplicationAdapter {
	SpriteBatch batch;
	Logic logic;
	private BitmapFont font;
	@Override
	public void create () {
		batch = new SpriteBatch();
		logic = new Logic(batch);
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(4);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		logic.Loop();
		font.draw(batch, Gdx.graphics.getWidth() + " pixels", 10, Gdx.graphics.getHeight() - 10);
		font.draw(batch, Gdx.graphics.getHeight() + " pixels", 10, Gdx.graphics.getHeight() - 80);
		font.draw(batch, (Gdx.graphics.getWidth()/2560)+" width ratio",10,Gdx.graphics.getHeight()-160);
		font.draw(batch, Gdx.graphics.getHeight()/1440+" height ratio",10,Gdx.graphics.getHeight()-240);
		batch.end();
	}

}
