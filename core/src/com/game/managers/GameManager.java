package com.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.gameobjects.Player;

public class GameManager {
    public static Player player;
    public static Texture playerTexture;
    public static Texture background;
    public static float BIKER_RESIZE = 1500f;

    public static final float height = Gdx.graphics.getHeight();
    public static final float width = Gdx.graphics.getWidth();

        public static void initialize(float width, float height){
            player = new Player();
            player.playerSprite.setSize(player.playerSprite.getWidth()*(width/BIKER_RESIZE), player.playerSprite.getHeight()*(width/BIKER_RESIZE));
            background = new Texture("background.png");

            player.position.set(player.playerSprite.getX() + player.velocity.x, 0f);
            player.playerSprite.setOrigin(player.playerSprite.getWidth()/2, player.playerSprite.getHeight()/2 );
            player.velocity.set(5,0);
            player.bikeRect.setSize(player.playerSprite.getWidth(), player.playerSprite.getHeight());
        }

        public static void renderGame(SpriteBatch batch){
            batch.draw(background, 0, 0, width, height);
            player.render(batch);
            player.update();
        }

        public static void dispose(){
            playerTexture.dispose();
        }
}
