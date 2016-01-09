package com.latentdev.universe;
import com.badlogic.gdx.graphics.Texture;
/**
 * Created by laten on 1/7/2016.
 */
public class Entity {
    int x;
    int y;
    double speed;
    float rotation;
    Texture tex;

    public Entity(int in_x,int in_y, float in_rotation,double in_speed, String file)
    {
        x=in_x;
        y=in_y;
        rotation=in_rotation;
        tex=new Texture(file);
        speed=in_speed;
    }
}
