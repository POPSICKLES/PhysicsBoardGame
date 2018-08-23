package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -1285670934175365101L;
	
	private Menu menu;

	public static final int WIDTH = 1000, HEIGHT = WIDTH;

	private Thread thread;
	private boolean running = false;
	private int frames;

	private Handler handler;
	
	public enum TURN{
		player1,
		player2,
		bot,
		command
	}

	public enum STATE{
		Menu,
		Help,
		Game,
		End,
	};

	public STATE gameState = STATE.Menu;

	public Game() {
		this.handler = new Handler(this);
		this.menu = new Menu(this, this.handler);

		//Random r = new Random();
		this.addMouseListener(menu);
		this.addKeyListener(new KeyInput(handler));

		new Window(WIDTH, HEIGHT, "Magnetic Fields and Ladders, Without the Ladders", this);

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;

		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				this.frames = frames;
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		if(gameState == STATE.Game)
			handler.tick();
		else {
			this.menu.tick();
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		if(gameState == STATE.Game)
			handler.render(g);
		else {
			this.menu.render(g);
		}
		
		Font fnt = new Font("ariel", 1, 15);
		g.setFont(fnt);
		g.setColor(Color.green);
		g.drawString("FPS: " + this.frames, 900, 20);
		
		g.dispose();
		bs.show();
	}

	public static void main(String args[]) {
		new Game();
	}
}
