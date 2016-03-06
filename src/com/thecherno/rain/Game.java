package com.thecherno.rain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import com.thecherno.rain.entity.mob.Player;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.graphics.SpriteSheet;
import com.thecherno.rain.input.Keyboard;
import com.thecherno.rain.input.Mouse;
import com.thecherno.rain.level.Level;
import com.thecherno.rain.level.RandomLevel;
import com.thecherno.rain.level.SpawnLevel;
import com.thecherno.rain.level.TileCoordinate;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	// variables used to set  a defined resolution for the game.
		
	public static String title = "Rain";
	public Screen screen;
	
	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private Level level;
	private Player player;
	private boolean running = false;
	private boolean randomized = false; // This boolean sets whether or not the level is from a pre-created map, or is generated randomly.
	// NEED TO CHECK THESE LINES AND UPDATE ACCORDINGLY
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); //this creates an image
	private int [] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData(); //and this allows us to write to it.
	// Here's a fuller explanation from: http://stackoverflow.com/questions/20852641/bufferedimage-int-pixels-and-rendering-how-do-they-work-they-work-together
	// Basic types like short, int, long etc are not Objects.
	// However, int[] is an array. Arrays are objects in java. Java manipulates objects by reference, not value.
	// In this line you are not creating a new object. You are storing a reference to the object int[] in your 
	// variable pixels. Anything you change in pixels, gets changed inside of the int[] object in image
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen (width, height);
		frame = new JFrame();
		key = new Keyboard();
		if(randomized == true) {
			level = new RandomLevel(64, 64);  //I kind of like the randomized level, so I kept it :) 
		}else{					
		level = Level.spawn;
		}
		TileCoordinate playerSpawn = new TileCoordinate(20,62);
		player = new Player (playerSpawn.x(),playerSpawn.y(), key); //128 is the x and y axis of the spawning points of the player
		player.init(level);
		addKeyListener(key);
		Mouse mouse = new Mouse();
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public static int getWindowWidth(){
		return width * scale;
	}
	
	public static int getWindowHeight(){
		return height * scale;
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
		// threads are sub processes, they allow us to create multiple processes on the same system process instead of multiple .exes
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// anything put between here and the while (running == true) loop is only executed once when we start the game
		long lastTime = System.nanoTime();
		// moves the system time into a last time variable.  long is a very long variable, like a DINT
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running == true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns; // -> creates delta in ms
			lastTime = now;
			while (delta >= 1) {
				update();
					updates++;	// this is updates = updates +1 (we're counting up).
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + "ups, " + frames + "fps");
				frame.setTitle(title + "  |  " + (updates + "ups, " + frames + "fps"));
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
 
	public void update() {
		key.update();
		player.update();
		level.update();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
                
		//screen.renderSheet(40, 40, SpriteSheet.player_down, false);
		
		for (int i=0; i<pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0,50));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("title");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);

		game.start();
	}
}
