package com.leahtcodes.plank.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.leahtcodes.plank.Plank;

public class LoadSave implements Screen {
    private Plank parent;
    private Stage stage;

    public LoadSave(Plank plank){
        parent = plank;
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
