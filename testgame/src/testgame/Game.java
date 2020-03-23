package testgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game implements Runnable {

	private final int WIDTH = 640;
	private final int HEIGHT = 480;
	
	private JFrame frame;
	private Canvas canvas;
	
	public Game() {
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		
		canvas = new Canvas();
		frame.add(canvas);
		
		new Thread(this).start();
	}
	
	private void tick() {
		
	}
	
	private void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
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
