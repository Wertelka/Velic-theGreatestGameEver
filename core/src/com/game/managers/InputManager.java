package com.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.game.Screens.MenuScreen;

import java.awt.Menu;


public class InputManager extends InputAdapter {

    float width = Gdx.graphics.getWidth();
    float height = Gdx.graphics.getHeight();

    OrthographicCamera camera;
    static Vector3 temp = new Vector3();

    public InputManager(OrthographicCamera camera){
    this.camera = camera;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button){
        temp.set(screenX, screenY, 0);
        camera.unproject(temp);
        return false;
    }
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button){
        temp.set(screenX, screenY, 0);
        camera.unproject(temp);
        return false;
    }
}
