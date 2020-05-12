package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.game.gameobjects.Player;
import com.game.managers.GameManager;
import com.game.managers.InputManager;

public class Velic implements Screen {

    public static final float height = Gdx.graphics.getHeight();
    public static final float width = Gdx.graphics.getWidth();


    SpriteBatch batch; // объект для отрисовки спрайтов нашей игры
    OrthographicCamera camera; // область просмотра нашей игры
    private Rectangle rotateRight = new Rectangle();
    private Rectangle rotateLeft = new Rectangle();
    private static ShapeRenderer renderer = new ShapeRenderer();
    private InputManager manager;

    public Velic() {

        camera = new OrthographicCamera(width, height);
        camera.setToOrtho(false);
        batch = new SpriteBatch();
        manager = new InputManager(camera);

        GameManager.initialize(width, height);
        GameManager.player.playerSprite.setOriginCenter();
        rotateRight.set(width / 2, 0, width / 2, height);
        rotateLeft.set(0, 0, width / 2, height);
        Gdx.input.setInputProcessor(manager);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);// Очищаем экран
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setColor(Color.GREEN);

        batch.setProjectionMatrix(camera.combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rectLine(0, GameManager.player.playerSprite.getY(), width, GameManager.player.playerSprite.getY(), 30);
        renderer.end();
        batch.begin();
        GameManager.renderGame(batch);
        handleTouch();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        renderer.dispose();
        GameManager.dispose();
    }

    private void handleTouch() {
        boolean rotating = false;
        if (Gdx.input.justTouched()) {
            rotating = true;
        }
        Vector3 temp = new Vector3();
        temp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(temp);
        float touchX = temp.x;
        float touchY = temp.y;
        boolean right = touchX >= rotateRight.getX() && touchX <= (rotateRight.getX() + rotateRight.getWidth()) && (touchY >= rotateRight.getY()) && touchY <= (rotateRight.getY() + rotateRight.getHeight());
        boolean left = touchX >= rotateLeft.getX() && touchX <= (rotateLeft.getX() + rotateLeft.getWidth()) && (touchY >= rotateLeft.getY()) && touchY <= (rotateLeft.getY() + rotateLeft.getHeight());

        if (rotating && right) {
            GameManager.player.rotated += 5;
        } else if (rotating && left) {
            GameManager.player.rotated -= 5;
        } else rotating = false;

        GameManager.player.playerSprite.rotate(GameManager.player.rotated);

        GameManager.player.rotated = 0;
    }
}

