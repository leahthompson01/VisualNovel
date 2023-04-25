package com.leahtcodes.plank.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
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

    private Label dialogLabel;

    public MainScreen(Plank plank){
        parent = plank;
        stage = new Stage( new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("dark-hdpi/Holo-dark-hdpi.json"));

        Texture dialogBox = new Texture("green-background.png");
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
        dialogLabel = new Label("Enter your name: ", skin);
        dialogLabel.setWrap(false);
        dialogLabel.setSize(Gdx.graphics.getWidth()/12,Gdx.graphics.getWidth()/12);
        final Table table2 = new Table();
        TextureRegionDrawable dialogBackground = new TextureRegionDrawable(new TextureRegion(dialogBox));
        table2.setBackground(dialogBackground);
        table2.add(dialogLabel);
        table.add(table2);
        table.setDebug(true);

        TextureRegionDrawable background = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Library 1.png"))));
        table.setBackground(background);
        name = new TextField("", skin);
        table2.add(name);
        final TextButton doneButton = new TextButton("Done", skin);
        table.row();
        table.add(doneButton);
        doneButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if(name.getText().length() >= 1){
                    table.removeActor(doneButton);
                    table2.removeActor(name);
                    dialogLabel.setText("Your name is " + name.getText());
                }
            }
        });

//        dlgName = new Dialog("Enter your character's name below. Once done, press the done button! ", new Skin(Gdx.files.internal("skin/glassy-ui.json"))){
//            @Override
//            protected void result(Object object){
//
//
//                boolean value = (Boolean) object;
//                if(value){
//                    if(name.getText().length() < 1){
//                        dlgName.text("INVALID USERNAME LENGTH");
//                    }
//                }
//                System.out.println("result " + object);
//                if(value == true){
//                  Dialog nameDialog  = new Dialog("Your Character's name is: " + name.getText(), skin);
//                  table.add(nameDialog);
//
//                }
//
//
//            }
//        };

//        dlgName.getContentTable().row();
//        dlgName.getContentTable().add(name);
//
//
//        dlgName.button("Done", true);
//        dlgName.show(stage);
//
//        table.add(dlgName);
//        table.row();









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
        stage.getViewport().update(width, height, true);
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

