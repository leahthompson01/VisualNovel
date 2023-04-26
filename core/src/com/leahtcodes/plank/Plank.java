package com.leahtcodes.plank;

import com.badlogic.gdx.Game;
import com.leahtcodes.plank.provider.IScreenManager;

public class Plank extends Game {
    private IScreenManager screenManager;

    private static Plank instance;

    @Override
    public void create()  {
        screenManager = new ScreenManager.getInstance(this);
        screenManager.addScreen("loading", new LoadingScreen(this));
        screenManager.addScreen("menu", new MenuScreen(this));
        screenManager.addScreen("main", new MainScreen(this));
        screenManager.addScreen("end", new EndScreen(this));
    }



}
