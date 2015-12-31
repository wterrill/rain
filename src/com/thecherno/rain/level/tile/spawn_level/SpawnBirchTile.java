package com.thecherno.rain.level.tile.spawn_level;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.Tile;

public class SpawnBirchTile extends Tile {

	public SpawnBirchTile(Sprite sprite) {
		super(sprite);
	}
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
		// the bitwise shift left converts tile precision into pixel precision
	}
	
	public boolean solid(){
		return false;
	}

}
