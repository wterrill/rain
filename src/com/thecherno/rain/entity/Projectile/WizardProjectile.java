package com.thecherno.rain.entity.Projectile;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.level.tile.Tile;

public class WizardProjectile extends Projectile {

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 200;
		damage = 20;
		rateOfFire = 15;
		speed = 4;
		sprite = Sprite.projectile_wizard;
		nx = speed * Math.cos(dir);
		ny = speed * Math.sin(dir);
		
		
	}

	public void update(){
		move();
	}
	
	protected void move() {
		x += nx;
		y += ny;
	}
	
	public void render(Screen screen){
		screen.renderTile(x, y, sprite);
	}
}
