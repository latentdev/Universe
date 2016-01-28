package com.latentdev.universe;

/**
 * Created by laten on 1/7/2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Battlefield implements ProtoLevel {

    private Entity [] level;
    Entity [] character;
    Entity [] tools;
    private int Hero;
    SpriteBatch batch;
    Music Theme;
    private float speed_x;
    private float speed_y;
    private float scale_width;
    private float scale_height;

    public Battlefield(SpriteBatch in_batch)
    {
        batch=in_batch;
        Hero= 3;
        speed_x=10;
        speed_y=0;
        scale_width=(float)(Gdx.graphics.getWidth())/2560;
        scale_height=(float)(Gdx.graphics.getHeight())/1440;

        character = new Entity[2];
        character[0] = new Entity(256,256,0,0,"steven-256.png");
        character[1] = new Entity(256,256,0,0,"bubble-256.png");
        level= new Entity[7];
        level[2]= new Entity(0,0,0,speed_x,"Battleground.png");
        level[0]= new Entity(0,0,0,(float)(level[2].GetSpeed()*.25),"sky.png");
        level[1]= new Entity(0,0,0,(float)(level[2].GetSpeed()*.5),"clouds.png");
        level[3]= new Entity(3072,0,0,(float)(speed_x*1.5),"Hammer.png");
        level[4]= new Entity(1024,0,0,(float)(speed_x*1.5),"Sword.png");
        level[5]= new Entity(2048,0,0,(float)(speed_x*1.5),"hatchet.png");
        level[6]= new Entity(0,0,0,speed_x*2,"Foreground.png");

        tools= new Entity[3];
        tools[0]= new Entity(0,0,0,0,"arc_fill.png");
        tools[1]= new Entity(0,0,0,0,"arc_outline.png");
        tools[2]= new Entity(0,0,0,0,"vector.png");

        Theme = Gdx.audio.newMusic(Gdx.files.internal("gems.ogg"));
        Theme.setLooping(true);
    }

    public void DrawLevel()
    {
        for (int i=0;i<level.length;i++)
        {
            if (i==Hero)
            {
                for (int k=0;k<character.length;k++)
                {
                    batch.draw(character[k].tex,character[k].GetX(),character[k].GetY(),character[k].GetWidth()/2,character[k].GetHeight()/2,character[k].GetWidth(),character[k].GetHeight(),scale_width,scale_height,character[k].GetRotation(),0,0,character[k].GetWidth(),character[k].GetHeight(),false,false);
                }
            }
            batch.draw(level[i].tex, level[i].GetX(), level[i].GetY());
            batch.draw(level[i].tex, level[i].GetX() + 5120, level[i].GetY());
            level[i].SetX(level[i].GetX()-level[i].GetSpeed());
            if (level[i].GetX() < -5120) {
                level[i].SetX(0);
            }

        }
        for (int m=0;m<3;m++)
            batch.draw(tools[m].tex,tools[m].GetX(),tools[m].GetY());
    }

    public void Update(float in_speed_x)
    {
        speed_x=in_speed_x;
        for (int i=0;i<level.length;i++)
        {
            level[i].SetSpeed(speed_x);
        }
    }

    public void PlayMusic()
    {
        Theme.play();
    }

    public int GetHero()
    {
        return Hero;
    }

    public float GetSpeedX()
    {
        return speed_x;
    }

    public float GetSpeedY()
    {
        return speed_y;
    }

    public Entity [] GetLevel()
    {
        return level;
    }


}
