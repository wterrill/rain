package com.thecherno.rain.level.tile;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class GrassTile extends Tile{

	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
			screen.renderTile(x << 4, y << 4, this.sprite);
			// the bitwise shift left converts tile precision into pixel precision
	}
	
	public boolean solid(){
		return false;
	}
}
