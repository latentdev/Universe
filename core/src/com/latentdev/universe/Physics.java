package com.latentdev.universe;


public class Physics {

    private double g;
    private double vx;
    private double vy;
    private float speed;
    Battlefield level;

<<<<<<< HEAD
    Physics(Battlefield in_level) {
        g = 20;
=======
    Physics(Battlefield in_level)
    {
        g = 25;
>>>>>>> origin/master
        vx = 3;
        vy = 0;
        level = in_level;
        speed = level.GetSpeedX();
    }

    public void physics() {
        vy -= g;

<<<<<<< HEAD
        level.player[0].SetY(level.player[0].GetY() + (float) vy * level.dt);
        level.player[1].SetY(level.player[1].GetY() + (float) vy * level.dt);

        if (level.player[0].GetY() < 400 * level.scale_height) {
            vy *= -0.9;
            level.player[0].SetY(400 * level.scale_height);
            level.player[1].SetY(400 * level.scale_height);
            level.char_rotation = speed * (float) 0.25 * level.dt;
            speed -= vx;
            if (speed < 0) {
                speed = 0;
                vx = 0;
=======
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
>>>>>>> origin/master
            }
        }
    }

    public float GetSpeed() {
        return speed;
    }


    public void Push(float x, float y) {
        vy*=-1;
        vy += y;
        speed += x;
        vx=10;
    }
}
