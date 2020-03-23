package testgame.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

import testgame.Game;

public class Player extends Entity {

	private boolean up, down, left, right;
	private Game game;
	
	private final float SPEED = 0.2f;
	private final int PLAYER_WIDTH = 32;
	private final int PLAYER_HEIGHT = 32;

	public Player(Game game, double x, double y) {
		super(x, y);
		this.game = game;
	}
	
	@Override
	public void tick() {
		System.out.println("x: "+ Math.round(x));
		System.out.println("y: "+ Math.round(y));
		
		int width = game.getCanvas().getWidth();
		int height = game.getCanvas().getHeight();

		if (up){
			if (y > 0) {
				y = y-SPEED;
			}
		} 
			
		else if (down){
			System.out.println("jngefjnegf");
			if (y < height-PLAYER_HEIGHT) {
				y = y+SPEED;
			}
		}
		
		if (right) {
			if (x < width-PLAYER_WIDTH) {
				x = x+SPEED;
			}
		}
			
		else if (left) {
			if (x > 0) {
				x = x-SPEED;
			}
		}
			
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
	
	public void setUp(boolean up) {
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}
	
}
