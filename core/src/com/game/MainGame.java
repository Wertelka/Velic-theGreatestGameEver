package com.game;

import com.badlogic.gdx.Game;
import com.game.Screens.MenuScreen;

public class MainGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
