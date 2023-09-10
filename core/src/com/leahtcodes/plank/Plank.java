package com.leahtcodes.plank;

import com.badlogic.gdx.Game;
import com.leahtcodes.plank.provider.DialogManager;
import com.leahtcodes.plank.provider.JSONDialogParser;
import com.leahtcodes.plank.provider.ScreenManager;
import com.leahtcodes.plank.views.*;

import java.io.IOException;
import java.util.Map;


public class  Plank extends Game {

    private LoadingScreen loadingScreen;
    private MenuScreen menuScreen;
    private MainScreen mainScreen;
    private EndScreen endScreen;
    private Map<Integer, Object> map;
    public ScreenManager screenManager;


//
//    private static Plank instance;

    private LoadSave loadSave;
    private DialogManager dialogManager;



    @Override
    public void create() {
        screenManager = new ScreenManager();
        try {
            map = JSONDialogParser.JsonFileToPojo();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        screenManager.addScreen("end", new EndScreen(this));
        screenManager.addScreen("loading", new LoadingScreen(this));
        screenManager.addScreen("main", new MainScreen(this));
        screenManager.addScreen("menu", new MenuScreen(this, screenManager));


    };

}
