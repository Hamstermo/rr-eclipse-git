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
		frame.setVisible(true);
		
		canvas = new Canvas();
		frame.add(canvas);
		canvas.addKeyListener(this);
		
		handler = new Handler();
		
		player = new Player(100, 100);
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
	}
	
}
