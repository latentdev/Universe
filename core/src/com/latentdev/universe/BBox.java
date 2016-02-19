package com.latentdev.universe;

/**
 * Created by laten on 2/18/2016.
 */
public class BBox {
    float x1;
    float x2;
    float y1;
    float y2;

    BBox(float in_x1, float in_x2, float in_y1, float in_y2)
    {
        x1=in_x1;
        x2=x1+in_x2;
        y1=in_y1;
        y2=y1+in_y2;
    }

    public boolean CheckCollision(BBox in_bbox)
    {
        if (in_bbox.x2>x1&&in_bbox.x2<x2&&in_bbox.y1<y2&&in_bbox.y1>y1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
