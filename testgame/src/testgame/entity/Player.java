package testgame.entity;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity {

	public Player(double x, double y) {
		super(x, y);
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, 32, 32);
	}
	
}
