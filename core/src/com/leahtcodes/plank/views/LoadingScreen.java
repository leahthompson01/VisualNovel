package com.leahtcodes.plank.views;

import com.badlogic.gdx.Screen;
import com.leahtcodes.plank.Plank;

public class LoadingScreen implements Screen{
    private Plank parent;
    public LoadingScreen(Plank plank){
        parent = plank;
    }

    @Override
    public void show(){

    }
    @Override
    public void render(float delta){
        parent.changeScreen(0);

    }

    @Override
    public void resize(int width, int height){

    }
    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }

}
