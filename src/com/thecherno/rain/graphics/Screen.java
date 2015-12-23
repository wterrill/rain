package com.thecherno.rain.graphics;

import java.util.Random;

import com.thecherno.rain.entity.mob.Player;
import com.thecherno.rain.level.tile.Tile;

public class Screen {

	public int width;
	public int height;
	public int[] pixels;
	public final int MAP_SIZE = 8;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	// tiles that we use to create a display map

	public int xOffset, yOffset;

	private Random random = new Random();
	// java imported number random generator

	int xtime = 0;
	int ytime = 75;
	int counter = 0;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xFFFFFF);
			// every time that a number (i) is less than are tile size (64*64), add one to a number (i).  Then, asses that integer (i) in the tiles array, and apply a random color from 0-255 (or 0x000000 to 0xFFFFFF where 0x denotes hexidecimal format).
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
			// clear is used to clear the screen; other wise what ever is previously drawn is always displayed.
		}
	}

	//public void render(int xOffset, int yOffset) {
		//for (int y = 0; y < height; y++) {
			//int yp = y + yOffset;
			//if (yp < 0 || yp >= height) continue;
			//for (int x = 0; x < width; x++) {
				//int xp = x + xOffset;
				//if (xp < 0 || xp >= width) continue;
				//int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK)* MAP_SIZE;
				// this tileIndex creates how many pixels reside in a tile (which is 32 x 32) (>> is shift right operation; it is divide by 2 to the power of X, where x is 4 in this equation). the & function is a bitwise function, when you get to tile 63, return to tile 0.  This will create a repeating pattern; or a map loop
				//pixels[xp + yp * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
				// Sprite.grass.pixels we're looking at sprites pixels [(x (from full loop above) & 15.  The bitwise & is like a move with mask.  0 & 0 = 0, 0 & 1 = 0, 1 & 0 = 0, 1 & 1 = 1.  It compares every bit at the bit level.
			//}
		//}
	//}

	// things that go into rendering: Where? -- we're using offset, based off player position.
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa <0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}

	}
	
	public void renderPlayer (int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 16; y++) {
		int ya = y + yp;
		for (int x = 0; x < 16; x++) {
			int xa = x + xp;
			if (xa < -16 || xa >= width || ya < 0 || ya >= height) break;
			if (xa <0) xa = 0;
			pixels[xa + ya * width] = sprite.pixels[x+y*16];
		}
	}
		
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

}
