package com.thecherno.rain.entity.Projectile;

import com.thecherno.rain.entity.particle.Particle;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.Tile;

public class WizardProjectile extends Projectile {
	
	public static final int FIRE_RATE = 10; //Higher value is slower.

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = random.nextInt(50)+80;
		damage = 20;
		speed = 3;
		sprite = Sprite.projectile_wizard;
		nx = speed * Math.cos(dir);
		ny = speed * Math.sin(dir);
		
		
	}

	public void update(){
		if (level.tileCollision(x, y, nx, ny, 7)){
			Particle p = new Particle((int)x,(int)y,500);
			level.add(p);remove();	
		}
			move();
	}
	
	protected void move() {
		
		x += nx;
		y += ny;
		
		if (distance() > range) remove();
		
	}
	
	private double distance(){
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x)*(xOrigin - x)) + Math.abs((yOrigin - y)*(yOrigin - y)));
		return dist;
	}
	public void render(Screen screen){
		screen.renderProjectile((int)x -8, (int)y -8, this);
	}
}
