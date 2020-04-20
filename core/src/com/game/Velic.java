package com.game;


import com.badlogic.gdx.Game;
import com.game.Screens.MenuScreen;

public class Velic extends Game{

    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
