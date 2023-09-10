package com.leahtcodes.plank.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.leahtcodes.plank.Plank;
import com.leahtcodes.plank.provider.MyScreen;
import com.leahtcodes.plank.provider.ScreenManager;

public class LoadSave extends MyScreen {
    private Plank parent;
    private Stage stage;
    private ScreenManager screenManager;
    public LoadSave(Plank game){
        super(game);
        parent = game;
        stage = new Stage( new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        TextureRegionDrawable background = new TextureRegionDrawable( new Texture(Gdx.files.internal("Library 1.png")));
        table.setBackground(background);
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
