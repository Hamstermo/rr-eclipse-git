package testgame.entity;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity {

	private boolean up, down, left, right;

	public Player(double x, double y) {
		super(x, y);
	}
	
	@Override
	public void tick() {
		if (up) 
			y--;
		else if (down)
			y++;
		
		if (right)
			x++;
		else if (left)
			x--;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, 32, 32);
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
