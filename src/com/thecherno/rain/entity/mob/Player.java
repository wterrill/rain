package com.thecherno.rain.entity.mob;

import com.thecherno.rain.Game;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.input.Keyboard;
import com.thecherno.rain.input.Mouse;

public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
	public Player (Keyboard input) {
		this.input = input;
		
	}
	
	
	public Player (int x, int y, Keyboard input){
		this.x = x;
		this.y = y;
		this.input = input;
		// this.x and this.y actually trace all the way back to entity class through the extend parameter.
	}
	
	public void update () {
		int xa=0, ya=0;
		if (anim < 7500) anim++;
		else anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right)xa++;
		
		if (xa != 0 || ya != 0) {
			move (xa, ya);
			walking = true;}
		else
			walking = false;
			
		updateShooting();
	}
	
	private void updateShooting(){
		if (Mouse.getButton() == 1){
			double dx = Mouse.getX() - Game.getWindowWidth()/2;
			double dy = Mouse.getY() - Game.getWindowHeight()/2;
			double dir = Math.atan2(dy, dx);
			shoot(x,y,dir);
		}
	}
	public void render (Screen screen) {
		sprite = Sprite.player_down;
		if (dir == 0) {
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
		int yy = y - 16;
		screen.renderPlayer (xx,yy, sprite);
		
	}
	

}
