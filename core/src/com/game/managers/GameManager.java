package com.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.game.Screens.GameScreen;
import com.game.gameobjects.Player;

public class GameManager {
    public static Player player;
    public static Texture playerTexture;
    public static Texture backgroundTexture;
    public static Sprite backgroundSprite;
    public static float BIKER_RESIZE = 1500f;

        public static void initialize(float width, float height){
            player = new Player();
            player.playerSprite.setSize(player.playerSprite.getWidth()*(width/BIKER_RESIZE), player.playerSprite.getHeight()*(width/BIKER_RESIZE));
            backgroundTexture = new Texture(Gdx.files.internal("background.png"));
            backgroundSprite = new Sprite(backgroundTexture);
            backgroundSprite.setSize(width, height);
            player.position.set(player.playerSprite.getX() + player.velocity.x, 0.0f);
            player.velocity.set(5,0);
            player.bikeRect.setSize(player.playerSprite.getWidth(), player.playerSprite.getHeight());
        }

        public static void renderGame(SpriteBatch batch){
            backgroundSprite.draw(batch);
            player.update();
            player.render(batch);
        }

        public static void dispose(){
            backgroundTexture.dispose();
            playerTexture.dispose();
        }
}
