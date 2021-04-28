package com.libgdx.breakoutgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball extends Shape
{
    public int radius, xSpeed, ySpeed;

    public Ball(int xCor, int yCor, int radius, int xSpeed, int ySpeed, Color color)
    {
        this.xCor = xCor;
        this.yCor = yCor;
        this.radius = radius;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.color = color;
    }

    @Override
    public void draw(ShapeRenderer shape)
    {
        shape.setColor(color);
        shape.circle(xCor, yCor, radius);
    }

    @Override
    public void update()
    {
        xCor += xSpeed;
        yCor += ySpeed;

        if (xCor-radius < 0 || xCor+radius > Gdx.graphics.getWidth())
            xSpeed = -xSpeed;

        if (yCor-radius < 0 || yCor+radius > Gdx.graphics.getHeight())
            ySpeed = -ySpeed;
    }

    public void checkCollision(Rectangle rectangle)
    {
        boolean collided = collidesWith(rectangle);
        if (collided)
            ySpeed = -ySpeed;

        if (collided && rectangle instanceof Block)
            ((Block)rectangle).destroyed = true;
    }

    private boolean collidesWith(Rectangle rectangle)
    {
        int paddleLeft = rectangle.xCor;
        int paddleRight = rectangle.xCor + rectangle.width;
        int paddleBottom = rectangle.yCor;
        int paddleTop = rectangle.yCor + rectangle.height;

        int ballLeft = xCor - radius;
        int ballRight =  xCor + radius;
        int ballBottom =  yCor - radius;
        int ballTop = yCor + radius;

        boolean xAxis = false;
        boolean yAxis = false;

        if (ballBottom <= paddleTop && ballTop >= paddleBottom)
            xAxis = true;

        if (ballLeft <= paddleRight && ballRight >= paddleLeft)
            yAxis = true;

        return xAxis && yAxis;
    }
}
