package com.thecherno.rain.entity.mob;

import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	
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
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right)xa++;
		
		if (xa != 0 || ya != 0) move (xa, ya);
	}
	
	public void render (Screen screen) {
		int xx = x -16;
		int yy = y - 16;
		screen.renderPlayer (xx,yy, sprite.player0);
		screen.renderPlayer (xx + 16,yy, sprite.player1);
		screen.renderPlayer (xx,yy+16, sprite.player2);
		screen.renderPlayer (xx + 16,yy + 16, sprite.player3);
		
		
	}
	

}
