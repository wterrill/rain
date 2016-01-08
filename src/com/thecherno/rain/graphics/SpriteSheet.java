package com.thecherno.rain.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	
	public final int SIZE;
	public int[] pixels;
	public static SpriteSheet characters = new SpriteSheet ("/textures/sheets/charactersheet.png", 256);
	public static SpriteSheet generic_tiles = new SpriteSheet ("/textures/sheets/genericTiles.png", 256);
	public static SpriteSheet level1 = new SpriteSheet("/textures/sheets/level1.png",48);
	public static SpriteSheet projectile_wizard = new SpriteSheet("/textures/sheets/projectiles/wizard.png",48);
	public SpriteSheet (String path, int size) {
		this.path = path;
		SIZE = size;
		pixels = new int [SIZE * SIZE];
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
