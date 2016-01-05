package com.thecherno.rain.graphics;

import java.util.Random;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	private int width, height;
	public int [] pixels;
	private SpriteSheet sheet;
	
	//generic sprites from genericTiles.png
	public static Sprite voidSprite_generic = 		new Sprite (16,0x1B87E0);
	public static Sprite flowers_generic = 			new Sprite (16, 3, 1, SpriteSheet.generic_tiles);
	public static Sprite grass_generic = 			new Sprite (16, 0, 1, SpriteSheet.generic_tiles);
	public static Sprite rock_generic = 			new Sprite (16, 2, 1, SpriteSheet.generic_tiles);
	

	//level tiles from level1.png
	public static Sprite birch_red = 		new Sprite (16, 0, 0, SpriteSheet.level1);
	public static Sprite grass1_level1 = 	new Sprite (16, 2, 0, SpriteSheet.level1);
	public static Sprite grass2_level1 = 	new Sprite (16, 1, 0, SpriteSheet.level1);
	public static Sprite grass_summer = 	new Sprite (16, 1, 1, SpriteSheet.level1);
	public static Sprite birch = 			new Sprite (16, 2, 1, SpriteSheet.level1);
	public static Sprite stone_wall2 = 		new Sprite (16, 0, 2, SpriteSheet.level1);
	public static Sprite brick_colored =	new Sprite (16, 1, 2, SpriteSheet.level1); 
	public static Sprite water1 = 			new Sprite (16, 2, 2, SpriteSheet.level1); 
	
	
	
	//the player sprite is 32x32, so the numbering on the sprite sheet is different.
	public static Sprite player_up = 		new Sprite(32, 0, 0, SpriteSheet.characters);
	public static Sprite player_up_1 = 		new Sprite(32, 0, 1, SpriteSheet.characters);
	public static Sprite player_up_2 = 		new Sprite(32, 0, 2, SpriteSheet.characters);
	
	public static Sprite player_right = 	new Sprite(32, 1, 0, SpriteSheet.characters);
	public static Sprite player_right_1 =	new Sprite(32, 1, 1, SpriteSheet.characters);
	public static Sprite player_right_2 =	new Sprite(32, 1, 2, SpriteSheet.characters);
	
	public static Sprite player_down = 		new Sprite(32, 2, 0, SpriteSheet.characters);
	public static Sprite player_down_1 = 	new Sprite(32, 2, 1, SpriteSheet.characters);
	public static Sprite player_down_2 = 	new Sprite(32, 2, 2, SpriteSheet.characters);
	
	public static Sprite player_left = 		new Sprite(32, 3, 0, SpriteSheet.characters);
	public static Sprite player_left_1 = 	new Sprite(32, 3, 1, SpriteSheet.characters);
	public static Sprite player_left_2 =	new Sprite(32, 3, 2, SpriteSheet.characters);
	
	//projectile sprites
	public static Sprite projectile_wizard = new Sprite(16, 0,0, SpriteSheet.projectile_wizard);
	

	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
			//this defines what a new Sprite needs in order 
			// to be created, and what those objects correlate too.
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int [SIZE*SIZE];
		this.x = x * size;
		// setting the x coordinate / y coordinate of a sprite.  We want the sprite that starts at x = 5, y = 2.  But the sprite is 16 pixels big (defined by size).  So the logical coordinates are actually x* size and y*size.
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite (int width, int height, int color){
		this.width = width;
		this.height = height;
		SIZE = -1;
		pixels = new int[width*height];
		setColor(color);
		
	}
	public Sprite (int size, int color){
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int [SIZE*SIZE];
		setColor(color);
	}
	private void setColor(int color){
		for (int i= 0; i<width*height; i++){
			pixels[i] = color;
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
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
