package com.leahtcodes.plank;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.leahtcodes.plank.views.*;

public class Plank extends Game {
    private LoadingScreen loadingScreen;
    private MenuScreen menuScreen;
    private MainScreen mainScreen;
    private EndScreen endScreen;

    private TraverseMap traverseMap;

    private LoadSave loadSave;
    public void changeScreen(int screen){
        if (screen == 0){
            if(menuScreen == null) menuScreen = new MenuScreen(this);
            this.setScreen(menuScreen);
        }else if( screen == 1){
            if(mainScreen == null) mainScreen = new MainScreen(this);
            this.setScreen(mainScreen);
        }else if(screen == 2){
            if(endScreen == null) endScreen = new EndScreen(this);
            this.setScreen(endScreen);
        }else if(screen == 3){
            if(loadSave == null) loadSave = new LoadSave(this);
            this.setScreen(loadSave);
        }
        System.out.println(screen);
    }

    //overriding the default create method from the Game class
    @Override
    public void create(){
        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);

    }

}
