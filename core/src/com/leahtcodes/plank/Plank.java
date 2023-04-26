package com.leahtcodes.plank;

import com.badlogic.gdx.Game;
import com.leahtcodes.plank.provider.DialogManager;
import com.leahtcodes.plank.views.*;

public class Plank extends Game {
    private LoadingScreen loadingScreen;
    private MenuScreen menuScreen;
    private MainScreen mainScreen;
    private EndScreen endScreen;

    private TraverseMap traverseMap; //TODO: remove

    private LoadSave loadSave;
    private DialogManager dialogManager;
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
            if(traverseMap == null) traverseMap = new TraverseMap();
        }
        System.out.println(screen);
    }

    //overriding the default create method from the Game class
    @Override
    public void create(){
        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);
//        dialogManager = new DialogManager();
    }
}
