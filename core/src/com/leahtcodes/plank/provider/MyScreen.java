package com.leahtcodes.plank.provider;

import com.badlogic.gdx.Screen;
import com.leahtcodes.plank.Plank;

public class MyScreen implements Screen {

    private final Plank game;
    public MyScreen(Plank game2){
        game = game2;
    }

    public Plank getPlank(){
        return game;
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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

    }

    @Override
    public void dispose() {

    }
}
