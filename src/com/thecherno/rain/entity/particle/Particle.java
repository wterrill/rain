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
		this.zz = random.nextFloat() + 2.0;
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		this.life = life + random.nextInt(100) - 10;		
		sprite = Sprite.paricle_normal;
	}

	public void update(){
		time++;
		if (time >= 8000) time = 0;
		if(time > life) remove();
		za -= 0.1;
		if(zz<0){ //zz = 0 is our 'floor
			zz=0; //we keep the z value pinned to the floor.
			za*=-0.6; //we multiply by -0.8 in order to have the velocity change direction and get reduced for every 'bounce'
			xa*=0.4; //to keep particles grouped, we half the x and y distances.
			ya*=0.4;
		}
		move((xx + xa), (yy + ya) + (zz + za));
	}
	
	private void move(double x, double y) {
		if (collision(x,y)) {
			this.xa *= -0.5;
			this.ya *= -0.5;
			this.za *= -0.5;
		}
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
		
	}

	public boolean collision (double x, double y){
		boolean solid = false;
		for(int c = 0; c < 4; c++){  //These are here to "look" in each of the four different directions. 
			double xt = (x - c % 2 * 16) /16.0;				
			double yt = (y - c/2 * 16 )  /16.0;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if (c % 2 == 0){
				ix = (int)Math.floor(xt);
			}//c = 0 and 2 =  RIGHT.
			
			if (c / 2 == 0) iy = (int) Math.floor(yt); //c = 0 = DOWN
			
			if (level.getTile(ix,iy).solid()) solid = true;
		}
		return solid;
	}
	public void render (Screen screen){
		screen.renderSprite((int)xx ,(int)yy - (int)zz ,sprite,true);
	}
}
