package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas{

	private JFrame frame;
	private int width = 1050, height = 800;
	
	private long last;
	private long delta;
	private double fps;
		
	private MouseCursor cursor;
	private Bot bot;
	
	public Game() {
		last = System.nanoTime();	
		window();	
		bot = new Bot(getWidth()/2, getHeight()/2, this, 5);
		cursor = new MouseCursor(0, 0, this);
		gameLoop();
	}
	
	/**
	 * 
	 */
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//Debug
		g.setColor(Color.CYAN);
		g.setFont(new Font("Calibri", Font.PLAIN, 12));
		g.drawString("FPS: " + ((int) (fps)), 10, 20);
		g.drawString("Cursor: " + cursor.position.toString(), 10, 40);
		g.drawString("Bot: " + bot.position.toString(), 10, 60);
		//
		
		g.drawString("Bot", (int) bot.position.x - 4, (int) bot.position.y - 5);
		
		bot.render(g);
		
		g.dispose();
		bs.show();
	}
	
	/**
	 * 
	 */
	public void gameLoop() {
		new Thread(() -> {
			while(true) {
				render();
				fps();
				
				cursor.update();
				bot.update();
				
				try {
					Thread.sleep(10);
				} catch (Exception e) {
				}
			}
		}).start();
	}
	
	public void window() {
		frame = new JFrame();
		
		frame.setMaximumSize(new Dimension(width, height));
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(0, 40);
		frame.requestFocus();
		frame.setTitle("Bot Test 1.0");
		frame.add(this);
		
		frame.setVisible(true);
	}
	
	public void fps() {
		delta = System.nanoTime() - last;
		last = System.nanoTime();
		fps = 1e9/delta;
	}
	
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the cursor
	 */
	public MouseCursor getMouseCursor() {
		return cursor;
	}

	/**
	 * @return the bot
	 */
	public Bot getBot() {
		return bot;
	}

	public static void main(String[] args) {
		new Game();
	}
	
}
