package com.latentdev.universe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by laten on 1/22/2016.
 */
public class Controls implements InputProcessor{
    Boolean touched = false;
    int touch = 0;

    @Override
    public boolean keyDown (int keycode) {
        return false;
    }

    @Override
    public boolean keyUp (int keycode) {

        return false;
    }

    @Override
    public boolean keyTyped (char character) {
        return false;
    }

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp (int x, int y, int pointer, int button) {
        touched = true;
        touch++;
        return false;
    }

    @Override
    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    //@Override
    //public boolean touchMoved (int x, int y) {
    //     return false;
    // }

    @Override
    public boolean scrolled (int amount) {
        return false;
    }
    @Override
    public boolean mouseMoved (int x,int y){
        return false;
    }

    int set () {
        return touch;
    }
}
