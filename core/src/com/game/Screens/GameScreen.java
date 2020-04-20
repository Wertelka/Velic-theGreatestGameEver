package com.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.game.gameobjects.Player;
import com.game.managers.GameManager;
import com.game.managers.InputManager;

public class GameScreen implements Screen {

    public static float height = Gdx.graphics.getHeight();
    public static float width = Gdx.graphics.getWidth();

    private static Vector2 v2 = new Vector2(5, 0);
    private static Vector2 v21 = new Vector2(5, width);

    SpriteBatch batch; // объект для отрисовки спрайтов нашей игры
    OrthographicCamera camera; // область просмотра нашей игры
    private Player player = GameManager.player;

    private static ShapeRenderer renderer = new ShapeRenderer();

    public GameScreen () {

        camera = new OrthographicCamera(width,height);// устанавливаем переменные высоты и ширины в качестве области просмотра нашей игры
        camera.setToOrtho(false);// этим методом мы центруем камеру на половину высоты и половину ширины
        batch = new SpriteBatch();
        //вызываем метод initialize класса GameManager
        GameManager.initialize(width, height);
        Gdx.input.setInputProcessor(new InputManager(camera));// доступ класса InputManager для получения касаний/нажатий

    }

    @Override
    public void show() {
    }

    @Override
    public void render (float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);// Очищаем экран
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.setColor(Color.GREEN);

        batch.setProjectionMatrix(camera.combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rectLine(0, GameManager.player.playerSprite.getY(), width, GameManager.player.playerSprite.getY(), 30);
        renderer.end();
        batch.begin();
        GameManager.renderGame(batch);
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
        GameManager.dispose();
    }



}