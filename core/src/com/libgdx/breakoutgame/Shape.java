package com.libgdx.breakoutgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Shape
{
    public int xCor, yCor;
    public Color color;

    public void draw(ShapeRenderer shape)
    {
        shape.setColor(color);
    }

    public void update()
    {
        xCor += xCor;
        yCor += yCor;
    }
}
