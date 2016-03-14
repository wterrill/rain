
package com.thecherno.rain.entity.mob;

import com.thecherno.rain.graphics.AnimatedSprite;
import com.thecherno.rain.graphics.Screen;
import com.thecherno.rain.graphics.Sprite;
import com.thecherno.rain.graphics.SpriteSheet;

public class Dummy extends Mob {
    

    
private AnimatedSprite down = new AnimatedSprite(SpriteSheet.npc_skeleton_down, 32, 32, 3);
private AnimatedSprite up = new AnimatedSprite(SpriteSheet.npc_skeleton_up, 32, 32, 3);
private AnimatedSprite left = new AnimatedSprite(SpriteSheet.npc_skeleton_left, 32, 32, 3);
private AnimatedSprite right = new AnimatedSprite(SpriteSheet.npc_skeleton_right, 32, 32, 3);

private AnimatedSprite animSprite = right;
    
public Dummy(int x, int y){
  this.x = x;
  this.y = y;
  sprite = animSprite;
}  
            
    public void update() {
        walking = true;
        
         if (walking) animSprite.update();
        
    }
    
    public void render(Screen screen) {
        sprite = animSprite.getSprite();
        screen.renderMob(x - 16, y - 16, sprite);
    }
}
