package com.latentdev.universe;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by laten on 1/22/2016.
 */
public class Logic {

    ProtoLevel level;
    Controls controls;
    Physics physics;

    public Logic(SpriteBatch in_batch)
    {
        level = new Battlefield(in_batch);
        controls = new Controls();
        physics = new Physics(level);
        level.PlayMusic();
    }

    void Measure()
    {

    }

    public void Loop()
    {
        level.Update(10);
        level.DrawLevel();
    }

}
