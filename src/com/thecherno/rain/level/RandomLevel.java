package com.thecherno.rain.level;

import java.util.Random;

public class RandomLevel extends Level {
	
	private static final Random random = new Random();
	
	
	//super refers to the extended constructor.  Any attributes we add to a super will be applied to the extended constructor to to run that constructor..
	public RandomLevel(int width, int height) {
		super(width, height);

	}
	protected void generateLevel(){
		int rand = 0; 
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				// The random generator below is for rocks, so that the frequency of them can be 
				// controlled.  Below, there is a 1 in 50 chance that a given tile will be set as a "4" (rock)
				// if not, then the randomness is limited to the grass tiles. 
				if (random.nextInt(50) == 1){
						rand = 4;
					}else{
						rand = random.nextInt(4);
						}
				tileInt [x+y*width] = rand;
				}
			}
		}
	}

