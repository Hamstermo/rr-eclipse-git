package testgame.entity;

import java.awt.Graphics;

public abstract class Entity {

	protected double x;
	protected double y;
	
	public Entity(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
