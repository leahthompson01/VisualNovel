package com.leahtcodes.plank.views;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.leahtcodes.plank.Plank;
import com.leahtcodes.plank.provider.MyScreen;
import com.leahtcodes.plank.provider.ScreenManager;

public class LoadingScreen extends MyScreen{
    private Plank parent;
    private ScreenManager screenManager;
    private Stage stage;
    public LoadingScreen(Plank game){
        super(game);
        parent = game;
    }


    @Override
    public void show(){

    }
    @Override
    public void render(float delta){
//        screenManager.changeScreen("menu");

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
