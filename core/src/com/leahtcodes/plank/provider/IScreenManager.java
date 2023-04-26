package com.leahtcodes.plank.provider;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Timer;

public interface IScreenManager {
    void addScreen(String name, Screen screen);
    void addActor(String name, Actor actor);
    void addMusic(String name, Music music);
    void changeScreen(String screenName);
    Actor getActor(String actorName);
    Music getMusic(String musicName);
    void scheduledTask(Timer.Task task, float delay);
}
