package com.leahtcodes.plank.provider;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Timer;
import com.leahtcodes.plank.Plank;

import java.util.HashMap;

public class ScreenManager implements IScreenManager {
    private Plank game;
    private HashMap<String, Screen> screens;
    private HashMap<String, Actor> actors;
    private HashMap<String, Music> musics;

    private ScreenManager(Plank game) {
        this.game = game;
        screens = new HashMap<String, Screen>();
        actors = new HashMap<String, Actor>();
        musics = new HashMap<String, Music>();

    }

    public static ScreenManager getInstance(Plank game) {
        if ( instance == null) {
            instance = new ScreenManager(game);
        }
        return instance;
    }
    @Override
    public void addScreen(String name, Screen screen) {
        screens.put(name, screen);

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
        game.setScreen(screens.get(screenName));

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
}
