package com.leahtcodes.plank.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.leahtcodes.plank.Plank;
import org.w3c.dom.Text;
import sun.awt.www.content.image.png;

public class MenuScreen implements Screen{

    private Plank parent;
    private Stage stage;
    private Skin skin;
    public MenuScreen(Plank plank){
        parent = plank;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        TextureRegionDrawable background = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Greenhouse.png"))));
        Image image = new Image(background);
        table.setBackground(background);
        table.row();
        TextButton newGame = new TextButton("New Game", skin);
        TextButton exit = new TextButton("Exit Game", skin);
        TextButton loadGame = new TextButton("Load Game", skin);
        TextButton gallery = new TextButton("Gallery", skin);

        table.add(newGame).padTop(500).space(10);
        table.add(loadGame).padTop(500).space(10);
        table.add(gallery).padTop(500).space(10);
        table.add(exit).padTop(500).space(10);

       newGame.addListener(new ChangeListener() {
           @Override
           public void changed(ChangeEvent event, Actor actor) {
               parent.changeScreen(1);
           }
       });

       exit.addListener(new ChangeListener() {
           @Override
           public void changed(ChangeEvent event, Actor actor) {
               parent.changeScreen(2);
           }
       });

       loadGame.addListener(new ChangeListener() {
           @Override
           public void changed(ChangeEvent event, Actor actor) {
               parent.changeScreen(3);
           }
       });



        stage.draw();








    }
    @Override
    public void show(){

    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
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
        skin.dispose();
        stage.dispose();

    }

}

