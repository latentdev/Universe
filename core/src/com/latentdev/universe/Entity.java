package com.latentdev.universe;
import com.badlogic.gdx.graphics.Texture;
/**
 * Created by laten on 1/7/2016.
 */
public class Entity {
    private float x;
    private float y;
    private float speed;
    private float rotation;
    private int width;
    private int height;
    Texture tex;

    public Entity(float in_x, float in_y, float in_rotation, float in_speed, String file) {
        x = in_x;
        y = in_y;
        rotation = in_rotation;
        tex = new Texture(file);
        speed = in_speed;
        width = tex.getWidth();
        height = tex.getHeight();

    }

    public float GetX() {
        return x;
    }

    public float GetY() {
        return y;
    }

    public float GetSpeed() {
        return speed;
    }

    public float GetRotation() {
        return rotation;
    }

    public int GetWidth() {
        return width;
    }

    public int GetHeight()
    {
        return height;
    }

    public void SetX(float in_x)
    {
        x=in_x;
    }

    public void SetY(float in_y)
    {
        y=in_y;
    }

    public void SetSpeed(float in_speed)
    {
        speed=in_speed;
    }

    public void SetRotation(float in_rotation)
    {
        rotation=in_rotation;
    }

}
