package com.leahtcodes.plank.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.leahtcodes.plank.Plank;

public class MainScreen implements Screen{
    private Plank parent;
    private Stage stage;
    private Skin skin;
    private Dialog dlgName;
    private TextField name;
    private Table table;
    private String dlgText;
    public MainScreen(Plank plank){
        parent = plank;
        stage = new Stage( new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));


        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        table.setDebug(true);
        TextureRegionDrawable background = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Library 1.png"))));
        table.setBackground(background);
        name = new TextField("", skin);
        dlgName = new Dialog("Enter your character's name below. Once done, press the done button! ", new Skin(Gdx.files.internal("skin/glassy-ui.json"))){
            @Override
            protected void result(Object object){


                Boolean value = (Boolean) object;

                if(value && name.getText().length() <1){
                    Dialog nameDialog  = new Dialog("Invalid username length", skin);
                    table.add(nameDialog);
                }else{
                  Dialog nameDialog  = new Dialog("Your Character's name is: " + name.getText(), skin);
                  table.add(nameDialog);

                }


            }
        };

        dlgName.getContentTable().row();
        dlgName.getContentTable().add(name);


        dlgName.button("Done", true);
        dlgName.show(stage);

        table.add(dlgName);
        table.row();









    }


    @Override
    public void show(){

    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();

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
        stage.dispose();
    }

}

