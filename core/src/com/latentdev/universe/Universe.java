package com.latentdev.universe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Universe extends ApplicationAdapter {
	SpriteBatch batch;
	Entity Main;
	Entity [] level;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Main= new Entity(0,128,0,0,"steven-256.png");
		level= new Entity[7];

		level[0]= new Entity(0,0,0,5,"Battleground.png");
		level[1]= new Entity(0,0,0,level[0].speed*.5,"clouds.png");
		level[2]= new Entity(0,0,0,level[0].speed*.25,"sky.png");
		level[3]= new Entity(0,0,0,level[0].speed*1.5,"Hammer.png");
		level[4]= new Entity(1024,0,0,level[0].speed*1.5,"Sword.png");
		level[5]= new Entity(2048,0,0,level[0].speed*1.5,"hatchet.png");
		level[6]= new Entity(0,0,0,level[0].speed*2,"Foreground.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		draw();
		batch.end();
	}

	public void background()
	{
		for (int i=2;i>-1;i--)
		{
		batch.draw(level[i].tex, level[i].x, level[i].y);
		batch.draw(level[i].tex, level[i].x + 5120, level[i].y);
		level[i].x-=level[i].speed;
			if (level[i].x < -5120) {
				level[i].x = 0;
			}
		}
	}

	public void foreground()
	{
		for (int i=3;i<7;i++) {
			batch.draw(level[i].tex, level[i].x, level[i].y);
			batch.draw(level[i].tex, level[i].x + 5120, level[i].y);
			level[i].x -= level[i].speed;
			if (level[i].x < -5120) {
				level[i].x = 0;
			}
		}
	}
	public void draw()
	{
		background();
		batch.draw(Main.tex, Main.x, Main.y);
		foreground();
	}
}
