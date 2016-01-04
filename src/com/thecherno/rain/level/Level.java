package com.thecherno.rain.level;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.entity.Projectile.Projectile;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tileInt;
	protected int[] tiles;
	private static int SPRITE_SIZE = 16;
	
	private static List<Entity> entities = new ArrayList<Entity>();
	private static List<Projectile> projectiles = new ArrayList<Projectile>();
	
	public static Level spawn = new SpawnLevel("/levels/spawn.png");

	

	
	//this is a constructor.  If defines what is in a level, how those items are defined.
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tileInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	//This is a method.  It is called by a constructor, which sets the parameters to run once the method is called.
	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}
	

	public void update() {
		for (int i = 0; i < entities.size(); i++){
		entities.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++){
		projectiles.get(i).update();
		}
	}

	private void time() {
	}
	
	public boolean tileCollision (double x, double y, double nx, double ny, int size){
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			double xt =  ((x + nx) + c % 2 * size / 16);
			double yt =  ((y + ny) + c / 2 * size / 16);
			if (getTile( (int)xt,(int)yt ).solid()) solid = true;
			}
		return solid;	
	}
	

	public List <Projectile> getProjectiles() {
		return projectiles;
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll); // xScroll, yScroll is the actual location of the player
		int x0 = xScroll >> 4;
			// >>4 is the same as / 16. move from pixel 
			//precision to tile precision
		int x1 = (xScroll + screen.width + SPRITE_SIZE) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + SPRITE_SIZE) >> 4;
			//the above variables define the render region; 
			//where the Scroll variables refer to play position 
			//on the screen. These are called  corner pins.
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				//x0, x1 = x min and x max on the screen
				//y0k y1 = y min and y max on the screen
				getTile(x, y).render(x,y,screen);

				
				// getTile examines the map array and gets the value of the specific tile there.
				// grass, stone, flowers, etc.
				// then we call the render method from Tile to put the tile on the screen
				
				}
			}
		for (int i = 0; i < entities.size(); i++){
			entities.get(i).render(screen);
			}
		
		for (int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).render(screen);
			}
		}

	public static void add(Entity e){
		entities.add(e);
	}
	
	public  void addProjectile(Projectile p)
	{
		p.init(this);
		projectiles.add(p);
	}
	// Grass = 	 0xFF00FF00 = Green
	// Wall =  	 0xFF000000 = Black
	// Flowers = 0xFFFFFF00 = Yellow
	// Rock = 	 0xFF808080 = Grey
/*	public Tile getTile(int x, int y) {
		Random random = new Random();
		// This allows us to take the finite map and make it look infinite by
		// providing values that are outside of the boundary of level.
		try{
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.col_spawn_flowers ) return Tile.flowers;
		if (tiles[x + y * width] == Tile.col_spawn_grass1)return Tile.grass1; 
		if (tiles[x + y * width] == Tile.col_spawn_grass2)return Tile.spawn_grass_summer; 
		if (tiles[x + y * width] == Tile.col_spawn_grass3)return Tile.spawn_grass5; 
		if (tiles[x + y * width] == Tile.col_spawn_sidewalk)return Tile.spawn_birch;
		if (tiles[x + y * width] == Tile.col_spawn_rock)return Tile.rock;
		if (tiles[x + y * width] == Tile.col_spawn_walls)return Tile.spawn_stone_wall1;
		if (tiles[x + y * width] == Tile.col_spawn_inner_walls)return Tile.spawn_brick_colored;
		if (tiles[x + y * width] == Tile.col_spawn_flooring)return Tile.spawn_birch_red; 
		if (tiles[x + y * width] == Tile.col_spawn_water){
			return Tile.spawn_stone_wall_vine; 
		}
		
		
		
		if (tiles[x + y * width] == 0xFF000000) return Tile.rock; // this should be Tile.wall in the future.
		} catch(NullPointerException e) {
			if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
			if (tileInt[x + y * width] == 0 ) return Tile.flowers;
			if (tileInt[x + y * width] == 1) return Tile.grass1;
			if (tileInt[x + y * width] == 2) return Tile.grass2;
			if (tileInt[x + y * width] == 3) return Tile.grass3;
			if (tileInt[x + y * width] == 4) return Tile.rock;
			//if (tileInt[x + y * width] == 0xFF000000) return Tile.rock; // this should be Tile.wall in the future.
		}
		
		
		return Tile.voidTile;
	}*/
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile_generic;
		if (tiles[x + y * width] == Tile.col_spawn_flowers ) 
			{
			return Tile.flowers_generic;
			}
		if (tiles[x + y * width] == Tile.col_spawn_grass1)
			{
			return Tile.grass1_generic; 
			}
		if (tiles[x + y * width] == Tile.col_spawn_grass2)return Tile.spawn_grass_summer; 
		if (tiles[x + y * width] == Tile.col_spawn_grass3)return Tile.grass1_level1; 
		if (tiles[x + y * width] == Tile.col_spawn_sidewalk)return Tile.spawn_birch;
		if (tiles[x + y * width] == Tile.col_spawn_rock)return Tile.rock_generic;
		if (tiles[x + y * width] == Tile.col_spawn_walls)return Tile.spawn_stone_wall2;
		if (tiles[x + y * width] == Tile.col_spawn_inner_walls)return Tile.spawn_brick_colored;
		if (tiles[x + y * width] == Tile.col_spawn_flooring)return Tile.spawn_birch_red; 
		if (tiles[x + y * width] == Tile.col_spawn_water)return Tile.spawn_water1; 
		return Tile.voidTile_generic;
	}
}
