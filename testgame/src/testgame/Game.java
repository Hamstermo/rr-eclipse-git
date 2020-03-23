package testgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import testgame.entity.Handler;
import testgame.entity.Player;

public class Game implements Runnable {

	private final int WIDTH = 640;
	private final int HEIGHT = 480;
	
	private JFrame frame;
	private Canvas canvas;
	
	private Thread thread;
	
	private Handler handler;
	
	public Game() {
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		
		canvas = new Canvas();
		frame.add(canvas);
		
		handler = new Handler();
		handler.addEntity(new Player(50, 50));
		
		thread = new Thread(this);
		thread.start();
	}
	
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Game();
	}

	@Override
	public void run() {
		while (true) {
			tick();
			render();
		}
	}
	
}
