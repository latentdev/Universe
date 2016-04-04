package com.latentdev.universe;

/**
 * Created by laten on 1/7/2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Battlefield implements ProtoLevel {

    private Entity [] level;
    Entity [] player;
    Entity [] character;
    Entity [] tools;
    private int Hero;
    SpriteBatch batch;
    Music Theme;
    float speed_x;
    float speed_y;
    float scale_width;
    float scale_height;
    float distance;
    float char_rotation;
    float dt;

    float scale;
    float increment;


    public Battlefield(SpriteBatch in_batch)
    {
        batch=in_batch;
        Hero= 3;

        speed_x=0; //forward character movement

        speed_x=3000;

        speed_y=0;
        //scale_width=(float)(Gdx.graphics.getWidth())/(float)2560;
        scale_height=(float)(Gdx.graphics.getHeight())/(float)1440;
        scale_width=scale_height;
        scale=1;

        distance=0;
        char_rotation=0;

        player = new Entity[2];
        player[0] = new Entity(400*scale_width,400*scale_height,0,0,"steven-256.png");
        player[1] = new Entity(400*scale_width,400*scale_height,0,0,"bubble-256.png");
        character = new Entity[8];
        int offset=0;
        for (int i=0; i<character.length; i++)
        {
            character[i] = new Entity((0+(offset*scale_width)),400*scale_height-(128*scale_height),0,0,"steven-256.png");
            offset+= character[i].GetWidth() +character[i].GetWidth()*2;
        }

        level= new Entity[7];
        level[2]= new Entity(0,0,0,speed_x,"Battleground.png");
        level[0]= new Entity(0,0,0,(float)(level[2].GetSpeed()*.25),"sky.png");
        level[1]= new Entity(0,0,0,(float)(level[2].GetSpeed()*.5),"clouds.png");
        level[3]= new Entity(3072*scale_width,0,0,(float)(level[2].GetSpeed()*1.5),"Hammer.png");
        level[4]= new Entity(1024*scale_width,0,0,(float)(level[2].GetSpeed()*1.5),"Sword.png");
        level[5]= new Entity(2048*scale_width,0,0,(float)(level[2].GetSpeed()*1.5),"hatchet.png");
        level[6]= new Entity(0,0,0,speed_x*2,"Foreground.png");

        tools= new Entity[3];
        tools[0]= new Entity(0,0,0,0,"arc_fill.png");
        tools[1]= new Entity(0,0,0,0,"arc_outline.png");
        tools[2]= new Entity(0,0,0,0,"vector.png");

        Theme = Gdx.audio.newMusic(Gdx.files.internal("Music/gems-piano.ogg"));
        Theme.setLooping(true);
    }

    public void DrawLevel()
    {
        dt=Gdx.graphics.getDeltaTime();
        for (int i=0;i<level.length;i++)
        {
            if (i==Hero)
            {
                for (int k=0;k< player.length;k++)
                {
                    batch.draw(player[k].tex, player[k].GetX()-(player[k].GetWidth()/2), player[k].GetY()-(player[k].GetHeight()/2), player[k].GetWidth()/2, player[k].GetHeight()/2, player[k].GetWidth(), player[k].GetHeight(),scale_width,scale_height, player[k].SetRotation(player[k].GetRotation()-char_rotation),0,0, player[k].GetWidth(), player[k].GetHeight(),false,false);
                }

                for (int m=0;m<character.length;m++)
                {
                    batch.draw(character[m].tex, character[m].GetX(), character[m].GetY(), 0, 0, character[m].GetWidth(), character[m].GetHeight(),scale_width,scale_height, character[m].GetRotation(),0,0, character[m].GetWidth(), character[m].GetHeight(),false,false);
                    character[m].SetX(character[m].GetX()-character[m].GetSpeed()*dt);
                }
            }
            batch.draw(level[i].tex,level[i].GetX(),level[i].GetY(),0,0,level[i].GetWidth(),level[i].GetHeight(),scale_width,scale_height,level[i].GetRotation(),0,0,level[i].GetWidth(),level[i].GetHeight(),false,false);
            batch.draw(level[i].tex, level[i].GetX() + (5120*scale_width), level[i].GetY(),0,0,level[i].GetWidth(),level[i].GetHeight(),scale_width,scale_height,level[i].GetRotation(),0,0,level[i].GetWidth(),level[i].GetHeight(),false,false);
            level[i].SetX(level[i].GetX()-level[i].GetSpeed()*dt);
            if (level[i].GetX() < (-1*(5120*scale_width))) {
                level[i].SetX(0);
            }

        }

        Animate_Tools();


        for (int m=0;m<3;m++)
            batch.draw(tools[m].tex, tools[m].GetX(), tools[m].GetY(),0,0,tools[m].GetWidth(),tools[m].GetHeight(),scale_width,scale_height,tools[m].GetRotation(),0,0,tools[m].GetWidth(),tools[m].GetHeight(),false,false);
    }



    public void Update(float in_speed_x)
    {
        speed_x=in_speed_x;
        level[0].SetSpeed(speed_x*(float).25);
        level[1].SetSpeed(speed_x * (float) .5);
        level[2].SetSpeed(speed_x);
        level[3].SetSpeed(speed_x * (float) 1.5);
        level[4].SetSpeed(speed_x * (float) 1.5);
        level[5].SetSpeed(speed_x * (float) 1.5);
        level[6].SetSpeed(speed_x*(float)2);
        for (int i=0;i<character.length;i++)
        {
            character[i].SetSpeed(speed_x);
        }
        distance+=speed_x*dt*scale_width;

        increment=-.5f*dt;


    }

    public void Animate_Tools()
    {

        if (tools[0].GetScale() > 1f || tools[0].GetScale() < 0f) {
            increment *= -1;
        }
        tools[0].AddScale(increment);

        batch.draw(tools[0].tex, tools[0].GetX(), tools[0].GetY(),0,0,tools[0].GetWidth(),tools[0].GetHeight(),tools[0].GetScale()*scale_width,tools[0].GetScale()*scale_height,tools[0].GetRotation(),0,0,tools[0].GetWidth(),tools[0].GetHeight(),false,false);
        for (int m=1;m<3;m++)
            batch.draw(tools[m].tex, tools[m].GetX(), tools[m].GetY(),0,0,tools[m].GetWidth(),tools[m].GetHeight(),scale_width,scale_height,tools[m].GetRotation(),0,0,tools[m].GetWidth(),tools[m].GetHeight(),false,false);

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

    public void SetSpeedX(float in_speed)
    {
        speed_x=in_speed;
    }


}
