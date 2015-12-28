package com.thecherno.rain.level;

import java.util.Random;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tileInt;
	protected int[] tiles;
	private static int SPRITE_SIZE = 16;

	

	
	//this is a constructor.  If defines what is in a level, how those items are defined.
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tileInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	//This is a method.  It is called by a constructor, which sets the parameters to run once the method is called.
	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}
	

	public void update() {

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll); // xScroll, yScroll is the actual location of the player
		int x0 = xScroll >> 4;
			// >>4 is the same as / 16. move from pixel 
			//precision to tile precision
		int x1 = (xScroll + screen.width + SPRITE_SIZE) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + SPRITE_SIZE) >> 4;
			//the above variables define the render region; 
			//where the Scroll variables refer to play position 
			//on the screen. These are called  corner pins.
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				//x0, x1 = x min and x max on the screen
				//y0k y1 = y min and y max on the screen
				getTile(x, y).render(x,y,screen);

				
				// getTile examines the map array and gets the value of the specific tile there.
				// grass, stone, flowers, etc.
				// then we call the render method from Tile to put the tile on the screen
				
				}
			}
		}

	// Grass = 	 0xFF00FF00 = Green
	// Wall =  	 0xFF000000 = Black
	// Flowers = 0xFFFFFF00 = Yellow
	// Rock = 	 0xFF808080 = Grey
	public Tile getTile(int x, int y) {
		Random random = new Random();
		// This allows us to take the finite map and make it look infinite by
		// providing values that are outside of the boundary of level.
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == 0xFFFFFF00 ) return Tile.flowers;
		if (tiles[x + y * width] == 0xFF00FF00){
			if (random.nextInt(3) == 0) return Tile.grass1;
			if (random.nextInt(3) == 1) return Tile.grass2;
			if (random.nextInt(3) == 2) return Tile.grass3;
		}
		if (tiles[x + y * width] == 0xFF808080) return Tile.rock;
		if (tiles[x + y * width] == 0xFF000000) return Tile.rock; // this should be Tile.wall in the future.
		
		return Tile.voidTile;
	}
	
}
