package com.thecherno.rain.level.tile;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.graphics.SpriteSheet;
import com.thecherno.rain.level.tile.spawn_level.SpawnBirchTile;
import com.thecherno.rain.level.tile.spawn_level.SpawnBrickTile;
import com.thecherno.rain.level.tile.spawn_level.SpawnGrassTile;
import com.thecherno.rain.level.tile.spawn_level.SpawnHedgeTile;
import com.thecherno.rain.level.tile.spawn_level.SpawnWallTile;
import com.thecherno.rain.level.tile.spawn_level.SpawnWaterTile;

public class Tile {

	public int x, y;
	public Sprite sprite;
	
	//row1
	public static Tile flowers = 	new FlowerTile (Sprite.flowers);
	public static Tile grass1 = 	new GrassTile(Sprite.grass1);
	public static Tile grass2 = 	new GrassTile(Sprite.grass2);
	public static Tile grass3 = 	new GrassTile(Sprite.grass3);
	public static Tile rock = 		new RockTile(Sprite.rock);
	public static Tile voidTile = 	new VoidTile (Sprite.voidSprite);
	
	//row1 and 2
	public static Tile spawn_brick_red1 = 	new SpawnBrickTile(Sprite.brick_red1);
	public static Tile spawn_brick_red2 = 	new SpawnBrickTile(Sprite.brick_red2);
	public static Tile spawn_brick_colored =new SpawnBrickTile(Sprite.brick_colored);
	public static Tile spawn_brick_darkRed =new SpawnBrickTile(Sprite.brick_darkRed);
	public static Tile spawn_brick_white =  new SpawnBrickTile(Sprite.brick_white);
	public static Tile spawn_brick_house = 	new SpawnBrickTile(Sprite.brick_house);
	public static Tile spawn_stonewall_mixed = 	new SpawnWallTile(Sprite.stonewall_mixed);
	public static Tile spawn_stone_wall1 = 	new SpawnWallTile(Sprite.stone_wall1);
	public static Tile spawn_stone_wall_vine = 	new SpawnWallTile(Sprite.stone_wall_vine);
	public static Tile spawn_stone_wall_crack = new SpawnWallTile(Sprite.stone_wall_crack);
	
	//row2
	public static Tile spawn_grass_fall = 		new SpawnGrassTile (Sprite.grass_fall);
	public static Tile spawn_grass_summer = 	new SpawnGrassTile (Sprite.grass_summer);
	public static Tile spawn_grass_winter = 	new SpawnGrassTile (Sprite.grass_winter);
	public static Tile spawn_grass4 = 			new SpawnGrassTile (Sprite.grass4);
	public static Tile spawn_grass5 = 			new SpawnGrassTile (Sprite.grass5);
	public static Tile spawn_grass6 = 			new SpawnGrassTile (Sprite.grass6);
	public static Tile spawn_water1 = 			new SpawnWaterTile (Sprite.water1);
	public static Tile spawn_water2 = 			new SpawnWaterTile (Sprite.water2);
	public static Tile spawn_water3 = 			new SpawnWaterTile (Sprite.water3);
	
	//row3
	public static Tile spawn_hedge = 			new SpawnHedgeTile (Sprite.hedge);
	public static Tile spawn_hedge_fall = 		new SpawnHedgeTile (Sprite.hedge_fall);
	public static Tile spawn_birch = 			new SpawnBirchTile (Sprite.birch);
	public static Tile spawn_birch_red = 		new SpawnBirchTile (Sprite.birch_red);
	public static Tile spawn_birch_brown = 		new SpawnBirchTile (Sprite.birch_brown);
	
	

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	} // by default a tile is not solid, you can pass through it, unless we define otherwise in a sub tile class.

}
