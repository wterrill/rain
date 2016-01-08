package com.thecherno.rain.entity.particle;

import com.thecherno.rain.entity.Entity;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;

public class Particle extends Entity {
	private Sprite sprite;
	private int life;
	private int time;
	
	protected double xx,yy,xa, ya;
	
	public Particle(int x, int y, int life){
		System.out.println("particle life " + life);
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		this.life = life;		
		sprite = Sprite.paricle_normal;
	}

	public void update(){
		time++;
		if (time >= 8000) time = 0;
		if(time > life) remove();
		this.xx += xa;
		this.yy += ya;
	}
	
	public void render (Screen screen){
		screen.renderSprite((int)xx,(int)yy,sprite,true);
	}
}
