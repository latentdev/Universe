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
    private float scale;
    Texture tex;
    BBox bbox;

    public Entity(float in_x, float in_y, float in_rotation, float in_speed, String file) {
        x = in_x;
        y = in_y;
        rotation = in_rotation;
        tex = new Texture(file);
        speed = in_speed;
        width = tex.getWidth();
        height = tex.getHeight();
        bbox = new BBox(x,y,(float)width,(float)height);
        scale = 1;

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
    public float GetScale() {return scale; }

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

    public float SetRotation(float in_rotation)
    {
        rotation=in_rotation;
        return rotation;
    }
    public void SetScale(float in_scale){ scale = in_scale;}
    public void AddScale(float new_scale){ scale+=new_scale; }

}
