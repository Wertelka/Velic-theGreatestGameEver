package com.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Texture playerTexture;
    public Sprite playerSprite;
    public int rotated = 0;
    public Vector2 velocity = new Vector2();
    public Vector2 position = new Vector2();
    public Rectangle bikeRect = new Rectangle();
    public final Vector2 gravity = new Vector2(0, -0.1f);

    public Player(){
        playerTexture = new Texture(Gdx.files.internal("biker.png"));
        playerSprite = new Sprite(playerTexture);

    }

    public void render(SpriteBatch batch) {
        playerSprite.draw(batch);
    }

    public void update(){
    position.add(velocity);
    playerSprite.rotate(rotated);
    playerSprite.setPosition(position.x, position.y);
    bikeRect.setPosition(playerSprite.getX(), playerSprite.getY());
    if(position.y > 0) position.add(gravity);
    }

}
