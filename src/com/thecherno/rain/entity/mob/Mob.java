package com.thecherno.rain.entity.mob;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 2;
	protected boolean moving = false;
	
	public void move(int xa, int ya) {
		if (ya < 0) dir = 0; // up
		if (xa > 0) dir = 1; // right
		if (ya > 0) dir = 2; // down
		if (xa < 0) dir = 3; // left

		if (!collision(xa, ya)){
			
		x += xa;
		y += ya;
		}
		}
	
	public void update () {
		}
	
	private boolean collision (int xa, int ya){
		boolean solid = false;
		if (level.getTile( (x + xa) / 16,  (y + ya) / 16 ).solid()) solid = true;
		return solid;
	}
	
	public void render () {
		
	}

}
