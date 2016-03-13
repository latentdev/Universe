package com.latentdev.universe;


public class Physics {

    private double g;
    private double vx;
    private double vy;
    private float speed;
    Battlefield level;

    Physics(Battlefield in_level)
    {
        g = 25;
        vx = 3;
        vy = 0;
        level = in_level;
        speed = level.GetSpeedX();
    }

    public void physics()
    {
        vy -= g;

        level.player[0].SetY(level.player[0].GetY() + (float) vy*level.dt);
        level.player[1].SetY(level.player[1].GetY() + (float) vy*level.dt);

        if (level.player[0].GetY()<400*level.scale_height)
        {
            vy*=-0.9;
            level.player[0].SetY(400*level.scale_height);
            level.player[1].SetY(400*level.scale_height);
            level.char_rotation=speed*(float)0.25*level.dt;
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
