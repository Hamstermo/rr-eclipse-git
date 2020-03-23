package testgame.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

import testgame.Game;

public class Player extends Entity {

	private boolean up, down, left, right;
	private Game game;
	private Canvas canvas;
	private final double speed = 0.2;
	private final int HEIGHT;
	private final int WIDTH;
	private final int playerWidth = 32;
	private final int playerHeight = 32;

	public Player(Game game, double x, double y) {
		super(x, y);
		this.game = game;
		canvas = game.getCanvas();
		HEIGHT = canvas.getHeight();
		WIDTH = canvas.getWidth();
	}
	
	@Override
	public void tick() {
		System.out.println("x: "+ Math.round(x));
		System.out.println("y: "+ Math.round(y));
		System.out.println(WIDTH);

		if (up){
			if (y>=0){
				y = y-speed;
			}
		} 
			
		else if (down){
			System.out.println("jngefjnegf");
			if (y<=(HEIGHT-playerHeight)){
				y = y+speed;
			}
		}
		
		if (right){
			if (x<(WIDTH-playerWidth)){
				x = x+speed;
			}
		}
			
		else if (left){
			if (x>0){
				x = x-speed;
			}
		}
			
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, playerWidth, playerHeight);
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
