package KillAll;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
	private JFrame1 frame;
	
	public int width, hight;
	public String title;
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage testImage;
	
	public Game(String title ,int width, int hight) {
		this.width=width;
		this.hight=hight;
		this.title=title;
		
	}
	
	private void init() {
		frame = new JFrame1(title, hight, hight);
		testImage = ImagesLoader.loadImage("/textures/backg.jpg/");
	}
	
	public void tick() {
		
	}
	
	
	private void render() {
		bs = frame.getCanvas().getBufferStrategy();
		if(bs == null) {
			frame.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, width, hight);
		//Draw here!
		
		g.drawImage(testImage, 50, 50, null);
		
		
		//end draw
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();
		while(running) {
			tick();
			render();
		}
		stop();
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
