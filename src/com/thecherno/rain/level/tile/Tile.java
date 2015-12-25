package com.thecherno.rain.level.tile;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;
	
	public static Tile flowers = new GrassTile (Sprite.flowers);
	public static Tile grass1 = new GrassTile(Sprite.grass1);
	public static Tile grass2 = new GrassTile(Sprite.grass2);
	public static Tile grass3 = new GrassTile(Sprite.grass3);
	public static Tile voidTile = new VoidTile (Sprite.voidSprite);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	} // by default a tile is not solid, you can pass through it, unless we define otherwise in a sub tile class.

}
