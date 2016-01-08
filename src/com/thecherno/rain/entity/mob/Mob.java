package com.thecherno.rain.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.entity.Projectile.Projectile;
import com.thecherno.rain.entity.Projectile.WizardProjectile;
import com.thecherno.rain.entity.particle.Particle;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.Level;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 2;
	protected boolean moving = false;
	protected boolean walking = false;
	
	
	public void move(int xa, int ya) {
		if (xa != 0 && ya!=0){
			move(xa,0);
			move(0,ya);
			return;
		}
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
	
	protected void shoot(int x, int y, double dir){
		//dir = Math.toDegrees(dir);
		Projectile p = new WizardProjectile(x,y,dir);
		level.add(p);
	}
	
	private boolean collision (int xa, int ya){
		boolean solid = false;
		for(int c = 0; c < 4; c++){
			int xt = ((x + xa) + c % 2 * 14 - 8) / 16;
			int yt = ((y + ya) + c/2 * 12 + 3)/ 16;
			if (level.getTile(xt,yt).solid()) solid = true;
		}
		return solid;
	}
	
	public void render () {
	}
}
