package com.thecherno.rain.entity.particle;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class Particle extends Entity {
	private Sprite sprite;
	private int life;
	private int time;
	
	protected double xx,yy, zz;
	protected double xa, ya, za;
	
	public Particle(int x, int y, int life){
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.zz = 20.0;
		this.xa = random.nextGaussian() + 2.0;
		this.ya = random.nextGaussian();
		this.life = life;		
		sprite = Sprite.paricle_normal;
	}

	public void update(){
		time++;
		if (time >= 8000) time = 0;
		if(time > life) remove();
		za -= 0.1;
		if(zz<0){ //zz = 0 is our 'floor
			zz=0; //we keep the z value pinned to the floor.
			za*=-0.8; //we multiply by -0.8 in order to have the velocity change direction and get reduced for every 'bounce'
			xa*=0.4; //to keep particles grouped, we half the x and y distances.
			ya*=0.4;
		}
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}
	
	public void render (Screen screen){
		screen.renderSprite((int)xx + 2,(int)yy - (int)zz + 20,sprite,true);
	}
}
