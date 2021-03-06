package testgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import testgame.entity.Handler;
import testgame.entity.Player;

public class Game implements Runnable, KeyListener {

	private final int WIDTH = 640;
	private final int HEIGHT = 480;
	
	private JFrame frame;
	private Canvas canvas;
	
	private Thread thread;
	
	private Handler handler;
	private Player player;
	
	public Game() {
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		canvas = new Canvas();
		frame.add(canvas);
		canvas.addKeyListener(this);
		
		handler = new Handler();
		
		player = new Player(this, 100, 100);
		handler.addEntity(player);
		
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
		
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Game();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
		   
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " Ticks: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			player.setUp(true);
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			player.setDown(true);
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			player.setLeft(true);
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			player.setRight(true);
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			player.setSpace(true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			player.setUp(false);
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			player.setDown(false);
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			player.setLeft(false);
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			player.setRight(false);
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			player.setSpace(false);
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public Canvas getCanvas(){
		return canvas;
	}
	
}
