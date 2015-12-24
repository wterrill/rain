package com.thecherno.rain.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int [] pixels;
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite (16, 0, 0, SpriteSheet.tiles);
	// creates a new, static Sprite.  Sprite.grass is not accessible from all other classes.  Sprite grass = a new Sprite.  Below we defined a Sprite to need (size, x, y, Spritesheet.sheet), where size is the size of the sprite in pixels, x is the beginning x coordinate on the sprite sheet, y the beginning y coordinate of the sprite on the sprite sheet, and Spritesheet sheet the actualy spritesheet that we have stored the sprite into in the Spritesheet class
	public static Sprite voidSprite = new Sprite (16,0x1B87E0);
	
	public static Sprite player0 = new Sprite (16, 1, 0, SpriteSheet.tiles);
	//public static Sprite player1 = new Sprite (16, 2, 0, SpriteSheet.tiles);
	//public static Sprite player2 = new Sprite (16, 3, 0, SpriteSheet.tiles);
	//public static Sprite player3 = new Sprite (16, 4, 0, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		//this defines what a new Sprite needs in order to be created, and what those objects correlate too.
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
				//sets / extracts a single spirte from the sprite sheet.  It sets the sprite pixels (pixels [x+y * size] to a specific pixel in the sprite sheet.
			}
		}
	}
	
}
