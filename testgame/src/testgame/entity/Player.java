package testgame.entity;

import java.awt.Color;
import java.awt.Graphics;

import testgame.Game;

public class Player extends Entity {

	private boolean up, down, left, right, space;
	private Game game;
	
	private final float SPEED = 5f;
	private final int playerWIDTH = 32;
	private final int playerHeight = 32;

	private final double dt = 0.017;
	private double VEL = 0f;
	private double GRAVITY = -400;
	private boolean inAir;

	public Player(Game game, double x, double y) {
		super(x, y);
		this.game = game;
	}
	
	@Override
	public void tick() {
		int screenWidth = game.getCanvas().getWidth();
		int screenHeight = game.getCanvas().getHeight();

		//if (up) {
			//if (y > 0) {
				//y -= SPEED;
			//}
		//}

		if (y<(screenHeight-playerHeight)) {
			inAir = true;
		}
		else {
			inAir = false;
		}

		if (space) {
			if (y>0){
				if (inAir==false){
					VEL =  500;
				}
			}
		}
			
		else if (down) {
			if (y < screenHeight-playerHeight) {
				y += SPEED;
			}
		}
		
		if (right) {
			if (x < screenWidth-playerWIDTH) {
				x += SPEED;
			}
		}
			
		else if (left) {
			if (x > 0) {
				x -= SPEED;
			}
		}

		double calcY = (screenHeight-y);
		double calcnewY = calcY + VEL*dt;
		if (inAir){
			VEL = VEL + GRAVITY*dt;
		}
		if (!inAir){
			System.out.println(VEL);
			VEL = (Math.sqrt(VEL*VEL))*0.8;
		}

		double newY = screenHeight-calcnewY;
		if (newY >= 0) {
			if (newY <= (screenHeight-playerHeight)){
				y = newY;
			}
			else {
				y = screenHeight-playerHeight;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, playerWIDTH, playerHeight);
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

	public void setSpace(boolean space) {
		this.space = space;
	}
	
}
