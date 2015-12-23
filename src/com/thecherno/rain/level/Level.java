package com.thecherno.rain.level;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tiles;

	
	//this is a constructor.  If defines what is in a level, how those items are defined.
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	//This is a method.  It is called by a constructor, which sets the parameters to run once the method is called.
	protected void generateLevel() {

	}

	private void loadLevel(String path) {

	}

	public void update() {

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		// >>4 is the same as / 16. move from pixel precision to tile precision
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		// the above variables define the rend region; where the Scroll variables refer to play position on the screen.
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x,y,screen);
				}
			}
		}


	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == 0) return Tile.grass;
		return Tile.voidTile;
	}
	
}
