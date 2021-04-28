package com.libgdx.breakoutgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;

public class BreakoutGame extends ApplicationAdapter
{
	ShapeRenderer shape;
	Ball ball;
	Rectangle paddle;
	ArrayList<Rectangle> blocks;

	@Override
	public void create ()
	{
		shape = new ShapeRenderer();
		ball = new Ball(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 10, 5, 5, Color.RED);
		paddle = new Rectangle(Gdx.graphics.getWidth()/2, 20, 200, 10, Color.CYAN);

		int blockWidth = 64;
		int blockHeight = 20;
		int blockSpacing = 10;

		blocks = new ArrayList<>();

		for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += blockHeight + blockSpacing)
		{
			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + blockSpacing)
				blocks.add(new Block(x, y, blockWidth, blockHeight, Color.GREEN));
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		ball.update();
		paddle.update();

		shape.begin(ShapeRenderer.ShapeType.Filled);

		for (Rectangle block : blocks)
		{
			block.draw(shape);
			ball.checkCollision(block);
		}
		ball.draw(shape);
		paddle.draw(shape);

		ball.checkCollision(paddle);

		for (int i = 0; i < blocks.size(); i++)
		{
			Block b = (Block)blocks.get(i);

			if (b.destroyed)
			{
				blocks.remove(b);
				i--;
			}
		}

		shape.end();
	}
	
	@Override
	public void dispose ()
	{
		shape.dispose();
		blocks.clear();
	}
}
