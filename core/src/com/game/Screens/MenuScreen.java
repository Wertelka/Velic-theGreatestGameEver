package com.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.game.Velic;
import com.game.managers.InputManager;

public class MenuScreen implements Screen {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture startTexture;
    private Texture exitTexture;
    private Texture back;
    private Sprite startButton;
    private Sprite exitButton;
    private Sprite backSprite;

    private static float BUTTON_RESIZE = 300f;
    private static float START_VERT_RESIZE = 2.7f;
    private static float EXIT_VERT_RESIZE = 4.2f;

    public float height = Gdx.graphics.getHeight();
    public float width = Gdx.graphics.getWidth();

    private Vector3 temp = new Vector3();
    private Velic game;
    public MenuScreen(Velic game) {
        this.game = game;

        camera = new OrthographicCamera(width, height);
        camera.setToOrtho(false);
        batch = new SpriteBatch();
        startTexture = new Texture(Gdx.files.internal("start.png"));
        exitTexture = new Texture(Gdx.files.internal("exit.png"));
        back  =new Texture(Gdx.files.internal("background.png"));
        backSprite = new Sprite(back);
        backSprite.setSize(width, height);
        startButton = new Sprite(startTexture);
        exitButton = new Sprite(exitTexture);

        startButton.setSize(startButton.getWidth()*(width/BUTTON_RESIZE), startButton.getHeight()*(width/BUTTON_RESIZE));
        exitButton.setSize(exitButton.getWidth()*(width/BUTTON_RESIZE), exitButton.getHeight()*(width/BUTTON_RESIZE));

        startButton.setPosition(width/2f - startButton.getWidth()/2, width/START_VERT_RESIZE);
        exitButton.setPosition(width/2f - exitButton.getWidth()/2, width/EXIT_VERT_RESIZE);

        Gdx.input.setInputProcessor(new InputManager(camera));
    }

    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {
    Gdx.gl.glClearColor(1,1,1,1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    batch.setProjectionMatrix(camera.combined);
    batch.begin();
    backSprite.draw(batch);
    startButton.draw(batch);
    exitButton.draw(batch);
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
        dispose();
    }

    @Override
    public void dispose() {
        startTexture.dispose();
        exitTexture.dispose();
        batch.dispose();
    }

    public void handleTouch(){
        if(Gdx.input.justTouched()){
            temp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(temp);
            float touchX = temp.x;
            float touchY = temp.y;
            if((touchX>=startButton.getX()) && touchX<= (startButton.getX()+startButton.getWidth()) && (touchY>=startButton.getY()) && touchY<=(startButton.getY()+startButton.getHeight())){
                game.setScreen(new GameScreen());

            }
            if((touchX >= exitButton.getX()) && touchX <= (exitButton.getX() + exitButton.getWidth()) && (touchY >= exitButton.getY()) && touchY <= (exitButton.getY() + exitButton.getHeight())){
                Gdx.app.exit();
            }
        }
    }
}
