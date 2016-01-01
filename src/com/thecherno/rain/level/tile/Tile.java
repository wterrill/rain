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
	
	//generic
	public static Tile flowers_generic = 	new FlowerTile (Sprite.flowers_generic);
	public static Tile rock_generic = 		new RockTile(Sprite.rock_generic);
	public static Tile grass1_generic = 	new GrassTile(Sprite.grass_generic);
	public static Tile voidTile_generic = 	new VoidTile (Sprite.voidSprite_generic);
	
	//level1

	public static Tile spawn_brick_colored =	new SpawnBrickTile(Sprite.brick_colored);
	public static Tile spawn_stone_wall2 = 	new SpawnWallTile(Sprite.stone_wall2);
	public static Tile spawn_grass_summer = 	new SpawnGrassTile (Sprite.grass_summer);
	public static Tile grass1_level1 = 			new SpawnGrassTile (Sprite.grass1_level1);
	public static Tile grass2_level2= 			new SpawnGrassTile (Sprite.grass2_level1);
	public static Tile spawn_water1 = 			new SpawnWaterTile (Sprite.water1);
	public static Tile spawn_birch = 			new SpawnBirchTile (Sprite.birch);
	public static Tile spawn_birch_red = 		new SpawnBirchTile (Sprite.birch_red);
	
	
	//color definitions
	public final static int col_spawn_flowers 		= 0xFFFFFF00;
	public final static int col_spawn_grass1 		= 0xff4CFF00;
	public final static int col_spawn_grass2 		= 0xFFB6FF00;
	public final static int col_spawn_grass3 		= 0xFF00FF90;
	public final static int col_spawn_sidewalk 		= 0xFF3F3F3F;
	public final static int col_spawn_rock 			= 0xFF808080;
	public final static int col_spawn_walls 		= 0xFF000000;
	public final static int col_spawn_inner_walls 	= 0xFFBFBFBF;
	public final static int col_spawn_flooring 		= 0xFFFFD800;
	public final static int col_spawn_water 		= 0xFF00FFFF;
	

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	} // by default a tile is not solid, you can pass through it, unless we define otherwise in a sub tile class.

}
