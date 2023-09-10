package com.leahtcodes.plank.provider;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Timer;
import com.leahtcodes.plank.Plank;

import java.util.HashMap;

public class ScreenManager implements IScreenManager {
    public Plank game;
    private HashMap<String, MyScreen> screens;
    private HashMap<String, Actor> actors;
    private HashMap<String, Music> musics;

    public Screen getCurrentScreen() {
        return currentScreen;
    }

    private MyScreen currentScreen;

    public ScreenManager() {
        screens = new HashMap<String, MyScreen>();
        actors = new HashMap<String, Actor>();
        musics = new HashMap<String, Music>();
        currentScreen = null;
    }




    @Override
    public void addScreen(String name, MyScreen screenName) {
//            System.out.println(currentScreen);
            if(currentScreen != null){
                currentScreen.dispose();
                System.out.println("Screen Disposed");
            }
            currentScreen = screenName;
            System.out.println("this is the current Screen " + currentScreen);
            currentScreen.getPlank().setScreen(currentScreen);
            screens.put(name, screenName);
            currentScreen = null;

    }

    @Override
    public void addActor(String name, Actor actor) {
        actors.put(name, actor);

    }

    @Override
    public void addMusic(String name, Music music) {
        musics.put(name, music);

    }

    @Override
    public void changeScreen(String screenName) {
        System.out.println("these are the screens" + screens);
        if( screens.containsKey(screenName)) {
//            System.out.println(currentScreen);
            if(currentScreen != null && screens.containsValue(currentScreen)){
                screens.remove(currentScreen);
                currentScreen.dispose();
//                System.out.println("Screen Disposed 2");
            }
//            currentScreen = screens.get(screenName);
            currentScreen = screens.get(screenName);
//            System.out.println("this is the current Screen " + currentScreen);

            currentScreen.getPlank().setScreen(currentScreen);
        }
//            System.out.println(screens.get("main").toString());

//        }
//        currentScreen = screen;
//        System.out.println("this is the screenName " + screenName);
//
    }

    @Override
    public Actor getActor(String actorName) {
        return actors.get(actorName);
    }

    @Override
    public Music getMusic(String musicName) {
        return musics.get(musicName);
    }

    @Override
    public void scheduledTask(Timer.Task task, float delay) {
        Timer.schedule(task, delay);
    }
    public String toString(){
        return "";
    }
}
