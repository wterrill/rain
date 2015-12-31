package com.thecherno.rain.entity.Projectile;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Sprite;

public abstract class Projectile extends Entity {
	
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny; //new x and new y. 
	protected double speed, rateOfFire, range, damage;
	
	public Projectile(int x, int y, int dir){
		xOrigin = x;
		yOrigin = y;
		angle = dir;
	}
	
	protected void move(){
		
	}
}
