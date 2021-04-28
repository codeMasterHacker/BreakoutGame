package com.libgdx.breakoutgame;

import com.badlogic.gdx.graphics.Color;

public class Block extends Rectangle
{
    public boolean destroyed;

    public Block(int xCor, int yCor, int width, int height, Color color)
    {
        super(xCor, yCor, width, height, color);
        destroyed = false;
    }
}
