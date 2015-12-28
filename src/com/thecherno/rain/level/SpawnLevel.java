package com.thecherno.rain.level;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.thecherno.rain.level.tile.Tile;

public class SpawnLevel extends Level {

	
	private int[] levelPixels;

	public SpawnLevel(String path) {
		super(path);
	}
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			tiles = new Tile [w*h];
			image.getRGB(0, 0, w, h, levelPixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file!");
			
		}
	}
	// Grass = 	 0x00FF00 = Green
	// Wall =  	 0x000000 = Black
	// Flowers = 0xFFFF00 = Yellow
	// Rock = 	 0x808080 = Grey
	protected void generateLevel(){
		for (int i = 0; i < levelPixels.length; i++){
			if (levelPixels[i] == 0xff00ff00) {
				Random random = new Random();
				int rand = random.nextInt(3);
				if (rand == 0) tiles[i] = Tile.grass1;
				if (rand == 1) tiles[i] = Tile.grass2;
				if (rand == 2) tiles [i] = Tile.grass3;
			}
			// commented until the wall class is created.... if (levelPixels[i] == 0xff000000) tiles[i] = Tile.wall;
			if (levelPixels[i] == 0xffffff00) tiles[i] = Tile.flowers;
			if (levelPixels[i] == 0xff808080) tiles[i] = Tile.rock;
			
		}
	}
}
