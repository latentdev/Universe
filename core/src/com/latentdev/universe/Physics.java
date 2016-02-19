package com.latentdev.universe;


public class Physics {

    private double g;
    private double vx;
    private double vy;
    private float speed;
    Battlefield level;

    Physics(Battlefield in_level)
    {
        g = 0.3;
        vx = 1;
        vy = 0;
        level = in_level;
        speed = level.GetSpeedX();
    }

    public void physics()
    {
        vy -= g;

        level.character[0].SetY(level.character[0].GetY() + (float) vy);
        level.character[1].SetY(level.character[1].GetY() + (float) vy);

        if (level.character[0].GetY()<256*level.scale_height)
        {
            vy*=-0.9;
            level.character[0].SetY(256*level.scale_height);
            level.character[1].SetY(256*level.scale_height);
            level.char_rotation=speed*(float)0.25;
            speed-=vx;
            if (speed<0)
            {
                speed=0;
                vx=0;
            }
        }
    }

    public float GetSpeed()
    {
        return speed;
    }

}
