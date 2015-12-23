package com.thecherno.rain.level;

import java.util.Random;

public class RandomLevel extends Level {
	
	private static final Random random = new Random();
	
	
	//super refers to the extended constructor.  Any attributes we add to a super will be applied to the extended constructor to to run that constructor..
	public RandomLevel(int width, int height) {
		super(width, height);

	}
	protected void generateLevel(){
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
			tiles [x+y*width] = random.nextInt(4);	
			}
		}
	}
}
