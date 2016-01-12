package com.thecherno.rain.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	
	public final int SIZE;
	public final int WIDTH, HEIGHT;
	public int[] pixels;
	public static SpriteSheet characters = new SpriteSheet ("/textures/sheets/charactersheet.png", 256);
	public static SpriteSheet generic_tiles = new SpriteSheet ("/textures/sheets/genericTiles.png", 256);
	public static SpriteSheet level1 = new SpriteSheet("/textures/sheets/level1.png",48);
	public static SpriteSheet projectile_wizard = new SpriteSheet("/textures/sheets/projectiles/wizard.png",48);
	
	public static SpriteSheet player = new SpriteSheet("/textures/sheets/player_sheet.png", 128, 96);
	public static SpriteSheet player_down = new SpriteSheet(player, 0, 0, 1, 3, 32);
	
	public SpriteSheet (SpriteSheet sheet, int x, int y, int width, int height, int spriteSize) {
		//calling variables are in tile precision. xx, yy, w and h are in pixel precision.
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		int w = width * spriteSize;
		int h = height * spriteSize;
		WIDTH = w;
		HEIGHT = h;
		if (width == height) SIZE = width;
		else SIZE = -1;
		pixels = new int[w * h];
		for (int y0 = 0; y0 < h; y0++){
			int yp = yy + y0;
			for (int x0 = 0; x0 < w; x0++){
				int xp = xx + x0;
				pixels[x0 + y0 * w] = sheet.pixels[xp + yp * sheet.WIDTH];
			}
		}
	}
	public SpriteSheet (String path, int size) {
		this.path = path;
		SIZE = size;
		WIDTH = size;
		HEIGHT = size;
		pixels = new int [SIZE * SIZE];
		load();
	}
	
	public SpriteSheet (String path, int width, int height) {
	this.path = path;
	SIZE = -1;
	WIDTH = width;
	HEIGHT = height;
	pixels = new int [WIDTH * HEIGHT];
	load();
	}
	
	private void load() {
		try {
			String a = System.getProperty("java.class.path");
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
