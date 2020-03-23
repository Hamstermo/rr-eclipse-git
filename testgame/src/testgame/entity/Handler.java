package testgame.entity;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	private LinkedList<Entity> entities = new LinkedList<Entity>();
	
	public void tick() {
		for (Entity entity : entities) {
			entity.tick();
		}
	}
	
	public void render(Graphics g) {
		for (Entity entity : entities) {
			entity.render(g);
		}
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}
	
}
