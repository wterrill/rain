package com.thecherno.rain.entity.Projectile;

import java.util.Random;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Sprite;

public abstract class Projectile extends Entity {
	
	protected final int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x,y;
	protected double nx, ny; //new x and new y. 
	protected double distance;
	protected double speed, range, damage;
	
	protected final Random random = new Random();
	
	public Projectile(int x, int y, double dir){
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	protected void move(){
		
	}
	
	public Sprite getSprite(){
		return sprite;	
	}
	
	public int getSpriteSize(){
		return sprite.SIZE;
	}
}
