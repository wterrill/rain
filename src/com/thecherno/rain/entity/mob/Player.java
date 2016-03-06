package com.thecherno.rain.entity.mob;

import com.thecherno.rain.Game;
import com.thecherno.rain.entity.Projectile.Projectile;
import com.thecherno.rain.entity.Projectile.WizardProjectile;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.graphics.SpriteSheet;
import com.thecherno.rain.graphics.AnimatedSprite;
import com.thecherno.rain.input.Keyboard;
import com.thecherno.rain.input.Mouse;

public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	private Projectile p;
	
        private int fireRate = 0;
        
        private AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 32, 32, 3);
        private AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 32, 32, 3);
        private AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left, 32, 32, 3);
        private AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 32, 32, 3);
        
        private AnimatedSprite animSprite = down;
	
	public Player (Keyboard input) {
		this.input = input;
		sprite = Sprite.player_down;
                animSprite = down;
	}
	
	public Player (int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input; // this.x and this.y actually trace all the way back to entity class through the extend parameter.
		sprite = Sprite.player_down;
		fireRate = WizardProjectile.FIRE_RATE;
	}
	
	public void update () {
                if (walking) animSprite.update();
                else animSprite.setFrame(0);
		if (fireRate > 0) fireRate--;
			int xa=0, ya=0;
		if (anim < 7500) anim++;
		else anim = 0;
		if (input.up) {
                    ya--;
                    animSprite = up;
                }
                else if (input.down){
                    ya++;
                    animSprite = down;
                }
		if (input.left){
                    xa--;
                    animSprite = left;
                }
                else if (input.right){
                    xa++;
                    animSprite = right;
                }	
		if (xa != 0 || ya != 0) {
			move (xa, ya);
			walking = true;}
		else
			walking = false;
		clear();
		updateShooting();
	}
	
	private void clear(){
		for (int i=0; i< level.getProjectiles().size(); i++){
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) level.getProjectiles().remove(i);
		}
	}
	
	private void updateShooting(){
		if (Mouse.getButton() == 1 && fireRate <= 0){
			double dx = Mouse.getX() - Game.getWindowWidth()/2;
			double dy = Mouse.getY() - Game.getWindowHeight()/2;
			double dir = Math.atan2(dy, dx);
			shoot(x,y,dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}
	}
	
	public void render (Screen screen) {
                
		/*if (dir == 0) {
			sprite = Sprite.player_up;
			if (walking){
				if (anim % 20 > 10){
					sprite = Sprite.player_up_1;
				}else {
					sprite = Sprite.player_up_2;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.player_right;
			if (walking){
				if (anim % 20 > 10){
					sprite = Sprite.player_right_1;
				}else {
					sprite = Sprite.player_right_2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.player_down;
			if (walking){
				if (anim % 20 > 10){
					sprite = Sprite.player_down_1;
				}else {
					sprite = Sprite.player_down_2;
				}
			}
		}
		if (dir == 3) sprite = Sprite.player_left;
		if (dir == 3) {
			sprite = Sprite.player_left;
			if (walking){
				if (anim % 20 > 10){
					sprite = Sprite.player_left_1;
				}else {
					sprite = Sprite.player_left_2;
				}
			}
		}
		int xx = x -16;
		int yy = y - 16; */
                sprite = animSprite.getSprite();
		screen.renderPlayer (x - 16,y - 16, sprite);	
	}
}
