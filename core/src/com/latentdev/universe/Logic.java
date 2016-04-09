package com.latentdev.universe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by laten on 1/22/2016.
 */
public class Logic {

    Battlefield level;
    Controls controls;
    Physics physics;

    public Logic(SpriteBatch in_batch, AssetManager manager)
    {
        level = new Battlefield(in_batch, manager);
        controls = new Controls();
        Gdx.input.setInputProcessor(controls);
        physics = new Physics(level);
       // level.PlayMusic();
    }

    void Measure()
    {

    }
    void Touch_Event()
    {
        if (controls.touched)
        {
            physics.Push(2000*level.scale_width,2000*level.scale_width);
            controls.touched=false;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.CENTER))
            controls.touched=true;
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)||Gdx.input.isKeyPressed(Input.Keys.BACK))
        {
            Gdx.app.exit();
        }
    }
    public void Loop()
    {
        Touch_Event();
        level.Update(physics.GetSpeed());
        level.DrawLevel();
        physics.physics();
    }
    public void dispose()
    {
        level.dispose();
        controls.dispose();
        physics.dispose();
    }

}
