package com.libgdx.breakoutgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Rectangle extends Shape
{
    public int width, height;

    public Rectangle(int xCor, int yCor, int width, int height, Color color)
    {
        this.xCor = xCor;
        this.yCor = yCor;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(ShapeRenderer shape)
    {
        shape.setColor(color);
        shape.rect(xCor, yCor, width, height);
    }

    @Override
    public void update()
    {
        xCor = Gdx.input.getX() - width/2;
        //yCor = Gdx.graphics.getHeight() - Gdx.input.getY();
    }
}
