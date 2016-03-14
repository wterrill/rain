package com.thecherno.rain.entity.mob;

import com.thecherno.rain.graphics.AnimatedSprite;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.graphics.SpriteSheet;




public class MeleeEnemy extends Mob {

  public void update(){
      
  }
    
  public void render (Screen screen){
      screen.renderMob(x, y, sprite);
  }
    
}
