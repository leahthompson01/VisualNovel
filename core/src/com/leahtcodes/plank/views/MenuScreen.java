package com.leahtcodes.plank.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
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
        stage.act(Math.min(Gdx.graphics.getDeltaTime(),1/30f));
        Texture image = new  Texture (Gdx.files.internal("Spring_Park1.png"));
        TextureRegion region = new TextureRegion(image, 20, 20,  100, 100);
//        Image img = new Image(drawable);
        stage.getBatch().begin();
        stage.getBatch().draw(region,400, 400);
        stage.getBatch().end();


        stage.draw();
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);
        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));


        TextButton newGame = new TextButton("New Game", skin);
        TextButton exit = new TextButton("Exit Game", skin);
        TextButton loadGame = new TextButton("Load Game", skin);
        TextButton gallery = new TextButton("Gallery", skin);

        table.add(newGame).padTop(300).bottom().space(10);
        table.add(loadGame).padTop(300).bottom().space(10);
        table.add(gallery).padTop(300).bottom().space(10);
        table.add(exit).padTop(300).bottom().space(10);



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

