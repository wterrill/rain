package com.thecherno.rain.graphics;

import java.util.Random;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int [] pixels;
	private SpriteSheet sheet;
	
	//row1
	public static Sprite flowers = 			new Sprite (16, 0, 0, SpriteSheet.tiles);
	public static Sprite grass1 = 			new Sprite (16, 5, 0, SpriteSheet.tiles);
	public static Sprite grass2 = 			new Sprite (16, 8, 0, SpriteSheet.tiles);
	public static Sprite grass3 = 			new Sprite (16, 9, 0, SpriteSheet.tiles);
	public static Sprite rock = 			new Sprite (16, 10, 0, SpriteSheet.tiles);
	public static Sprite brick_red1 = 		new Sprite (16, 11, 0, SpriteSheet.tiles);
	public static Sprite stonewall_mixed = 	new Sprite (16, 12, 0, SpriteSheet.tiles);
	public static Sprite stone_wall1 = 		new Sprite (16, 13, 0, SpriteSheet.tiles);
	public static Sprite stone_wall_vine = 	new Sprite (16, 14, 0, SpriteSheet.tiles);
	public static Sprite stone_wall_crack = new Sprite (16, 15, 0, SpriteSheet.tiles);
	
	//row2
	public static Sprite brick_red2 = 		new Sprite (16, 0, 1, SpriteSheet.tiles);
	public static Sprite brick_colored =	new Sprite (16, 1, 1, SpriteSheet.tiles);
	public static Sprite brick_darkRed =	new Sprite (16, 2, 1, SpriteSheet.tiles);
	public static Sprite brick_white = 		new Sprite (16, 3, 1, SpriteSheet.tiles);
	public static Sprite brick_house = 		new Sprite (16, 4, 1, SpriteSheet.tiles);
	public static Sprite stone_wall2 = 		new Sprite (16, 5, 1, SpriteSheet.tiles);
	public static Sprite grass_fall = 		new Sprite (16, 6, 1, SpriteSheet.tiles);
	public static Sprite grass_summer = 	new Sprite (16, 7, 1, SpriteSheet.tiles);
	public static Sprite grass_winter = 	new Sprite (16, 8, 1, SpriteSheet.tiles);
	public static Sprite grass4 = 			new Sprite (16, 9, 1, SpriteSheet.tiles);
	public static Sprite grass5 = 			new Sprite (16, 10, 1, SpriteSheet.tiles);
	public static Sprite grass6 = 			new Sprite (16, 11, 1, SpriteSheet.tiles);
	public static Sprite water1 = 			new Sprite (16, 12, 1, SpriteSheet.tiles);
	public static Sprite water2 = 			new Sprite (16, 13, 1, SpriteSheet.tiles);
	public static Sprite water3 = 			new Sprite (16, 14, 1, SpriteSheet.tiles);
	
	//row3
	public static Sprite hedge = 			new Sprite (16, 8, 2, SpriteSheet.tiles);
	public static Sprite hedge_fall = 		new Sprite (16, 8, 2, SpriteSheet.tiles);
	public static Sprite birch = 			new Sprite (16, 10, 2, SpriteSheet.tiles);
	public static Sprite birch_red = 		new Sprite (16, 11, 2, SpriteSheet.tiles);
	public static Sprite birch_brown = 		new Sprite (16, 12, 2, SpriteSheet.tiles);
	
	
		// creates a new, static Sprite.  Sprite.grass is 
		// not accessible from all other classes. 
		// Sprite grass = a new Sprite.  Below we defined a 
		// Sprite to need (size, x, y, Spritesheet.sheet), where size 
		// is the size of the sprite in pixels, x is the beginning 
		// x coordinate on the sprite sheet, y the beginning 
		// y coordinate of the sprite on the sprite sheet, and 
		// Spritesheet sheet the actualy spritesheet that we have 
		// stored the sprite into in the Spritesheet class
	
	public static Sprite voidSprite = new Sprite (16,0x1B87E0);
	
	//the player sprite is 32x32, so the numbering on the sprite sheet is different.
	public static Sprite player_up = 		new Sprite(32, 0, 1, SpriteSheet.tiles);
	public static Sprite player_up_1 = 		new Sprite(32, 0, 2, SpriteSheet.tiles);
	public static Sprite player_up_2 = 		new Sprite(32, 0, 3, SpriteSheet.tiles);
	
	public static Sprite player_right = 	new Sprite(32, 1, 1, SpriteSheet.tiles);
	public static Sprite player_right_1 =	new Sprite(32, 1, 2, SpriteSheet.tiles);
	public static Sprite player_right_2 =	new Sprite(32, 1, 3, SpriteSheet.tiles);
	
	public static Sprite player_down = 		new Sprite(32, 2, 1, SpriteSheet.tiles);
	public static Sprite player_down_1 = 	new Sprite(32, 2, 2, SpriteSheet.tiles);
	public static Sprite player_down_2 = 	new Sprite(32, 2, 3, SpriteSheet.tiles);
	
	public static Sprite player_left = 		new Sprite(32, 3, 1, SpriteSheet.tiles);
	public static Sprite player_left_1 = 	new Sprite(32, 3, 2, SpriteSheet.tiles);
	public static Sprite player_left_2 =	new Sprite(32, 3, 3, SpriteSheet.tiles);
	

	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
			//this defines what a new Sprite needs in order 
			// to be created, and what those objects correlate too.
		SIZE = size;
		pixels = new int [SIZE*SIZE];
		this.x = x * size;
		// setting the x coordinate / y coordinate of a sprite.  We want the sprite that starts at x = 5, y = 2.  But the sprite is 16 pixels big (defined by size).  So the logical coordinates are actually x* size and y*size.
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite (int size, int color){
		SIZE = size;
		pixels = new int [SIZE*SIZE];
		setColor(color);
	}
	private void setColor(int color){
		for (int i= 0; i<SIZE*SIZE; i++){
			pixels[i] = color;
		}
	}
	
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x=0; x<SIZE; x++) {
				pixels [x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
				//sets / extracts a single sprite from the sprite sheet.  It sets the sprite pixels (pixels [x+y * size] to a specific pixel in the sprite sheet.
			}
		}
	}
	
}
