package testgame.entity;

import java.awt.Color;
import java.awt.Graphics;

import testgame.Game;

public class Player extends Entity {

	private boolean up, down, left, right;
	private Game game;
	
	private final float SPEED = 0.2f;
	private final int WIDTH = 32;
	private final int HEIGHT = 32;

	public Player(Game game, double x, double y) {
		super(x, y);
		this.game = game;
	}
	
	@Override
	public void tick() {
		int screenWidth = game.getCanvas().getWidth();
		int screenHeight = game.getCanvas().getHeight();

		if (up) {
			if (y > 0) {
				y -= SPEED;
			}
		} 
			
		else if (down) {
			if (y < screenHeight-HEIGHT) {
				y += SPEED;
			}
		}
		
		if (right) {
			if (x < screenWidth-WIDTH) {
				x += SPEED;
			}
		}
			
		else if (left) {
			if (x > 0) {
				x -= SPEED;
			}
		}
			
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
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
