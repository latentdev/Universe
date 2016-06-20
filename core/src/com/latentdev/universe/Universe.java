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
	String [] texture;
	String [] music;
	String [] fonts;

	@Override
	public void create () {
		batch = new SpriteBatch();
		manager = new AssetManager();
		texture= new String [12];
		music= new String [1];
		texture[0]="steven-256.png";
		texture[1]="bubble-256.png";
		texture[2]="Battleground.png";
		texture[3]="sky.png";
		texture[4]="clouds.png";
		texture[5]="Hammer.png";
		texture[6]="Sword.png";
		texture[7]="hatchet.png";
		texture[8]="Foreground.png";
		texture[9]="arc_fill.png";
		texture[10]="arc_outline.png";
		texture[11]="vector.png";

		music[0]="Music/gems-piano.ogg";
		this.load(manager,texture,music,null);
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
			font.draw(batch, "Resolution: " + Gdx.graphics.getWidth() + "x" + Gdx.graphics.getHeight(), 10, Gdx.graphics.getHeight() - 80);
			//font.draw(batch, "vector_rotation: " + logic.level.vector_rotation_result, 10, Gdx.graphics.getHeight() - 160);
			//font.draw(batch, "scale: " + logic.level.tools[0].GetScale(), 10, Gdx.graphics.getHeight() - 240);
			/*batch.draw(manager.get("sky.png",Texture.class),0,0);
			batch.draw(manager.get("clouds.png",Texture.class),0,0);
			batch.draw(manager.get("Battleground.png",Texture.class),0,0);
			batch.draw(manager.get("Foreground.png",Texture.class),0,0);
			font.draw(batch, "Loading done: "+ progress, 10, Gdx.graphics.getHeight() - 10);*/
		}
        // Load assets for loading screen
		else if (!finished&&!manager.isLoaded("bubble-256.png")){
			manager.finishLoadingAsset("bubble-256.png");
		}
        //Load assets for rest of game. Future versions we will load only the assets for the title screen and will load level assets upon level choice.
		else
		{
			Texture steven = manager.get("steven-256.png");
			Texture bubble = manager.get("bubble-256.png");
			batch.draw(steven,10,10);
			batch.draw(bubble,10,10);
			finished = manager.update();
			progress = manager.getProgress();
			String load = "Loading.";
			layout.setText(font, load);
			font.draw(batch, load, Gdx.graphics.getWidth() / 2 - (layout.width / 2), Gdx.graphics.getHeight() / 2);
			if (manager.update())
				logic = new Logic(batch,manager);
		}
		batch.end();
	}
	@Override
	public void dispose (){

        manager.dispose();
        batch.dispose();
        font.dispose();
        logic.dispose();
	}
    // pass in arrays of files to load into the passed in AssetManager.
	static void load(AssetManager in_manager,String [] in_texture,String [] in_music, String [] in_font)
	{
		if(in_texture!=null) {
			for (int i = 0; i < in_texture.length; i++)
			{
				in_manager.load(in_texture[i], Texture.class);
			}
		}
		if(in_music!=null)
		{
			for (int i = 0; i < in_music.length; i++)
			{
				in_manager.load(in_music[i], Music.class);
			}
		}
		if(in_font!=null){
			for (int i=0; i<in_font.length; i++)
			{
				in_manager.load(in_font[i],BitmapFont.class);
			}
		}

	}



}
