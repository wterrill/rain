/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecherno.rain.graphics;


public class AnimatedSprite extends Sprite{
    
    private int frame = 0;
    private Sprite sprite;
    private int rate = 5;
    private int time = 0;
    private int animationSize = 0;
    private int length = -1;
    

    
       public AnimatedSprite (SpriteSheet sheet, int width, int height, int lenght){    
           super(sheet, width, height);
           this.length = length;
           sprite = sheet.getSprites()[0];
           if (length > sheet.getSprites().length) System.err.println("ERROR! Length of Animation too Long!");
       }
       
       public void update(){
           time++;
           if (time % rate == 0) {
            if (frame >= (length - 1)) frame = 0;
            else frame++;
            sprite = sheet.getSprites()[frame];
           }
           System.out.println(sprite + ": " + frame);
       }
       
       public Sprite getSprite(){
           
           return sprite;
       }
       
       public void setFrameRate (int frames){
           rate = frames;
       }
}
